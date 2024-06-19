package collection.concurrent;

import java.util.*;
import java.util.concurrent.*;

public class SomeTest {

    private static CopyOnWriteArraySet<Integer> poolIds = new CopyOnWriteArraySet<>();

    /**
     * Chia mảng thành n mảng con
     */
    public static <T> List<List<T>> splitList(List<T> list, int n) {
        List<List<T>> result = new ArrayList<>();
        int partitionSize = list.size() / n;    // Dự đoán kích thước 1 list con
        int remaining = list.size() % n;    // Phần dư
        int currentIndex = 0;
        for (int i = 0; i < n; i++) {
            int subListSize = partitionSize;    // Kích thước 1 list con thực tế
            if (remaining > 0) {
                remaining--;
                subListSize++;
            }
            // int subListSize = partitionSize + (remaining-- > 0 ? 1 : 0);
            result.add(list.subList(currentIndex, currentIndex + subListSize));
            currentIndex += subListSize;
        }
        return result;
    }

    public static void main(String[] args) {
        // Init dataList
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i = 1; i <= 10_000; i++) {
            map.put(i, false);
        }

        // Get the first 1000 keys from map -> dataList
        List<Integer> dataList = new ArrayList<>(1000);
        int count = 0;
        for (int key : map.keySet()) {
            if (count == 1000) {
                break;
            }
            dataList.add(key);
            count++;
        }

        var splitData = splitList(dataList, 4);

        System.out.println("dataList = " + dataList);

        // Chia làm làm 4 và đẩy vào 4 thread để xử lý
        ExecutorService executor = Executors.newFixedThreadPool(4);
        splitData.forEach(d ->
            executor.submit(() -> {

            })
        );
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//        }
    }

//        // Set & List => Có thể remove() khi đang duyệt?
//    public static void test1() {
//        // CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
//        CopyOnWriteArraySet<Integer> list = new CopyOnWriteArraySet<>();
//        Collections.addAll(list, 1, 1, 2, 3, 4, 5);
//        // System.out.println(Arrays.toString(list.toArray()));
//        for (int x : list) {
//            if (x == 2) {
//                list.remove(x);
//            }
//        }
//    }

}
