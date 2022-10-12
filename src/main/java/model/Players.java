package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="players")
public class Players {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="NUMBER") // stores the players jersey number
	private int number;
	@Column(name="STARTDATE") // stores the date the player started playing on the team
	private LocalDate startDate;
	
	public Players() {

	}
	
	public Players(String name, int number, LocalDate startDate) {
		this.name = name;
		this.number = number;
		this.startDate = startDate;
	}

	public Players(int id, String name, int number, LocalDate startDate) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.startDate = startDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", number=" + number + ", startDate=" + startDate + "]";
	}
	
	
	
	
	
	
	

}
