package com.crx.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String logtime;
	private String type;
	private String demo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDemo() {
		return demo;
	}
	public void setDemo(String demo) {
		this.demo = demo;
	}
	/*public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}*/
	public User() {
		super();
	}
	public User(int id, String username, String password, String logtime, String type, String demo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.logtime = logtime;
		this.type = type;
		this.demo = demo;
	}
	

}
