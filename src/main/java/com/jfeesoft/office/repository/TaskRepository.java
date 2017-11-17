package com.jfeesoft.office.repository;

import com.jfeesoft.office.model.Task;

public interface TaskRepository extends GenericRepository<Task, Integer>, TaskRepositoryCustom<Task> {

}
