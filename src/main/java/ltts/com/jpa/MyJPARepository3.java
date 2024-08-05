package ltts.com.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ltts.com.model.Booking;
import ltts.com.model.Login;
import ltts.com.model.Room;


@Repository
public interface MyJPARepository3 extends CrudRepository<Room,Integer>{

	Room save(Booking booking);



	Optional<Room> findByRoomno(int roomno);



	void deleteByRoomno(int roomno);
	
	

}

