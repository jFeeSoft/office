package com.jfeesoft.office.service.impl;

import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.repository.GoalRepository;
import com.jfeesoft.office.service.GoalService;

public class GoalServiceImpl extends GenericServiceImpl<Goal, Long> implements GoalService {

	public GoalServiceImpl(GoalRepository goalRepository) {
		super(goalRepository);
	}

}
