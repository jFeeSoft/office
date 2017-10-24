package com.jfeesoft.office.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jfeesoft.office.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findByRelationAndRelationId(String relation, Long relationId);
}
