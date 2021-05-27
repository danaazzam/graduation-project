package com.project.mangement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Projects {

	@Id
	private int project_id;
	private String project_name;
	private String doctor_name;
	private int doctor_id;
	private String about;
	private String student_name1;
	private String student_name2;
	private String student_name3;
	private String student_name4;
	private int project_status;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStudent_name1() {
		return student_name1;
	}

	public void setStudent_name1(String student_name1) {
		this.student_name1 = student_name1;
	}

	public String getStudent_name2() {
		return student_name2;
	}

	public void setStudent_name2(String student_name2) {
		this.student_name2 = student_name2;
	}

	public String getStudent_name3() {
		return student_name3;
	}

	public void setStudent_name3(String student_name3) {
		this.student_name3 = student_name3;
	}

	public String getStudent_name4() {
		return student_name4;
	}

	public void setStudent_name4(String student_name4) {
		this.student_name4 = student_name4;
	}

	public int getProject_status() {
		return project_status;
	}

	public void setProject_status(int project_status) {
		this.project_status = project_status;
	}

	@Override
	public String toString() {
		return "Projects [project_id=" + project_id + ", project_name=" + project_name + ", doctor_name=" + doctor_name
				+ ", doctor_id=" + doctor_id + ", about=" + about + ", student_name1=" + student_name1
				+ ", student_name2=" + student_name2 + ", student_name3=" + student_name3 + ", student_name4="
				+ student_name4 + ", project_status=" + project_status + "]";
	}

}
