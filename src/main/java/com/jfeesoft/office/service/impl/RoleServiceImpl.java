package com.jfeesoft.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.repository.RoleRepository;
import com.jfeesoft.office.service.RoleService;

@Component
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		super(roleRepository);

	}

}
