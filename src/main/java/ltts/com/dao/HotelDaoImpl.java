package ltts.com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ltts.com.jpa.MyJPARepository1;
import ltts.com.jpa.MyJPARepository2;
import ltts.com.jpa.MyJPARepository3;

import ltts.com.model.Booking;
import ltts.com.model.Login;

import ltts.com.model.Room;



@Repository
public class HotelDaoImpl implements HotelDao {
	
	@Autowired
	private MyJPARepository1 repo1;
	@Autowired
	private MyJPARepository2 repo2;
	@Autowired
	private MyJPARepository3 repo3;
	
	
	@Override
	public boolean addLogin(Login users) {
		Login u = repo1.save(users);
		 if(u!=null)
		 {
			 return true;
		 } 	
		return false;
	}


	@Override
	public boolean addRoom(Room rooms) {
		Room r = repo2.save(rooms);
		 if(r!=null)
		 {
			 return true;
		 } 	
		return false;
	}


	@Override
	public boolean addBooking(Booking booking) {
		Room r = repo3.save(booking);
		 if(r!=null)
		 {
			 return true;
		 } 	
		return false;
	}


	@Override
	public List<Room> show() {
		List<Room> a1=(List<Room>)repo3.findAll();

		return a1;
	}


	@Override
	@Transactional
	public boolean deleteRoom(int roomno) {
		Optional<Room> getData = repo3.findByRoomno(roomno);
		if (getData.isPresent()) {
           repo3.deleteByRoomno(roomno);
           System.out.println("Room found and deleted");
		   return true;
		}
		System.out.println("Room not found");
		return false;
	}


	

	@Override
	@Transactional
	public boolean deleteBookRoom(int roomno) {
		Optional<Booking> getData = repo2.findByRoomno(roomno);
		if (getData.isPresent()) {
           repo2.deleteByRoomno(roomno);
           System.out.println("Room found and deleted");
		   return true;
		}
		System.out.println("Room not found");
		return false;
	}
	@Override
	@Transactional
	public boolean login(Login u) {
		if(repo1.getByUsernamePass(u.getName(), u.getPwd())!=null) {
			return true;
		}
		return false;
	}
	

}

