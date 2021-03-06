package com.bigkoo.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.lvfq.pickerview.TimePickerView;
import com.lvfq.pickerview.adapter.ArrayWheelAdapter;
import com.lvfq.pickerview.lib.WheelView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PickerViewUtil {

	/**
	 * 时间选择回调
	 */
	public interface TimerPickerCallBack {
		void onTimeSelect(String date);
	}

	/**
	 * 弹出时间选择
	 * 
	 * @param context
	 * @param type TimerPickerView 中定义的 选择时间类型
	 * @param format 时间格式化
	 * @param callBack 时间选择回调
	 */
	public static void alertTimerPicker(Context context, TimePickerView.Type type, final String format,
			final TimerPickerCallBack callBack) {
		TimePickerView pvTime = new TimePickerView(context, type, true);
//		控制时间范围
//		Calendar calendar = Calendar.getInstance();
//		pvTime.setRange(calendar.get(Calendar.YEAR) - 20,
//		calendar.get(Calendar.YEAR));
		pvTime.setTime(new Date());
		pvTime.setCyclic(false);
		pvTime.setCancelable(true);
		// 时间选择后回调
		pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

			@SuppressLint("SimpleDateFormat")
			@Override
			public void onTimeSelect(Date date) {
//				tvTime.setText(getTime(date));
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				callBack.onTimeSelect(sdf.format(date));
			}
		});
		pvTime.setTextSize(16);
		pvTime.show();
	}

	public static void alertTimerPicker(Context context, TimePickerView.Type type, final String format,
			boolean showlabel, final TimerPickerCallBack callBack) {
		TimePickerView pvTime = new TimePickerView(context, type, showlabel);
//		控制时间范围
//		Calendar calendar = Calendar.getInstance();
//		pvTime.setRange(calendar.get(Calendar.YEAR) - 20,
//		calendar.get(Calendar.YEAR));
		pvTime.setTime(new Date());
		pvTime.setCyclic(false);
		pvTime.setCancelable(true);
//		时间选择后回调
		pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

			@SuppressLint("SimpleDateFormat")
			@Override
			public void onTimeSelect(Date date) {
//				tvTime.setText(getTime(date));
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				callBack.onTimeSelect(sdf.format(date));
			}
		});
		pvTime.setTextSize(16);
		pvTime.show();
	}

	/**
	 * 底部滚轮点击事件回调
	 */
	public interface OnWheelViewClick {
		void onClick(View view, int postion);
	}

	/**
	 * 弹出底部滚轮选择
	 *
	 * @param context
	 * @param list
	 * @param click
	 */
	@SuppressLint("InflateParams")
	public static void alertBottomWheelOption(Context context, ArrayList<?> list, final OnWheelViewClick click) {

		final PopupWindow popupWindow = new PopupWindow();

		View view = LayoutInflater.from(context).inflate(R.layout.layout_bottom_wheel_option, null);
		TextView tv_confirm = (TextView) view.findViewById(R.id.btnSubmit);
		final WheelView wv_option = (WheelView) view.findViewById(R.id.wv_option);
		wv_option.setAdapter(new ArrayWheelAdapter(list));
		wv_option.setCyclic(false);
		wv_option.setTextSize(16);
		tv_confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				popupWindow.dismiss();
				click.onClick(view, wv_option.getCurrentItem());
			}
		});

		view.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				TODO: 2016/8/11 0011 取消
				popupWindow.dismiss();
			}
		});
		view.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				int top = view.findViewById(R.id.ll_container).getTop();
				if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
					int y = (int) motionEvent.getY();
					if (y < top) {
						popupWindow.dismiss();
					}
				}
				return true;
			}
		});
		popupWindow.setContentView(view);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
		popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
		popupWindow.showAtLocation(((ViewGroup) ((Activity) context).findViewById(android.R.id.content)).getChildAt(0), Gravity.CENTER, 0, 0);
	}
}
