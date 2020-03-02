package com.springboot.hotel.bookhere.pricing.service;

import com.springboot.hotel.bookhere.model.BookingDetails;

public interface Pricing {
	
	public BookingDetails price(BookingDetails bookingDetails);

}
