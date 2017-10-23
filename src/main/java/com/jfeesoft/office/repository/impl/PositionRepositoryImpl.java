package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.office.model.Position;
import com.jfeesoft.office.repository.PositionRepositoryCustom;

public class PositionRepositoryImpl extends GenericRepositoryImpl<Position>
		implements PositionRepositoryCustom<Position> {

	public PositionRepositoryImpl() {
		super("position", Position.class);
	}

	@Override
	void createQuery(Criteria criteria) {
	}

}
