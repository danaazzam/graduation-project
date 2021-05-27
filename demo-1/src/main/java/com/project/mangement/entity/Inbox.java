package com.project.mangement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inbox")
public class Inbox {

	@Id
	private int id;
	private String message;
	private String sender_email;
	private String sender_name;
	private String reciver_email;
	private String reciver_name;
	private String message_date;
	private int reciver_id;
	private int sender_id;

	public int getReciver_id() {
		return reciver_id;
	}

	public void setReciver_id(int reciver_id) {
		this.reciver_id = reciver_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getReciver_email() {
		return reciver_email;
	}

	public void setReciver_email(String reciver_email) {
		this.reciver_email = reciver_email;
	}

	public String getReciver_name() {
		return reciver_name;
	}

	public void setReciver_name(String reciver_name) {
		this.reciver_name = reciver_name;
	}

	public String getMessage_date() {
		return message_date;
	}

	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}

	@Override
	public String toString() {
		return "Inbox [id=" + id + ", message=" + message + ", sender_email=" + sender_email + ", sender_name="
				+ sender_name + ", reciver_email=" + reciver_email + ", reciver_name=" + reciver_name
				+ ", message_date=" + message_date + ", reciver_id=" + reciver_id + ", sender_id=" + sender_id + "]";
	}

}
