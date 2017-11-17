package com.jfeesoft.office.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Task;
import com.jfeesoft.office.service.TaskService;

@Component
public class TaskLazyDataModel extends GenericLazyDataModel<Task> {

	private static final long serialVersionUID = 1L;

	public TaskLazyDataModel(TaskService taskService) {
		super(taskService);
	}

}
