package com.project.mangement.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mangement.entity.Email;
import com.project.mangement.entity.Inbox;
import com.project.mangement.repository.InboxRepository;

@RestController()
@RequestMapping("Inbox")
public class InboxController {

	@Autowired
	private InboxRepository repository_Inbox;

	@GetMapping("/myInbox/{email}")
	public List<Inbox> myInbox(@PathVariable String email) {

		List<Inbox> myInbox = repository_Inbox.myInbox(email);

		return myInbox;

	}

	@GetMapping("/inboxById/{id}")
	public Inbox InboxById(@PathVariable int id) {

		Inbox myInbox = repository_Inbox.InboxId(id);

		if (myInbox != null)
			return myInbox;
		else
			return new Inbox();

	}

	@PostMapping("/addToInbox")
	public Inbox addToInbox(@RequestBody Inbox inbox) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		inbox.setMessage_date(dateFormat.format(date).toString());

		Inbox result = repository_Inbox.save(inbox);

		if (result != null) {

			Email.sendEmail(inbox.getReciver_email(), "New Message",
					"you have a new message from " + inbox.getSender_name());

		}

		return result;

	}

}
