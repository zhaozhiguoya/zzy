package com.crx.model;

public class Submenu {
	private int id;
	private String title;
	private int type;
	private int mid;
	private String time;
	private int uid;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Submenu(int id, String title, int type, int mid, String time, int uid, String content) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.mid = mid;
		this.time = time;
		this.uid = uid;
		this.content = content;
	}
	public Submenu(String title, int type, int mid, String time, int uid, String content) {
		super();
		this.title = title;
		this.type = type;
		this.mid = mid;
		this.time = time;
		this.uid = uid;
		this.content = content;
	}
	public Submenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
