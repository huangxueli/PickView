package com.bigkoo.demo.bean;

public class TypeBean {

    private int id;
    private String name;

    public TypeBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //���������ʾ��PickerView������ַ���,PickerView��ͨ�������ȡgetPickerViewText������ʾ������
    public String getPickerViewText() {
        //���ﻹ�����ж����ֳ����ض����ṩ��ʾ
        return name;
    }
}
