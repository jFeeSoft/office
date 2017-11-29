package com.jfeesoft.office.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "file")
@AttributeOverride(name = "id", column = @Column(name = "file_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "file_seq", allocationSize = 1, initialValue = 100)
public class File extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "file_name", length = 64)
	private String fileName;

	@Column(name = "content")
	private byte[] content;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "content_type")
	private String contentType;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
