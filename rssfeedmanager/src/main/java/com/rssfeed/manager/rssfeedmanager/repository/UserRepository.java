package com.rssfeed.manager.rssfeedmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rssfeed.manager.rssfeedmanager.entity.RssFeedUser;

public interface UserRepository extends CrudRepository<RssFeedUser, Long> {
	public static final String FIND_EMAIL_ID = "SELECT EMAIL_ID FROM RSS_FEED_USER";

	@Query(value = FIND_EMAIL_ID, nativeQuery = true)
	public List<String> findEmailId();

}
