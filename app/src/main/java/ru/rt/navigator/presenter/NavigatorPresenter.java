package ru.rt.navigator.presenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.rt.navigator.model.ResponseBody;
import ru.rt.navigator.model.api.ApiFactory;
import ru.rt.navigator.model.api.ApiInterface;
import ru.rt.navigator.view.RequestBody;
import ru.rt.navigator.view.ViewNavigator;
import ru.rt.navigator.view.dto.IntitutionDto;
import ru.rt.navigator.view.utils.Converter;

/**
 * Created by ramil on 14.11.2017.
 */

public class NavigatorPresenter {

    ApiInterface apiInterface = ApiFactory.getRetrofitInstance("http://navigator.rcvrrt.ru/").create(ApiInterface.class);
    ViewNavigator viewNavigator;
    List<IntitutionDto> intitutionDtos;
    Integer spinnerForm;

    public void setSpinnerForm(Long spinnerForm) {
        this.spinnerForm = spinnerForm.intValue();
    }

    public NavigatorPresenter(ViewNavigator viewNavigator, Long spinnerForm) {
        this.viewNavigator = viewNavigator;
        this.spinnerForm = spinnerForm.intValue();
    }

    public void requestGetListNavigator(final RequestBody requestBody) {

        Call<ResponseBody> call = apiInterface.getListNavigator(requestBody);
        viewNavigator.showDialog();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    viewNavigator.hideDialog();
                    if (!response.body().getInstitutions().isEmpty() && response.body().getInstitutions() != null) {
                        switch (spinnerForm) {
                            case 0:
                                Boolean state = false;
                                for (int i = 0; i < response.body().getInstitutions().size(); i++) {
                                    if (!response.body().getInstitutions().get(i).getPrograms().isEmpty()) {
                                        state = true;
                                        break;
                                    }
                                }
                                if (state) {
                                    viewNavigator.showPrograms(Converter.getListProgram(response.body()));
                                } else {
                                    viewNavigator.showNoResult();
                                }
                                break;
                            case 1:
                                Boolean stateEvent = false;
                                for (int i = 0; i < response.body().getInstitutions().size(); i++) {
                                    if (!response.body().getInstitutions().get(i).getEvents().isEmpty()) {
                                        stateEvent = true;
                                        break;
                                    }
                                }
                                if (stateEvent) {
                                    viewNavigator.showEvents(Converter.getListEvent(response.body()));
                                } else {
                                    viewNavigator.showNoResult();
                                }
                                break;
                        }
                        } else {
                        viewNavigator.showNoResult();
                    }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                viewNavigator.hideDialog();
                viewNavigator.showError("Произошла ошибка");
            }
        });
    }
}
