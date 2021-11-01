package com.security.jwt.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ni_project_npi")
public class ni_project_npi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long project_id;
	
	@Column(name = "user_id")
	private Integer user_id;
	

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private ni_team team;
	
	@Column(name= "npiid")
	private Integer npiid;
	
	@Column(name = "finid")
	private String finid;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "yr1rev")
	private String yr1rev;
	
	@Column (name = "yr2rev")
	private String yr2rev;
	
	@Column (name = "investment")
	private String investment;
	
	public ni_project_npi() {
		
	}
	
	public ni_project_npi(long project_id, Integer user_id, ni_team team, Integer npiid, String finid, String name,
			String description, String yr1rev, String yr2rev, String investment) {
		super();
		this.project_id = project_id;
		this.user_id = user_id;
		this.team = team;
		this.npiid = npiid;
		this.finid = finid;
		this.name = name;
		this.description = description;
		this.yr1rev = yr1rev;
		this.yr2rev = yr2rev;
		this.investment = investment;
	}

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public ni_team getTeam() {
		return team;
	}

	public void setTeam(ni_team team) {
		this.team = team;
	}

	public Integer getNpiid() {
		return npiid;
	}

	public void setNpiid(Integer npiid) {
		this.npiid = npiid;
	}

	public String getFinid() {
		return finid;
	}

	public void setFinid(String finid) {
		this.finid = finid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYr1rev() {
		return yr1rev;
	}

	public void setYr1rev(String yr1rev) {
		this.yr1rev = yr1rev;
	}

	public String getYr2rev() {
		return yr2rev;
	}

	public void setYr2rev(String yr2rev) {
		this.yr2rev = yr2rev;
	}

	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}


	
	public ni_project_npi(long project_id) {
		super();
		this.project_id = project_id;
		
	}
	
}