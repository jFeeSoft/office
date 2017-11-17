package com.jfeesoft.office.view.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.jfeesoft.office.model.GenericEntity;
import com.jfeesoft.office.service.GenericService;
import com.jfeesoft.office.view.utils.ProperSortOrder;

public abstract class GenericLazyDataModel<T extends GenericEntity> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private final GenericService genericService;

	@SuppressWarnings("rawtypes")
	public GenericLazyDataModel(GenericService genericService) {
		super();
		this.genericService = genericService;
	}

	@SuppressWarnings("unchecked")
	public T getRowData(String rowKey) {
		ArrayList<T> entities = ((ArrayList<T>) this.getWrappedData());
		for (T entity : entities) {
			if (entity.getId().longValue() == Integer.parseInt(rowKey)) {
				return entity;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(T entity) {
		return entity.getId();
	}

	@SuppressWarnings("unchecked")
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<T> entities = genericService.load(first, pageSize, sortField, ProperSortOrder.getDirection(sortOrder),
				filters);
		Long count = genericService.countRepositoryFilter(filters);
		this.setRowCount(count.intValue());
		this.setWrappedData(entities);
		return entities;
	}
}
