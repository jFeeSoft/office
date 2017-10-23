package com.jfeesoft.office.service;

import java.util.Map;

import com.jfeesoft.office.model.OrganizationalUnit;

public interface OrganizationalUnitService extends GenericService<OrganizationalUnit, Long> {
	Map<Long, OrganizationalUnit> findAllMap();
}
