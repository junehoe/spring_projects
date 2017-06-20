package com.junehoe.grouplanguages.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language {
	@Size(min=2, max=20)
	private String name;
	
	@Size(min=2, max=20)
	private String creator;
	
	@NotNull
	private double currentVersion;

	public Language() {
	}
	
	public Language(String name, String creator, double currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public double getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(double currentVersion) {
		this.currentVersion = currentVersion;
	}
}
