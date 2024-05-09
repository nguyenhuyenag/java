package collection.map;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class SwapKeyValue {

    private <A, B> Map<B, A> invertMap(Map<A, B> map) {
        Map<B, A> reverseMap = new HashMap<>();
        for (Map.Entry<A, B> entry : map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        return reverseMap;
    }

    public static void main(String[] args) {
        Map<String, Character> myHashMap = new HashMap<>();
        Map<Character, String> inversedMap = new HashMap<>();
        myHashMap.forEach((key, value) -> inversedMap.put(value, key));
    }
}
