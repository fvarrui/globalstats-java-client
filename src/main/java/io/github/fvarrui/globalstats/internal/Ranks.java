package io.github.fvarrui.globalstats.internal;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.fvarrui.globalstats.model.Rank;

public class Ranks {

	@SerializedName("data")
	@Expose
	private List<Rank> data;

	public List<Rank> getData() {
		return data;
	}

	public void setData(List<Rank> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Ranks [data=" + data + "]";
	}

}
