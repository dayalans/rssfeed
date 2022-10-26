package com.rssfeed.manager.rssfeedmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rssfeed.manager.rssfeedmanager.entity.RssFeedUser;
import com.rssfeed.manager.rssfeedmanager.service.RssFeedUserService;

@RestController
public class RssFeedUserController {
	@Autowired
	RssFeedUserService rssFeedUserService;
	
	@PostMapping("/v1/ucinstance")
	public ResponseEntity<RssFeedUser> createUCInstance(@RequestBody  RssFeedUser user) {

		try {
			rssFeedUserService.saveOrUpdate(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
