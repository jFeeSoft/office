package com.jfeesoft.office.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.OrganizationalUnit;
import com.jfeesoft.office.repository.OrganizationalUnitRepository;
import com.jfeesoft.office.service.OrganizationalUnitService;

@Component
@Transactional
public class OrganizationalUnitServiceImpl extends GenericServiceImpl<OrganizationalUnit, Long>
		implements OrganizationalUnitService {

	@Autowired
	public OrganizationalUnitServiceImpl(OrganizationalUnitRepository unitRepository) {
		super(unitRepository);
	}

	@Override
	public Map<Long, OrganizationalUnit> findAllMap() {
		List<OrganizationalUnit> organizationalUnits = (List<OrganizationalUnit>) ((OrganizationalUnitRepository) repository)
				.findAll();
		Map<Long, OrganizationalUnit> unitMap = new HashMap<>();
		for (OrganizationalUnit unit : organizationalUnits) {
			unitMap.put(unit.getId(), unit);
		}
		return unitMap;
	}

}
