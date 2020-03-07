package com.springboot.hotel.bookhere.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.springboot.hotel.bookhere.model.Hotel;
import com.springboot.hotel.bookhere.model.Room;

@Component
public class HotelAggregatorInMemImpl implements HotelAggregator{

	private Map<Long, Hotel> hotels = new HashMap<Long, Hotel>();
	
	@Override
	public void registerHotel(Hotel hotel) {
		hotels.put(hotel.getId(), hotel);
	}

	@Override
	public void addRoomType(long hotelId, Room room) {
		if(hotels.containsKey(hotelId)) {
			 List<Room> rooms = hotels.get(hotelId).getRooms();
			 rooms.add(room);
			 hotels.get(hotelId).setRooms(rooms);
			 }
		
	}

	@Override
	public List<Hotel> listHotels() {
		return new ArrayList<Hotel>(hotels.values());
	}

	@Override
	public Room findRoomById(long roomId) {
		return hotels
				.values()
				.stream()
				.flatMap(hotel -> hotel.getRooms().stream())
				.filter(room -> room.getRoomId() == roomId)
				.findFirst()
				.orElse(null);
				
	}

}
