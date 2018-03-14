package ru.rt.navigator.model.api;

import ru.rt.navigator.model.ResponseBody;
import ru.rt.navigator.view.RequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ramil on 14.11.2017.
 */

public interface ApiInterface {
    @POST("search/all")
    Call<ResponseBody> getListNavigator(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST("/institutions/313/declarations")
    Call<okhttp3.ResponseBody> requestForm(@Field("parentName") String parentName,
                                           @Field("workPlace") String workPlace,
                                           @Field("phone") String phone,
                                           @Field("mail") String mail,
                                           @Field("programTitle") String programTitle,
                                           @Field("childName") String childName,
                                           @Field("birthDate") String birthDate,
                                           @Field("childClass") String childClass,
                                           @Field("registrationAddress") String registrationAddress,
                                           @Field("hours") String hours);
    @FormUrlEncoded
    @POST("/institutions/313/event-declarations")
    Call<okhttp3.ResponseBody> requestFormEvent(@Field("name") String Name,
                                           @Field("eventTitle") String eventTitle,
                                           @Field("nomination") String nomination,
                                           @Field("birthDate") String birthDate,
                                           @Field("schoolTitle") String schoolTitle,
                                           @Field("phoneNumber") String phoneNumber,
                                           @Field("email") String email,
                                           @Field("teacherName") String teacherName,
                                           @Field("teacherPhone") String teacherPhone);

}
