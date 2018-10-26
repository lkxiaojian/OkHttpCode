package com.example.lk.okhttpcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request.Builder builder = new Request.Builder();
        Request build = builder.get().url("http://baobab.kaiyanapp.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83").build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("e", "e--" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("response", "response--" + response.body().string());

            }
        });
    }
}
