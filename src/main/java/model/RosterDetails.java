package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Oct 13, 2022
 */
@Entity
public class RosterDetails {
	@Id
	@GeneratedValue
	private int id;
	private String rosterName;
	private LocalDate startDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Teams teams;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Players> listOfPlayers;
	
	public RosterDetails() {
		super();
	}
	
	public RosterDetails(int id, String rosterName, LocalDate startDate, Teams teams, List<Players> listOfPlayers) {
		super();
		this.id = id;
		this.rosterName = rosterName;
		this.startDate = startDate;
		this.teams = teams;
		this.listOfPlayers = listOfPlayers;
	}
	
	public RosterDetails(String rosterName, LocalDate startDate, Teams teams, List<Players> listOfPlayers) {
		super();
		this.rosterName = rosterName;
		this.startDate = startDate;
		this.teams = teams;
		this.listOfPlayers = listOfPlayers;
	}
	
	public RosterDetails(String rosterName, LocalDate startDate, Teams teams) {
		super();
		this.rosterName = rosterName;
		this.startDate = startDate;
		this.teams = teams;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRosterName() {
		return rosterName;
	}

	public void setRosterName(String rosterName) {
		this.rosterName = rosterName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	public List<Players> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(List<Players> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	@Override
	public String toString() {
		return "RosterDetails [id=" + id + ", rosterName=" + rosterName + ", startDate=" + startDate + ", teams="
				+ teams + ", listOfPlayers=" + listOfPlayers + "]";
	}
	
}
