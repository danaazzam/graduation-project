package com.project.mangement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.mangement.entity.Projects;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {

	@Query(value = "SELECT * FROM db.projects where doctor_id=?1 and student_name1=?2", nativeQuery = true)
	public Projects findProject(int doctorId, String email);

	@Query(value = "SELECT * FROM db.projects where project_id=?1", nativeQuery = true)
	public Projects findProjectId(int projectId);

	@Query(value = "SELECT * FROM db.projects where doctor_id=?1", nativeQuery = true)
	public List<Projects> myProjects(int doctorId);
	

	@Query(value = "SELECT * FROM db.projects where doctor_id=?1 and project_status=-1", nativeQuery = true)
	public List<Projects> myRequests(int doctorId);

	

	@Transactional
	@Modifying
	@Query(value = "UPDATE db.projects SET project_status =1 WHERE project_id = ?1", nativeQuery = true)
	public int updateAcceptedProjectStatus(int id);

}
