package com.springboot.hotel.bookhere.hotel.service;

import java.util.List;

import com.springboot.hotel.bookhere.model.Hotel;
import com.springboot.hotel.bookhere.model.Room;

public interface HotelAggregator {
	
	void registerHotel(Hotel hotel);
	
	List<Hotel> listHotels();
	
	void addRoomType(long hotelId, Room room);
	
	Room findRoomById(long roomId);
	
}
