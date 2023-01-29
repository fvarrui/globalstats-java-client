package io.github.fvarrui.globalstats.model;

import java.net.URL;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rank {

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("user_profile")
	@Expose
	private URL userProfile;

	@SerializedName("user_icon")
	@Expose
	private URL userIcon;

	@SerializedName("value")
	@Expose
	private Integer value;

	@SerializedName("rank")
	@Expose
	private Integer rank;

	@SerializedName("additionals")
	@Expose
	private List<Value> additionals;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(URL userProfile) {
		this.userProfile = userProfile;
	}

	public URL getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(URL userIcon) {
		this.userIcon = userIcon;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public List<Value> getAdditionals() {
		return additionals;
	}

	public void setAdditionals(List<Value> additionals) {
		this.additionals = additionals;
	}

	@Override
	public String toString() {
		return "Rank [name=" + name + ", userProfile=" + userProfile + ", userIcon=" + userIcon + ", value=" + value
				+ ", rank=" + rank + ", additionals=" + additionals + "]";
	}

}