package com.ysy.talkheart.bases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.ysy.talkheart.utils.DataProcessor;

public class DayNightFullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isNightMode())
            setBrightness(0.0f);
    }

    private boolean isNightMode() {
        DataProcessor dP = new DataProcessor(this);
        return dP.readIntData("day_night") == 1;
    }

    private void setBrightness(float value) {
        WindowManager.LayoutParams lP = this.getWindow().getAttributes();
        if (value > 1.0f)
            lP.screenBrightness = 1.0f;
        else if (value <= 0.0f)
            lP.screenBrightness = 0.0f;
        else
            lP.screenBrightness = value;
        this.getWindow().setAttributes(lP);
    }
}
