
package io.github.fvarrui.globalstats.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Achievement {

	@SerializedName("key")
	@Expose
	private String key;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("image_active")
	@Expose
	private String imageActive;

	@SerializedName("image_inactive")
	@Expose
	private String imageInactive;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageActive() {
		return imageActive;
	}

	public void setImageActive(String imageActive) {
		this.imageActive = imageActive;
	}

	public String getImageInactive() {
		return imageInactive;
	}

	public void setImageInactive(String imageInactive) {
		this.imageInactive = imageInactive;
	}

	@Override
	public String toString() {
		return "Achievement [key=" + key + ", name=" + name + ", description=" + description + ", imageActive="
				+ imageActive + ", imageInactive=" + imageInactive + "]";
	}

}
