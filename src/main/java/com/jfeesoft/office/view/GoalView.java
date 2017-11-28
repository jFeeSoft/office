package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.GenericEntity;
import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.model.Status;
import com.jfeesoft.office.model.Task;
import com.jfeesoft.office.service.GoalService;
import com.jfeesoft.office.service.TaskService;
import com.jfeesoft.office.view.utils.DialogMode;
import com.jfeesoft.office.view.utils.Utils;

@Component("goalView")
@Scope("view")
public class GoalView extends GenericView<Goal> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Task> taskSelected;
	private String selectedStatus;
	private Goal selectedGoal;
	private String dialogMode;
	private Task newTask;

	@Autowired
	private TaskService taskService;

	public GoalView(GoalService genericService) {
		super(genericService);
	}

	@PostConstruct
	public void init() {
		dialogMode = DialogMode.ADD.name();
		if (selectedGoal != null) {
			taskSelected = selectedGoal.getTasks();
		}
		newEntity = new Goal();
		newTask = new Task();
	}

	public void add() {
		newEntity = new Goal();
		selectedStatus = Status.NOWY.name();
	}

	public void addTask() {
		newTask = new Task();
		selectedStatus = Status.NOWY.name();
	}

	public void edit(Goal entity) {
		newEntity = entity;
		selectedStatus = entity.getStatus().name();
	}

	public void editTask(Task entity) {
		newTask = entity;
		selectedStatus = entity.getStatus().name();
	}

	public Status[] getStatus() {
		return Status.values();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save() {
		newEntity.setStatus(Status.valueOf(selectedStatus));
		try {
			newEntity = (Goal) genericService.save(newEntity);
			Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			Utils.addDetailMessage(messagesBundle.getString("message.error.undefinedSaveException"),
					FacesMessage.SEVERITY_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	public void delete(GenericEntity entity) {
		genericService.delete(entity);
		selectedGoal = null;
		taskSelected.clear();
		Utils.addDetailMessage(messagesBundle.getString("info.delete"), FacesMessage.SEVERITY_INFO);
	}

	public void saveTask() {
		newTask.setStatus(Status.valueOf(selectedStatus));
		newTask.setGoalId(selectedGoal.getId());
		try {
			newTask = (Task) taskService.save(newTask);
			taskSelected.removeIf(task -> task.getId().intValue() == newTask.getId().intValue());
			taskSelected.add(newTask);
			Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			Utils.addDetailMessage(messagesBundle.getString("message.error.undefinedSaveException"),
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public void deleteTask(Task entity) {
		taskSelected.remove(entity);
		taskService.delete(entity);
		Utils.addDetailMessage(messagesBundle.getString("info.delete"), FacesMessage.SEVERITY_INFO);
	}

	public void onRowSelect(SelectEvent event) {
		selectedGoal = (Goal) event.getObject();
		taskSelected = selectedGoal.getTasks();
	}

	public Goal getSelectedGoal() {
		return selectedGoal;
	}

	public void setSelectedRole(Goal selectedGoal) {
		this.selectedGoal = selectedGoal;
	}

	public String getDialogMode() {
		return dialogMode;
	}

	public void setDialogMode(String dialogMode) {
		this.dialogMode = dialogMode;
	}

	public List<Task> getTaskSelected() {
		return taskSelected;
	}

	public void setTaskSelected(List<Task> taskSelected) {
		this.taskSelected = taskSelected;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public void setSelectedGoal(Goal selectedGoal) {
		this.selectedGoal = selectedGoal;
	}

	public Task getNewTask() {
		return newTask;
	}

	public void setNewTask(Task newTask) {
		this.newTask = newTask;
	}

}
