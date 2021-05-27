package com.project.mangement.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mangement.entity.Doctor;
import com.project.mangement.entity.Student;
import com.project.mangement.entity.User;
import com.project.mangement.repository.DoctorRepository;
import com.project.mangement.repository.StudentRepositroy;

@RestController()
@RequestMapping("user")
public class UserController {

	@Autowired
	private DoctorRepository repository;
	@Autowired
	private StudentRepositroy repository2;

	@PostMapping("/signIn")
	public User signIn(@RequestBody User doctor) {

		Doctor result = repository.signIn(doctor.getEmail());

		if (result != null)

			return new User(result.getId(), result.getName(), result.getEmail(), result.getPassword(),
					result.getRole());

		else {

			Student result2 = repository2.signIn(doctor.getEmail(), doctor.getPassword());

			if (result2 != null)

				return new User(result2.getId(), result2.getName(), result2.getEmail(), result2.getPassword(),
						result2.getRole());

			else
				return new User();
		}
	}

	@PostMapping("/signUp")
	public User signUp(@RequestBody User user) {

		if (user.getRole() == 1) {

			Doctor result = repository.signIn(user.getEmail());

			if (result == null) {

				Random r = new Random();
				int rate = r.nextInt((5 - 1) + 1) + 1;

				Doctor doc = new Doctor();

				doc.setEmail(user.getEmail());
				doc.setName(user.getName());
				doc.setPassword(user.getPassword());
				doc.setAvailable(0);
				doc.setRole(1);
				doc.setRate(rate);
				doc.setAbout_doctor(doc.getName()
						+ " he is the one of the best doctors in our univercity he has 13 years as experince in his major and he has master degree in software engineering from USA and he graduated as elctrical engineer from JUST university and he came back to be one of out staff");

				repository.save(doc);

				Doctor result2 = repository.signIn(user.getEmail());

				return new User(result2.getId(), result2.getName(), result2.getEmail(), result2.getPassword(),
						result2.getRole());

			}

			else
				return new User();

		} else {

			Student result = repository2.signIn(user.getEmail(), user.getPassword());

			if (result == null) {

				Student stu = new Student();

				stu.setEmail(user.getEmail());
				stu.setName(user.getName());
				stu.setPassword(user.getPassword());
				stu.setRole(0);

				repository2.save(stu);

				Student result2 = repository2.signIn(user.getEmail(), user.getPassword());

				return new User(result2.getId(), result2.getName(), result2.getEmail(), result2.getPassword(),
						result2.getRole());

			}

			else
				return new User();

		}

	}

}
