package com.cybage.resourcemanagement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the team_empid_table database table.
 * 
 */
@Entity
@Table(name="team_empid_table")
@NamedQuery(name="TeamEmpidTable.findAll", query="SELECT t FROM TeamEmpidTable t")
public class TeamEmpidTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int TEid;

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

	//bi-directional many-to-one association to TeamTable
	@ManyToOne
	@JoinColumn(name="Tid")
	private TeamTable teamTable;

	public TeamEmpidTable() {
	}

	public int getTEid() {
		return this.TEid;
	}

	public void setTEid(int TEid) {
		this.TEid = TEid;
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

	public TeamTable getTeamTable() {
		return this.teamTable;
	}

	public void setTeamTable(TeamTable teamTable) {
		this.teamTable = teamTable;
	}

}