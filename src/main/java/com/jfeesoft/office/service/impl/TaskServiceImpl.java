package com.jfeesoft.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.Task;
import com.jfeesoft.office.repository.TaskRepository;
import com.jfeesoft.office.service.TaskService;

@Component
@Transactional
public class TaskServiceImpl extends GenericServiceImpl<Task, Long> implements TaskService {

	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		super(taskRepository);
	}

}
