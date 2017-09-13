package com.jfeesoft.office.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.service.RoleService;

@Component
public class RoleLazyDataModel extends GenericLazyDataModel<Role> {

	private static final long serialVersionUID = 1L;

	public RoleLazyDataModel(RoleService roleService) {
		super(roleService);
	}

}
