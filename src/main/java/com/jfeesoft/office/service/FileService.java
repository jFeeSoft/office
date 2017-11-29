package com.jfeesoft.office.service;

import java.util.List;

import com.jfeesoft.office.model.File;

public interface FileService extends GenericService<File, Long> {
	List<File> findByUserId(Long userId);
}
