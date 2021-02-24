package com.revature.tables;

public class Events {

	private static String certification;
	private static String certificationprep;
	private static String other;
	private static String seminar;
	private static String technicaltraining;
	private static String universitycourse;
	private static int eventcost;
	private static String eventlocation;
	private static int currentdate;
	private static int eventstartdate;
	private static int eventenddate;
	private static String eventdescription;
	private static Boolean gradingformatpresentation;
	private static Boolean gradingformatletterdefault;
	private static Boolean gradingformatlettercustom;
	private static String requestjustification;
	private static Boolean isurgent;                        //if there's only 2 weeks before event
	private static String rejectionjustification;
	private static Boolean empsubmitted;                  //did the employee submit the form
	private static Boolean dseapproved;                  //did the direct supervisor of the employee approve
	private static Boolean dhapproved;                  //did the department head of the employee approve
	private static Boolean bencoapproved;              //did the benefits coordinator approve
	private static Boolean finalsay;                  //did the benefits coordinators supervisor approve (if necessary)
	private static Boolean changerequestamount;      //is a requested amount change needing to be done 
	private static int changedamountto;             //What's the new amount
	private static String events;
	
	
	public Events(String certification, String certificationprep, String other, String seminar, String technicaltraining,
			String universitycourse, int eventcost, String eventlocation, int currentdate, int eventstartdate, int eventenddate,
			String eventdescription, Boolean gradingformatpresentation, Boolean gradingformatletterdefault, Boolean gradingformatlettercustom,
			String requestjustification, Boolean isurgent, String rejectionjustification, Boolean empsubmitted, Boolean dseapproved,
			Boolean dhapproved, Boolean bencoapproved, Boolean finalsay, Boolean changerequestamount, 
			int changedamountto, String events) {
		
		super();
		Events.certification = certification;
		Events.certificationprep = certificationprep;
		Events.other = other;
		Events.seminar = seminar;
		Events.technicaltraining = technicaltraining;
		Events.universitycourse = universitycourse;
		Events.eventcost = eventcost;
		Events.eventlocation = eventlocation;
		Events.currentdate = currentdate;
		Events.eventstartdate = eventstartdate;
		Events.eventenddate = eventenddate;
		Events.eventdescription = eventdescription;
		Events.gradingformatpresentation = gradingformatpresentation;
		Events.gradingformatletterdefault = gradingformatletterdefault;
		Events.gradingformatlettercustom = gradingformatlettercustom;
		Events.requestjustification = requestjustification;
		Events.isurgent = isurgent;
		Events.rejectionjustification = rejectionjustification;
		Events.empsubmitted = empsubmitted;
		Events.dseapproved = dseapproved;
		Events.dhapproved = dhapproved;
		Events.bencoapproved = bencoapproved;
		Events.finalsay = finalsay;
		Events.changerequestamount = changerequestamount;
		Events.changedamountto = changedamountto;
		Events.events = events;
	
	}



	public static String getCertification() {
		return certification;
	}



	public static void setCertification(String certification) {
		Events.certification = certification;
	}



	public static String getCertificationprep() {
		return certificationprep;
	}



	public static void setCertificationprep(String certificationprep) {
		Events.certificationprep = certificationprep;
	}



	public static String getOther() {
		return other;
	}



	public static void setOther(String other) {
		Events.other = other;
	}



	public static String getSeminar() {
		return seminar;
	}



	public static void setSeminar(String seminar) {
		Events.seminar = seminar;
	}



	public static String getTechnicaltraining() {
		return technicaltraining;
	}



	public static void setTechnicaltraining(String technicaltraining) {
		Events.technicaltraining = technicaltraining;
	}



	public static String getUniversitycourse() {
		return universitycourse;
	}



	public static void setUniversitycourse(String universitycourse) {
		Events.universitycourse = universitycourse;
	}



	public static int getEventcost() {
		return eventcost;
	}



	public static void setEventcost(int eventcost) {
		Events.eventcost = eventcost;
	}



	public static String getEventlocation() {
		return eventlocation;
	}



	public static void setEventlocation(String eventlocation) {
		Events.eventlocation = eventlocation;
	}



	public static int getCurrentdate() {
		return currentdate;
	}



	public static void setCurrentdate(int currentdate) {
		Events.currentdate = currentdate;
	}



	public static int getEventstartdate() {
		return eventstartdate;
	}



	public static void setEventstartdate(int eventstartdate) {
		Events.eventstartdate = eventstartdate;
	}



	public static int getEventenddate() {
		return eventenddate;
	}



	public static void setEventenddate(int eventenddate) {
		Events.eventenddate = eventenddate;
	}



	public static String getEventdescription() {
		return eventdescription;
	}



	public static void setEventdescription(String eventdescription) {
		Events.eventdescription = eventdescription;
	}



	public static Boolean getGradingformatpresentation() {
		return gradingformatpresentation;
	}



	public static void setGradingformatpresentation(Boolean gradingformatpresentation) {
		Events.gradingformatpresentation = gradingformatpresentation;
	}



	public static Boolean getGradingformatletterdefault() {
		return gradingformatletterdefault;
	}



	public static void setGradingformatletterdefault(Boolean gradingformatletterdefault) {
		Events.gradingformatletterdefault = gradingformatletterdefault;
	}



	public static Boolean getGradingformatlettercustom() {
		return gradingformatlettercustom;
	}



	public static void setGradingformatlettercustom(Boolean gradingformatlettercustom) {
		Events.gradingformatlettercustom = gradingformatlettercustom;
	}



	public static String getRequestjustification() {
		return requestjustification;
	}



	public static void setRequestjustification(String requestjustification) {
		Events.requestjustification = requestjustification;
	}



	public static Boolean getIsurgent() {
		return isurgent;
	}



	public static void setIsurgent(Boolean isurgent) {
		Events.isurgent = isurgent;
	}



	public static String getRejectionjustification() {
		return rejectionjustification;
	}



	public static void setRejectionjustification(String rejectionjustification) {
		Events.rejectionjustification = rejectionjustification;
	}



	public static Boolean getEmpsubmitted() {
		return empsubmitted;
	}



	public static void setEmpsubmitted(Boolean empsubmitted) {
		Events.empsubmitted = empsubmitted;
	}



	public static Boolean getDseapproved() {
		return dseapproved;
	}



	public static void setDseapproved(Boolean dseapproved) {
		Events.dseapproved = dseapproved;
	}



	public static Boolean getDhapproved() {
		return dhapproved;
	}



	public static void setDhapproved(Boolean dhapproved) {
		Events.dhapproved = dhapproved;
	}



	public static Boolean getBencoapproved() {
		return bencoapproved;
	}



	public static void setBencoapproved(Boolean bencoapproved) {
		Events.bencoapproved = bencoapproved;
	}



	public static Boolean getFinalsay() {
		return finalsay;
	}



	public static void setFinalsay(Boolean finalsay) {
		Events.finalsay = finalsay;
	}



	public static Boolean getChangerequestamount() {
		return changerequestamount;
	}



	public static void setChangerequestamount(Boolean changerequestamount) {
		Events.changerequestamount = changerequestamount;
	}



	public static int getChangedamountto() {
		return changedamountto;
	}



	public static void setChangedamountto(int changedamountto) {
		Events.changedamountto = changedamountto;
	}



	public static String getEvents() {
		return events;
	}



	public static void setEvents(String events) {
		Events.events = events;
	}
	
	
	
		
		
		
		
		
	
	
	
	}
	
	
	
	
	

