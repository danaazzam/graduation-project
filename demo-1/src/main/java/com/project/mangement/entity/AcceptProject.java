package com.project.mangement.entity;

public class AcceptProject {

	private int project_id;
	private int doctor_id;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	@Override
	public String toString() {
		return "AcceptProject [project_id=" + project_id + ", doctor_id=" + doctor_id + "]";
	}

}
