package com.springboot.hotel.bookhere.inventory.service.model;

import java.time.LocalDate;
import java.util.Date;

import com.springboot.hotel.bookhere.model.Room;

public class InventoryLoadRequest {
	
	private Room room;
	private LocalDate from;
	private LocalDate to;
	private int nos;
	private double price;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
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
	public int getNos() {
		return nos;
	}
	public void setNos(int nos) {
		this.nos = nos;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
