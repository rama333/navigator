package ru.rt.navigator.presenter;

import ru.rt.navigator.model.api.ApiFactory;
import ru.rt.navigator.model.api.ApiInterface;
import ru.rt.navigator.view.ViewForm;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ramil on 06.12.2017.
 */

public class FormPresenter {

    ViewForm viewForm;

    public FormPresenter(ViewForm viewForm) {
        this.viewForm = viewForm;
    }

    ApiInterface apiInterface = ApiFactory.getRetrofitInstance("http://navigator.rcvrrt.ru/").create(ApiInterface.class);

    public void requestForm(String parentName,
                            String workPlace,
                            String phone,
                            String mail,
                            String programTitle,
                            String childName,
                            String birthDate,
                            String childClass,
                            String registrationAddress,
                            String hours){
        Call<ResponseBody> call = apiInterface.requestForm(parentName,
                workPlace,
                phone,
                mail,
                programTitle,
                childName,
                birthDate,
                childClass,
                registrationAddress,
                hours);
        viewForm.showProgressDiaolog();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                viewForm.dismiss();

                if (response.isSuccessful()) {
                    viewForm.showStatusRequest("Успешно");
                    viewForm.ok();
                } else {
                    viewForm.showStatusRequest("Ошибка сервера");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                viewForm.dismiss();
                viewForm.showStatusRequest("Ошибка");
            }
        });
    }


    public void requestFormEvent(String Name,
                                 String eventTitle,
                                 String nomination,
                                 String birthDate,
                                 String schoolTitle,
                                 String phoneNumber,
                                 String email,
                                 String teacherName,
                                 String teacherPhone) {

        Call<ResponseBody> call = apiInterface.requestFormEvent(Name,
                eventTitle,
                nomination,
                birthDate,
                schoolTitle,
                phoneNumber,
                email,
                teacherName,
                teacherPhone);
        viewForm.showProgressDiaolog();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                viewForm.dismiss();
                if (response.isSuccessful()) {
                    viewForm.showStatusRequest("Успешно");
                    viewForm.ok();
                } else {
                    viewForm.showStatusRequest("Ошибка сервера");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                viewForm.dismiss();
                viewForm.showStatusRequest("Ошибка");
            }
        });

    }
}
