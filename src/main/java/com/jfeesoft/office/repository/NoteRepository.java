package com.jfeesoft.office.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jfeesoft.office.model.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {

	List<Note> findByRelationAndRelationId(String relation, Long relationId);

	@Modifying
	@Query(value = "DELETE FROM Note WHERE relation = :rel AND relationId = :relId")
	void deleteByRelationAndRelationId(@Param("rel") String relation, @Param("relId") Long relationId);
}
