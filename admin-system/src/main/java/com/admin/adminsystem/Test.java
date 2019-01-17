package com.admin.adminsystem;

import java.util.ArrayList;

/**
 * Created by DC on 2018/8/28.
 */
public class Test {
    public static void main(String[] args) {

//        String s = "qwe";
//        String[] ss = s.split(",");
//        for (int i = 0; i < ss.length; i++)
//            System.out.println(ss[i]);
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        a.add("ppp");a.add("323");a.add("11");a.add("444");a.add("123213");
        b.add("kkk");b.add("dds");b.add("rre");b.add("ccx");b.add("zza");
        a.addAll(b);
        System.out.println(a.toString());
        a.addAll(b);
        System.out.println(a.toString());
    }
}
