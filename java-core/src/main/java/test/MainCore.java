package test;

import com.fasterxml.uuid.Generators;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainCore {

    public static void main(String[] args) {
        String str = "Coooovvvidd 19";
        Map<String, Integer> counter = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            counter.put(String.valueOf(c), counter.getOrDefault(String.valueOf(c), 0) + 1);
        }
        // Print the map to verify the results
        counter.forEach((key, value) -> System.out.print(key));
    }

}
