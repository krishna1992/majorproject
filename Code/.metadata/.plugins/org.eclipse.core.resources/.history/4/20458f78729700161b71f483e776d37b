package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project_table database table.
 * 
 */
@Entity
@Table(name="project_table")
@NamedQuery(name="ProjectTable.findAll", query="SELECT p FROM ProjectTable p")
public class ProjectTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int proj_id;

	@Temporal(TemporalType.DATE)
	private Date proj_end_date;

	private String proj_name;

	@Temporal(TemporalType.DATE)
	private Date proj_start_date;

	private String proj_status;

	//bi-directional many-to-one association to ResourceProjectTable
	@OneToMany(mappedBy="projectTable")
	private List<ResourceProjectTable> resourceProjectTables;

	//bi-directional many-to-one association to RoleTable
	@OneToMany(mappedBy="projectTable")
	private List<RoleTable> roleTables;

	//bi-directional many-to-one association to TeamEmpidTable
	@OneToMany(mappedBy="projectTable")
	private List<TeamEmpidTable> teamEmpidTables;

	public ProjectTable() {
	}

	public int getProj_id() {
		return this.proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public Date getProj_end_date() {
		return this.proj_end_date;
	}

	public void setProj_end_date(Date proj_end_date) {
		this.proj_end_date = proj_end_date;
	}

	public String getProj_name() {
		return this.proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	public Date getProj_start_date() {
		return this.proj_start_date;
	}

	public void setProj_start_date(Date proj_start_date) {
		this.proj_start_date = proj_start_date;
	}

	public String getProj_status() {
		return this.proj_status;
	}

	public void setProj_status(String proj_status) {
		this.proj_status = proj_status;
	}

	public List<ResourceProjectTable> getResourceProjectTables() {
		return this.resourceProjectTables;
	}

	public void setResourceProjectTables(List<ResourceProjectTable> resourceProjectTables) {
		this.resourceProjectTables = resourceProjectTables;
	}

	public ResourceProjectTable addResourceProjectTable(ResourceProjectTable resourceProjectTable) {
		getResourceProjectTables().add(resourceProjectTable);
		resourceProjectTable.setProjectTable(this);

		return resourceProjectTable;
	}

	public ResourceProjectTable removeResourceProjectTable(ResourceProjectTable resourceProjectTable) {
		getResourceProjectTables().remove(resourceProjectTable);
		resourceProjectTable.setProjectTable(null);

		return resourceProjectTable;
	}

	public List<RoleTable> getRoleTables() {
		return this.roleTables;
	}

	public void setRoleTables(List<RoleTable> roleTables) {
		this.roleTables = roleTables;
	}

	public RoleTable addRoleTable(RoleTable roleTable) {
		getRoleTables().add(roleTable);
		roleTable.setProjectTable(this);

		return roleTable;
	}

	public RoleTable removeRoleTable(RoleTable roleTable) {
		getRoleTables().remove(roleTable);
		roleTable.setProjectTable(null);

		return roleTable;
	}

	public List<TeamEmpidTable> getTeamEmpidTables() {
		return this.teamEmpidTables;
	}

	public void setTeamEmpidTables(List<TeamEmpidTable> teamEmpidTables) {
		this.teamEmpidTables = teamEmpidTables;
	}

	public TeamEmpidTable addTeamEmpidTable(TeamEmpidTable teamEmpidTable) {
		getTeamEmpidTables().add(teamEmpidTable);
		teamEmpidTable.setProjectTable(this);

		return teamEmpidTable;
	}

	public TeamEmpidTable removeTeamEmpidTable(TeamEmpidTable teamEmpidTable) {
		getTeamEmpidTables().remove(teamEmpidTable);
		teamEmpidTable.setProjectTable(null);

		return teamEmpidTable;
	}

}