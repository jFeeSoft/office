package com.jfeesoft.office.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jfeesoft.office.model.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {

	List<Note> findByRelationAndRelationId(String relation, Long relationId);
}
