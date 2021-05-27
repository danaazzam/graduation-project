package com.project.mangement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.mangement.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	@Query(value = "SELECT * FROM db.doctor where email=?1", nativeQuery = true)
	public Doctor signIn(String user_name);

	@Query(value = "SELECT * FROM db.doctor where id=?1", nativeQuery = true)
	public Doctor my_profile(int id);

	@Query(value = "SELECT * FROM db.doctor where available<4", nativeQuery = true)
	public List<Doctor> doctors_list();

	@Query(value = "SELECT * FROM db.doctor where id=?1", nativeQuery = true)
	public Doctor doctor_info(int id);

	@Query(value = "SELECT name FROM db.doctor where id=?1", nativeQuery = true)
	public String doctor_name(int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE db.doctor SET available = ?1 WHERE id=?2", nativeQuery = true)
	public int updateDoctorAva(int available, int doctorId);

}
