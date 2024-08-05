package collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/*

 */
public class LinkedMapApi {

    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        LinkedHashMap<String, Integer> counter = new LinkedHashMap<>();
        for (String key : arr) {
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }
        // It returns a set view of the mappings contained in the map,
        // and this set is ordered in the same order as the keys were
        // inserted into the map.
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry);
        }
    }

}
