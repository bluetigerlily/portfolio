package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events{
	


	@Id
	@Column(name = "eventsid", unique = true)
	private int id;
	
	@Column(name="certification")
	private String certification;
	
	@Column(name = "certificationprep")
	private String certificationprep;
	
	@Column(name = "other")
	private String other;
	
	@Column(name = "seminar")
	private String seminar;
	
	@Column(name = "technicaltraining")
	private String technicaltraining;
	
	@Column(name = "universitycourse")
	private String universitycourse;
	
	@Column(name = "eventcost")
	private int eventcost;
	
	@Column(name = "eventlocation")
	private String eventlocation;
	
	@Column(name = "currentdate")
	private int currentdate;
	
	@Column(name = "eventstartdate")
	private int eventstartdate;
	
	@Column(name = "eventenddate")
	private int eventenddate;
	
	@Column(name = "eventdescription")
	private String eventdescription;
	
	@Column(name = "gradingformatpresentation")
	private Boolean gradingformatpresentation;
	
	@Column(name = "gradingformatletterdefault")
	private Boolean gradingformatletterdefault;
	
	@Column(name = "gradingformatlettercustom")
	private Boolean gradingformatlettercustom;
	
	@Column(name = "requestjustification")
	private String requestjustification;
	
	@Column(name = "isurgent")
	private Boolean isurgent; // if there's only 2 weeks before event
	
	@Column(name = "rejectionjustification")
	private String rejectionjustification;
	
	@Column(name = "empsubmitted")
	private Boolean empsubmitted;// did the employee submit the form
	
	@Column(name = "dseapproved")
	private Boolean dseapproved;// did the direct supervisor of the employee approve
	
	@Column(name = "dhapproved")
	private Boolean dhapproved; // did the department head of the employee approve
	
	@Column(name = "bencoapproved")
	private Boolean bencoapproved; // did the benefits coordinator approve
	
	@Column(name = "finalsay")
	private Boolean finalsay; // did the benefits coordinators supervisor approve (if necessary)
	
	@Column(name = "changerequestamount")
	private Boolean changerequestamount; // is a requested amount change needing to be done
	
	@Column(name = "changedamounto")
	private int changedamountto; // What's the new amount
	
	
	public int getId() {
		return id;
	}

	/**
	 * @param userid the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the certification
	 */
	public String getCertification() {
		return certification;
	}

	/**
	 * @param certification the certification to set
	 */
	public void setCertification(String certification) {
		this.certification = certification;
	}

	/**
	 * @return the certificationprep
	 */
	public String getCertificationprep() {
		return certificationprep;
	}

	/**
	 * @param certificationprep the certificationprep to set
	 */
	public void setCertificationprep(String certificationprep) {
		this.certificationprep = certificationprep;
	}

	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @return the seminar
	 */
	public String getSeminar() {
		return seminar;
	}

	/**
	 * @param seminar the seminar to set
	 */
	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}

	/**
	 * @return the technicaltraining
	 */
	public String getTechnicaltraining() {
		return technicaltraining;
	}

	/**
	 * @param technicaltraining the technicaltraining to set
	 */
	public void setTechnicaltraining(String technicaltraining) {
		this.technicaltraining = technicaltraining;
	}

	/**
	 * @return the universitycourse
	 */
	public String getUniversitycourse() {
		return universitycourse;
	}

	/**
	 * @param universitycourse the universitycourse to set
	 */
	public void setUniversitycourse(String universitycourse) {
		this.universitycourse = universitycourse;
	}

	/**
	 * @return the eventcost
	 */
	public int getEventcost() {
		return eventcost;
	}

	/**
	 * @param eventcost the eventcost to set
	 */
	public void setEventcost(int eventcost) {
		this.eventcost = eventcost;
	}

	/**
	 * @return the eventlocation
	 */
	public String getEventlocation() {
		return eventlocation;
	}

	/**
	 * @param eventlocation the eventlocation to set
	 */
	public void setEventlocation(String eventlocation) {
		this.eventlocation = eventlocation;
	}

	/**
	 * @return the currentdate
	 */
	public int getCurrentdate() {
		return currentdate;
	}

	/**
	 * @param currentdate the currentdate to set
	 */
	public void setCurrentdate(int currentdate) {
		this.currentdate = currentdate;
	}

	/**
	 * @return the eventstartdate
	 */
	public int getEventstartdate() {
		return eventstartdate;
	}

	/**
	 * @param eventstartdate the eventstartdate to set
	 */
	public void setEventstartdate(int eventstartdate) {
		this.eventstartdate = eventstartdate;
	}

	/**
	 * @return the eventenddate
	 */
	public int getEventenddate() {
		return eventenddate;
	}

	/**
	 * @param eventenddate the eventenddate to set
	 */
	public void setEventenddate(int eventenddate) {
		this.eventenddate = eventenddate;
	}

	/**
	 * @return the eventdescription
	 */
	public String getEventdescription() {
		return eventdescription;
	}

	/**
	 * @param eventdescription the eventdescription to set
	 */
	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}

	/**
	 * @return the gradingformatpresentation
	 */
	public Boolean getGradingformatpresentation() {
		return gradingformatpresentation;
	}

	/**
	 * @param gradingformatpresentation the gradingformatpresentation to set
	 */
	public void setGradingformatpresentation(Boolean gradingformatpresentation) {
		this.gradingformatpresentation = gradingformatpresentation;
	}

	/**
	 * @return the gradingformatletterdefault
	 */
	public Boolean getGradingformatletterdefault() {
		return gradingformatletterdefault;
	}

	/**
	 * @param gradingformatletterdefault the gradingformatletterdefault to set
	 */
	public void setGradingformatletterdefault(Boolean gradingformatletterdefault) {
		this.gradingformatletterdefault = gradingformatletterdefault;
	}

	/**
	 * @return the gradingformatlettercustom
	 */
	public Boolean getGradingformatlettercustom() {
		return gradingformatlettercustom;
	}

	/**
	 * @param gradingformatlettercustom the gradingformatlettercustom to set
	 */
	public void setGradingformatlettercustom(Boolean gradingformatlettercustom) {
		this.gradingformatlettercustom = gradingformatlettercustom;
	}

	/**
	 * @return the requestjustification
	 */
	public String getRequestjustification() {
		return requestjustification;
	}

	/**
	 * @param requestjustification the requestjustification to set
	 */
	public void setRequestjustification(String requestjustification) {
		this.requestjustification = requestjustification;
	}

	/**
	 * @return the isurgent
	 */
	public Boolean getIsurgent() {
		return isurgent;
	}

	/**
	 * @param isurgent the isurgent to set
	 */
	public void setIsurgent(Boolean isurgent) {
		this.isurgent = isurgent;
	}

	/**
	 * @return the rejectionjustification
	 */
	public String getRejectionjustification() {
		return rejectionjustification;
	}

	/**
	 * @param rejectionjustification the rejectionjustification to set
	 */
	public void setRejectionjustification(String rejectionjustification) {
		this.rejectionjustification = rejectionjustification;
	}

	/**
	 * @return the empsubmitted
	 */
	public Boolean getEmpsubmitted() {
		return empsubmitted;
	}

	/**
	 * @param empsubmitted the empsubmitted to set
	 */
	public void setEmpsubmitted(Boolean empsubmitted) {
		this.empsubmitted = empsubmitted;
	}

	/**
	 * @return the dseapproved
	 */
	public Boolean getDseapproved() {
		return dseapproved;
	}

	/**
	 * @param dseapproved the dseapproved to set
	 */
	public void setDseapproved(Boolean dseapproved) {
		this.dseapproved = dseapproved;
	}

	/**
	 * @return the dhapproved
	 */
	public Boolean getDhapproved() {
		return dhapproved;
	}

	/**
	 * @param dhapproved the dhapproved to set
	 */
	public void setDhapproved(Boolean dhapproved) {
		this.dhapproved = dhapproved;
	}

	/**
	 * @return the bencoapproved
	 */
	public Boolean getBencoapproved() {
		return bencoapproved;
	}

	/**
	 * @param bencoapproved the bencoapproved to set
	 */
	public void setBencoapproved(Boolean bencoapproved) {
		this.bencoapproved = bencoapproved;
	}

	/**
	 * @return the finalsay
	 */
	public Boolean getFinalsay() {
		return finalsay;
	}

	/**
	 * @param finalsay the finalsay to set
	 */
	public void setFinalsay(Boolean finalsay) {
		this.finalsay = finalsay;
	}

	/**
	 * @return the changerequestamount
	 */
	public Boolean getChangerequestamount() {
		return changerequestamount;
	}

	/**
	 * @param changerequestamount the changerequestamount to set
	 */
	public void setChangerequestamount(Boolean changerequestamount) {
		this.changerequestamount = changerequestamount;
	}

	/**
	 * @return the changedamountto
	 */
	public int getChangedamountto() {
		return changedamountto;
	}

	/**
	 * @param changedamountto the changedamountto to set
	 */
	public void setChangedamountto(int changedamountto) {
		this.changedamountto = changedamountto;
	}

	/**
	 * @return the events
	 */
	public User getEvents(User user) {
		return user;
	}
	
	public Events getEvents(Events events) {
		return events;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", certification=" + certification + ", certificationprep=" + certificationprep
				+ ", other=" + other + ", seminar=" + seminar + ", technicaltraining=" + technicaltraining
				+ ", universitycourse=" + universitycourse + ", eventcost=" + eventcost + ", eventlocation="
				+ eventlocation + ", currentdate=" + currentdate + ", eventstartdate=" + eventstartdate
				+ ", eventenddate=" + eventenddate + ", eventdescription=" + eventdescription
				+ ", gradingformatpresentation=" + gradingformatpresentation + ", gradingformatletterdefault="
				+ gradingformatletterdefault + ", gradingformatlettercustom=" + gradingformatlettercustom
				+ ", requestjustification=" + requestjustification + ", isurgent=" + isurgent
				+ ", rejectionjustification=" + rejectionjustification + ", empsubmitted=" + empsubmitted
				+ ", dseapproved=" + dseapproved + ", dhapproved=" + dhapproved + ", bencoapproved=" + bencoapproved
				+ ", finalsay=" + finalsay + ", changerequestamount=" + changerequestamount + ", changedamountto="
				+ changedamountto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bencoapproved == null) ? 0 : bencoapproved.hashCode());
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((certificationprep == null) ? 0 : certificationprep.hashCode());
		result = prime * result + changedamountto;
		result = prime * result + ((changerequestamount == null) ? 0 : changerequestamount.hashCode());
		result = prime * result + currentdate;
		result = prime * result + ((dhapproved == null) ? 0 : dhapproved.hashCode());
		result = prime * result + ((dseapproved == null) ? 0 : dseapproved.hashCode());
		result = prime * result + ((empsubmitted == null) ? 0 : empsubmitted.hashCode());
		result = prime * result + eventcost;
		result = prime * result + ((eventdescription == null) ? 0 : eventdescription.hashCode());
		result = prime * result + eventenddate;
		result = prime * result + ((eventlocation == null) ? 0 : eventlocation.hashCode());
		result = prime * result + eventstartdate;
		result = prime * result + ((finalsay == null) ? 0 : finalsay.hashCode());
		result = prime * result + ((gradingformatlettercustom == null) ? 0 : gradingformatlettercustom.hashCode());
		result = prime * result + ((gradingformatletterdefault == null) ? 0 : gradingformatletterdefault.hashCode());
		result = prime * result + ((gradingformatpresentation == null) ? 0 : gradingformatpresentation.hashCode());
		result = prime * result + id;
		result = prime * result + ((isurgent == null) ? 0 : isurgent.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((rejectionjustification == null) ? 0 : rejectionjustification.hashCode());
		result = prime * result + ((requestjustification == null) ? 0 : requestjustification.hashCode());
		result = prime * result + ((seminar == null) ? 0 : seminar.hashCode());
		result = prime * result + ((technicaltraining == null) ? 0 : technicaltraining.hashCode());
		result = prime * result + ((universitycourse == null) ? 0 : universitycourse.hashCode());
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
		Events other = (Events) obj;
		if (bencoapproved == null) {
			if (other.bencoapproved != null)
				return false;
		} else if (!bencoapproved.equals(other.bencoapproved))
			return false;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (certificationprep == null) {
			if (other.certificationprep != null)
				return false;
		} else if (!certificationprep.equals(other.certificationprep))
			return false;
		if (changedamountto != other.changedamountto)
			return false;
		if (changerequestamount == null) {
			if (other.changerequestamount != null)
				return false;
		} else if (!changerequestamount.equals(other.changerequestamount))
			return false;
		if (currentdate != other.currentdate)
			return false;
		if (dhapproved == null) {
			if (other.dhapproved != null)
				return false;
		} else if (!dhapproved.equals(other.dhapproved))
			return false;
		if (dseapproved == null) {
			if (other.dseapproved != null)
				return false;
		} else if (!dseapproved.equals(other.dseapproved))
			return false;
		if (empsubmitted == null) {
			if (other.empsubmitted != null)
				return false;
		} else if (!empsubmitted.equals(other.empsubmitted))
			return false;
		if (eventcost != other.eventcost)
			return false;
		if (eventdescription == null) {
			if (other.eventdescription != null)
				return false;
		} else if (!eventdescription.equals(other.eventdescription))
			return false;
		if (eventenddate != other.eventenddate)
			return false;
		if (eventlocation == null) {
			if (other.eventlocation != null)
				return false;
		} else if (!eventlocation.equals(other.eventlocation))
			return false;
		if (eventstartdate != other.eventstartdate)
			return false;
		if (finalsay == null) {
			if (other.finalsay != null)
				return false;
		} else if (!finalsay.equals(other.finalsay))
			return false;
		if (gradingformatlettercustom == null) {
			if (other.gradingformatlettercustom != null)
				return false;
		} else if (!gradingformatlettercustom.equals(other.gradingformatlettercustom))
			return false;
		if (gradingformatletterdefault == null) {
			if (other.gradingformatletterdefault != null)
				return false;
		} else if (!gradingformatletterdefault.equals(other.gradingformatletterdefault))
			return false;
		if (gradingformatpresentation == null) {
			if (other.gradingformatpresentation != null)
				return false;
		} else if (!gradingformatpresentation.equals(other.gradingformatpresentation))
			return false;
		if (id != other.id)
			return false;
		if (isurgent == null) {
			if (other.isurgent != null)
				return false;
		} else if (!isurgent.equals(other.isurgent))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (rejectionjustification == null) {
			if (other.rejectionjustification != null)
				return false;
		} else if (!rejectionjustification.equals(other.rejectionjustification))
			return false;
		if (requestjustification == null) {
			if (other.requestjustification != null)
				return false;
		} else if (!requestjustification.equals(other.requestjustification))
			return false;
		if (seminar == null) {
			if (other.seminar != null)
				return false;
		} else if (!seminar.equals(other.seminar))
			return false;
		if (technicaltraining == null) {
			if (other.technicaltraining != null)
				return false;
		} else if (!technicaltraining.equals(other.technicaltraining))
			return false;
		if (universitycourse == null) {
			if (other.universitycourse != null)
				return false;
		} else if (!universitycourse.equals(other.universitycourse))
			return false;
		return true;
	}

	
	public Events(int id, String certification, String certificationprep, String other, String technicaltraining, String universitycourse, int eventcost, String seminar, String eventlocation, int currentdate, int eventstartdate, int eventenddate, String eventdescription, Boolean gradingformatpresentation, Boolean gradingformatletterdefault, Boolean gradingformatlettercustom, String requestjustification, Boolean isurgent, String rejectionjustification, Boolean dhapproved, Boolean bencoapproved, Boolean finalsay, Boolean changerequestamount, int changedamountto, Boolean dseapproved, Boolean empsubmitted) {
		super();
		this.id = id;
		this.certification = certification;
		this.certificationprep = certificationprep;
		this.other = other;
		this.seminar = seminar;
		this.technicaltraining = technicaltraining;
		this.universitycourse = universitycourse;
		this.eventcost = eventcost;
		this.eventlocation = eventlocation;
		this.currentdate = currentdate;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.eventdescription = eventdescription;
		this.gradingformatpresentation = gradingformatpresentation;
		this.gradingformatletterdefault = gradingformatletterdefault;
		this.gradingformatlettercustom = gradingformatlettercustom;
		this.requestjustification = requestjustification;
		this.isurgent = isurgent;
		this.rejectionjustification = rejectionjustification;
		this.empsubmitted = empsubmitted;
		this.dseapproved = dseapproved;
		this.dhapproved = dhapproved;
		this.bencoapproved = bencoapproved;
		this.finalsay = finalsay;
		this.changerequestamount = changerequestamount;
		this.changedamountto = changedamountto;
	}
	public Events() {
	}

	

}
