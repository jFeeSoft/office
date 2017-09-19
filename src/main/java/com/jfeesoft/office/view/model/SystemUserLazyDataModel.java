package com.jfeesoft.office.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.SystemUser;
import com.jfeesoft.office.service.SystemUserService;

@Component
public class SystemUserLazyDataModel extends GenericLazyDataModel<SystemUser> {

	private static final long serialVersionUID = 1L;

	public SystemUserLazyDataModel(SystemUserService systemUserService) {
		super(systemUserService);
	}

}
