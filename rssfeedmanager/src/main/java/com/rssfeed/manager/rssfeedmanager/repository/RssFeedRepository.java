package com.rssfeed.manager.rssfeedmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rssfeed.manager.rssfeedmanager.entity.RSSFeed;

public interface RssFeedRepository extends CrudRepository<RSSFeed, Long> {

	public static final String FIND_RSSFEED = "SELECT * FROM rssfeed where status = 'NOT SENT'";

	@Query(value = FIND_RSSFEED, nativeQuery = true)
	public List<RSSFeed> findRSSFeed();
}
