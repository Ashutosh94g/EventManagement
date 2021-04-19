package EventManagement;

import java.time.LocalDate;
import java.util.HashSet;
// import java.util.Hashtable;

class Event {
	public boolean isNull = true;
	// Main members of the event
	public Person organizer;
	public Person coorganizer;
	public Person[] members;

	// Important dates of the event
	public LocalDate firstDateofRegistration;
	public LocalDate lastDateofRegistration;
	public LocalDate firstDateofEvent;
	public LocalDate lastDateofEvent;

	// Event details
	public String eventName;
	public String eventDescription;
	public String eventPrizeDetails;
	public int eventPricePerPerson;
	public int maxParticipants;

	// Other parties that are involved in the event
	public HashSet<Person> sponsers; // include name, number and description of sponser
	public HashSet<Person> participants; // include name and phone number

	// Constructor
	public Event(Person organizer, Person coorganizer, Person[] members, String firstDateofRegistration,
			String lastDateofRegistration, String firstDateofEvent, String lastDateofEvent, String eventName,
			String eventDescription, String eventPrizeDetails, int eventPricePerPerson, int maxParticipants,
			HashSet<Person> sponsers) {

		isNull = false;
		// Calling various private methods
		setCastMembers(organizer, coorganizer, members);
		setDateDetails(firstDateofRegistration, lastDateofRegistration, firstDateofEvent, lastDateofEvent);
		setEventDetails(eventName, eventDescription, eventPrizeDetails, eventPricePerPerson, maxParticipants);
		setSponsersDetails(sponsers);
	}

	public Event() {
	}

	// 1: Get the cast details
	protected void setCastMembers(Person organizer, Person coorganizer, Person[] members) {
		this.organizer = organizer;
		this.coorganizer = coorganizer;
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
	protected void setEventDetails(String eventName, String eventDescription, String eventPrizeDetails,
			int eventPricePerPerson, int maxParticipants) {
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventPrizeDetails = eventPrizeDetails;
		this.eventPricePerPerson = eventPricePerPerson;
		this.maxParticipants = maxParticipants;
	}

	// 4: Get the details of sponsers
	protected void setSponsersDetails(HashSet<Person> sponsers) {
		this.sponsers = sponsers;
		participants = new HashSet<Person>();
	}

	// Ticket booking, cancelling and confirm Tickets
	public boolean bookATicket(String name, Long phoneNumber) {
		if ((participants.size() < maxParticipants) && !confirmTicket(name, phoneNumber)) {
			participants.add(new Person(name, phoneNumber));
			return true; // successfully
		}
		return false; // failed
	}

	public boolean confirmTicket(String name, Long phoneNumber) {
		if (participants.contains(new Person(name, phoneNumber))) {
			return true; // already Available
		}
		return false; // not Available
	}

	public boolean cancelTicket(String name, Long phoneNumber) {
		if (confirmTicket(name, phoneNumber)) {
			participants.remove(new Person(name, phoneNumber));
			return true; // successfully Cancelled
		}
		return false; // not Available
	}

}