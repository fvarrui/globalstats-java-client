package io.github.fvarrui.globalstats.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

	@SerializedName("code")
	@Expose
	private Integer code;

	@SerializedName("message")
	@Expose
	private String message;

	@SerializedName("data")
	@Expose
	private String data;

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
	
	@Override
	public String toString() {
		return "Error " + code + ": " + message + " (" + data + ")";
	}

}
