package com.revature.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "useremail")
	private String useremail;
	
	@Column(name="fundsavailable")
	private int fundsavailable;
	
	@Column(name = "fundspending")
	private int fundspending;
	
	@Column(name = "role")
	private Role role;
	
	@Column(name = "events")
	private Events events;

	@Override
	public int hashCode() {
		return Objects.hash(events, firstname, fundsavailable, fundspending, lastname, password, role, useremail,
				id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(events, other.events) && Objects.equals(firstname, other.firstname)
				&& fundsavailable == other.fundsavailable && fundspending == other.fundspending
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(useremail, other.useremail)
				&& id == other.id && Objects.equals(username, other.username);
	}

	public User() {

		id = 0;
		username = "";
		password = "";
		firstname = "";
		lastname = "";
		useremail = "";
		fundsavailable = 0;
		fundspending = 0;
		role = new Role();
		events = new Events();

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the useremail
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * @param useremail the useremail to set
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * @return the fundsavailable
	 */
	public int getFundsavailable() {
		return fundsavailable;
	}

	/**
	 * @param fundsavailable the fundsavailable to set
	 */
	public void setFundsavailable(int fundsavailable) {
		this.fundsavailable = fundsavailable;
	}

	/**
	 * @return the fundspending
	 */
	public int getFundspending() {
		return fundspending;
	}

	/**
	 * @param fundspending the fundspending to set
	 */
	public void setFundspending(int fundspending) {
		this.fundspending = fundspending;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the events
	 */
	public Events getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(Events events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", useremail=" + useremail + ", fundsavailable="
				+ fundsavailable + ", fundspending=" + fundspending + ", role=" + role + ", events=" + events + "]";
	}

	public User(int id, String username, String password, String firstname, String lastname, String useremail,
			int fundsavailable, int fundspending, Role role, Events events) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.fundsavailable = fundsavailable;
		this.fundspending = fundspending;
		this.role = role;
		this.events = events;
	}

	

	


		
	

	
		
		
	

	

}
