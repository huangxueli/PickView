package com.lvfq.pickerview.utils;

import android.content.Context;

public class PickerViewSizeUtil {

	/**
	 * �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊpx(����)
	 */
	public static int Dip2Px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * �����ֻ��ķֱ��ʴ� px(����) �ĵ�λ ת��Ϊ dp
	 */
	public static int Px2Dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
	
	/**
	 * pxֵת��Ϊspֵ
	 */
	public static int Px2Sp(Context context, float px) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (px / fontScale + 0.5f);
	}

	/**
	 * spֵת��Ϊpxֵ
	 */
	public static int Sp2Px(Context context, float sp) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (sp * fontScale + 0.5f);
	}
}
