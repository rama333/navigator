package ru.rt.navigator.view;

import java.util.List;

import ru.rt.navigator.view.dto.EventDto;
import ru.rt.navigator.view.dto.ProgramDto;

/**
 * Created by ramil on 15.11.2017.
 */

public interface ViewNavigator {
    void showPrograms(List<ProgramDto> programDtos);
    void showEvents(List<EventDto> eventDtos);
    void showError(String error);
    void showNoResult();
    void showDialog();
    void hideDialog();
}
