package com.hongxeob.ch1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.addElement(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		int frequentRenterPoints = 0;
		Enumeration rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			frequentRenterPoints = each.getFrequentRenterPoints();

			//이 대여에 대한 요금 계산결과 표시
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";

		return result;
	}

	public String htmlStatement() {
		Enumeration rentals = this.rentals.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM><H1><P>\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getMovie().getTitle() + ": " +
				String.valueOf(each.getCharge()) + "<BR>\n";
		}

		result += "<P>You Owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this Rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter point<P>";

		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = this.rentals.elements();

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}

		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = this.rentals.elements();

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}

		return result;
	}

}
