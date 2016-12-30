package org.nevack.android.dvach2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import org.nevack.android.dvach2.R;

import static org.nevack.android.dvach2.model.File.TYPE_GIF;
import static org.nevack.android.dvach2.model.File.TYPE_PIC;
import static org.nevack.android.dvach2.model.File.TYPE_STICKER;
import static org.nevack.android.dvach2.model.File.TYPE_WEBM;

public class ContentActivity extends AppCompatActivity {

    public static final String CONTENT_EXTRA = "contenturl";
    public static final String TYPE_EXTRA = "type";

    public static Intent newInstance(Context context, String url, int type) {
        Intent intent = new Intent(context, ContentActivity.class);
        intent.putExtra(CONTENT_EXTRA, url);
        intent.putExtra(TYPE_EXTRA, type);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_universal_content);

        ImageView imageView = (ImageView) findViewById(R.id.close_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String content = getIntent().getStringExtra(CONTENT_EXTRA);
        int type = getIntent().getIntExtra(TYPE_EXTRA, TYPE_PIC);

        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = ImageFragment.newInstance(content);

        switch (type) {
            case TYPE_STICKER:
            case TYPE_GIF:
            case TYPE_PIC:
                fragment = ImageFragment.newInstance(content);
                break;

            case TYPE_WEBM:
                fragment = WebmFragment.newInstance(content);
        }

        manager.beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}
