package com.project.mangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mangement.entity.Notifiactions;
import com.project.mangement.repository.NotificationRepository;

@RestController()
@RequestMapping("notification")
public class NotificationController {

	@Autowired
	NotificationRepository repository_notification;

	@GetMapping("/getNotifications/{email}")
	public List<Notifiactions> myNotifications(@PathVariable String email) {

		List<Notifiactions> result = repository_notification.getNotifications(email);

		return result;
	}

}
