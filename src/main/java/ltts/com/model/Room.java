package ltts.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
	
	@Id
	int roomno;
	int floor;
	String rtype;
	String category;
	Double price;
	
	
	@Override
	public String toString() {
		return "Room [roomno=" + roomno + ", floor=" + floor + ", rtype=" + rtype + ", category=" + category
				+ ", price=" + price + "]";
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int roomno, int floor, String rtype, String category, Double price) {
		super();
		this.roomno = roomno;
		this.floor = floor;
		this.rtype = rtype;
		this.category = category;
		this.price = price;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
