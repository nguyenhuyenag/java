package com;


import common.object.User;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.Random;

public class MainCore {

    public static void main(String[] args) {
        User u1 = new User("An", 22);
        User u2 = u1;
        u2.setAge(1_000);
        System.out.println(u1);
        System.out.println(u2);
    }

}
