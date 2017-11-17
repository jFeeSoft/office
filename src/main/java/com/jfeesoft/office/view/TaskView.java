package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.model.Task;
import com.jfeesoft.office.service.TaskService;
import com.jfeesoft.office.view.utils.DialogMode;

@Component("taskView")
@Scope("view")
public class TaskView extends GenericView<Task> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Task> taskSource;
	private Long idRoleParent;
	private Task selectedTask;
	private TreeNode[] selectedPermission;
	private String dialogMode;

	public TaskView(TaskService genericService) {
		super(genericService);
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		dialogMode = DialogMode.ADD.name();
		taskSource = (List<Task>) genericService.findAll();

		if (taskSource.size() > 0) {
			selectedTask = taskSource.get(0);
		}
	}

	// private void createPermissionTree(TreeNode root, Permission permission) {
	// CheckboxTreeNode node = new CheckboxTreeNode(new PermissionCheck(permission,
	// false), root);
	// node.setExpanded(true);
	// if (permission.getChildren() != null) {
	// for (Permission permissionChild : permission.getChildren()) {
	// createPermissionTree(node, permissionChild);
	// }
	// }
	// }

	public void add() {
		newEntity = new Task();
	}

	public void edit(Task entity) {
		newEntity = entity;
	}

	// @Override
	// public void save() {
	// newEntity.getPermissions().clear();
	// if (idRoleParent != null) {
	// Role parentRole = genericLazyModel.getRowData(idRoleParent.toString());
	// newEntity.setPermissions(parentRole.getPermissions());
	// }
	// newEntity = (Role) genericSerivice.save(newEntity);
	// Utils.addDetailMessage(messagesBundle.getString("info.edit"),
	// FacesMessage.SEVERITY_INFO);
	// }

	// public void savePermission() {
	// if (selectedGoal != null) {
	// newEntity = (Goal) genericSerivice.save(selectedGoal);
	// }
	// Utils.addDetailMessage(messagesBundle.getString("info.edit"),
	// FacesMessage.SEVERITY_INFO);
	// }

	@SuppressWarnings("unused")
	public void onRowSelect(SelectEvent event) {
		Goal goal = (Goal) event.getObject();
	}

	// private void collectCheckedPermission(Set<Permission> permissions, TreeNode
	// rootNode) {
	// for (TreeNode node : rootNode.getChildren()) {
	// if (((PermissionCheck) node.getData()).getCheck()) {
	// permissions.add(((PermissionCheck) node.getData()).getPermission());
	// }
	// if (!node.isLeaf()) {
	// collectCheckedPermission(permissions, node);
	// }
	//
	// }
	// }

	public List<Task> getTaskSource() {
		return taskSource;
	}

	public void setTaskSource(List<Task> taskSource) {
		this.taskSource = taskSource;
	}

	public Long getIdRoleParent() {
		return idRoleParent;
	}

	public void setIdRoleParent(Long idRoleParent) {
		this.idRoleParent = idRoleParent;
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

	public TreeNode[] getSelectedPermission() {
		return selectedPermission;
	}

	public void setSelectedPermission(TreeNode[] selectedPermission) {
		this.selectedPermission = selectedPermission;
	}

	public String getDialogMode() {
		return dialogMode;
	}

	public void setDialogMode(String dialogMode) {
		this.dialogMode = dialogMode;
	}

}
