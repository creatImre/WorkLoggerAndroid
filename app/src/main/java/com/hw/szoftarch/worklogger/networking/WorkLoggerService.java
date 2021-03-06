package com.hw.szoftarch.worklogger.networking;

import com.hw.szoftarch.worklogger.entities.Issue;
import com.hw.szoftarch.worklogger.entities.Project;
import com.hw.szoftarch.worklogger.entities.Report;
import com.hw.szoftarch.worklogger.entities.User;
import com.hw.szoftarch.worklogger.entities.WorkingHour;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface WorkLoggerService {

    @GET("auth/")
    Call<User> login();

    @PUT("auth/")
    Call<String> updateUser(@Body User user);

    @DELETE("auth/{googleId}")
    Call<String> removeUser(@Path("googleId") String googleId);

    @GET("auth/all/")
    Call<List<User>> getUsers();

    @GET("report/{reportId}")
    Call<Project> getReportById(@Path("projectName") long reportId);

    @POST("report/")
    Call<Report> addReport(@Body Report report);

    @PUT("report/")
    Call<String> updateReport(@Body Report report);

    @DELETE("report/{id}")
    Call<String> removeReport(@Path("id") long id);

    @GET("report/all")
    Call<List<Report>> getReportsByUser();

    @GET("report/sum/{reportId}")
    Call<Long> getWorkedHoursForReport(@Path("reportId") long id);

    @POST("hour/")
    Call<WorkingHour> addWorkingHour(@Body WorkingHour workingHour);

    @PUT("hour/")
    Call<String> updateWorkingHour(@Body WorkingHour workingHour);

    @DELETE("hour/{id}")
    Call<String> removeWorkingHour(@Path("id") long id);

    @GET("hour/")
    Call<List<WorkingHour>> getWorkingHoursByUser();

    @GET("hour/issues/")
    Call<List<Issue>> getIssues();

}
