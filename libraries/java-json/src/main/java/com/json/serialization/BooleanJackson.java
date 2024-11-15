package com.json.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooleanJackson {

    // Nếu không có @JsonProperty thì dù gửi { "isNewContract": true} vẫn nhận giá trị false
    @JsonProperty("isNewContract")
    private boolean isNewContract;

}
