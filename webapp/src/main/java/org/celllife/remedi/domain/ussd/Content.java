package org.celllife.remedi.domain.ussd;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Domain object used for the USSD endpoint. Contains version information
 */
@Embeddable
public final class Content implements Serializable {

	private static final long serialVersionUID = 7446811257791848435L;

	@Basic
	private String version;

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
