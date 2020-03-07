package com.springboot.hotel.bookhere.pricing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.hotel.bookhere.model.BookingDetails;
import com.springboot.hotel.bookhere.model.Slot;

@SpringBootTest(classes = PricingImpl.class)
public class PricingTest {
	
	@Autowired
	private Pricing pricing;

	
	@Test
	public void testPricing() {
		BookingDetails bookingDetails = new BookingDetails();
	
		List<Slot> slots= new ArrayList<Slot>();
		slots.add(new Slot(1, null, null, 100));
		slots.add(new Slot(2, null, null, 100));
		slots.add(new Slot(3, null, null, 100));
		slots.add(new Slot(4, null, null, 100));
		slots.add(new Slot(5, null, null, 100));
		
		bookingDetails.setSlots(slots);
		
		bookingDetails = pricing.price(bookingDetails);
		
		assertNotNull(bookingDetails.getPrice());
		assertEquals(500.00, bookingDetails.getPrice().getTotalAmount());
		assertEquals(90.00, bookingDetails.getPrice().getTax());
		assertEquals(590.00, bookingDetails.getPrice().getFinalAmount());

	}

}
