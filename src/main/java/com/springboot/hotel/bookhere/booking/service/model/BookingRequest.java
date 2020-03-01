package com.springboot.hotel.bookhere.booking.service.model;

import java.time.LocalDate;
import java.util.List;

import com.springboot.hotel.bookhere.model.Room;

public class BookingRequest {
	
	private Room room;
	
	private List<String> slotIds;
	
	private LocalDate from;
	
	private LocalDate to;
	
	private String userName;
	
	
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<String> getSlotIds() {
		return slotIds;
	}

	public void setSlotIds(List<String> slotIds) {
		this.slotIds = slotIds;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
