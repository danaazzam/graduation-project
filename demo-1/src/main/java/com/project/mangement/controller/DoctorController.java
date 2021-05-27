package com.project.mangement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mangement.entity.AcceptProject;
import com.project.mangement.entity.Doctor;
import com.project.mangement.entity.Email;
import com.project.mangement.entity.Notifiactions;
import com.project.mangement.entity.Projects;
import com.project.mangement.entity.Student;
import com.project.mangement.repository.DoctorRepository;
import com.project.mangement.repository.NotificationRepository;
import com.project.mangement.repository.ProjectRepository;
import com.project.mangement.repository.StudentRepositroy;

@RestController()
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	private DoctorRepository repository;

	@Autowired
	private ProjectRepository repository_project;
	@Autowired
	private StudentRepositroy repository_student;
	@Autowired
	private NotificationRepository repository_notification;

	@GetMapping("/doctorslist")
	public List<Doctor> doctorslist() {

		List<Doctor> result = repository.doctors_list();

		if (result != null)
			return result;
		else {
			List<Doctor> result2 = new ArrayList<>();
			return result2;
		}
	}

	@GetMapping("/doctorInfo/{id}")
	public Doctor doctor_info(@PathVariable int id) {

		Doctor result = repository.doctor_info(id);

		if (result != null)
			return result;
		else
			return new Doctor();

	}

	@GetMapping("/myStudents/{id}")
	public List<Student> doctorslist(@PathVariable int id) {

		List<Student> result = repository_student.myStudents(id);

		if (result != null)
			return result;
		else {

			return result;
		}
	}

	@GetMapping("/myProjects/{id}")
	public List<Projects> myProjects(@PathVariable int id) {

		List<Projects> result = repository_project.myProjects(id);

		if (result != null)
			return result;
		else

			return result;

	}

	@GetMapping("/getProject/{id}")
	public Projects getProject(@PathVariable int id) {

		Projects result = repository_project.findProjectId(id);

		if (result != null)
			return result;
		else

			return new Projects();

	}

	@GetMapping("/myRequests/{id}")
	public List<Projects> myRequests(@PathVariable int id) {

		List<Projects> result = repository_project.myRequests(id);

		if (result != null)
			return result;
		else

			return result;

	}

	@PostMapping("/acceptProject")
	public int acceptProject(@RequestBody AcceptProject request) {

		Projects result = repository_project.findProjectId(request.getProject_id());

		if (result != null) {

			Doctor doc = repository.doctor_info(request.getDoctor_id());

			if (doc.getAvailable() != 4) {

				int ava = doc.getAvailable() + 1;

				int result3 = repository.updateDoctorAva(ava, request.getDoctor_id());

				if (result3 != 0) {

					int result2 = repository_student.updateDoctorId(request.getDoctor_id(), result.getStudent_name1(),
							result.getStudent_name2(), result.getStudent_name3(), result.getStudent_name4());

					repository_project.updateAcceptedProjectStatus(request.getProject_id());

					Student stu1 = repository_student.findByName(result.getStudent_name1());
					Student stu2 = repository_student.findByName(result.getStudent_name2());
					Student stu3 = repository_student.findByName(result.getStudent_name3());
					Student stu4 = repository_student.findByName(result.getStudent_name4());

					Email.sendEmail(stu1.getEmail(), "Accept Project",
							"congrats your project have been accepted by " + doc.getName());
					Email.sendEmail(stu2.getEmail(), "Accept Project",
							"congrats your project have been accepted by " + doc.getName());
					Email.sendEmail(stu3.getEmail(), "Accept Project",
							"congrats your project have been accepted by " + doc.getName());
					Email.sendEmail(stu4.getEmail(), "Accept Project",
							"congrats your project have been accepted by " + doc.getName());

					repository_notification.save(new Notifiactions(stu1.getId(), stu1.getEmail(), "acceptProject",
							"congrats your project have been accepted by " + doc.getName()));

					repository_notification.save(new Notifiactions(stu2.getId(), stu2.getEmail(), "acceptProject",
							"congrats your project have been accepted by " + doc.getName()));

					repository_notification.save(new Notifiactions(stu3.getId(), stu3.getEmail(), "acceptProject",
							"congrats your project have been accepted by " + doc.getName()));

					repository_notification.save(new Notifiactions(stu4.getId(), stu4.getEmail(), "acceptProject",
							"congrats your project have been accepted by " + doc.getName()));

					return result2;
				}

			} else
				return -1;

		} else {

			return -1;
		}
		return -1;
	}

	@GetMapping("/denyProject/{id}")
	public int denyProject(@PathVariable int id) {

		Projects project = repository_project.findProjectId(id);
		repository_project.deleteById(id);

		boolean result = repository_project.existsById(id);

		if (result)

			return -1;
		else {

			Student stu1 = repository_student.findByName(project.getStudent_name1());
			Student stu2 = repository_student.findByName(project.getStudent_name2());
			Student stu3 = repository_student.findByName(project.getStudent_name3());
			Student stu4 = repository_student.findByName(project.getStudent_name4());

			// send emails to students

			Email.sendEmail(project.getStudent_name1(), "Deny Project",
					" Please consider that your project was denied by  Doctor" + project.getDoctor_name());
			Email.sendEmail(project.getStudent_name2(), "Deny Project",
					"Please consider that your project was denied by  Doctor" + project.getDoctor_name());
			Email.sendEmail(project.getStudent_name3(), "DenyProject",
					"Please consider that your project was denied by  Doctor" + project.getDoctor_name());
			Email.sendEmail(project.getStudent_name4(), "DenyProject",
					"Please consider that your project was denied by  Doctor" + project.getDoctor_name());

			// adding to notification table

			repository_notification.save(new Notifiactions(stu1.getId(), stu1.getEmail(), "Deny Project",
					"Please consider that your project was denied by  Doctor " + project.getDoctor_name()));

			repository_notification.save(new Notifiactions(stu2.getId(), stu2.getEmail(), "Deny Project",
					"Please consider that your project was denied by  Doctor " + project.getDoctor_name()));

			repository_notification.save(new Notifiactions(stu3.getId(), stu3.getEmail(), "Deny Project",
					"Please consider that your project was denied by  Doctor " + project.getDoctor_name()));

			repository_notification.save(new Notifiactions(stu4.getId(), stu4.getEmail(), "Deny Project",
					"Please consider that your project was denied by  Doctor " + project.getDoctor_name()));

			return 1;
		}
	}

}
