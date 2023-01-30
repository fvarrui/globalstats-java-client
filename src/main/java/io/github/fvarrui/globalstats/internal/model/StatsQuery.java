package io.github.fvarrui.globalstats.internal.model;

import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatsQuery {

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("values")
	@Expose
	private Map<String, Object> values;

	public StatsQuery() {
	}

	public StatsQuery(Map<String, Object> values) {
		this(null, values);
	}

	public StatsQuery(String name, Map<String, Object> values) {
		super();
		this.name = name;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "SendStats [name=" + name + ", values=" + values + "]";
	}

}