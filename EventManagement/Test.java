package EventManagement;

import java.util.HashSet;
import java.time.LocalDate;

public class Test {
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
	public HashSet<Person> sponsers;

	Test() {
	}

	public void run() {
		Event e = new Event();
		boolean t1 = testCastMembers(e);
		boolean t2 = testDateDetails(e);
		boolean t3 = testEventDetails(e);
		boolean t4 = testSponsersDetails(e);
		if (t1 && t2 && t3 && t4) {
			System.out.println("Test Successful");
			e.toString();
		} else {
			System.out.println("Test Failed");
		}
	}

	public boolean testCastMembers(Event e) {
		try {
			organizer = new Person("Ashutosh Modi", Long.parseLong("7896543210"));
			coorganizer = new Person("Tejasvi Garg", Long.parseLong("9876543210"));
			members = new HashSet<Person>(2);
			members.add(new Person("Guneet Thind", Long.parseLong("8765432190")));
			members.add(new Person("Naman Singla", Long.parseLong("7654321980")));
			e.setCastMembers(organizer, coorganizer, members);
			return true;
		} catch (Exception ex) {
			System.out.println("System test failed: " + ex.getMessage());
			return false;
		}
	}

	public boolean testDateDetails(Event e) {
		try {
			firstDateofRegistration = EventOrganiser.getFormatedLocalDate("02/02/2021");
			lastDateofRegistration = EventOrganiser.getFormatedLocalDate("05/02/2021");
			firstDateofEvent = EventOrganiser.getFormatedLocalDate("15/02/2021");
			lastDateofEvent = EventOrganiser.getFormatedLocalDate("20/02/2021");
			e.setDateDetails(firstDateofRegistration, lastDateofRegistration, firstDateofEvent, lastDateofEvent);
			return true;
		} catch (Exception ex) {
			System.out.println("System test failed: " + ex.getMessage());
			return false;
		}
	}

	public boolean testEventDetails(Event e) {
		try {
			eventName = "Hackathon";
			eventDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris convallis eros nulla, sit amet consequat ligula ornare ut. Cras pretium sem non urna interdum mattis. Donec quis dolor odio. Proin rhoncus elit risus, eget scelerisque quam pulvinar volutpat. Sed lectus nisi, volutpat a eros vel, consectetur viverra purus. Sed suscipit leo orci. Donec et elementum elit, et aliquet tortor. Nunc suscipit gravida ipsum ut tempor. Pellentesque dui nulla, faucibus sit amet neque vitae, vehicula vulputate augue";
			eventPrizeDetails = "Mollit ea ullamco tempor dolor amet consequat non minim esse. Veniam exercitation ipsum culpa amet aliquip fugiat esse culpa non irure labore ea. Ullamco consectetur exercitation officia laboris ad et ut voluptate ea ullamco mollit in ad. Esse exercitation magna sunt velit voluptate occaecat ex irure labore laborum in excepteur ad. Sunt do culpa ullamco tempor laborum commodo veniam pariatur. Cupidatat laborum amet amet magna aute ipsum ad";
			eventPricePerPerson = 20;
			maxParticipants = 25;
			e.setEventDetails(eventName, eventDescription, eventPrizeDetails, eventPricePerPerson, maxParticipants);
			return true;
		} catch (Exception ex) {
			System.out.println("System test failed: " + ex.getMessage());
			return false;
		}
	}

	public boolean testSponsersDetails(Event e) {
		try {
			HashSet<Person> sponsers = new HashSet<Person>(2);
			sponsers.add(new Person("Google", Long.parseLong("2548552558")));
			sponsers.add(new Person("Netflix", Long.parseLong("3578498455")));
			e.setSponsersDetails(sponsers);
			return true;
		} catch (Exception ex) {
			System.out.println("System test failed: " + ex.getMessage());
			return false;
		}
	}
}
