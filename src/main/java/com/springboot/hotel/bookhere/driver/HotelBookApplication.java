package com.springboot.hotel.bookhere.driver;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springboot.hotel.bookhere.inventory.service.RoomInventory;
import com.springboot.hotel.bookhere.inventory.service.model.InventoryLoadRequest;
import com.springboot.hotel.bookhere.model.Room;
import com.springboot.hotel.bookhere.model.Room.RoomType;
import com.springboot.hotel.bookhere.model.Slot;

@SpringBootApplication
@ComponentScan ("com.springboot.hotel.bookhere.inventory.service")
public class HotelBookApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HotelBookApplication.class, args);
		
		RoomInventory roomIn = ctx.getBean(RoomInventory.class);
		
		Room room = new Room(RoomType.NON_AC, 10L);
		
		InventoryLoadRequest inventoryLoadRequest = new InventoryLoadRequest();
		inventoryLoadRequest.setFrom(LocalDate.now());
		inventoryLoadRequest.setTo(LocalDate.now().plusDays(5));
		inventoryLoadRequest.setNos(3);
		inventoryLoadRequest.setRoom(room);
		inventoryLoadRequest.setPrice(200);
		
		
		roomIn.loadInventry(inventoryLoadRequest);
		
		List<Slot> slots = roomIn.findSlots(room,LocalDate.now().plusDays(1) , LocalDate.now().plusDays(2));
		System.out.println("resullt "  + slots.size());
		System.out.println("Before Booking " + slots);
		
		List<Slot> bookSlots = slots.stream().limit(3).collect(Collectors.toList());
		
		roomIn.bookRooms(bookSlots);
		
		 slots = roomIn.findSlots(room,LocalDate.now().plusDays(1) , LocalDate.now().plusDays(2));
		System.out.println("resullt "  + slots.size());
		System.out.println("Before Booking " + slots);
		
		
bookSlots = slots.stream().limit(3).collect(Collectors.toList());
		
		roomIn.bookRooms(bookSlots);
		
		 slots = roomIn.findSlots(room,LocalDate.now().plusDays(1) , LocalDate.now().plusDays(2));
		System.out.println("resullt "  + slots.size());
		System.out.println("Before Booking " + slots);
	}

}
