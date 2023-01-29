
package io.github.fvarrui.globalstats.model;

import java.net.URL;

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
	private URL imageActive;

	@SerializedName("image_inactive")
	@Expose
	private URL imageInactive;

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

	public URL getImageActive() {
		return imageActive;
	}

	public void setImageActive(URL imageActive) {
		this.imageActive = imageActive;
	}

	public URL getImageInactive() {
		return imageInactive;
	}

	public void setImageInactive(URL imageInactive) {
		this.imageInactive = imageInactive;
	}

	@Override
	public String toString() {
		return "Achievement [key=" + key + ", name=" + name + ", description=" + description + ", imageActive="
				+ imageActive + ", imageInactive=" + imageInactive + "]";
	}

}
