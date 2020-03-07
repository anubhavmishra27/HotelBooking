package com.springboot.hotel.bookhere.model;

import java.time.LocalDate;
import java.util.List;

public class BookingDetails {

	private String name;
	
	private Room room;
	
	private List<Slot> slots;
	
	private LocalDate from;
	
	private LocalDate to;
	
	private Price price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
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

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingDetails [name=").append(name).append(", room=").append(room).append(", slots=")
				.append(slots).append(", from=").append(from).append(", to=").append(to).append(", price=")
				.append(price).append("]");
		return builder.toString();
	}
	
	
	
	
}
