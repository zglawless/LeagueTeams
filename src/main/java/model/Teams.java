package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="teams")
public class Teams {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TEAMNAME")
	private String teamName;
	
	public Teams() {
	super();
	}
	
	public Teams(String teamName) {
		super();
		this.teamName = teamName;
	}

	public Teams(int id, String teamName) {
		super();
		this.id = id;
		this.teamName = teamName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "Teams [id=" + id + ", teamName=" + teamName + "]";
	}
	
	
	
}
