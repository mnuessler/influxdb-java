package org.influxdb.dto;

import java.util.Objects;

/**
 * Representation of the response for a influxdb ping.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class Pong {
	private String version;
	private long responseTime;

	/**
	 * @return the status
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * @param version
	 *            the status to set
	 */
	public void setVersion(final String version) {
		this.version = version;
	}

	/**
	 * @return the responseTime
	 */
	public long getResponseTime() {
		return this.responseTime;
	}

	/**
	 * @param responseTime
	 *            the responseTime to set
	 */
	public void setResponseTime(final long responseTime) {
		this.responseTime = responseTime;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pong [");
        sb.append("version='").append(version).append('\'');
        sb.append(", responseTime=").append(responseTime);
        sb.append(']');
        return sb.toString();
    }
}
