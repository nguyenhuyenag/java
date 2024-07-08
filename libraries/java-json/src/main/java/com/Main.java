package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[{\"op\":\"add\",\"path\":\"/details\",\"value\":[\"name\",\"date\"]}]";
        ArrayNode parse = (ArrayNode) mapper.readTree(json);

        for (JsonNode patch : parse) {
            ArrayNode valueNode = (ArrayNode) patch.get("value");
            for (int i = 0; i < valueNode.size(); i++) {
                String upper = valueNode.get(i).asText().toUpperCase();
                valueNode.set(i, valueNode.textNode(upper));
            }
        }

        String output = mapper.writeValueAsString(parse);
        System.out.println(output);
    }

}
