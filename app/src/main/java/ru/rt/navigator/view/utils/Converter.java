package ru.rt.navigator.view.utils;

import java.util.ArrayList;
import java.util.List;

import ru.rt.navigator.model.ResponseBody;
import ru.rt.navigator.view.dto.EventDto;
import ru.rt.navigator.view.dto.ProgramDto;

/**
 * Created by ramil on 20.11.2017.
 */
public class Converter {

    public static List<ProgramDto> getListProgram(ResponseBody responseBody) {
        List<ProgramDto> list = new ArrayList<>();

        for (int i = 0; i < responseBody.getInstitutions().size(); i++) {
            for (int j = 0; j < responseBody.getInstitutions().get(i).getPrograms().size(); j++) {
                list.add( new ProgramDto(responseBody.getInstitutions().get(i).getName(),
                        responseBody.getInstitutions().get(i).getId(),
                        responseBody.getInstitutions().get(i).getDistrict(),
                        responseBody.getInstitutions().get(i).getAddress(),
                        responseBody.getInstitutions().get(i).getPhone(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getId(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getTitle(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getStartDate(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getFinishDate(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getDescription(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getMinAge(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getMaxAge(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getPaidForm(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getRealizationForm(),
                        responseBody.getInstitutions().get(i).getPrograms().get(j).getChildCategory()));
            }
        }
        return list;
    }

    public static List<EventDto> getListEvent(ResponseBody responseBody) {
        List<EventDto> list = new ArrayList<>();

        for (int i = 0; i < responseBody.getInstitutions().size(); i++) {
            for (int j = 0; j < responseBody.getInstitutions().get(i).getEvents().size(); j++) {
                list.add( new EventDto(responseBody.getInstitutions().get(i).getName(),
                        responseBody.getInstitutions().get(i).getId(),
                        responseBody.getInstitutions().get(i).getDistrict(),
                        responseBody.getInstitutions().get(i).getAddress(),
                        responseBody.getInstitutions().get(i).getPhone(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getId(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getTitle(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getStartDate(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getFinishDate(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getDescription(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getMinAge(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getMaxAge(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getPaidForm(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getRealizationForm(),
                        responseBody.getInstitutions().get(i).getEvents().get(j).getFile()));
            }
        }
        return list;
    }
}
