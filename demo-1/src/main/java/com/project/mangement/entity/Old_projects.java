package com.project.mangement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "old_project")
public class Old_projects {

	@Id
	private int Oldproject_id;
	private String project_name;
	private String about;
	private String student1;
	private String student2;
	private String student3;
	private String student4;

	public int getOldproject_id() {
		return Oldproject_id;
	}

	public void setOldproject_id(int oldproject_id) {
		Oldproject_id = oldproject_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStudent1() {
		return student1;
	}

	public void setStudent1(String student1) {
		this.student1 = student1;
	}

	public String getStudent2() {
		return student2;
	}

	public void setStudent2(String student2) {
		this.student2 = student2;
	}

	public String getStudent3() {
		return student3;
	}

	public void setStudent3(String student3) {
		this.student3 = student3;
	}

	public String getStudent4() {
		return student4;
	}

	public void setStudent4(String student4) {
		this.student4 = student4;
	}

	@Override
	public String toString() {
		return "Old_projects [Oldproject_id=" + Oldproject_id + ", project_name=" + project_name + ", about=" + about
				+ ", student1=" + student1 + ", student2=" + student2 + ", student3=" + student3 + ", student4="
				+ student4 + "]";
	}

}