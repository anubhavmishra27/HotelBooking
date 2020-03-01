package com.springboot.hotel.bookhere.booking.service;

import java.time.LocalDate;
import java.util.List;

import com.springboot.hotel.bookhere.booking.service.model.BookingRequest;
import com.springboot.hotel.bookhere.model.BookingDetails;
import com.springboot.hotel.bookhere.model.Room;
import com.springboot.hotel.bookhere.model.Slot;

public interface BookingPortal {
	
	List<Room> listRooms(long hotelId);
	
	List<Slot> findSlots(Room room, LocalDate from, LocalDate to);
	
	BookingDetails book(BookingRequest bookingRequest);

}
