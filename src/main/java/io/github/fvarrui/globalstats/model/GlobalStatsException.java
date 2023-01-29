package io.github.fvarrui.globalstats.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalStatsException extends Exception {
	private static final long serialVersionUID = -4546541580805813125L;

	@SerializedName("code")
	@Expose
	private Integer code;
	
	@SerializedName("message")
	@Expose
	private String message;
	
	@SerializedName("data")
	@Expose
	private String data;

	public GlobalStatsException() {
		super();
	}

	public GlobalStatsException(Throwable cause) {
		super(cause);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
