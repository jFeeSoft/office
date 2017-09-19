package com.jfeesoft.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.SystemUser;
import com.jfeesoft.office.repository.SystemUserRepository;
import com.jfeesoft.office.service.SystemUserService;

@Component
@Transactional
public class SystemUserServiceImpl extends GenericServiceImpl<SystemUser, Long> implements SystemUserService {

	@Autowired
	public SystemUserServiceImpl(SystemUserRepository systemUserRepository) {
		super(systemUserRepository);

	}
}
