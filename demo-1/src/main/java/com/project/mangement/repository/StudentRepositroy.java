package com.project.mangement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.mangement.entity.Student;

public interface StudentRepositroy extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT * FROM db.student u WHERE u.email = ?1", nativeQuery = true)
	public Student findByName(String email);

	@Query(value = "SELECT * FROM db.student WHERE doctor_id = ?1", nativeQuery = true)
	public List<Student> myStudents(int doctorId);

	@Query(value = "SELECT * FROM db.student where email=?1 and password=?2", nativeQuery = true)
	public Student signIn(String user_name, String psssword);

	@Query(value = "SELECT * FROM db.student where id=?1", nativeQuery = true)
	public Student my_profile(int id);

	@Query(value = "SELECT * FROM db.student u WHERE u.email = ?1", nativeQuery = true)
	public Student findByNames(String name1, String name2, String name3, String name4);

	@Transactional
	@Modifying
	@Query(value = "UPDATE db.student SET doctor_id = ?1 WHERE email in(?2,?3,?4,?5)", nativeQuery = true)
	public int updateDoctorId(int doctorId, String name1, String name2, String name3, String name4);

}
