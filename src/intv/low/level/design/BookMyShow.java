package intv.low.level.design;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class BookMyShow {

	List<CinemaHall> cinemas;

	public abstract List<Movie> getMovies(Date date, String city);
	public abstract List<CinemaHall> getCinemalHalls(String city);

}

abstract class CinemaHall {

	int cinemaHallId;
	String cinemaHallName;

	Address address;

	List<Audi>audiList;

	public abstract Map<Date, Movie> getMovies(List<Date> dateList);
	public abstract Map<Date, Show> getShows(List<Date> dateList);

}

class AddressBMS {

	int pinCode; //ZipCode
	String street;
	String city;
	String state;
	String country;

}

class Audi {

	int audiId;
	String audiName;
	int totalSeats;
	
	List<Show> shows;

}

class Show {

	int showId;
	Movie movie;
	Date startTime;
	Date endTime;
	CinemaHall cinemaPlayedAt;
	List<Seat> seats;
}

class Seat {

	int seatId;
	SeatType seatType;
	SeatStatus seatStatus;
	Double price;

}

enum SeatType {

	DELUX, VIP, ECONOMY, OTHER;

}

enum SeatStatus {

	BOOKED, AVAILABLE, RESERVED, NOT_AVAILABLE;
}

class Movie {

	String movieName;
	int movieId;
	int durationInMins;
	String language;
	Genre genre;
	Date releaseDate;
	Map<String, List<Show>> cityShowMap;
}

enum Genre {

	SCI_FI, DRAMA, ROM_COM, FANTASY;
}

class UserBMS {

	int userId;
	Search searchObj;

}

abstract class SystemMember extends User {

	Account account;
	String name;
	String email;
	Address address;

}



abstract class MemberBMS extends SystemMember {

	public abstract Booking makeBooking(Booking booking);
	public abstract List<Booking> getBooking();

}

abstract class AdminBM extends SystemMember {

	public abstract boolean addMovie(Movie moivie);
	public abstract boolean addShow(Show show);

}

class AccountBMS {

	String userName;
	String password;

}

abstract class SearchBMS {

	public abstract List<Movie> searchMoviesByNames(String name);
	public abstract List<Movie> searchMoviesByGenre(Genre genre);
	public abstract List<Movie> searchMoviesByLanguage(String language);
	public abstract List<Movie> searchMoviesByDate(Date releaseDate);
}

abstract class Booking {

	String bookingId;
	Date bookingDate;
	Member member;
	Audi audi;
	Show show;
	BookingStatus bookingStatus;
	double totalAmount;
	List<Seat> seats;
	Payment paymentObj;

	public abstract boolean makePayment(Payment payment);

}

class PaymentBMS {

	double amount;
	Date paymentDate;
	int transactionId;
	PaymentStatus paymentStatus;
}

enum BookingStatus {

	REQUESTED, PENDING, CONFIRMED, CANCELLED;
}

enum PaymentStatusBMS {

	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;
}
