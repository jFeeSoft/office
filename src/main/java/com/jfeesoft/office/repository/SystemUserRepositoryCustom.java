package com.jfeesoft.office.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

import com.jfeesoft.office.model.SystemUser;

public interface SystemUserRepositoryCustom {
	public Long countUserRepositoryFilter(Map<String, Object> filters);
	public List<SystemUser> findUserRepositorySortFilterPage(int first, int pageSize, String sortField, Direction sortOrder, Map<String, Object> filters);
}
