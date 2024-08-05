package ltts.com.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltts.com.dao.HotelDao;
import ltts.com.model.Booking;
import ltts.com.model.Login;
import ltts.com.model.Room;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelDao dao;

	@Override
	public List<Room> show() {
		
		return dao.show();
	}

	@Override
	public boolean deleteRoom(int roomno) {
		
		return dao.deleteRoom(roomno);
	}


	@Override
	public boolean addLogin(int id, String name, String email, String pwd, String atype) {
		if(dao.addLogin(new Login(id,name,email,pwd,atype))) {
		return true;
	}
	return false;
	}

	@Override
	public boolean addRoom(int roomno, int floor, String rtype, String category, Double price) {
		if(dao.addRoom(new Room(roomno, floor, rtype, category, price))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addBooking(int bid, int roomno, int id, Date check_in, Date check_out, int nop, Date bookdate,
			Double price) {
		if(dao.addBooking(new Booking(bid, roomno, id, check_in, check_out, nop, bookdate, price)))
				{
			return true;
				}
		return false;
	}

	@Override
	public boolean deleteBookRoom(int roomno) {
		
		return dao.deleteBookRoom(roomno);
	}

	@Override
	public boolean login(Login u) {
		
		return dao.login(u);
	}


	

	

	

}
