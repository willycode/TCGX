package com.kangdainfo.util.net;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class FtpRoutingContext {

	private String host;
	private int port;
	private String username;
	private String password;
	private String encoding;
	private String enterLocalPassiveMode;
	private String defaultDirectory;
	private String usingSSL;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}		
	public String getEnterLocalPassiveMode() {
		return enterLocalPassiveMode;
	}
	public void setEnterLocalPassiveMode(String enterLocalPassiveMode) {
		this.enterLocalPassiveMode = enterLocalPassiveMode;
	}
	public String getDefaultDirectory() {
		return defaultDirectory;
	}
	public void setDefaultDirectory(String defaultDirectory) {
		this.defaultDirectory = defaultDirectory;
	}	
	public String getUsingSSL() {
		return usingSSL;
	}
	public void setUsingSSL(String usingSSL) {
		this.usingSSL = usingSSL;
	}
	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof FtpRoutingContext) ) return false;
        FtpRoutingContext castOther = (FtpRoutingContext) other;
        return new EqualsBuilder()
            .append(this.getHost(), castOther.getHost())
            .append(this.getPort(), castOther.getPort())
            .append(this.getUsername(), castOther.getUsername())
            .append(this.getEncoding(), castOther.getEncoding())  
            .append(this.getDefaultDirectory(), castOther.getDefaultDirectory())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHost())
            .append(getPort())
            .append(getUsername())
            .append(getEncoding())
            .append(getDefaultDirectory())
            .toHashCode();
    }
    
	
}
