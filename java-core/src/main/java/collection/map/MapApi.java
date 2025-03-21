package collection.map;

import java.util.*;

public class MapApi {

    /*-
        - put(k, v) ~ addOrUpdate: Thêm mới hoặc cập nhật giá trị của key:
            + Nếu key chưa tồn tại put(k,v) trả về `null`.
            + Nếu key đã tồn tại (k, v1) thì sẽ cập nhật v2 và trả về v1.

        - putIfAbsent(k, v) ~ addIfNotExist: Chỉ thêm mới entry khi key chưa tồn tại
        trong Map. Hàm trả về giá trị hiện tại của entry với key đã tồn tại, hoặc giá
        trị mới được cung cấp nếu key chưa tồn tại.

        - merge("key", "newValue", (oldValue, newValue) -> oldValue + "_" + newValue);

        - getOrDefault(k, v): Trả về phần tử của key được chỉ định. Nếu key không tồn
        tại sẽ trả về default value mà chúng ta truyền vào.

        - compute("key", (k, v) -> to_do): Tính toán dựa trên key-value hiện tại (k chính là "key")

        - computeIfPresent("key", (k, v) -> to_do): Chỉ thực hiện khi key tồn tại và value != null

        - computeIfAbsent(k, k1 -> to_do): Chỉ thực hiện khi key chưa tồn tại hoặc value == null

        - keySet(): Set<K>

        - values(): Collection<V>

        - entrySet() = keySet() + values()

        - remove(e): Xóa entry
        - remove(k, v): Xóa chính xác entry có giá trị k, v

        - containsKey()
        - containsValue()

        - replace(k, v):     Cập nhập giá trị của 1 entry
        - replace(k, v, v0): Cập nhập giá trị của 1 entry đúng giá trị k, v

        - Map.replaceAll((key, value) -> value  2); // Nhân đôi giá trị
    */
    public static void mapApi() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 80);
        scores.put("B", 75);

        // replaceAll()
        scores.replaceAll((name, score) -> score + 5);
        System.out.println("ReplaceAll: " + scores);

        scores.put("C", null);
        scores.computeIfPresent("A", (k, v) -> 1000);
        scores.computeIfPresent("C", (k, v) -> 2000); // Nothing change C
        System.out.println("ComputeIfPresent: " + scores);

        scores.computeIfAbsent("C", k -> 22);
        scores.computeIfAbsent("D", k -> 33);
        System.out.println("ComputeIfAbsent: " + scores);
    }

    public static void compute() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ten", 10);
        System.out.println("Before: " + map);
        // Tính toán với giá trị hiện tại
        map.compute("ten", (k, v) -> v * v);

        // Nếu k không tồn tại sẽ lỗi, do đó phải kiểm tra tồn tại của k hoặc v
        // map.compute("ten", (k, v) -> v * v); // Error
        map.compute("ten1", (k, v) -> v == null ? 1_000 : v * v);
        System.out.println("After: " + map);
    }

    public static void mapWithCollectionValue() {
        String[] arr = {"a", "c", "c", "a", "b", "c"};
        // <value, list_index>
        Map<String, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // groupMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            groupMap.computeIfAbsent(arr[i], k -> {
                System.out.println("k = " + k);
                return new ArrayList<>();
            }).add(i);
        }
        System.out.println("GroupMap = " + groupMap);
    }

    public static void mapWithCollectionValue_2() {
        // @formatter:off
        String[] keys = {"key 1", "key 2", "key 3"};
        String[] vals = {"value 1", "value 2", "value 3"};
        Map<String, StringJoiner> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.computeIfAbsent(keys[i], v -> new StringJoiner(", "))
               .add(vals[i]);
        }
        // @formatter:on
    }

    public static void mergerAndGetOrDefault() {
        int[] nums = {3, 2, 3, 2, 2, 2};

        // (1) Cách thông thường
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
            (2) Cách dùng merge
                - Nếu num chưa có trong counter, nó sẽ được thêm vào với giá trị 1.
                - Nếu num đã tồn tại, giá trị của nó sẽ được cập nhật bằng cách cộng thêm 1
         */
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            // counter.merge(num, 1, Integer::sum);
            counter.merge(num, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        // mapApi();
        // compute();
        // mapWithCollectionValue();
        // mapWithCollectionValue_2();
        mergerAndGetOrDefault();
    }

}
