package com.revature.beans;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String useremail;
	private int fundsavailable;
	private int fundspending;
	private Role role;
	private Events events;
	@Override
	public int hashCode() {
		return Objects.hash(events, firstname, fundsavailable, fundspending, lastname, password, role, useremail,
				userid, username);
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
				&& userid == other.userid && Objects.equals(username, other.username);
	}
	

	
	public User() {
	
		userid =0;
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
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
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
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", useremail=" + useremail + ", fundsavailable="
				+ fundsavailable + ", fundspending=" + fundspending + ", role=" + role + ", events=" + events + "]";
	}
	public User(int userid, String username, String password, String firstname, String lastname, String useremail,
			int fundsavailable, int fundspending, Role role, Events events) {
		super();
		this.userid = userid;
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
	
	

	

	
	
	
	
	
	
	
	

