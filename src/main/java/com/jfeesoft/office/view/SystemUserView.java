package com.jfeesoft.office.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.jfeesoft.office.model.OrganizationalUnit;
import com.jfeesoft.office.model.Position;
import com.jfeesoft.office.model.Role;
import com.jfeesoft.office.model.SystemUser;
import com.jfeesoft.office.service.OrganizationalUnitService;
import com.jfeesoft.office.service.PositionService;
import com.jfeesoft.office.service.RoleService;
import com.jfeesoft.office.service.SystemUserService;
import com.jfeesoft.office.view.utils.DialogMode;
import com.jfeesoft.office.view.utils.Utils;

@Component("systemUserView")
@Scope("view")
public class SystemUserView extends GenericView<SystemUser> implements Serializable {

	private static final long serialVersionUID = 1L;

	private DualListModel<Role> roles;

	private List<Role> roleSource;

	private List<String> tags;
	private String dialogMode;
	private Long idPosition;
	private Long idOrganizationUnit;
	private Map<Long, Position> positions;
	private Map<Long, OrganizationalUnit> organizationalUnits;

	private Object test;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private OrganizationalUnitService organizationalUnitService;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public SystemUserView(SystemUserService genericService) {
		super(genericService);
		newEntity = new SystemUser();
	}

	@PostConstruct
	public void init() {
		dialogMode = DialogMode.ADD.name();
		roleSource = (List<Role>) roleService.findAll();
		positions = positionService.findAllMap();
		organizationalUnits = organizationalUnitService.findAllMap();
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

	public void addNote() {
		roleSource.add(new Role());
	}

	public void deleteNote(Role role) {
		roleSource.remove(roleSource.size() - 1);
	}

	@Override
	public void save() {
		if (dialogMode.equals(DialogMode.ADD.name())) {
			newEntity.setPassword(bcryptEncoder.encode(newEntity.getPassword()));
			newEntity.setIsActive(true);
		}
		if (idOrganizationUnit != null) {
			OrganizationalUnit unit = organizationalUnits.get(idOrganizationUnit);
			newEntity.setOrganizationalUnit(unit);
		}
		if (idPosition != null) {
			Position position = positions.get(idPosition);
			newEntity.setPosition(position);
		}
		newEntity.setRoles(Sets.newHashSet(roles.getTarget()));
		newEntity = (SystemUser) genericSerivice.save(newEntity);
		Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
	}

	public void saveTag(SelectEvent event) {
		int a = 0;
		a++;
	}

	public void saveTag(SystemUser entity) {
		int a = 0;
		a++;
	}

	@Override
	public void edit(SystemUser entity) {
		roles.getTarget().clear();
		roles.getSource().clear();
		roles.getTarget().addAll(entity.getRoles());
		roles.getSource().addAll(roleSource);
		roles.getSource().removeAll(entity.getRoles());
		newEntity = entity;
		if (entity.getOrganizationalUnit() != null) {
			idOrganizationUnit = entity.getOrganizationalUnit().getId();
		}
		if (entity.getPosition() != null) {
			idPosition = entity.getPosition().getId();
		}
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

	public String getDialogMode() {
		return dialogMode;
	}

	public void setDialogMode(String dialogMode) {
		this.dialogMode = dialogMode;
	}

	public Long getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(Long idPosition) {
		this.idPosition = idPosition;
	}

	public Long getIdOrganizationUnit() {
		return idOrganizationUnit;
	}

	public void setIdOrganizationUnit(Long idOrganizationUnit) {
		this.idOrganizationUnit = idOrganizationUnit;
	}

	public Collection<Position> getPositions() {
		return positions.values();
	}

	public Collection<OrganizationalUnit> getOrganizationalUnits() {
		return organizationalUnits.values();
	}

	public List<Role> getRoleSource() {
		return roleSource;
	}

	public void setRoleSource(List<Role> roleSource) {
		this.roleSource = roleSource;
	}

	public Object getTest() {
		return test;
	}

	public void setTest(Object test) {
		this.test = test;
	}

}
