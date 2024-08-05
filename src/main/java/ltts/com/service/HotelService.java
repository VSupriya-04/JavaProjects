package ltts.com.service;

import java.sql.Date;
import java.util.List;

import ltts.com.model.Booking;
import ltts.com.model.Login;

import ltts.com.model.Room;

public interface HotelService {
	
	public boolean addRoom(int roomno, int floor, String rtype, String category, Double price);
	public boolean addBooking(int bid, int roomno, int id, Date check_in, Date check_out, int nop, Date bookdate,
			Double price);
	public boolean addLogin(int id,String name,String email,String pwd,String atype);
	public List<Room> show();
	public boolean deleteRoom(int roomno);
	boolean deleteBookRoom(int roomno);
	public boolean login(Login u);
}
