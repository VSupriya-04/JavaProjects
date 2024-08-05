package ltts.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
	
	@Id
	int id;
	String name;
	String email;
	String pwd;
	String atype;
	
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", atype=" + atype + "]";
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int id, String name, String email, String pwd, String atype) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.atype = atype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	
	
	}


