package com.gson;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ZaloTemplateRequest {

    private String phone;

    @SerializedName("template_id")
    private String templateId;

    @SerializedName("template_data")
    private Object templateData;

}
