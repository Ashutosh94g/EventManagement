package EventManagement;

import java.util.Date;
import java.util.Dictionary;

class Event {
	// Main members of the event
	public String organizer;
	public String cooganiser;
	public String[] members;

	// Important dates of the event
	public Date firstDateofRegistration;
	public Date lastDateofRegistration;
	public Date firstDateofEvent;
	public Date lastDateofEvent;

	// Event details
	public String eventName;
	public String eventDescription;
	public String eventPriceDetails;
	public int eventPricePerPerson;
	public int maxParticipants;

	// Other parties that are involved in the event
	public Dictionary<String, Long> sponsers; // include name, number and description of sponser
	public Dictionary<String, Long> participants; // include name and phone number
}