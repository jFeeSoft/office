package com.jfeesoft.office.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
@AttributeOverride(name = "id", column = @Column(name = "permission_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "permission_seq", allocationSize = 1, initialValue = 100)
public class Permission extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Column(name = "component", length = 64)
	private String component;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Permission parent;

	@OneToMany(mappedBy = "parent")
	private List<Permission> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

}
