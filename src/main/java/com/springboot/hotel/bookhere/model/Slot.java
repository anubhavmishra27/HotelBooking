package com.springboot.hotel.bookhere.model;

import java.time.LocalDate;
import java.util.Date;

public class Slot {
	
	private long id;
	
	private Room room;
	
	private LocalDate day;
	
	private double price;
	
	private boolean isBooked;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Slot(long id) {
		this.id = id;
	}
	
	public Slot(long id, Room room, LocalDate day, double price) {
		super();
		this.id = id;
		this.room = room;
		this.day = day;
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Slot [id=");
		builder.append(id);
		builder.append(", room=");
		builder.append(room);
		builder.append(", day=");
		builder.append(day);
		builder.append(", price=");
		builder.append(price);
		builder.append(", isBooked=");
		builder.append(isBooked);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
