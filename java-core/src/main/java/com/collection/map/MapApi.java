package com.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapApi {

    /*-
     * - put(k, v) ~ addOrUpdate: Thêm mới entry hoặc cập nhật giá trị của một entry
     * đã tồn tại. Hàm trả về giá trị cũ của entry với key đã được cập nhật (nếu có).
     * Nếu key chưa tồn tại, phương thức trả về `null`.
     *
     * - putIfAbsent(k, v) ~ addIfNotExist: Chỉ thêm mới entry khi key chưa tồn tại
     * trong Map. Hàm trả về giá trị hiện tại của entry với key đã tồn tại, hoặc giá
     * trị mới được cung cấp nếu key chưa tồn tại.
     *
     * - getOrDefault(k, v): Trả về phần tử của key được chỉ định. Nếu key không tồn
     * tại sẽ trả về default value mà chúng ta truyền vào.
     *
     * - compute("key", (k, v) -> to_do): Tính toán dựa trên key-value hiện tại (k chính là "key")
     *
     * - computeIfPresent("key", (k, v) -> to_do): Chỉ thực hiện khi key tồn tại và value != null
     *
     * - computeIfAbsent(k, k1 -> to_do): Chỉ thực hiện khi key chưa tồn tại hoặc value == null
     *
     * - keySet(): Set<K>
     *
     * - values(): Collection<V>
     *
     * - entrySet() = keySet() + values()
     *
     * - remove(k): Xóa entry - remove(k, v): Xóa chính xác entry có giá trị k, v
     *
     * - containsKey()
     * - containsValue()
     *
     * - replace(k, v): Cập nhập giá trị của 1 entry
     * - replace(k, v, v0): Cập nhập giá trị của 1 entry đúng giá trị k, v
     *
     * - wordCountMap.replaceAll((key, value) -> value * 2); // Nhân đôi giá trị
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
        map.compute("ten1", (k, v) -> v == null ? 1_000 : v * v );
        System.out.println("After: " + map);
    }

    public static void main(String[] args) {
        // mapApi();
        compute();
    }

}
