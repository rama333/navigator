package ru.rt.navigator.view;

/**
 * Created by ramil on 06.12.2017.
 */

public interface ViewForm {
    void showStatusRequest(String text);
    void showProgressDiaolog();
    void dismiss();
    void ok();
}
