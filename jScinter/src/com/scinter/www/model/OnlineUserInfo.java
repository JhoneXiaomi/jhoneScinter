package com.scinter.www.model;

public class OnlineUserInfo {

	private String sessionid;
	private String userId;
	private String username;
	private String createTime;
	private String accessedTime;
	private String activeTimes;
	private String ip;

	public String getSessionid() {
		return sessionid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAccessedTime() {
		return accessedTime;
	}

	public void setAccessedTime(String accessedTime) {
		this.accessedTime = accessedTime;
	}

	public String getActiveTimes() {
		return activeTimes;
	}

	public void setActiveTimes(String activeTimes) {
		this.activeTimes = activeTimes;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
