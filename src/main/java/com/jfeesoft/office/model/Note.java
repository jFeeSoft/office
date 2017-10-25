package com.jfeesoft.office.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "note")
@AttributeOverride(name = "id", column = @Column(name = "note_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "note_seq", allocationSize = 1, initialValue = 100)
public class Note extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "relation", length = 64)
	private String relation;

	@Column(name = "relation_id")
	private Long relationId;

	@Column(name = "note_text")
	private String noteText;

	public Note(String relation, Long relationId, String noteText) {
		super();
		this.relation = relation;
		this.relationId = relationId;
		this.noteText = noteText;
	}

	public Note() {
		super();
	}

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

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

}
