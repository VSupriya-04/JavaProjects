package ltts.com.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue
	int bid;
	int roomno;
	int id;
	Date check_in;
	Date check_out;
	int nop;
	Date bookdate;
	Double price;
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bid, int roomno, int id, Date check_in, Date check_out, int nop, Date bookdate, Double price) {
		super();
		this.bid = bid;
		this.roomno = roomno;
		this.id = id;
		this.check_in = check_in;
		this.check_out = check_out;
		this.nop = nop;
		this.bookdate = bookdate;
		this.price = price;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}
	public Date getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}
	public int getNop() {
		return nop;
	}
	public void setNop(int nop) {
		this.nop = nop;
	}
	public Date getBookdate() {
		return bookdate;
	}
	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
}
