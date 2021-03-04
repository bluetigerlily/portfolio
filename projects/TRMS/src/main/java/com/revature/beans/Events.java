package com.revature.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Events{
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinTable(name = "events", joinColumns = @JoinColumn(name = ("events")))

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
	
	@Column(name = "events")
	private String events;

	public Events() {

		id = 0;
		certification = "";
		certificationprep = "";
		other = "";
		seminar = "";
		technicaltraining = "";
		universitycourse = "";
		eventcost = 0;
		eventlocation = "";
		currentdate = 0;
		eventstartdate = 0;
		eventenddate = 0;
		eventdescription = "";
		gradingformatpresentation = false;
		gradingformatletterdefault = false;
		gradingformatlettercustom = false;
		requestjustification = "";
		isurgent = false;
		rejectionjustification = "";
		empsubmitted = false;
		dseapproved = false;
		dhapproved = false;
		bencoapproved = false;
		finalsay = false;
		changerequestamount = false;
		changedamountto = 0;
		events = "";

	}

	/**
	 * @return the userid
	 */

	@Override
	public String toString() {
		return "Events [userid=" + id + ", certification=" + certification + ", certificationprep="
				+ certificationprep + ", other=" + other + ", seminar=" + seminar + ", technicaltraining="
				+ technicaltraining + ", universitycourse=" + universitycourse + ", eventcost=" + eventcost
				+ ", eventlocation=" + eventlocation + ", currentdate=" + currentdate + ", eventstartdate="
				+ eventstartdate + ", eventenddate=" + eventenddate + ", eventdescription=" + eventdescription
				+ ", gradingformatpresentation=" + gradingformatpresentation + ", gradingformatletterdefault="
				+ gradingformatletterdefault + ", gradingformatlettercustom=" + gradingformatlettercustom
				+ ", requestjustification=" + requestjustification + ", isurgent=" + isurgent
				+ ", rejectionjustification=" + rejectionjustification + ", empsubmitted=" + empsubmitted
				+ ", dseapproved=" + dseapproved + ", dhapproved=" + dhapproved + ", bencoapproved=" + bencoapproved
				+ ", finalsay=" + finalsay + ", changerequestamount=" + changerequestamount + ", changedamountto="
				+ changedamountto + ", events=" + events + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bencoapproved, certification, certificationprep, changedamountto, changerequestamount,
				currentdate, dhapproved, dseapproved, empsubmitted, eventcost, eventdescription, eventenddate,
				eventlocation, events, eventstartdate, finalsay, gradingformatlettercustom, gradingformatletterdefault,
				gradingformatpresentation, isurgent, other, rejectionjustification, requestjustification, seminar,
				technicaltraining, universitycourse, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Events)) {
			return false;
		}
		Events other = (Events) obj;
		return Objects.equals(bencoapproved, other.bencoapproved) && Objects.equals(certification, other.certification)
				&& Objects.equals(certificationprep, other.certificationprep)
				&& changedamountto == other.changedamountto
				&& Objects.equals(changerequestamount, other.changerequestamount) && currentdate == other.currentdate
				&& Objects.equals(dhapproved, other.dhapproved) && Objects.equals(dseapproved, other.dseapproved)
				&& Objects.equals(empsubmitted, other.empsubmitted) && eventcost == other.eventcost
				&& Objects.equals(eventdescription, other.eventdescription) && eventenddate == other.eventenddate
				&& Objects.equals(eventlocation, other.eventlocation) && Objects.equals(events, other.events)
				&& eventstartdate == other.eventstartdate && Objects.equals(finalsay, other.finalsay)
				&& Objects.equals(gradingformatlettercustom, other.gradingformatlettercustom)
				&& Objects.equals(gradingformatletterdefault, other.gradingformatletterdefault)
				&& Objects.equals(gradingformatpresentation, other.gradingformatpresentation)
				&& Objects.equals(isurgent, other.isurgent) && Objects.equals(this.other, other.other)
				&& Objects.equals(rejectionjustification, other.rejectionjustification)
				&& Objects.equals(requestjustification, other.requestjustification)
				&& Objects.equals(seminar, other.seminar) && Objects.equals(technicaltraining, other.technicaltraining)
				&& Objects.equals(universitycourse, other.universitycourse) && id == other.id;
	}

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

	/**
	 * @param events the events to set
	 */
	public void setEvents(String events) {
		this.events = events;
	}

}
