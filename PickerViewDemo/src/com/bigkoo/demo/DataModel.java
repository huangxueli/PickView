package com.bigkoo.demo;

import java.util.ArrayList;

import com.bigkoo.demo.bean.ProvinceBean;

public class DataModel {

    /**
     * ��ʼ������ѡ����ݡ�
     *
     * @param options1Items
     * @param options2Items
     * @param options3Items
     */
    public static void initData(ArrayList<ProvinceBean> options1Items, ArrayList<ArrayList<String>> options2Items, ArrayList<ArrayList<ArrayList<String>>> options3Items) {

        //ѡ��1
        options1Items.add(new ProvinceBean(0, "�㶫", "�㶫ʡ�������϶��������϶�·����", "��������"));
        options1Items.add(new ProvinceBean(1, "����", "����ʡ�ش��й��в����������Σ���󲿷������ڶ�ͥ�����϶���������", "â��TV"));
        options1Items.add(new ProvinceBean(2, "����", "�š���", ""));

        //ѡ��2
        ArrayList<String> options2Items_01 = new ArrayList<String>();
        options2Items_01.add("����");
        options2Items_01.add("��ɽ");
        options2Items_01.add("��ݸ");
        options2Items_01.add("����");
        options2Items_01.add("�麣");
        ArrayList<String> options2Items_02 = new ArrayList<String>();
        options2Items_02.add("��ɳ");
        options2Items_02.add("����");
        ArrayList<String> options2Items_03 = new ArrayList<String>();
        options2Items_03.add("����");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);

        //ѡ��3
        ArrayList<ArrayList<String>> options3Items_01 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> options3Items_02 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> options3Items_03 = new ArrayList<ArrayList<String>>();
        ArrayList<String> options3Items_01_01 = new ArrayList<String>();
        options3Items_01_01.add("����");
        options3Items_01_01.add("���");
        options3Items_01_01.add("����");
        options3Items_01_01.add("Խ��");
        options3Items_01.add(options3Items_01_01);
        ArrayList<String> options3Items_01_02 = new ArrayList<String>();
        options3Items_01_02.add("�Ϻ�");
        options3Items_01_02.add("����");
        options3Items_01_02.add("˳��");
        options3Items_01_02.add("����");
        options3Items_01.add(options3Items_01_02);
        ArrayList<String> options3Items_01_03 = new ArrayList<String>();
        options3Items_01_03.add("����");
        options3Items_01_03.add("��ƽ");
        options3Items_01_03.add("����");
        options3Items_01.add(options3Items_01_03);
        ArrayList<String> options3Items_01_04 = new ArrayList<String>();
        options3Items_01_04.add("����1");
        options3Items_01_04.add("����2");
        options3Items_01_04.add("����3");
        options3Items_01.add(options3Items_01_04);
        ArrayList<String> options3Items_01_05 = new ArrayList<String>();
        options3Items_01_05.add("����1");
        options3Items_01_05.add("����2");
        options3Items_01_05.add("����3");
        options3Items_01.add(options3Items_01_05);

        ArrayList<String> options3Items_02_01 = new ArrayList<String>();
        options3Items_02_01.add("��ɳ1");
        options3Items_02_01.add("��ɳ2");
        options3Items_02_01.add("��ɳ3");
        options3Items_02_01.add("��ɳ4");
        options3Items_02_01.add("��ɳ5");
        options3Items_02_01.add("��ɳ6");
        options3Items_02_01.add("��ɳ7");
        options3Items_02_01.add("��ɳ8");
        options3Items_02.add(options3Items_02_01);
        ArrayList<String> options3Items_02_02 = new ArrayList<String>();
        options3Items_02_02.add("��1");
        options3Items_02_02.add("��2");
        options3Items_02_02.add("��3");
        options3Items_02_02.add("��4");
        options3Items_02_02.add("��5");
        options3Items_02_02.add("��6");
        options3Items_02_02.add("��7");
        options3Items_02_02.add("��8");
        options3Items_02_02.add("��9");
        options3Items_02.add(options3Items_02_02);
        ArrayList<String> options3Items_03_01 = new ArrayList<String>();
        options3Items_03_01.add("��ɽˮ");
        options3Items_03.add(options3Items_03_01);

        options3Items.add(options3Items_01);
        options3Items.add(options3Items_02);
        options3Items.add(options3Items_03);
    }
}
