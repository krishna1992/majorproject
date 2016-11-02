package com.cybage.resourcemanagement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the resource_project_table database table.
 * 
 */
@Entity
@Table(name="resource_project_table")
@NamedQuery(name="ResourceProjectTable.findAll", query="SELECT r FROM ResourceProjectTable r")
public class ResourceProjectTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int RP_id;

	private float billing;

	@Temporal(TemporalType.DATE)
	private Date end_date;

	@Temporal(TemporalType.DATE)
	private Date start_date;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="Empid")
	private Employee employee;

	//bi-directional many-to-one association to ProjectTable
	@ManyToOne
	@JoinColumn(name="Proj_id")
	private ProjectTable projectTable;

	public ResourceProjectTable() {
	}

	public int getRP_id() {
		return this.RP_id;
	}

	public void setRP_id(int RP_id) {
		this.RP_id = RP_id;
	}

	public float getBilling() {
		return this.billing;
	}

	public void setBilling(float billing) {
		this.billing = billing;
	}

	public Date getEnd_date() {
		return this.end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getStart_date() {
		return this.start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ProjectTable getProjectTable() {
		return this.projectTable;
	}

	public void setProjectTable(ProjectTable projectTable) {
		this.projectTable = projectTable;
	}

}