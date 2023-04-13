package com.basic.json.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatDatetime extends PrettyJson {

	private String name;
	private Date eventDate;

	/**
	 * Mặc định Jackson sẽ chuyển Date sang Timestamp (long) tính từ 01 – 01 – 1970
	 * UTC khi serialize sang Json
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		Date date = df.parse("01-01-2020 00:00");
		FormatDatetime bean = new FormatDatetime("party", date);

		// without format
		System.out.println(bean.toJSON());

		// format
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(df);
		System.out.println(bean.toJSON(mapper));
	}

}
