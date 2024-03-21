package com;


import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.Random;

public class MainCore {

    public static void main(String[] args) {
        BigInteger n1 = new BigInteger("987");
        BigInteger n2 = new BigInteger("-987");
        BigInteger n3 = new BigInteger("123");
        System.out.println(n1.mod(n3));
        System.out.println(n1.remainder(n3));
    }

}
