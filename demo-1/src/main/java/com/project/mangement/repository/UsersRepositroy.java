package com.project.mangement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mangement.entity.Users;

public interface UsersRepositroy extends JpaRepository<Users, Integer> {

	@Query( value ="SELECT * FROM users u WHERE u.user_name = ?1",nativeQuery = true)
	public Users findByName(String name);
	
	@Query( value ="SELECT * FROM db.users where user_name=?1 and password=?2",nativeQuery = true)
	public Users signIn(String user_name,String psssword);
	

}
