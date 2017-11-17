package com.jfeesoft.office.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

public interface TaskRepositoryCustom<T> {
	public Long countRepositoryFilter(Map<String, Object> filters);

	public List<T> findRepositorySortFilterPage(int first, int pageSize, String sortField, Direction sortOrder,
			Map<String, Object> filters);
}
