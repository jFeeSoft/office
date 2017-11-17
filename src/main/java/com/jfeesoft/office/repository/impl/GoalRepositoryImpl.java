package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.repository.GoalRepositoryCustom;

public class GoalRepositoryImpl extends GenericRepositoryImpl<Goal> implements GoalRepositoryCustom<Goal> {

	public GoalRepositoryImpl() {
		super("goal", Goal.class);
	}

	@Override
	void createQuery(Criteria criteria) {
		
	}

//	@Override
//	void createQuery(Criteria criteria) {
//		criteria.setFetchMode("permissions", FetchMode.JOIN);
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//	}

}
