package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.office.model.OrganizationalUnit;
import com.jfeesoft.office.repository.OrganizationalUnitRepositoryCustom;

public class OrganizationalUnitRepositoryImpl extends GenericRepositoryImpl<OrganizationalUnit>
		implements OrganizationalUnitRepositoryCustom<OrganizationalUnit> {

	public OrganizationalUnitRepositoryImpl() {
		super("unit", OrganizationalUnit.class);
	}

	@Override
	void createQuery(Criteria criteria) {
	}

}
