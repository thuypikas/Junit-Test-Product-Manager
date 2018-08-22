package entity;

import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="pass")
	private String pass;
	@Column(name="fullname")
	private String fullname;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String pass, String fullname, String email, String phone) {
		super();
		this.username = username;
		this.pass = pass;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
