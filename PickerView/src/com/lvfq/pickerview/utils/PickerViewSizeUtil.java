package com.lvfq.pickerview.utils;

import android.content.Context;

public class PickerViewSizeUtil {

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为px(像素)
	 */
	public static int Dip2Px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int Px2Dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
	
	/**
	 * px值转换为sp值
	 */
	public static int Px2Sp(Context context, float px) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (px / fontScale + 0.5f);
	}

	/**
	 * sp值转换为px值
	 */
	public static int Sp2Px(Context context, float sp) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (sp * fontScale + 0.5f);
	}
}
