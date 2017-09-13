package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.repository.PermissionRepositoryCustom;

public class PermissionRepositoryImpl extends GenericRepositoryImpl<Permission>
		implements PermissionRepositoryCustom<Permission> {

	public PermissionRepositoryImpl() {
		super("permission", Permission.class);
	}

	@Override
	void createQuery(Criteria criteria) {

	}

}
