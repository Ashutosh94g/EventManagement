package EventManagement;

import java.util.HashSet;
import java.util.Scanner;

public class EventOrganiser {
	public static void main(String[] args) {
		// Event e = new Event();
		// e.setCastMembers(organizer, coorganizer, members);
	}

	// 1: Get the cast details from Users
	public void setCastMembersFromUser(Event e) {
		Person organizer = getPerson("Organiser's Details: ");
		Person coorganizer = getPerson("coorganizer's Details: ");

		Scanner numberOfCastMembersScanner = new Scanner(System.in);
		System.out.print("Enter the remaining number of members: ");
		int numberOfCastMembers = numberOfCastMembersScanner.nextInt();
		numberOfCastMembersScanner.close();
		Person[] members = new Person[numberOfCastMembers];
		for (int i = 0; i < numberOfCastMembers; i++) {
			members[i] = getPerson("Member number " + (i + 1) + "'s details: ");
		}
		e.setCastMembers(organizer, coorganizer, members);
	}

	protected Person getPerson(String printText) {
		System.out.println(printText);
		Scanner nameScanner = new Scanner(System.in);
		System.out.print("Enter Name				: ");
		String name = nameScanner.nextLine();
		nameScanner.close();
		Scanner phoneScanner = new Scanner(System.in);
		System.out.print("Enter Phone Number: ");
		long phoneNumber = phoneScanner.nextLong();
		phoneScanner.close();

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
		Scanner stringLocalDateScanner = new Scanner(System.in);
		System.out.print(printText);
		String date = stringLocalDateScanner.nextLine();
		stringLocalDateScanner.close();
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
		Scanner eventDetailScanner = new Scanner(System.in);
		System.out.println(printText);
		String eventDetail = eventDetailScanner.nextLine();
		eventDetailScanner.close();
		return eventDetail;
	}

	protected int getEventIntegerDetails(String printText) {
		Scanner eventDetailScanner = new Scanner(System.in);
		System.out.println(printText);
		int eventDetail = eventDetailScanner.nextInt();
		eventDetailScanner.close();
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
		Scanner numberOfSponsersScanner = new Scanner(System.in);
		System.out.println(printText);
		int numberOfSponsors = numberOfSponsersScanner.nextInt();
		numberOfSponsersScanner.close();
		return numberOfSponsors;
	}
	// 4: END

}
