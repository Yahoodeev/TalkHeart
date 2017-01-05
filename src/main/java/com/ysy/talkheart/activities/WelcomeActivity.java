package com.ysy.talkheart.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ysy.talkheart.R;
import com.ysy.talkheart.utils.ActivitiesDestroyer;
import com.ysy.talkheart.utils.DataProcessor;
import com.ysy.talkheart.utils.StringUtils;

public class WelcomeActivity extends AppCompatActivity {

    private String UID = "0";
    private String[] opts_o = new String[4];
    private String[] opts_t = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ActivitiesDestroyer.getInstance().addActivity(this);
        try {
            String[] temps = initOption();
            opts_o[0] = temps[2];
            opts_o[1] = temps[3];
            opts_o[2] = temps[0];
            opts_o[3] = temps[1];
            opts_t[0] = temps[2];
            opts_t[1] = temps[4];
            opts_t[2] = temps[0];
            opts_t[3] = temps[1];
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "出现了一点小异常，请重启啦", Toast.LENGTH_SHORT).show();
            finish();
        }
        int WAIT_TIME;
        DataProcessor dp = new DataProcessor(WelcomeActivity.this);
        UID = dp.readStrData("uid");
        if (!UID.equals("")) {
            WAIT_TIME = 256;
        } else
            WAIT_TIME = 1024;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (!UID.equals("")) {
                    Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                    intent.putExtra("uid", UID);
                    intent.putExtra("opts_o", opts_o);
                    intent.putExtra("opts_t", opts_t);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    intent.putExtra("opts_o", opts_o);
                    intent.putExtra("opts_t", opts_t);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions tAO = ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this, findViewById(R.id.welcome_logo_img), getString(R.string.trans_logo));
                        startActivity(intent, tAO.toBundle());
                    } else {
                        startActivity(intent);
                    }
                }
            }
        }, WAIT_TIME);
    }

    private String[] initOption() throws Exception {
        StringUtils utils = new StringUtils();
        String[] temps = new String[6];
        temps[0] = getResources().getString(R.string.trans_title);
        temps[1] = getResources().getString(R.string.trans_button);
        temps[2] = getResources().getString(R.string.trans_img);
        temps[3] = getResources().getString(R.string.trans_fab);
        temps[4] = getResources().getString(R.string.trans_text_2) + getResources().getString(R.string.trans_text_1);
        temps[5] = getResources().getString(R.string.trans_list_3) + getResources().getString(R.string.trans_list_2)
                + getResources().getString(R.string.trans_list_1);
        return utils.eU(temps);
    }
}
