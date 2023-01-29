package io.github.fvarrui.globalstats.internal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {

	@SerializedName("access_token")
	@Expose
	private String accessToken;

	@SerializedName("token_type")
	@Expose
	private String tokenType;

	@SerializedName("expires_in")
	@Expose
	private Integer expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expiresIn=" + expiresIn
				+ "]";
	}

}