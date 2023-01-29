
package io.github.fvarrui.globalstats.model;

import java.time.LocalDateTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

	@SerializedName("key")
	@Expose
	private String key;

	@SerializedName("value")
	@Expose
	private Integer value;

	@SerializedName("sorting")
	@Expose
	private String sorting;

	@SerializedName("rank")
	@Expose
	private Integer rank;

	@SerializedName("updated_at")
	@Expose
	private LocalDateTime updatedAt;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Value [key=" + key + ", value=" + value + ", sorting=" + sorting + ", rank=" + rank + ", updatedAt="
				+ updatedAt + "]";
	}

}
