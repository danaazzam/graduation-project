package com.project.mangement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mangement.entity.Inbox;

public interface InboxRepository extends JpaRepository<Inbox, Integer> {

	@Query(value = "SELECT * FROM db.inbox where reciver_email=?1", nativeQuery = true)
	public List<Inbox> myInbox(String email);
	
	@Query(value="SELECT * FROM db.inbox where id=?1", nativeQuery=true)
	public Inbox InboxId(int id);
	
}
