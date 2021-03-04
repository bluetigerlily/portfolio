package com.revature.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table
public class Role{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinTable(name = "role", joinColumns = @JoinColumn(name = "id"))
	
	@Column(name = "employee")
	private String employee;
	
	@Column(name = "directsuperemp")
	private String directsuperemp;
	
	@Column(name = "directsuperbenco")
	private String directsuperbenco;
	
	@Column(name = "departmenthead")
	private String departmenthead;
	
	@Column(name = "benco")
	private String benco;
	
	@Column(name = "role")
	private String role;
	

	public Role() {
		id = 0;
		employee = "";
		directsuperemp = "";
		directsuperbenco = "";
		departmenthead = "";
		benco = "";
		role = "";

	}

	public Role(int id, String employee, String directsuperemp, String directsuperbenco, String departmenthead,
			String benco, String role) {
		super();
		this.id = id;
		this.employee = employee;
		this.directsuperemp = directsuperemp;
		this.directsuperbenco = directsuperbenco;
		this.departmenthead = departmenthead;
		this.benco = benco;
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(benco, departmenthead, directsuperbenco, directsuperemp, employee, role, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		return Objects.equals(benco, other.benco) && Objects.equals(departmenthead, other.departmenthead)
				&& Objects.equals(directsuperbenco, other.directsuperbenco)
				&& Objects.equals(directsuperemp, other.directsuperemp) && Objects.equals(employee, other.employee)
				&& Objects.equals(role, other.role) && id == other.id;
	}

	@Override
	public String toString() {
		return "Role [userid=" + id + ", employee=" + employee + ", directsuperemp=" + directsuperemp
				+ ", directsuperbenco=" + directsuperbenco + ", departmenthead=" + departmenthead + ", benco=" + benco
				+ ", role=" + role + "]";
	}

	/**
	 * @return the userid
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	/**
	 * @return the directsuperemp
	 */
	public String getDirectsuperemp() {
		return directsuperemp;
	}

	/**
	 * @param directsuperemp the directsuperemp to set
	 */
	public void setDirectsuperemp(String directsuperemp) {
		this.directsuperemp = directsuperemp;
	}

	/**
	 * @return the directsuperbenco
	 */
	public String getDirectsuperbenco() {
		return directsuperbenco;
	}

	/**
	 * @param directsuperbenco the directsuperbenco to set
	 */
	public void setDirectsuperbenco(String directsuperbenco) {
		this.directsuperbenco = directsuperbenco;
	}

	/**
	 * @return the departmenthead
	 */
	public String getDepartmenthead() {
		return departmenthead;
	}

	/**
	 * @param departmenthead the departmenthead to set
	 */
	public void setDepartmenthead(String departmenthead) {
		this.departmenthead = departmenthead;
	}

	/**
	 * @return the benco
	 */
	public String getBenco() {
		return benco;
	}

	/**
	 * @param benco the benco to set
	 */
	public void setBenco(String benco) {
		this.benco = benco;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
