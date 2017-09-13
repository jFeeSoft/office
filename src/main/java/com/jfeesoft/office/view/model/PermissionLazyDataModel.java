package com.jfeesoft.office.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.service.PermissionService;

@Component
public class PermissionLazyDataModel extends GenericLazyDataModel<Permission> {

	private static final long serialVersionUID = 1L;

	public PermissionLazyDataModel(PermissionService permissionService) {
		super(permissionService);
	}

}
