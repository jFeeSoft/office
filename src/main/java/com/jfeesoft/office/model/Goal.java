package com.jfeesoft.office.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "goal")
@AttributeOverride(name = "id", column = @Column(name = "goal_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "goal_seq", allocationSize = 1, initialValue = 100)
public class Goal extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", length = 64)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_from", length = 13)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_to", length = 13)
	private Date dateTo;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 16)
	private Status status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goal")
	private Set<Task> tasks = new HashSet<>(0);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
