package com.crx.model;

public class Menu {
	private int id;
	private String title;
	private int type;
	private int mid;
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
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public Menu(int id, String title, int type, int mid) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.mid = mid;
	}
	
	public Menu(int id, String title, int type) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
	}
	public Menu(String title, int type, int mid) {
		super();
		this.title = title;
		this.type = type;
		this.mid = mid;
	}
	public Menu(String title, int type) {
		super();
		this.title = title;
		this.type = type;
	}
	public Menu() {
		super();
	}
	
}
