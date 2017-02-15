package com.lvfq.pickerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.R;
import com.lvfq.pickerview.view.BasePickerView;
import com.lvfq.pickerview.view.WheelOptions;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class OptionsPickerView<T> extends BasePickerView implements View.OnClickListener {
    
	WheelOptions wheelOptions;
    private View btnSubmit, btnCancel;
    private TextView tvTitle;
    private OnOptionsSelectListener optionsSelectListener;
    private static final String TAG_SUBMIT = "submit";
    private static final String TAG_CANCEL = "cancel";

    private View optionspicker_title, optionspicker_notitle;
    
    public OptionsPickerView(Context context) {
        super(context);
        optionspicker_title  = LayoutInflater.from(context).inflate(R.layout.pickerview_options, contentContainer);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setTag(TAG_SUBMIT);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setTag(TAG_CANCEL);
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        // 顶部标题
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        // 转轮
        optionspicker_notitle = findViewById(R.id.optionspicker);
        wheelOptions = new WheelOptions(optionspicker_notitle);
    }

    @SuppressWarnings("unchecked")
	public void setPicker(ArrayList<T> optionsItems) {
        wheelOptions.setPicker(optionsItems, null, null, false);
    }

    @SuppressWarnings("unchecked")
	public void setPicker(ArrayList<T> options1Items,
                          ArrayList<ArrayList<T>> options2Items, boolean linkage) {
        wheelOptions.setPicker(options1Items, options2Items, null, linkage);
    }

    @SuppressWarnings("unchecked")
	public void setPicker(ArrayList<T> options1Items,
                          ArrayList<ArrayList<T>> options2Items,
                          ArrayList<ArrayList<ArrayList<T>>> options3Items,
                          boolean linkage) {
        wheelOptions.setPicker(options1Items, options2Items, options3Items, linkage);
    }

    /**
     * 设置选中的item位置
     *
     * @param option1
     */
    public void setSelectOptions(int option1) {
        wheelOptions.setCurrentItems(option1, 0, 0);
    }

    /**
     * 设置选中的item位置
     *
     * @param option1
     * @param option2
     */
    public void setSelectOptions(int option1, int option2) {
        wheelOptions.setCurrentItems(option1, option2, 0);
    }

    /**
     * 设置选中的item位置
     *
     * @param option1
     * @param option2
     * @param option3
     */
    public void setSelectOptions(int option1, int option2, int option3) {
        wheelOptions.setCurrentItems(option1, option2, option3);
    }

    /**
     * 设置选项的单位
     *
     * @param label1
     */
    public void setLabels(String label1) {
        wheelOptions.setLabels(label1, null, null);
    }

    /**
     * 设置选项的单位
     *
     * @param label1
     * @param label2
     */
    public void setLabels(String label1, String label2) {
        wheelOptions.setLabels(label1, label2, null);
    }

    public void setLabels(String label1, String label2, String label3) {
        wheelOptions.setLabels(label1, label2, label3);
    }
    
    public void setLablePadingRight(float padingRight) {
    	wheelOptions.setLablePadingRight(padingRight);
    }
    
    public void setLabelYoffset(float yoffset) {
    	wheelOptions.setLabelYOffset(yoffset);
    }
    
    public void setContentXOffset(float padingRight){
    	wheelOptions.setContentXOffset(padingRight);
    }
    
    public void setCenterContentYOffset(float offset){
    	wheelOptions.setCenterContentYOffset(offset);
    }
    /**
     * 设置是否循环滚动
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        wheelOptions.setCyclic(cyclic);
    }

    public void setCyclic(boolean cyclic1, boolean cyclic2, boolean cyclic3) {
        wheelOptions.setCyclic(cyclic1, cyclic2, cyclic3);
    }


    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tag.equals(TAG_CANCEL)) {
            dismiss();
            return;
        } else {
            if (optionsSelectListener != null) {
                int[] optionsCurrentItems = wheelOptions.getCurrentItems();
                optionsSelectListener.onOptionsSelect(optionsCurrentItems[0], optionsCurrentItems[1], optionsCurrentItems[2]);
            }
            dismiss();
            return;
        }
    }

    public interface OnOptionsSelectListener {
        public void onOptionsSelect(int options1, int option2, int options3);
    }

    public void setOnoptionsSelectListener(
            OnOptionsSelectListener optionsSelectListener) {
        this.optionsSelectListener = optionsSelectListener;
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    /**
     * 设置文字大小
     * @param textSize
     */
    public void setTextSize(float textSize) {
        wheelOptions.setTextSize(textSize);
    }
    
    public View getOptionsPickerViewNoTitle(){
		return optionspicker_notitle;
	}
	
	public View getOptionsPickerViewWithTitle(){
		return optionspicker_title;
	}
}
