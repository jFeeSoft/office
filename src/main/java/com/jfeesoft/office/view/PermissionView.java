package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.service.PermissionService;

@Component("permissionView")
@Scope("view")
public class PermissionView extends GenericView<Permission> implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeNode root;

	public PermissionView(PermissionService genericService) {
		super(genericService);
		newEntity = new Permission();
		newEntity.setComponent("asdf");
		newEntity.setName("sd");
	}

	@PostConstruct
	public void init() {
		root = new CheckboxTreeNode(new Permission(), null);
		List<Permission> permissionAll = (List<Permission>) ((PermissionService) this.genericSerivice)
				.findAllPermission();
		for (Permission permission : permissionAll) {
			createPermissionTree(root, permission);
		}
	}

	private void createPermissionTree(TreeNode root, Permission permission) {
		TreeNode node = new CheckboxTreeNode(permission, root);
		if (permission.getChildren() != null) {
			for (Permission permissionChild : permission.getChildren()) {
				createPermissionTree(node, permissionChild);
			}
		}
	}

	@Override
	public void add() {
		newEntity = new Permission();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

}
