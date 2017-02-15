package com.lvfq.pickerview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.R;
import com.lvfq.pickerview.TimePickerView.Type;
import com.lvfq.pickerview.adapter.NumericWheelAdapter;
import com.lvfq.pickerview.lib.WheelView;
import com.lvfq.pickerview.listener.OnItemSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


public class WheelTime {
    @SuppressLint("SimpleDateFormat")
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private View view;
    private WheelView wv_year;
    private WheelView wv_month;
    private WheelView wv_day;
    private WheelView wv_hours;
    private WheelView wv_mins;

    private Type type;
    private boolean showlabel = true;
    public static final int DEFULT_START_YEAR = 1990;
    public static final int DEFULT_END_YEAR = 2100;
    private int startYear = DEFULT_START_YEAR;
    private int endYear = DEFULT_END_YEAR;

    public WheelTime(View view, boolean showlabel) {
        super();
        this.view = view;
		this.type = Type.ALL;
		this.showlabel = showlabel;
        setView(view);
    }

    public WheelTime(View view, Type type, boolean showlabel) {
        super();
        this.view = view;
        this.type = type;
        this.showlabel = showlabel;
        setView(view);
    }

    public void setPicker(int year, int month, int day) {
        this.setPicker(year, month, day, 0, 0);
    }

    /**
     * @Description: TODO ��������ʱ��ѡ����
     */
    public void setPicker(int year, int month, int day, int h, int m) {
        // ���Ӵ�С���·ݲ�����ת��Ϊlist,����֮����ж�
        String[] months_big = {"1", "3", "5", "7", "8", "10", "12"};
        String[] months_little = {"4", "6", "9", "11"};

        final List<String> list_big = Arrays.asList(months_big);
        final List<String> list_little = Arrays.asList(months_little);

        Context context = view.getContext();
        // ��
        wv_year = (WheelView) view.findViewById(R.id.year);
        wv_year.setAdapter(new NumericWheelAdapter(startYear, endYear));// ����"��"����ʾ����
        if(showlabel)
    	wv_year.setLabel(context.getString(R.string.pickerview_year));// ��������
        wv_year.setCurrentItem(year - startYear);// ��ʼ��ʱ��ʾ������

        // ��
        wv_month = (WheelView) view.findViewById(R.id.month);
        wv_month.setAdapter(new NumericWheelAdapter(1, 12));
        if(showlabel)
        wv_month.setLabel(context.getString(R.string.pickerview_month));
        wv_month.setCurrentItem(month);

        // ��
        wv_day = (WheelView) view.findViewById(R.id.day);
        // �жϴ�С�¼��Ƿ�����,����ȷ��"��"������
        if (list_big.contains(String.valueOf(month + 1))) {
            wv_day.setAdapter(new NumericWheelAdapter(1, 31));
        } else if (list_little.contains(String.valueOf(month + 1))) {
            wv_day.setAdapter(new NumericWheelAdapter(1, 30));
        } else {
            // ����
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                wv_day.setAdapter(new NumericWheelAdapter(1, 29));
            else
                wv_day.setAdapter(new NumericWheelAdapter(1, 28));
        }
        if(showlabel)
        wv_day.setLabel(context.getString(R.string.pickerview_day));
        wv_day.setCurrentItem(day - 1);

        wv_hours = (WheelView) view.findViewById(R.id.hour);
        wv_hours.setAdapter(new NumericWheelAdapter(0, 23));
        if(showlabel)
        wv_hours.setLabel(context.getString(R.string.pickerview_hours));// ��������
        wv_hours.setCurrentItem(h);

        wv_mins = (WheelView) view.findViewById(R.id.min);
        wv_mins.setAdapter(new NumericWheelAdapter(0, 59));
        if(showlabel)
        wv_mins.setLabel(context.getString(R.string.pickerview_minutes));// ��������
        wv_mins.setCurrentItem(m);

        // ����"��"����
        OnItemSelectedListener wheelListener_year = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int year_num = index + startYear;
                // �жϴ�С�¼��Ƿ�����,����ȷ��"��"������
                int maxItem = 30;
                if (list_big.contains(String.valueOf(wv_month.getCurrentItem() + 1))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                    maxItem = 31;
                } else if (list_little.contains(String.valueOf(wv_month.getCurrentItem() + 1))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                    maxItem = 30;
                } else {
                    if ((year_num % 4 == 0 && year_num % 100 != 0)
                            || year_num % 400 == 0) {
                        wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                        maxItem = 29;
                    } else {
                        wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                        maxItem = 28;
                    }
                }
                if (wv_day.getCurrentItem() > maxItem - 1) {
                    wv_day.setCurrentItem(maxItem - 1);
                }
            }
        };
        // ����"��"����
        OnItemSelectedListener wheelListener_month = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int month_num = index + 1;
                int maxItem = 30;
                // �жϴ�С�¼��Ƿ�����,����ȷ��"��"������
                if (list_big.contains(String.valueOf(month_num))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                    maxItem = 31;
                } else if (list_little.contains(String.valueOf(month_num))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                    maxItem = 30;
                } else {
                    if (((wv_year.getCurrentItem() + startYear) % 4 == 0 && (wv_year
                            .getCurrentItem() + startYear) % 100 != 0)
                            || (wv_year.getCurrentItem() + startYear) % 400 == 0) {
                        wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                        maxItem = 29;
                    } else {
                        wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                        maxItem = 28;
                    }
                }
                if (wv_day.getCurrentItem() > maxItem - 1) {
                    wv_day.setCurrentItem(maxItem - 1);
                }

            }
        };
        wv_year.setOnItemSelectedListener(wheelListener_year);
        wv_month.setOnItemSelectedListener(wheelListener_month);

        // ������Ļ�ܶ���ָ��ѡ��������Ĵ�С(��ͬ��Ļ���ܲ�ͬ)
        int textSize = 5;
        switch (type) {
            case ALL:
                textSize = textSize * 3;
                break;
            case YEAR_MONTH_DAY:
                textSize = textSize * 4;
                wv_hours.setVisibility(View.GONE);
                wv_mins.setVisibility(View.GONE);
                break;
            case YEAR_MONTH_DAY_HOUR:
                textSize = textSize * 3;
                wv_mins.setVisibility(View.GONE);
                break;
            case HOURS_MINS:
                textSize = textSize * 4;
                wv_year.setVisibility(View.GONE);
                wv_month.setVisibility(View.GONE);
                wv_day.setVisibility(View.GONE);
                break;
            case MONTH_DAY_HOUR_MIN:
                textSize = textSize * 3;
                wv_year.setVisibility(View.GONE);
                break;
            case YEAR_MONTH:
                textSize = textSize * 4;
                wv_day.setVisibility(View.GONE);
                wv_hours.setVisibility(View.GONE);
                wv_mins.setVisibility(View.GONE);
        }
        setTextSize(textSize);

    }

    /**
     * ����ʱ�������С
     *
     * @param textSize
     */
    public void setTextSize(float textSize) {
        wv_day.setTextSize(textSize);
        wv_month.setTextSize(textSize);
        wv_year.setTextSize(textSize);
        wv_hours.setTextSize(textSize);
        wv_mins.setTextSize(textSize);
    }

    /**
     * �����Ƿ�ѭ������
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        wv_year.setCyclic(cyclic);
        wv_month.setCyclic(cyclic);
        wv_day.setCyclic(cyclic);
        wv_hours.setCyclic(cyclic);
        wv_mins.setCyclic(cyclic);
    }
    
    public String getTime() {
        StringBuffer sb = new StringBuffer();
        sb.append((wv_year.getCurrentItem() + startYear)).append("-")
                .append((wv_month.getCurrentItem() + 1)).append("-")
                .append((wv_day.getCurrentItem() + 1)).append(" ")
                .append(wv_hours.getCurrentItem()).append(":")
                .append(wv_mins.getCurrentItem());
        return sb.toString();
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    
    public void setLablePadingRight(float padingRight){
        wv_year.setLablePadingRight(padingRight);
        wv_month.setLablePadingRight(padingRight);
        wv_day.setLablePadingRight(padingRight);
        wv_hours.setLablePadingRight(padingRight);
        wv_mins.setLablePadingRight(padingRight);
    }
    
    public void setLabelYOffset(float yoffset){
    	wv_year.setLableYOffset(yoffset);
    	wv_month.setLableYOffset(yoffset);
    	wv_day.setLableYOffset(yoffset);
    	wv_hours.setLableYOffset(yoffset);
    	wv_mins.setLableYOffset(yoffset);
    }
    
    public void setContentXOffset(float offset){
    	wv_year.setContentXOffset(0-offset);
    	wv_month.setContentXOffset(0-offset);
    	wv_day.setContentXOffset(0-offset);
    	wv_hours.setContentXOffset(0-offset);
    	wv_mins.setContentXOffset(0-offset);
    }
    
    public void setCenterContentYOffset(float offset){
    	wv_year.setCenterContentYOffset(offset);
    	wv_month.setCenterContentYOffset(offset);
    	wv_day.setCenterContentYOffset(offset);
    	wv_hours.setCenterContentYOffset(offset);
    	wv_mins.setCenterContentYOffset(offset);
    }
}