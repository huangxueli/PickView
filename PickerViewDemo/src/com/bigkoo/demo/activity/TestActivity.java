package com.bigkoo.demo.activity;

import com.bigkoo.demo.R;
import com.bigkoo.demo.PickerViewUtil;
import com.lvfq.pickerview.TimePickerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

public class TestActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        findViewById(R.id.btn_ymdhm).setOnClickListener(this);
        findViewById(R.id.btn_ymdh).setOnClickListener(this);
        findViewById(R.id.btn_ymd).setOnClickListener(this);
        findViewById(R.id.btn_mdhm).setOnClickListener(this);
        findViewById(R.id.btn_hm).setOnClickListener(this);
        findViewById(R.id.btn_ym).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String format = "";
        TimePickerView.Type type = null;
        switch (v.getId()) {
            case R.id.btn_ymdhm:
                type = TimePickerView.Type.ALL;
                format = "yyyy-MM-dd HH:mm";
                break;
            case R.id.btn_ymdh:
                type = TimePickerView.Type.YEAR_MONTH_DAY_HOUR;
                format = "yyyy-MM-dd HH";
                break;
            case R.id.btn_ymd:
                type = TimePickerView.Type.YEAR_MONTH_DAY;
                format = "yyyy-MM-dd";
                break;
            case R.id.btn_mdhm:
                type = TimePickerView.Type.MONTH_DAY_HOUR_MIN;
                format = "MM-dd HH:mm";
                break;
            case R.id.btn_hm:
                type = TimePickerView.Type.HOURS_MINS;
                format = "HH:mm";
                break;
            case R.id.btn_ym:
                type = TimePickerView.Type.YEAR_MONTH;
                format = "yyyy-MM";
                break;
        }
        PickerViewUtil.alertTimerPicker(this, type, format, new PickerViewUtil.TimerPickerCallBack() {
            @Override
            public void onTimeSelect(String date) {
                Toast.makeText(TestActivity.this, date, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
