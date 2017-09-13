package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Permission;
import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.service.PermissionService;
import com.jfeesoft.office.service.RoleService;
import com.jfeesoft.office.view.utils.Utils;

import lombok.Getter;
import lombok.Setter;

@Component("roleView")
@Scope("view")
public class RoleView extends GenericView<Role> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private DualListModel<Permission> permissions;

	@Autowired
	private PermissionService permissionService;

	private List<Permission> permissionSource;

	public RoleView(RoleService genericService) {
		super(genericService);
	}

	@PostConstruct
	public void init() {
		permissionSource = (List<Permission>) permissionService.findAll();
		permissions = new DualListModel<Permission>(new ArrayList<Permission>(), new ArrayList<Permission>());

	}

	public void add() {
		newEntity = new Role();
		permissions.getTarget().clear();
		permissions.getSource().clear();
		permissions.getSource().addAll(permissionSource);
	}

	public void edit(Role entity) {
		permissions.getTarget().clear();
		permissions.getSource().clear();
		permissions.getTarget().addAll(entity.getPermissions());
		permissions.getSource().addAll(permissionSource);
		permissions.getSource().removeAll(entity.getPermissions());
		newEntity = entity;
	}

	public void save() {
		newEntity.getPermissions().clear();
		newEntity.getPermissions().addAll(permissions.getTarget());
		newEntity = (Role) genericSerivice.save(newEntity);
		Utils.addDetailMessage(messagesBundle.getString("role.info.edit"), FacesMessage.SEVERITY_INFO);
	}

}
