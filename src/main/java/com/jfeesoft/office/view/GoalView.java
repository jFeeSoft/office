package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Goal;
import com.jfeesoft.office.service.GoalService;
import com.jfeesoft.office.view.utils.DialogMode;

@Component("goalView")
@Scope("view")
public class GoalView extends GenericView<Goal> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Goal> goalSource;
	private Long idRoleParent;
	private Goal selectedGoal;
	private TreeNode[] selectedPermission;
	private String dialogMode;

	public GoalView(GoalService genericService) {
		super(genericService);
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		dialogMode = DialogMode.ADD.name();
		goalSource = (List<Goal>) genericService.findAll();

		if (goalSource.size() > 0) {
			selectedGoal = goalSource.get(0);
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
		newEntity = new Goal();
	}

	public void edit(Goal entity) {
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

	public List<Goal> getGoalSource() {
		return goalSource;
	}

	public void setGoalSource(List<Goal> goalSource) {
		this.goalSource = goalSource;
	}

	public Long getIdRoleParent() {
		return idRoleParent;
	}

	public void setIdRoleParent(Long idRoleParent) {
		this.idRoleParent = idRoleParent;
	}

	public Goal getSelectedGoal() {
		return selectedGoal;
	}

	public void setSelectedRole(Goal selectedGoal) {
		this.selectedGoal = selectedGoal;
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
