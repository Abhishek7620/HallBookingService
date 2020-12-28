package com.test.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HallDetails {
	
	@Id
	@GeneratedValue
	private int id ;
	private String hallName;
	private int capacity; 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	///SELECT * FROM hall_details  where capacity >50 limit 2 ORDER BY CAST(capacity AS int) DESC;

	
}
