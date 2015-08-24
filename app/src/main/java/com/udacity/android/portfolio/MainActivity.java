package com.udacity.android.portfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static Map<Integer, String> sToastMessages;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (null == sToastMessages) {
            sToastMessages = ImmutableMap.<Integer, String>builder()
                    .put(R.id.button_media_streamer, getString(R.string.media_streamer))
                    .put(R.id.button_super_duo1, getString(R.string.super_duo1))
                    .put(R.id.button_super_duo2, getString(R.string.super_duo2))
                    .put(R.id.button_ant_terminator, getString(R.string.ant_terminator))
                    .put(R.id.button_materialize, getString(R.string.materialize))
                    .put(R.id.button_capstone, getString(R.string.capstone))
                    .build();
        }
    }

    @Override
    public void onClick(View view) {
        showToast(sToastMessages.get(view.getId()));
    }

    private void showToast(String message) {
        if (null != mToast) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }

}
