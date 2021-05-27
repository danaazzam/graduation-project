package com.project.mangement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notifiactions")
public class Notifiactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notifiactions_id;
	private int user_id;
	private String email;
	private String message_body;
	private String message_title;

	public Notifiactions() {
	}

	public Notifiactions(int user_id, String email, String message_body, String message_title) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.message_body = message_body;
		this.message_title = message_title;
	}

	public int getNotifiactions_id() {
		return notifiactions_id;
	}

	public void setNotifiactions_id(int notifiactions_id) {
		this.notifiactions_id = notifiactions_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage_body() {
		return message_body;
	}

	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}

	public String getMessage_title() {
		return message_title;
	}

	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}

	@Override
	public String toString() {
		return "Notifiactions [notifiactions_id=" + notifiactions_id + ", user_id=" + user_id + ", email=" + email
				+ ", message_body=" + message_body + ", message_title=" + message_title + "]";
	}

}
