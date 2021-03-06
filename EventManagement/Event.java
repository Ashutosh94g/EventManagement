package EventManagement;

import java.time.LocalDate;
import java.util.HashSet;
// import java.util.Hashtable;

class Event {
	// Main members of the event
	public Person organizer;
	public Person coorganizer;
	public HashSet<Person> members;

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
	public Event(Person organizer, Person coorganizer, HashSet<Person> members, LocalDate firstDateofRegistration,
			LocalDate lastDateofRegistration, LocalDate firstDateofEvent, LocalDate lastDateofEvent, String eventName,
			String eventDescription, String eventPrizeDetails, int eventPricePerPerson, int maxParticipants,
			HashSet<Person> sponsers) {

		// Calling various private methods
		setCastMembers(organizer, coorganizer, members);
		setDateDetails(firstDateofRegistration, lastDateofRegistration, firstDateofEvent, lastDateofEvent);
		setEventDetails(eventName, eventDescription, eventPrizeDetails, eventPricePerPerson, maxParticipants);
		setSponsersDetails(sponsers);
	}

	public Event() {
	}

	// 1: Get the cast details
	protected void setCastMembers(Person organizer, Person coorganizer, HashSet<Person> members) {
		this.organizer = organizer;
		this.coorganizer = coorganizer;
		this.members = members;
	}

	// 2: Get the info about dates
	protected void setDateDetails(LocalDate firstDateofRegistration, LocalDate lastDateofRegistration,
			LocalDate firstDateofEvent, LocalDate lastDateofEvent) {
		this.firstDateofRegistration = firstDateofRegistration;
		this.lastDateofRegistration = lastDateofRegistration;
		this.firstDateofEvent = firstDateofEvent;
		this.lastDateofEvent = lastDateofEvent;
	}

	// 2.2: Convert from String to LocalDate

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

	@Override
	public String toString() {
		System.out.println("------------------------------------------------------------------------");
		System.out.println(eventName + ": " + eventDescription);
		System.out.println("Organized by " + organizer.toString() + " and coorganized by " + coorganizer.toString());
		System.out.println("From " + firstDateofEvent.toString() + " to " + lastDateofEvent.toString());
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Prize details of the event: " + eventPrizeDetails);
		System.out.println("Sponsered by: ");
		for (Person sponser : sponsers) {
			System.out.println(sponser.toString());
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Limited event, only for " + maxParticipants + " people");
		System.out.println("Book Your tickets for just $" + eventPricePerPerson);
		System.out.println("from " + firstDateofRegistration.toString() + " to " + lastDateofRegistration.toString());
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Thanks to the remaining cast for making this event possible: ");
		for (Person member : members) {
			System.out.println(member.toString());
		}
		System.out.println("------------------------------------------------------------------------");
		return super.toString();
	}

}