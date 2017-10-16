package com.jfeesoft.office.service;

import java.util.List;

import com.jfeesoft.office.model.Permission;

public interface PermissionService extends GenericService<Permission, Long> {

	public List<Permission> findAllRootPermission();

	public List<Permission> findAllOrderByNameAsc();
}
