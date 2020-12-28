package com.test.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class HallBookingDetails {
	
	@Id
	@GeneratedValue
	private int id ;
	private String hallName;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private String bookingDate;
	private String bookingtime;
	private String status;
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
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingtime() {
		return bookingtime;
	}
	public void setBookingtime(String bookingtime) {
		this.bookingtime = bookingtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
	

}
