package com.springboot.hotel.bookhere.booking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.hotel.bookhere.booking.service.model.BookingRequest;
import com.springboot.hotel.bookhere.hotel.service.HotelAggregator;
import com.springboot.hotel.bookhere.inventory.service.RoomInventory;
import com.springboot.hotel.bookhere.model.BookingDetails;
import com.springboot.hotel.bookhere.model.Room;
import com.springboot.hotel.bookhere.model.Slot;
import com.springboot.hotel.bookhere.pricing.service.Pricing;

@Component
public class BookingPortalImpl  implements BookingPortal{
	
	@Autowired
	private HotelAggregator aggregator;
	
	@Autowired
	private RoomInventory roomInventory;
	
	@Autowired
	private Pricing pricing;

	@Override
	public List<Room> listRooms(long hotelId) {
		return aggregator.listHotels()
		.stream()
		.filter(hotel -> hotel.getId() == hotelId)
		.findAny()
		.map(hotel -> hotel.getRooms())
		.orElse(null);
	}

	@Override
	public List<Slot> findSlots(Room room, LocalDate from, LocalDate to) {
		return roomInventory.findSlots(room, from, to);
	}

	@Override
	public BookingDetails book(BookingRequest bookingRequest) {
		
		Room room = aggregator.findRoomById(Long.valueOf(bookingRequest.getRoomId()));
		if(room == null) {
			throw new IllegalArgumentException("Room Not Found");
		}
		
		
		List<Slot> slots = bookingRequest
		.getSlotIds()
		.stream()
		.map(slotId -> Long.valueOf(slotId))
		.map(slotId -> new Slot(slotId))
		.collect(Collectors.toList());
		
		slots = roomInventory.bookRooms(slots);
		
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setFrom(bookingRequest.getFrom());
		bookingDetails.setTo(bookingRequest.getTo());
		bookingDetails.setSlots(slots);
		bookingDetails.setRoom(room);
		
		bookingDetails = pricing.price(bookingDetails);
		
		return bookingDetails;
		
		
		
	}

}
