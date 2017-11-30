package com.jfeesoft.office.repository;

import java.util.List;

import com.jfeesoft.office.model.File;

public interface FileRepository extends GenericRepository<File, Long>, FileRepositoryCustom<File> {
	List<File> findByUserId(Long userId);

	Long countByUserId(Long userId);
}
