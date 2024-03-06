package com;


import org.apache.commons.lang3.StringUtils;

public class MainCore {

    public static void main(String[] args) {
        String s = "123      ";
        System.out.println("s = " + s.length());
        s = StringUtils.stripEnd(s,"");
        System.out.println("s = " + s.length());
    }

}
