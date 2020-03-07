package com.springboot.hotel.bookhere.inventory.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSInput;

import com.springboot.hotel.bookhere.inventory.service.model.InventoryLoadRequest;
import com.springboot.hotel.bookhere.model.Room;
import com.springboot.hotel.bookhere.model.Slot;


@Component
public class RoomInventoryInMemImpl implements RoomInventory {

	private Map<Long , Slot> slots = new HashMap<>();
	
	@Override
	public void loadInventry(InventoryLoadRequest req) {

		LocalDate from = req.getFrom();
		LocalDate to = req.getTo();

		for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
	        for(int i = 0 ; i < req.getNos() ; i ++) {
	        	long id = Math.abs(new Random().nextLong());
	        	slots.put(id , new Slot(id, req.getRoom(),date, req.getPrice()));
	        }
	    }
		
		System.out.println(slots.size());
		System.out.println(slots);
	}

	@Override
	public List<Slot> findSlots(Room room, LocalDate from, LocalDate to) {
		return slots
		.values()
		.stream()
		.filter(slot -> !slot.isBooked())
		.filter(slot -> slot.getRoom().getRoomId() == room.getRoomId())
		.filter(slot -> from.compareTo(slot.getDay()) <= 1  && to.compareTo(slot.getDay()) >= 1) 
		.collect(Collectors.toList());
	}

	@Override
	public List<Slot> bookRooms(List<Slot> slots) {
		List<Slot> resultSlots = new ArrayList<Slot>();
		for(Slot slot : slots) {
			if(!this.slots.containsKey(slot.getId())) {
				throw new RuntimeException("Not a valid slot");
			}
			if(this.slots.get(slot.getId()).isBooked()) {
				throw new RuntimeException("Its already booked");
			}
			Slot slotResult = this.slots.get(slot.getId());	
			slotResult.setBooked(true);
			resultSlots.add(slotResult);
		}
		return resultSlots;
		
	}

	

}
