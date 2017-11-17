package com.jfeesoft.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.repository.GoalRepository;
import com.jfeesoft.office.service.GoalService;

@Component
@Transactional
public class GoalServiceImpl extends GenericServiceImpl<Goal, Long> implements GoalService {

	@Autowired
	public GoalServiceImpl(GoalRepository goalRepository) {
		super(goalRepository);
	}

}
