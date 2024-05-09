package collection.queue;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueWithPair {

    public static void main(String[] args) {
        Comparator<AbstractMap.SimpleEntry<Integer, String>>
                comparator = Comparator.comparingInt(AbstractMap.SimpleEntry::getKey);

        PriorityQueue<AbstractMap.SimpleEntry<Integer, String>> pq = new PriorityQueue<>(comparator.reversed());

        pq.add(new AbstractMap.SimpleEntry<>(9, "Jame"));
        pq.add(new AbstractMap.SimpleEntry<>(4, "Mary"));
        pq.add(new AbstractMap.SimpleEntry<>(2, "Dante"));
        pq.add(new AbstractMap.SimpleEntry<>(5, "Jack"));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

}
