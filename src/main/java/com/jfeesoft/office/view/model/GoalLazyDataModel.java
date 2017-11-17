package com.jfeesoft.office.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.service.GoalService;

@Component
public class GoalLazyDataModel extends GenericLazyDataModel<Goal> {

	private static final long serialVersionUID = 1L;

	public GoalLazyDataModel(GoalService goalService) {
		super(goalService);
	}

}
