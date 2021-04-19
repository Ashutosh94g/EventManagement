package EventManagement;

import java.time.LocalDate;
import java.util.Dictionary;
import java.util.Hashtable;

class Event {
	// Main members of the event
	public String organizer;
	public String cooganiser;
	public String[] members;

	// Important dates of the event
	public LocalDate firstDateofRegistration;
	public LocalDate lastDateofRegistration;
	public LocalDate firstDateofEvent;
	public LocalDate lastDateofEvent;

	// Event details
	public String eventName;
	public String eventDescription;
	public String eventPriceDetails;
	public int eventPricePerPerson;
	public int maxParticipants;

	// Other parties that are involved in the event
	public Dictionary<String, Long> sponsers; // include name, number and description of sponser
	public Dictionary<String, Long> participants; // include name and phone number

	// Constructor
	public Event(String organizer, String cooganiser, String[] members, String firstDateofRegistration,
			String lastDateofRegistration, String firstDateofEvent, String lastDateofEvent, String eventName,
			String eventDescription, String eventPriceDetails, int eventPricePerPerson, int maxParticipants,
			Dictionary<String, Long> sponsers, Dictionary<String, Long> participants) {

		// Calling various private methods
		setCastMembers(organizer, cooganiser, members);
		setDateDetails(firstDateofRegistration, lastDateofRegistration, firstDateofEvent, lastDateofEvent);
		setEventDetails(eventName, eventDescription, eventPriceDetails, eventPricePerPerson, maxParticipants);
		setParticipantsDetails(sponsers, participants);
	}

	public Event() {
	}

	// 1: Get the cast details
	protected void setCastMembers(String organizer, String cooganiser, String[] members) {
		this.organizer = organizer;
		this.cooganiser = cooganiser;
		this.members = members.clone();
	}

	// 2: Get the info about dates
	protected void setDateDetails(String firstDateofRegistration, String lastDateofRegistration, String firstDateofEvent,
			String lastDateofEvent) {
		this.firstDateofRegistration = getFormatedLocalDate(firstDateofRegistration);
		this.lastDateofRegistration = getFormatedLocalDate(lastDateofRegistration);
		this.firstDateofEvent = getFormatedLocalDate(firstDateofEvent);
		this.lastDateofEvent = getFormatedLocalDate(lastDateofEvent);
	}

	// 2.2: Convert from String to LocalDate
	private LocalDate getFormatedLocalDate(String date) {
		String[] dmy = date.split("/"); // day month year
		return LocalDate.of(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1]), Integer.parseInt(dmy[0]));
	}

	// 3: Get the details of the event
	protected void setEventDetails(String eventName, String eventDescription, String eventPriceDetails,
			int eventPricePerPerson, int maxParticipants) {
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventPriceDetails = eventPriceDetails;
		this.eventPricePerPerson = eventPricePerPerson;
		this.maxParticipants = maxParticipants;
	}

	// 4: Get the details of sponsers and participants
	protected void setParticipantsDetails(Dictionary<String, Long> sponsers, Dictionary<String, Long> participants) {
		this.sponsers = sponsers;
		this.participants = participants;
	}

	protected void setParticipantsDetails(Dictionary<String, Long> sponsers) {
		this.sponsers = sponsers;
		participants = new Hashtable<String, Long>();
	}

	// Ticket booking, cancelling and confirm Tickets
	public boolean bookATicket(String name, long phoneNumber) {
		if ((participants.size() < maxParticipants) && !confirmTicket(name, phoneNumber)) {
			participants.put(name, phoneNumber);
			return true; // successfully
		}
		return false; // failed
	}

	public boolean confirmTicket(String name, long phoneNumber) {
		if (participants.get(name) == phoneNumber) {
			return true; // already Available
		}
		return false; // not Available
	}

	public boolean cancelTicket(String name, long phoneNumber) {
		if (confirmTicket(name, phoneNumber)) {
			return true; // successfully Cancelled
		}
		return false; // not Available
	}
}