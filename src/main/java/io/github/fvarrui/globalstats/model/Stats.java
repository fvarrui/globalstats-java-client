
package io.github.fvarrui.globalstats.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("_id")
	@Expose
	private String id;

	@SerializedName("values")
	@Expose
	private List<Value> values = null;

	@SerializedName("achievements")
	@Expose
	private List<Achievement> achievements = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public List<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	@Override
	public String toString() {
		return "Stats [name=" + name + ", id=" + id + ", values=" + values + ", achievements=" + achievements + "]";
	}

}
