package com.interview.zef.belfricsapi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.ContextThemeWrapper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.interview.zef.belfricsapi.R;
import com.interview.zef.belfricsapi.adapter.CategoryAdapter;
import com.interview.zef.belfricsapi.apiexecutor.RetrofitClient;
import com.interview.zef.belfricsapi.apiexecutor.Service;
import com.interview.zef.belfricsapi.model.Category;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Category> categoryList = new ArrayList<>();
    Category category = new Category();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        getCategoryResponse();
    }

    public Activity getActivity() {
        Context context = this;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextThemeWrapper) context).getBaseContext();
        }

        return null;
    }

    private void getCategoryResponse() {

        Service apiService = RetrofitClient.getClient();
        retrofit2.Call<Category> loadCategory = apiService.readCategory("user_id", "201");
        loadCategory.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(retrofit2.Call<Category> call, Response<Category> response) {

                try {
                    String categoryString = response.body().toString();
                    Type listType = new TypeToken<List<Category>>() {
                    }.getType();
                    categoryList = getCategoryListJson(categoryString, listType);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(new CategoryAdapter(getApplicationContext(), categoryList));
                } catch (Exception e) {
                    Log.i("onResponse", "error: ");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<Category> call, Throwable t) {

                Log.i("onFailure", t.toString());
            }
        });


    }


    public static <T> List<T> getCategoryListJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCategoryResponse();
        Log.i("category", "onCreate: " + category.getCategoryName());
    }
}
