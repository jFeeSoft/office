package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.service.PermissionService;
import com.jfeesoft.office.service.RoleService;
import com.jfeesoft.office.view.utils.Utils;

@Component("roleView")
@Scope("view")
public class RoleView extends GenericView<Role> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PermissionService permissionService;

	private TreeNode rootPermission;

	private List<Role> roleSource;
	private Long idRoleParent;
	private Role selectedRole;
	private TreeNode[] selectedPermission;

	public RoleView(RoleService genericService) {
		super(genericService);
	}

	@PostConstruct
	public void init() {
		roleSource = (List<Role>) genericSerivice.findAll();
		List<Permission> permissionRootAll = permissionService.findAllRootPermission();
		if (roleSource.size() > 0) {
			selectedRole = roleSource.get(0);
		}
		rootPermission = new CheckboxTreeNode(new Permission(), null);
		for (Permission permission : permissionRootAll) {
			createPermissionTree(rootPermission, permission);
		}
		checkPermission(selectedRole.getPermissions(), rootPermission);
	}

	private void createPermissionTree(TreeNode root, Permission permission) {
		CheckboxTreeNode node = new CheckboxTreeNode(permission, root);
		node.setExpanded(true);
		if (permission.getChildren() != null) {
			for (Permission permissionChild : permission.getChildren()) {
				createPermissionTree(node, permissionChild);
			}
		}
	}

	public void add() {
		newEntity = new Role();
	}

	public void edit(Role entity) {
		newEntity = entity;
	}

	public void save() {
		newEntity.getPermissions().clear();
		newEntity = (Role) genericSerivice.save(newEntity);
		Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
	}

	public void savePermission() {
		if (selectedRole != null) {
			selectedRole.getPermissions().clear();
			for (TreeNode node : selectedPermission) {
				selectedRole.getPermissions().add((Permission) node.getData());
			}
			newEntity = (Role) genericSerivice.save(selectedRole);
		}
		// newEntity = (Role) genericSerivice.save(newEntity);
		Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
	}

	public void onRowSelect(SelectEvent event) {
		Role role = (Role) event.getObject();
		checkPermission(role.getPermissions(), rootPermission);
		// Utils.addDetailMessage(messagesBundle.getString("info.select"),
		// FacesMessage.SEVERITY_INFO);
	}

	private void checkPermission(Set<Permission> permissions, TreeNode rootNode) {
		for (TreeNode node : rootNode.getChildren()) {
			Permission permissionNode = (Permission) node.getData();
			boolean selected = permissions.contains(permissionNode);
			node.setSelected(selected);

			if (!node.isLeaf() && !selected) {
				checkPermission(permissions, node);
			}
		}
	}

	public List<Role> getRoleSource() {
		return roleSource;
	}

	public void setRoleSource(List<Role> roleSource) {
		this.roleSource = roleSource;
	}

	public Long getIdRoleParent() {
		return idRoleParent;
	}

	public void setIdRoleParent(Long idRoleParent) {
		this.idRoleParent = idRoleParent;
	}

	public TreeNode getRootPermission() {
		return rootPermission;
	}

	public void setRootPermission(TreeNode root) {
		this.rootPermission = root;
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	public TreeNode[] getSelectedPermission() {
		return selectedPermission;
	}

	public void setSelectedPermission(TreeNode[] selectedPermission) {
		this.selectedPermission = selectedPermission;
	}

}
