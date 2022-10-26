package com.rss.feed.manager.entity;

import java.util.ArrayList;
import java.util.List;

public class RssFeed {
	 private String title;
	 private String link;
	 private String description;
	 private String pubDate;
	 
	 private List<FeedMessage> entries = new ArrayList<FeedMessage>();
		
		public RssFeed(String title, String link, String description, String language,
	            String copyright, String pubDate) {
	        this.title = title;
	        this.link = link;
	        this.description = description;
	        this.pubDate = pubDate;
	    }

		public List<FeedMessage> getMessages() {
	        return entries;
	    }
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPubDate() {
			return pubDate;
		}

		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}

		public List<FeedMessage> getEntries() {
			return entries;
		}

		public void setEntries(List<FeedMessage> entries) {
			this.entries = entries;
		}
		
		
}
