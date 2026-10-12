package test;

import com.fasterxml.uuid.Generators;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainCore {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            String uuid = Generators.timeBasedGenerator().generate().toString();
            map.put(uuid, "Value " + i);
        }
        // Print the map to verify the results
        map.forEach((key, value) -> System.out.println(key + " => " + value));
    }

}
