package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.service.PermissionService;

@Component("permissionView")
@Scope("view")
public class PermissionView extends GenericView<Permission> implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeNode root;
	private HashMap<Long, Permission> permissionRoot;
	private Integer idPermission;
	private TreeNode[] selectedNodes;

	public PermissionView(PermissionService genericService) {
		super(genericService);
		newEntity = new Permission();
		newEntity.setComponent("asdf");
		newEntity.setName("sd");
	}

	@PostConstruct
	public void init() {
		permissionRoot = Maps.newLinkedHashMap();
		List<Permission> permissionRootAll = (List<Permission>) ((PermissionService) this.genericSerivice)
				.findAllRootPermission();
		List<Permission> permissionAll = (List<Permission>) ((PermissionService) this.genericSerivice)
				.findAllOrderByNameAsc();

		for (Permission permission : permissionAll) {
			permissionRoot.put(permission.getId(), permission);
		}

		root = new CheckboxTreeNode(new Permission(), null);
		for (Permission permission : permissionRootAll) {
			createPermissionTree(root, permission);
		}
	}

	private void createPermissionTree(TreeNode root, Permission permission) {
		CheckboxTreeNode node = new CheckboxTreeNode(permission, root);
		if (permission.getChildren() != null) {
			for (Permission permissionChild : permission.getChildren()) {
				createPermissionTree(node, permissionChild);
			}
		}
	}

	public void permissionEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Document Edited", ((TreeNode) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void permissionEditCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public Collection<Permission> getPermissionRootList() {
		return permissionRoot.values();
	}

	public Integer getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

}
