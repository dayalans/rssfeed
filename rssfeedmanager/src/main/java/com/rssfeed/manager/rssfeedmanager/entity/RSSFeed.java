package com.rssfeed.manager.rssfeedmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RSSFeed {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long rssFeedID;
	private String header;
	private Date publishedDate;
	@Column(name = "Description", nullable = false, length = 500)
	private String Description;
	private String Status;
	public long getRssFeedID() {
		return rssFeedID;
	}
	public void setRssFeedID(long rssFeedID) {
		this.rssFeedID = rssFeedID;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
