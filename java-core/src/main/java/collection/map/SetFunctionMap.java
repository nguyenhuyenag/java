package collection.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Tạo map theo điều kiện nào đó
 *
 *      Set + Function = Map
 */
public class SetFunctionMap {

    private static <K, V> Map<K, V> buildMap(Iterable<K> keys, Function<? super K, V> valueFunction) {
        Map<K, V> builder = new HashMap<>();
        for (K key : keys) {
            builder.put(key, valueFunction.apply(key));
        }
        return builder;
    }

    // Tạo map từ chuỗi và độ dài của nó
    public static void main(String[] args) {
        List<String> keys = List.of("one", "two", "three");
        Function<String, Integer> valueFunction = String::length;
        // Function<String, Integer> valueFunction = key -> key.length();
        Map<String, Integer> keyToLengthMap = buildMap(keys, valueFunction);
        System.out.println(keyToLengthMap);
    }

}
