package com.springboot.hotel.bookhere.inventory.service;

import java.time.LocalDate;
import java.util.List;

import com.springboot.hotel.bookhere.inventory.service.model.InventoryLoadRequest;
import com.springboot.hotel.bookhere.model.Room;
import com.springboot.hotel.bookhere.model.Slot;

public interface RoomInventory {
	
	void loadInventry(InventoryLoadRequest req);
	
	List<Slot> findSlots(Room room, LocalDate from , LocalDate to );
	
	List<Slot> bookRooms(List<Slot> rooms);
	

}
