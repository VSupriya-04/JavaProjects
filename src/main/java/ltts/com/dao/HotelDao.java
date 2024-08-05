package ltts.com.dao;

import java.util.List;


import ltts.com.model.Booking;
import ltts.com.model.Login;

import ltts.com.model.Room;

public interface HotelDao {
	
	public boolean addLogin(Login users);
	public boolean addRoom(Room rooms);
	public boolean addBooking(Booking booking);
	
	
    public List<Room> show();
    public boolean deleteRoom(int roomno);
	boolean deleteBookRoom(int roomno);
	public boolean login(Login u);
}
