package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;

public final class Content implements Serializable {

	private static final long serialVersionUID = -2956518343097244420L;

	private String version;

	public Content() {
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Content [version=" + version + "]";
	}
}
