package com.springboot.hotel.bookhere.driver;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.springboot.hotel.bookhere.booking.service.BookingPortal;
import com.springboot.hotel.bookhere.booking.service.model.BookingRequest;
import com.springboot.hotel.bookhere.hotel.service.HotelAggregator;
import com.springboot.hotel.bookhere.inventory.service.RoomInventory;
import com.springboot.hotel.bookhere.inventory.service.model.InventoryLoadRequest;
import com.springboot.hotel.bookhere.model.BookingDetails;
import com.springboot.hotel.bookhere.model.Hotel;
import com.springboot.hotel.bookhere.model.Room;
import com.springboot.hotel.bookhere.model.Room.RoomType;
import com.springboot.hotel.bookhere.model.Slot;

@SpringBootApplication
@ComponentScan ("com.springboot.hotel.bookhere")
@PropertySource("classpath:tax.properties")
public class HotelBookApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HotelBookApplication.class, args);
		
		RoomInventory roomIn = ctx.getBean(RoomInventory.class);
		/*
		 * Room room = new Room(RoomType.NON_AC, 10L);
		 * 
		 * InventoryLoadRequest inventoryLoadRequest = new InventoryLoadRequest();
		 * inventoryLoadRequest.setFrom(LocalDate.now());
		 * inventoryLoadRequest.setTo(LocalDate.now().plusDays(5));
		 * inventoryLoadRequest.setNos(3); inventoryLoadRequest.setRoom(room);
		 * inventoryLoadRequest.setPrice(200);
		 * 
		 * 
		 * roomIn.loadInventry(inventoryLoadRequest);
		 */
		
		/*
		 * List<Slot> slots = roomIn.findSlots(room,LocalDate.now().plusDays(1) ,
		 * LocalDate.now().plusDays(2)); System.out.println("resullt " + slots.size());
		 * System.out.println("Before Booking " + slots);
		 * 
		 * List<Slot> bookSlots = slots.stream().limit(3).collect(Collectors.toList());
		 * 
		 * roomIn.bookRooms(bookSlots);
		 * 
		 * slots = roomIn.findSlots(room,LocalDate.now().plusDays(1) ,
		 * LocalDate.now().plusDays(2)); System.out.println("resullt " + slots.size());
		 * System.out.println("Before Booking " + slots);
		 * 
		 * 
		 * bookSlots = slots.stream().limit(3).collect(Collectors.toList());
		 * 
		 * roomIn.bookRooms(bookSlots);
		 * 
		 * slots = roomIn.findSlots(room,LocalDate.now().plusDays(1) ,
		 * LocalDate.now().plusDays(2)); System.out.println("resullt " + slots.size());
		 * System.out.println("Before Booking " + slots);
		 */
		
		BookingPortal portal = ctx.getBean(BookingPortal.class);
		HotelAggregator agg = ctx.getBean(HotelAggregator.class);
		
		agg.registerHotel(new Hotel(11, "Casa De", "BTM", "98863"));
		Room room = new Room(RoomType.NON_AC, 10L);

		agg.addRoomType(11, room);
		
		

		
		InventoryLoadRequest inventoryLoadRequest = new InventoryLoadRequest();
		inventoryLoadRequest.setFrom(LocalDate.now());
		inventoryLoadRequest.setTo(LocalDate.now().plusDays(5));
		inventoryLoadRequest.setNos(3);
		inventoryLoadRequest.setRoom(room);
		inventoryLoadRequest.setPrice(200);
		
		
		roomIn.loadInventry(inventoryLoadRequest);
	
	    List<Slot> slots = portal.findSlots(room, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));

	    System.out.println("Slots" + slots);
	    
	    BookingRequest request = new BookingRequest();
	    request.setFrom(inventoryLoadRequest.getFrom());
	    request.setTo(inventoryLoadRequest.getTo());
	    request.setRoomId(String.valueOf(room.getRoomId()));
	    request.setSlotIds(slots.stream()
	    		.map(slot -> slot.getId())
	    		.map(String::valueOf)
	    		.limit(2)
	    		.collect(Collectors.toList()));
	    
	   BookingDetails details = portal.book(request);
	   
	   
	   
	   System.out.println(details);
	   
	    //details = portal.book(request);

	    
		System.out.println("_-----------------------");
	 slots = portal.findSlots(room, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));

	    System.out.println("Slots" + slots);
	   
	}

}
