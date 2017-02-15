package com.lvfq.pickerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.R;
import com.lvfq.pickerview.view.BasePickerView;
import com.lvfq.pickerview.view.WheelTime;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TimePickerView extends BasePickerView implements View.OnClickListener {
	public enum Type {
		ALL, YEAR_MONTH_DAY, YEAR_MONTH_DAY_HOUR, HOURS_MINS, MONTH_DAY_HOUR_MIN, YEAR_MONTH
	}// ѡ��ģʽ��������ʱ�֣������գ�������ʱ , ʱ�֣�����ʱ�� ,����

	WheelTime wheelTime;
	View timepickerview_notitle, timepickerview_title;
	private View btnSubmit, btnCancel;
	private TextView tvTitle;
	private static final String TAG_SUBMIT = "submit";
	private static final String TAG_CANCEL = "cancel";
	private OnTimeSelectListener timeSelectListener;

	public TimePickerView(Context context, Type type, boolean showlabel) {
		super(context);

		timepickerview_title = LayoutInflater.from(context).inflate(R.layout.pickerview_time, contentContainer);
		// ȷ����ȡ����ť
		btnSubmit = findViewById(R.id.btnSubmit);
		btnSubmit.setTag(TAG_SUBMIT);
		btnCancel = findViewById(R.id.btnCancel);
		btnCancel.setTag(TAG_CANCEL);
		btnSubmit.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		// ��������
		tvTitle = (TextView) findViewById(R.id.tvTitle);
		// ʱ��ת��
		timepickerview_notitle = findViewById(R.id.timepicker);
		wheelTime = new WheelTime(timepickerview_notitle, type, showlabel);

		// Ĭ��ѡ�е�ǰʱ��
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		wheelTime.setPicker(year, month, day, hours, minute);

	}

	/**
	 * ���ÿ���ѡ���ʱ�䷶Χ
	 *
	 * @param startYear
	 * @param endYear
	 */
	public void setRange(int startYear, int endYear) {
		wheelTime.setStartYear(startYear);
		wheelTime.setEndYear(endYear);
	}

	/**
	 * ����ѡ��ʱ��
	 * 
	 * @param date
	 */
	public void setTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date == null)
			calendar.setTimeInMillis(System.currentTimeMillis());
		else
			calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		wheelTime.setPicker(year, month, day, hours, minute);
	}

	/**
	 * �����Ƿ�ѭ������
	 *
	 * @param cyclic
	 */
	public void setCyclic(boolean cyclic) {
		wheelTime.setCyclic(cyclic);
	}

	/**
	 * �������ִ�С
	 * 
	 * @param textSize
	 */
	public void setTextSize(float textSize) {
		wheelTime.setTextSize(textSize);
	}

	@Override
	public void onClick(View v) {
		String tag = (String) v.getTag();
		if (tag.equals(TAG_CANCEL)) {
			dismiss();
			return;
		} else {
			if (timeSelectListener != null) {
				try {
					Date date = WheelTime.dateFormat.parse(wheelTime.getTime());
					timeSelectListener.onTimeSelect(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			dismiss();
			return;
		}
	}

	public interface OnTimeSelectListener {
		public void onTimeSelect(Date date);
	}

	public void setOnTimeSelectListener(OnTimeSelectListener timeSelectListener) {
		this.timeSelectListener = timeSelectListener;
	}

	public void setTitle(String title) {
		tvTitle.setText(title);
	}
	
	public View getTimePickerViewNoTitle(){
		return timepickerview_notitle;
	}
	
	public View getTimePickerViewWithTitle(){
		return timepickerview_title;
	}
	
	public void setLablePadingRight(float padingRight) {
		wheelTime.setLablePadingRight(padingRight);
    }
    
    public void setLabelYoffset(float yoffset) {
    	wheelTime.setLabelYOffset(yoffset);
    }
    
    public void setContentXOffset(float padingRight){
    	wheelTime.setContentXOffset(padingRight);
    }
    
    public void setCenterContentYOffset(float offset){
    	wheelTime.setCenterContentYOffset(offset);
    }
}
