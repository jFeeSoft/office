package com.jfeesoft.office.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.service.GoalService;

@Component
public class GoalLazyDataModel extends GenericLazyDataModel<Role> {

	private static final long serialVersionUID = 1L;

	public GoalLazyDataModel(GoalService roleService) {
		super(roleService);
	}

}
