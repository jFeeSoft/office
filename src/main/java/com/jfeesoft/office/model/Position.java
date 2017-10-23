package com.jfeesoft.office.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organizational_unit")
@AttributeOverride(name = "id", column = @Column(name = "organizational_unit_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "organizational_unit_seq", allocationSize = 1, initialValue = 100)
public class Position extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", length = 64)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
