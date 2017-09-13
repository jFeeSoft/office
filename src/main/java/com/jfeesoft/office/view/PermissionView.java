package com.jfeesoft.office.view;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.service.PermissionService;

@Component("permissionView")
@Scope("view")
public class PermissionView extends GenericView<Permission> implements Serializable {

	private static final long serialVersionUID = 1L;

	public PermissionView(PermissionService genericService) {
		super(genericService);
	}

	@Override
	public void add() {
		newEntity = new Permission();
	}

}
