package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.office.model.File;
import com.jfeesoft.office.repository.FileRepositoryCustom;

public class FileRepositoryImpl extends GenericRepositoryImpl<File> implements FileRepositoryCustom<File> {

	public FileRepositoryImpl() {
		super("file", File.class);
	}

	@Override
	void createQuery(Criteria criteria) {

	}

}
