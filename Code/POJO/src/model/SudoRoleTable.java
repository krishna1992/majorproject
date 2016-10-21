package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sudo_role_table database table.
 * 
 */
@Entity
@Table(name="sudo_role_table")
@NamedQuery(name="SudoRoleTable.findAll", query="SELECT s FROM SudoRoleTable s")
public class SudoRoleTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int srole_id;

	@Temporal(TemporalType.DATE)
	private Date e_date;

	@Temporal(TemporalType.DATE)
	private Date s_date;

	private String sudo_Role;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="Empid")
	private Employee employee;

	public SudoRoleTable() {
	}

	public int getSrole_id() {
		return this.srole_id;
	}

	public void setSrole_id(int srole_id) {
		this.srole_id = srole_id;
	}

	public Date getE_date() {
		return this.e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public Date getS_date() {
		return this.s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getSudo_Role() {
		return this.sudo_Role;
	}

	public void setSudo_Role(String sudo_Role) {
		this.sudo_Role = sudo_Role;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}