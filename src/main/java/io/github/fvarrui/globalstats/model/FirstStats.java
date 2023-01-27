package io.github.fvarrui.globalstats.model;

import java.util.Map;

public class FirstStats {

	private String name;
	private Map<String, Object> values;
	
	public FirstStats() {}

	public FirstStats(String name, Map<String, Object> values) {
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

}
