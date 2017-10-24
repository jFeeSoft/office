package com.jfeesoft.office.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
@AttributeOverride(name = "id", column = @Column(name = "tag_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "tag_seq", allocationSize = 1, initialValue = 100)
public class Tag extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "relation", length = 64)
	private String relation;

	@Column(name = "relation_id")
	private Long relationId;

	@Column(name = "tag_text")
	private String tagText;

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public String getTagText() {
		return tagText;
	}

	public void setTagText(String tagText) {
		this.tagText = tagText;
	}

	@Override
	public String toString() {
		return this.tagText;
	}
}
