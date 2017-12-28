package com.interview.zef.belfricsapi.apiexecutor;

import com.google.gson.JsonArray;
import com.interview.zef.belfricsapi.model.Category;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zef on 28/12/17.
 */

public interface Service {
    @POST("~ummadc/demo/flamb/api/users/get-all-categories")
    Call<Category> readCategory(@Query("parameter") String parameter, @Query("value") String value);
}
