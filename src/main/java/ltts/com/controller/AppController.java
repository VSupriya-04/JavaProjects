package ltts.com.controller;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ltts.com.model.Booking;
import ltts.com.model.Login;

import ltts.com.model.Room;
import ltts.com.service.HotelService;

@CrossOrigin
@RestController
@RequestMapping("/hotel")
public class AppController {
	@Autowired
	private HotelService service;
	
	@GetMapping("/welcome")	
	public String welcome()
	{
		return "Welcome to first spring web rest application";
	}
	
	@PostMapping("/adduser")
	public boolean adduser(@RequestBody Login log) {
		if(service.addLogin(log.getId(),log.getName(),log.getEmail(),log.getPwd(),log.getAtype())) {
			return true;
		}
		return false;
	}
	
	
	@PostMapping("/addroom")
	public String addRoom(@RequestBody Room room) {
		if(service.addRoom(room.getRoomno(),room.getFloor(),room.getRtype(),room.getCategory(),room.getPrice())) {
			return "user Added SuccessFully";
		}
		return "user Not Added";
	}
	
	
	
	@PostMapping("/bookroom")
	public String addBooking(@RequestBody Booking book) {
		if(service.addBooking(book.getBid(),book.getRoomno(),book.getId(),book.getCheck_in(),book.getCheck_out(),book.getNop(),book.getBookdate(),book.getPrice())) {
			return "user Added SuccessFully";
		}
		return "user Not Added";
	}
	
	
	@GetMapping("/show")
	public List<Room> show()
	{
		return service.show();
	}
	
	
	@DeleteMapping("/delete/{roomno}")
	public String deleteRoom(@PathVariable("roomno") int roomno) {
		if(service.deleteRoom(roomno))
		{
			return "Deleted successfully";
		}
		return "Not found";
	}
	
	
	@DeleteMapping("/deleteBook/{roomno}")
	public String deleteBookRoom(@PathVariable("roomno") int roomno) {
		if(service.deleteBookRoom(roomno))
		{
			return "Deleted successfully";
		}
		return "Not found";
	}
	
	@PostMapping("/login")
    public boolean login(@RequestBody Login u) {
        return service.login(u);
    }
	
	
	
}	

