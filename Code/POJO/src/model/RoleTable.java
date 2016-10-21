package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_table database table.
 * 
 */
@Entity
@Table(name="role_table")
@NamedQuery(name="RoleTable.findAll", query="SELECT r FROM RoleTable r")
public class RoleTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int role_id;

	private String role;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="Empid")
	private Employee employee;

	//bi-directional many-to-one association to ProjectTable
	@ManyToOne
	@JoinColumn(name="Proj_id")
	private ProjectTable projectTable;

	public RoleTable() {
	}

	public int getRole_id() {
		return this.role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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