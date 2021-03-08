package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="role")
public class Role{
	
	@Id
	@Column(name = "roleid", unique = true)
	private int id;
	
	
	
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
	
	

	public Role(int id, String employee, String directsuperemp, String directsuperbenco, String departmenthead,
			String benco) {
		super();
		this.id = id;
		this.employee = employee;
		this.directsuperemp = directsuperemp;
		this.directsuperbenco = directsuperbenco;
		this.departmenthead = departmenthead;
		this.benco = benco;
	}



	public Role() {
		// TODO Auto-generated constructor stub
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benco == null) ? 0 : benco.hashCode());
		result = prime * result + ((departmenthead == null) ? 0 : departmenthead.hashCode());
		result = prime * result + ((directsuperbenco == null) ? 0 : directsuperbenco.hashCode());
		result = prime * result + ((directsuperemp == null) ? 0 : directsuperemp.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (benco == null) {
			if (other.benco != null)
				return false;
		} else if (!benco.equals(other.benco))
			return false;
		if (departmenthead == null) {
			if (other.departmenthead != null)
				return false;
		} else if (!departmenthead.equals(other.departmenthead))
			return false;
		if (directsuperbenco == null) {
			if (other.directsuperbenco != null)
				return false;
		} else if (!directsuperbenco.equals(other.directsuperbenco))
			return false;
		if (directsuperemp == null) {
			if (other.directsuperemp != null)
				return false;
		} else if (!directsuperemp.equals(other.directsuperemp))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Role [id=" + id + ", employee=" + employee + ", directsuperemp=" + directsuperemp
				+ ", directsuperbenco=" + directsuperbenco + ", departmenthead=" + departmenthead + ", benco=" + benco
				+ "]";
	}


}
