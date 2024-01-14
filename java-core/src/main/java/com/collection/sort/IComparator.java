package com.collection.sort;


import com.basic.exception.ConcurrentModification;
import common.object.User;
import common.util.ListData;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IComparator {

    public static List<User> list = ListData.users();

    public static void show() {
        for (User u : list) {
            System.out.println(u);
        }
    }

    public static void compare() {
        // Collections.sort(list, new Comparator<User>() {
        //      @Override
        //      public int compare(User u1, User u2) {
        //           return u1.getAge() - u2.getAge();
        //      }
        // });

        // Sort kiểu int tăng dần, giảm dần
        Collections.sort(list, (u1, u2) -> u1.getAge() - u2.getAge());
        // Collections.sort(list, (u1, u2) -> u2.getAge() - u1.getAge());

        // Sort kiểu String tăng dần, giảm dần
        // Collections.sort(list, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        // Collections.sort(list, (u1, u2) -> u2.getName().compareTo(u1.getName()));

        show();
    }

    public static void comparing() {
        // So sánh thuận
        // Collections.sort(list, Comparator.comparing(User::getAge));
        // So sánh ngược
        Collections.sort(list, Comparator.comparing(User::getAge).reversed());
        // Collections.sort(list, Comparator.comparing(User::getName, Comparator.reverseOrder()));
        show();
    }

    // Tương tự cho Long, Double
    public static void comparingInt() {
        List<String> words = Arrays.asList("is2", "Thi1s", "T4est", "3a");
        System.out.println("Before: " + String.join(" ", words));
        Collections.sort(words, Comparator.comparingInt(s -> {
            String intNumber = s.replaceAll("\\D", "");
            return intNumber.isEmpty() ? 0 : Integer.parseInt(intNumber);
        }));
        System.out.println("After: " + String.join(" ", words));
    }

    public static void main(String[] args) {
        // comparingInt();
        // compare();
        comparing();
    }

}
