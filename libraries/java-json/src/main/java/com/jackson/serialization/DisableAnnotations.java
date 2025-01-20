package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.PrettyJson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({"name", "id"}) // sắp xếp field
public class DisableAnnotations implements PrettyJson {

    public int id;
    public String name;

    public static void main(String[] args) throws JsonProcessingException {
        DisableAnnotations bean = new DisableAnnotations(1, null);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS); // disable all Jackson annotations

        System.out.println(bean.toJSON(objectMapper));
    }

}
