package com.json.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sample implements Serializable {

	private static final long serialVersionUID = 515027760598197195L;

	private String id;

	@JsonProperty("execute_time")
	private Date executeTime;

	@JsonProperty("ngaygui_hoadon")
	private Date ngayguiHoadon;

	@JsonProperty("ngaygui_tct")
	private Date ngayguiTct;

	private Timestamp ngaycapnhat;

	@JsonProperty("id_user")
	private String idUser;

	@JsonProperty("maloai_tdiep")
	private String maloaiTdiep;

	private String manoigui;

	private String manoinhan;

	@JsonProperty("masothue_tvan")
	private String masothueTvan;

	private String matdiep;

	@JsonProperty("mathdiep_thamchieu")
	private String mathdiepThamchieu;

	@JsonProperty("noidung_gui")
	private String noidungGui;

	@JsonProperty("tenhoso")
	private String tenHoSo;

	@JsonProperty("tinhtrang_gui")
	private int tinhtrangGui;

	@JsonProperty("tinhtrang_ky")
	private int tinhtrangKy;

	@JsonProperty("create_time")
	private long createTime = 0;

	@JsonProperty("matdiep_tcgp")
	private String matdieptcgp;

}