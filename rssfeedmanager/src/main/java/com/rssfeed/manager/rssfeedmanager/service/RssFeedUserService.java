package com.rssfeed.manager.rssfeedmanager.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.rssfeed.manager.rssfeedmanager.entity.RSSFeed;
import com.rssfeed.manager.rssfeedmanager.entity.RssFeedUser;
import com.rssfeed.manager.rssfeedmanager.repository.RssFeedRepository;
import com.rssfeed.manager.rssfeedmanager.repository.UserRepository;

@Service
public class RssFeedUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RssFeedRepository rssFeedRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	public RssFeedUser saveOrUpdate(RssFeedUser user) {

		return userRepository.save(user);

	}

	public void sendEmailToUsers() {

		List<String> usersEmail = userRepository.findEmailId();
		//Finding all the non sent RSS FEED
		List<RSSFeed> rssFeedList = rssFeedRepository.findRSSFeed();
		//Code to create a table for sending the RSS feed
		SimpleMailMessage message = new SimpleMailMessage();
		StringBuilder sb1 = new StringBuilder(200);
		sb1.append("<html><body>" + "<table style='border:2px solid black'>");
		for (RSSFeed rssFeed : rssFeedList) {

			sb1.append("<tr>");
			sb1.append(rssFeed.getHeader())
			.append("<td>")
			.append(rssFeed.getDescription())
			.append("</td><td>")
			.append(rssFeed.getPublishedDate());
			sb1.append("</tr>");
			rssFeed.setStatus("SENT");
		}
		sb1.append("</table></body></html>");

		message.setText(sb1.toString());
		message.setSubject("RSS FEED");
		for (String emailIds : usersEmail) {
			message.setTo(emailIds);
			javaMailSender.send(message);
		}
		//Code to update the Feed Status as sent so that those feed will not be sent to user again
		rssFeedList.forEach(rssFeed->{
			rssFeedRepository.save(rssFeed);
		});

	}
}
