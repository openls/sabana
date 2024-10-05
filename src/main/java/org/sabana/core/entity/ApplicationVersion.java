package org.sabana.core.entity;

import java.util.Optional;

public class ApplicationVersion {

	private String version;
	private String name;
	private String buildDate;
	private String buildTime;

	public static ApplicationVersion newInstance() {
		return new ApplicationVersion();
	}

	public ApplicationVersion withVersion(String version) {
		this.version = version;
		return this;
	}

	public ApplicationVersion withName(String name) {
		this.name = name;
		return this;
	}

	public ApplicationVersion withBuildDate(String buildDate) {
		this.buildDate = buildDate;
		return this;
	}

	public ApplicationVersion withBuildTime(String buildTime) {
		this.buildTime = buildTime;
		return this;
	}

	public String getVersion() {
		return Optional.ofNullable(version).orElse("");
	}

	public String getName() {
		return Optional.ofNullable(name).orElse("");
	}

	public String getBuildDate() {
		return Optional.ofNullable(buildDate).orElse("");
	}

	public String getBuildTime() {
		return Optional.ofNullable(buildTime).orElse("");
	}

	public String getCompleteVersion() {
		return getVersion() + "@" + getBuildDate() + ":" + getBuildTime();
	}
}
