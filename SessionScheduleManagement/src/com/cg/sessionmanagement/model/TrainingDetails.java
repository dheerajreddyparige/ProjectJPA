package com.cg.sessionmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ScheduledSessions")
public class TrainingDetails {

	@Id
	private Integer id;
	private String name;
	private Integer duration;
	private String faculty;
	private String mode1;

	public TrainingDetails() {

	}

	public TrainingDetails(Integer id,String name, Integer duration, String faculty, String mode1) {
		super();
		this.id=id;
		this.name = name;
		this.duration = duration;
		this.faculty = faculty;
		this.mode1 = mode1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getMode1() {
		return mode1;
	}

	public void setMode1(String mode1) {
		this.mode1 = mode1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}
