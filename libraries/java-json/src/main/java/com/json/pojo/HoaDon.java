package com.json.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.json.PrettyJson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({ "id_user" })
public class HoaDon extends Sample implements PrettyJson {

	private static final long serialVersionUID = -2911410330228623991L;

	private static HoaDon createData() {
		HoaDon entity = new HoaDon();
		entity.setId("01cf4f3f-64ec-4e4f-8e8a-763b14f8af23");
		entity.setExecuteTime(new Date());
		entity.setCreateTime(System.currentTimeMillis());
		entity.setTenHoSo("Hóa đơn từ máy tính tiền");
		entity.setMaloaiTdiep("206");
		entity.setMatdiep("V030947830663EF51CF73434778B7A878E9107356A8");
		entity.setManoigui("V0309478306");
		entity.setManoinhan("TCT");
		entity.setTinhtrangKy(1);
		entity.setIdUser("0002");
		return entity;
	}

	public static void main(String[] args) {
		HoaDon hoadon = createData();
		System.out.println(hoadon.toJSON());
	}

}
