package com.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.object.User;

public class QueueWithObject {

    public static void comparing() {
        Comparator<User> comparator = Comparator.comparing(User::getName); // auto sort by name
        PriorityQueue<User> queue = new PriorityQueue<>(comparator);
    }

}
