package com.ram;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "olx.config")
public class OlxConfigData {
	private Long loginTime;
	private Long maxAdvs;

	public OlxConfigData(Long loginTime, Long maxAdvs) {
		super();
		this.loginTime = loginTime;
		this.maxAdvs = maxAdvs;
	}
	public OlxConfigData() {
		super();
	}
	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	public Long getMaxAdvs() {
		return maxAdvs;
	}
	public void setMaxAdvs(Long maxAdvs) {
		this.maxAdvs = maxAdvs;
	}
	@Override
	public String toString() {
		return "OlxConfigData [loginTime=" + loginTime + ", maxAdvs=" + maxAdvs + "]";
	}

}
