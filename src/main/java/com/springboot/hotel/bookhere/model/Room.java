package com.springboot.hotel.bookhere.model;

public class Room {
	
	public enum RoomType { AC , NON_AC };
	
	private RoomType type;
	
	private long roomId;

	public Room(RoomType type, long roomId) {
		super();
		this.type = type;
		this.roomId = roomId;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [type=");
		builder.append(type);
		builder.append(", roomId=");
		builder.append(roomId);
		builder.append("]");
		return builder.toString();
	}
	

}
