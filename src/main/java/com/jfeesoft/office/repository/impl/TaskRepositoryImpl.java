package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.office.model.Task;
import com.jfeesoft.office.repository.TaskRepositoryCustom;

public class TaskRepositoryImpl extends GenericRepositoryImpl<Task> implements TaskRepositoryCustom<Task> {

	public TaskRepositoryImpl() {
		super("task", Task.class);
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
