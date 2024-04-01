package com.hongxeob.ch1;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge() {
		double result = 0;

		//각 영화에 대한 요금 결정
		switch (getMovie().getPriceCode()) {
			case Movie.REGULAR -> {
				result += 2;
				if (getDaysRented() > 2) {
					result += (getDaysRented() - 2) * 1.5;
				}
				break;
			}
			case Movie.NEW_RELEASE -> {
				result += getDaysRented() * 3;
				break;
			}
			case Movie.CHILDREN -> {
				result += 1.5;
				if (getDaysRented() > 3) {
					result += (getDaysRented() - 3) * 1.5;
					break;
				}
			}
		}

		return result;
	}

	public int getFrequentRenterPoints() {

		//최신(new release)을 이틀 이상 대여하는 경우 추가 포인트 제공
		if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
			return 2;
		}
		return 1;
	}

}
