package com.springboot.hotel.bookhere.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private long id;
	
	private String name;
	
	private String address;
	
	private String contactDetails;
	
	private List<Room> rooms = new ArrayList<Room>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	

	public List<Room> getRooms() {
		return new ArrayList<Room>( rooms);
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Hotel(long id, String name, String address, String contactDetails) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactDetails = contactDetails;
	}

	public Hotel(String name, String address, String contactDetails) {
		super();
		this.name = name;
		this.address = address;
		this.contactDetails = contactDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", contactDetails=");
		builder.append(contactDetails);
		builder.append("]");
		return builder.toString();
	}
	
	

}
