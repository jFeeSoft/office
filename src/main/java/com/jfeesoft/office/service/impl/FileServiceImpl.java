package com.jfeesoft.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.File;
import com.jfeesoft.office.repository.FileRepository;
import com.jfeesoft.office.service.FileService;

@Component
@Transactional
public class FileServiceImpl extends GenericServiceImpl<File, Long> implements FileService {

	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {
		super(fileRepository);
	}

	@Override
	public List<File> findByUserId(Long userId) {
		return ((FileRepository) repository).findByUserId(userId);
	}
}
