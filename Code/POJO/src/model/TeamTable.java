package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team_table database table.
 * 
 */
@Entity
@Table(name="team_table")
@NamedQuery(name="TeamTable.findAll", query="SELECT t FROM TeamTable t")
public class TeamTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int tid;

	private String team_name;

	private String team_status;

	//bi-directional many-to-one association to TeamEmpidTable
	@OneToMany(mappedBy="teamTable")
	private List<TeamEmpidTable> teamEmpidTables;

	public TeamTable() {
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTeam_name() {
		return this.team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_status() {
		return this.team_status;
	}

	public void setTeam_status(String team_status) {
		this.team_status = team_status;
	}

	public List<TeamEmpidTable> getTeamEmpidTables() {
		return this.teamEmpidTables;
	}

	public void setTeamEmpidTables(List<TeamEmpidTable> teamEmpidTables) {
		this.teamEmpidTables = teamEmpidTables;
	}

	public TeamEmpidTable addTeamEmpidTable(TeamEmpidTable teamEmpidTable) {
		getTeamEmpidTables().add(teamEmpidTable);
		teamEmpidTable.setTeamTable(this);

		return teamEmpidTable;
	}

	public TeamEmpidTable removeTeamEmpidTable(TeamEmpidTable teamEmpidTable) {
		getTeamEmpidTables().remove(teamEmpidTable);
		teamEmpidTable.setTeamTable(null);

		return teamEmpidTable;
	}

}