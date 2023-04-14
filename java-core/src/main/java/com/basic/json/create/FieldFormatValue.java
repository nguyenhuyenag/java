package com.basic.json.create;

import java.util.Date;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldFormatValue extends PrettyJson {

	public String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public Date eventDate;

	public static void main(String[] args) {
		FieldFormatValue bean = new FieldFormatValue("party", new Date());
		System.out.println(bean.toJSON());
	}

}
