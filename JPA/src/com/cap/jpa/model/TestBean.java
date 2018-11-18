package com.cap.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Entity(name="TestBean")
@Transactional
public class TestBean {
	
	@Id
	private Integer queryID;
	
	String technology;
	String name;
	String query;
	String solutions;
	String solutionname;
	public Integer getQueryID() {
		return queryID;
	}
	public void setQueryID(Integer queryID) {
		this.queryID = queryID;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSolutions() {
		return solutions;
	}
	public void setSolutions(String solutions) {
		this.solutions = solutions;
	}
	public String getSolutionname() {
		return solutionname;
	}
	public void setSolutionname(String solutionname) {
		this.solutionname = solutionname;
	}
	

}
