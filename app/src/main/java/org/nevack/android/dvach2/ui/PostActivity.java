package org.nevack.android.dvach2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.nevack.android.dvach2.DvachService;
import org.nevack.android.dvach2.R;
import org.nevack.android.dvach2.Utils;
import org.nevack.android.dvach2.model.BoardSettings;
import org.nevack.android.dvach2.model.Captcha;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {

    private static final String BOARD_EXTRA = "boardcode";
    private static final String THREAD_EXTRA = "threadnum";
    private String boardCode;
    private String threadNum;

    public static Intent getIntent(Context context, String boardCode, Integer threadNum) {
        Intent intent = new Intent(context, PostActivity.class);
        intent.putExtra(BOARD_EXTRA, boardCode);
        intent.putExtra(THREAD_EXTRA, threadNum);
        return intent;
    }

    BoardSettings boardSettings;
    Captcha captcha;
    private Retrofit retrofit;
    private DvachService service;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        boardCode = getIntent().getStringExtra(BOARD_EXTRA);
        threadNum = getIntent().getStringExtra(THREAD_EXTRA);

        imageView = (ImageView) findViewById(R.id.captcha);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://2ch.hk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(DvachService.class);

        Call<BoardSettings> settings = service.getBoardSettings(boardCode);
        settings.enqueue(new Callback<BoardSettings>() {
            @Override
            public void onResponse(Call<BoardSettings> call, Response<BoardSettings> response) {
                if (response.isSuccessful()) {
                    boardSettings = response.body();
                    loadCaptcha();
                }
            }

            @Override
            public void onFailure(Call<BoardSettings> call, Throwable t) {}
        });

    }

    private void loadCaptcha() {
        Call<Captcha> captchaCall = service.getCaptcha(boardSettings.getTypes().get(0).getId(), boardCode, threadNum);
        captchaCall.enqueue(new Callback<Captcha>() {
            @Override
            public void onResponse(Call<Captcha> call, Response<Captcha> response) {
                if (response.isSuccessful()) {
                    captcha = response.body();
                    Utils.getPicasso(PostActivity.this)
                            .load("https://2ch.hk/api/captcha/" + captcha.getType() + "/image/" + captcha.getId())
                            .into(imageView);
                }
            }

            @Override
            public void onFailure(Call<Captcha> call, Throwable t) {}
        });
    }
}
