package com.csdm.reader.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="feed_entries")
@ApiModel(description = "All details about the FeedEntry.")
public class FeedEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id", nullable = false)
	@ApiModelProperty(notes="The database generated feed entry ID")
	private Long id;
	
	@Column(name="title", nullable = false)
	@ApiModelProperty(notes="The feed entry title")
	private String title;
	
	@Column(name="link")
	@ApiModelProperty(notes="The feed entry URL")
	private String link;
	
	@Lob
	@Column(name="description")
	@ApiModelProperty(notes="The feed entry text content")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pub_date")
	@ApiModelProperty(notes="The feed entry publishing date")
	private Date pubDate;
	
	@Column(name="permalink", nullable = false, unique=true)
	@ApiModelProperty(notes="The feed entry unique URL")
	private String permalink;
	
	@Column(name="image_url")
	@ApiModelProperty(notes="The feed entry image URL")
	private String imageUrl;

	public FeedEntry() {
		
	}
	
	public FeedEntry(Long id, String title, String link, String description, Date pubDate, String permalink, String imageUrl) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
		this.permalink = permalink;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedEntry other = (FeedEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedEntry [id=" + id + ", title=" + title + ", link=" + link
				+ ", description=" + description + ", pubDate=" + pubDate
				+ ", permalink=" + permalink + ", imageUrl=" + imageUrl + "]";
	}

}
