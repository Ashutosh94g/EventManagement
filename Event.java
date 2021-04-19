package EventManagement;

import java.time.LocalDate;
import java.util.Dictionary;

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
		getCastMembers(organizer, cooganiser, members);
		getDateDetails(firstDateofRegistration, lastDateofRegistration, firstDateofEvent, lastDateofEvent);
		getEventDetails(eventName, eventDescription, eventPriceDetails, eventPricePerPerson, maxParticipants);
		getParticipantsDetails(sponsers, participants);
	}

	// 1: Get the cast details
	private void getCastMembers(String organizer, String cooganiser, String[] members) {
		this.organizer = organizer;
		this.cooganiser = cooganiser;
		this.members = members.clone();
	}

	// 2: Get the info about dates
	private void getDateDetails(String firstDateofRegistration, String lastDateofRegistration, String firstDateofEvent,
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
	private void getEventDetails(String eventName, String eventDescription, String eventPriceDetails,
			int eventPricePerPerson, int maxParticipants) {
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventPriceDetails = eventPriceDetails;
		this.eventPricePerPerson = eventPricePerPerson;
		this.maxParticipants = maxParticipants;
	}

	// 4: Get the details of sponsers and participants
	private void getParticipantsDetails(Dictionary<String, Long> sponsers, Dictionary<String, Long> participants) {
		this.sponsers = sponsers;
		this.participants = participants;
	}
}