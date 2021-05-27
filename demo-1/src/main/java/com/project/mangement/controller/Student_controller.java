package com.project.mangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mangement.entity.Doctor;
import com.project.mangement.entity.Email;
import com.project.mangement.entity.Notifiactions;
import com.project.mangement.entity.Old_projects;
import com.project.mangement.entity.Projects;
import com.project.mangement.entity.Student;
import com.project.mangement.repository.DoctorRepository;
import com.project.mangement.repository.NotificationRepository;
import com.project.mangement.repository.OldProjectsRepository;
import com.project.mangement.repository.ProjectRepository;
import com.project.mangement.repository.StudentRepositroy;

@RestController()
@RequestMapping("student")
public class Student_controller {

	@Autowired
	private StudentRepositroy repository;
	@Autowired
	private DoctorRepository repository_doctor;
	@Autowired
	private ProjectRepository repository_project;
	@Autowired
	private OldProjectsRepository repository_Oldproject;
	@Autowired
	private NotificationRepository repository_notification;

	@GetMapping("/myProfile/{id}")
	public Student my_profile(@PathVariable int id) {

		Student result = repository.my_profile(id);

		if (result != null)
			return result;
		else
			return new Student();

	}

	@PostMapping("/myProject")
	public Projects myProject(@RequestBody Projects project) {

		String doctorName = repository_doctor.doctor_name(project.getDoctor_id());

		if (doctorName == null)
			return new Projects();

		project.setProject_status(-1);
		project.setDoctor_name(doctorName);

		repository_project.save(project);

		Projects pro = repository_project.findProject(project.getDoctor_id(), project.getStudent_name1());

		if (pro != null) {

			Doctor doc = repository_doctor.doctor_info(pro.getProject_id());

			Email.sendEmail(doc.getEmail(), "New Project",
					"a new group has asked you to be the supervisour please check myRequests ASAP");

			repository_notification.save(new Notifiactions(doc.getId(), doc.getEmail(), "New Project",
					"a new group has asked you to be the supervisour please check myRequests ASAP"));

			return pro;

		} else
			return new Projects();

	}

	@GetMapping("/getProject/{id}")
	public Projects getProject(@PathVariable int id) {

		Projects project = repository_project.findProjectId(id);

		if (project != null)
			return project;
		else
			return new Projects();

	}

	@GetMapping("/oldProject")
	public List<Old_projects> oldProject() {

		List<Old_projects> OldProjects = repository_Oldproject.findAll();

		return OldProjects;

	}

	@GetMapping("/myStudents/{id}")
	public List<Student> doctorslist(@PathVariable int id) {

		List<Student> result = repository.myStudents(id);

		if (result != null)
			return result;
		else {

			return result;
		}
	}

}
