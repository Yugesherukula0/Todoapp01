package com.dto;

public class Task {
	private int id;
	private int userid;
	private String title;
	private String status;

	public Task() {

	}

	public Task(int id, int userid, String title, String status) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.status = status;
	}

	public Task(int userid, String title, String status) {
		super();
		this.userid = userid;
		this.title = title;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", userid=" + userid + ", title=" + title + ", status=" + status + "]";
	}

}
