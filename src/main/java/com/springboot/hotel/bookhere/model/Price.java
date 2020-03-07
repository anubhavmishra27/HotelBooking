package com.springboot.hotel.bookhere.model;

public class Price {
	
	private double totalAmount;
	
	private double tax;
	
	private double finalAmount;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Price [totalAmount=").append(totalAmount).append(", tax=").append(tax).append(", finalAmount=")
				.append(finalAmount).append("]");
		return builder.toString();
	}
	
	

}
