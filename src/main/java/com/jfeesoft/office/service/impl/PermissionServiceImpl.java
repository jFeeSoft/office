package com.jfeesoft.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.repository.PermissionRepository;
import com.jfeesoft.office.service.PermissionService;

@Component
@Transactional
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

	@Autowired
	public PermissionServiceImpl(PermissionRepository permissionRepository) {
		super(permissionRepository);
	}

	@Override
	public List<Permission> findAllRootPermission() {
		return Lists.newArrayList(((PermissionRepository) repository).findAllRootPermission());
	}

	@Override
	public List<Permission> findAllOrderByNameAsc() {
		return ((PermissionRepository) repository).findAllPermission();
	}

}
