package EventManagement;

import java.util.HashSet;
import java.util.Scanner;

public class EventOrganiser {
	Scanner scanner;

	public static void main(String[] args) {
		Event[] events = new Event[5];
		Event e = new Event();
		EventOrganiser eo = new EventOrganiser();
		bookAnEvent(events, e, eo);
		viewAllTheEvents(events);
	}

	public static boolean bookAnEvent(Event[] events, Event e, EventOrganiser eo) {
		for (int i = 0; i < events.length; i++) {
			if (events[i] == null) {
				eo.setEvent(e);
				System.out.println("Event index in array is " + i);
				events[i] = e;
				return true;
			}
		}
		return false;
	}

	public static void viewAllTheEvents(Event[] events) {
		for (Event ve : events) {
			if (ve != null) {
				ve.toString();
			} else {
				return;
			}
		}
	}

	EventOrganiser() {
		scanner = new Scanner(System.in);
	}

	public Event setEvent(Event e) {
		System.out.println("---------------------------------------------------------------------");
		setCastMembersFromUser(e);
		System.out.println("---------------------------------------------------------------------");
		setDateDetailsFromUser(e);
		System.out.println("---------------------------------------------------------------------");
		setEventDetailsFromUser(e);
		System.out.println("---------------------------------------------------------------------");
		setSponsersDetailsFromUser(e);
		System.out.println("---------------------------------------------------------------------");
		return e;
	}

	// 1: Get the cast details from Users
	public void setCastMembersFromUser(Event e) {
		Person organizer = getPerson("Organiser's Details: ");
		Person coorganizer = getPerson("coorganizer's Details: ");
		System.out.print("Enter the remaining number of members: ");
		int numberOfCastMembers = Integer.parseInt(scanner.nextLine());
		HashSet<Person> members = new HashSet<Person>(numberOfCastMembers);
		for (int i = 0; i < numberOfCastMembers; i++) {
			members.add(getPerson("Member number " + (i + 1) + "'s details: "));
		}
		e.setCastMembers(organizer, coorganizer, members);
	}

	protected Person getPerson(String printText) {
		System.out.println(printText);
		System.out.print("Enter Name        : ");
		String name = scanner.nextLine();
		System.out.print("Enter Phone Number: ");
		Long phoneNumber = Long.parseLong(scanner.nextLine());
		return new Person(name, phoneNumber);
	}
	// 1: END

	// 2: Get the info about dates from Users
	public void setDateDetailsFromUser(Event e) {
		String firstDateofRegistration = getLocalDateinStringFormat("First Date of Registration: ");
		String lastDateofRegistration = getLocalDateinStringFormat("Last Date Of Registration: ");
		String firstDateofEvent = getLocalDateinStringFormat("First Date of Event: ");
		String lastDateofEvent = getLocalDateinStringFormat("Last Date Of Event: ");
		e.setDateDetails(firstDateofRegistration, lastDateofRegistration, firstDateofEvent, lastDateofEvent);
	}

	protected String getLocalDateinStringFormat(String printText) {
		System.out.print(printText);
		String date = scanner.nextLine();
		return date;
	}
	// 2: END

	// 3: Get the details of the event from Users
	public void setEventDetailsFromUser(Event e) {
		String eventName = getEventStringDetails("Name of the event: ");
		String eventDescription = getEventStringDetails("Description of the event: ");
		String eventPrizeDetails = getEventStringDetails("Prize Details of the event: ");
		int eventPricePerPerson = getEventIntegerDetails("Price for each Person: ");
		int maxParticipants = getEventIntegerDetails("Max Number of Participants: ");
		e.setEventDetails(eventName, eventDescription, eventPrizeDetails, eventPricePerPerson, maxParticipants);
	}

	protected String getEventStringDetails(String printText) {
		System.out.print(printText);
		String eventDetail = scanner.nextLine();
		return eventDetail;
	}

	protected int getEventIntegerDetails(String printText) {
		System.out.print(printText);
		int eventDetail = Integer.parseInt(scanner.nextLine());
		return eventDetail;
	}
	// 3: END

	// 4: Get the details of sponsers
	public void setSponsersDetailsFromUser(Event e) {
		int numberOfSponsors = getNumberOfSponsers("Enter Number of sponsers you want to have: ");
		HashSet<Person> sponsers = new HashSet<Person>();
		System.out.println("Sponser's details: ");
		for (int i = 0; i < numberOfSponsors; i++) {
			sponsers.add(getPerson("Sponser number " + (i + 1) + "'s details: "));
		}
		e.setSponsersDetails(sponsers);
	}

	protected int getNumberOfSponsers(String printText) {
		System.out.print(printText);
		int numberOfSponsors = Integer.parseInt(scanner.nextLine());
		return numberOfSponsors;
	}
	// 4: END

}
