package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.model.SystemUser;
import com.jfeesoft.office.service.RoleService;
import com.jfeesoft.office.service.SystemUserService;

@Component("systemUserView")
@Scope("view")
public class SystemUserView extends GenericView<SystemUser> implements Serializable {

	private static final long serialVersionUID = 1L;

	private DualListModel<Role> roles;

	private List<Role> roleSource;

	private List<String> tags;

	@Autowired
	private RoleService roleService;

	public SystemUserView(SystemUserService genericService) {
		super(genericService);
		newEntity = new SystemUser();
	}

	@PostConstruct
	public void init() {
		roleSource = (List<Role>) roleService.findAll();
		roles = new DualListModel<Role>(new ArrayList<Role>(), new ArrayList<Role>());
		tags = new ArrayList<String>();
		tags.add("tag1");
		tags.add("tag2");
	}

	public void add() {
		newEntity = new SystemUser();
		roles.getTarget().clear();
		roles.getSource().clear();
		roles.getSource().addAll(roleSource);
	}

	public void edit(SystemUser entity) {
		roles.getTarget().clear();
		roles.getSource().clear();
		roles.getTarget().addAll(entity.getRoles());
		roles.getSource().addAll(roleSource);
		roles.getSource().removeAll(entity.getRoles());
		newEntity = entity;
	}

	public DualListModel<Role> getRoles() {
		return roles;
	}

	public void setRoles(DualListModel<Role> roles) {
		this.roles = roles;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
