package com.springboot.hotel.bookhere.pricing.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.hotel.bookhere.model.BookingDetails;
import com.springboot.hotel.bookhere.model.Price;

@Component
public class PricingImpl implements Pricing{

	
	@Value("${gov.tax:18d}")
	private double tax;
	
	
	
	@Override
	public BookingDetails price(BookingDetails bookingDetails) {
		if(bookingDetails != null && bookingDetails.getSlots() != null) {
			Double totalPrice = bookingDetails
					.getSlots()
					.stream()
					.map(slot -> slot.getPrice()).collect(Collectors.summingDouble(Double::valueOf));
			double taxAmount = totalPrice * (tax/100);
			double finalPrice = totalPrice + taxAmount;
		    Price price = new Price();
		    price.setFinalAmount(finalPrice);
		    //price.setTax(taxAmount);
		    price.setTotalAmount(totalPrice);
		    bookingDetails.setPrice(price);
		    
		    return bookingDetails;
		    
		    
		}
		return bookingDetails;
		
	}

}
