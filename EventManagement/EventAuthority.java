package EventManagement;

import java.util.Scanner;

public class EventAuthority {
	static Scanner scanner;
	static EventOrganiser eo;
	static Event[] events;
	static Event e;
	static boolean loop = true;

	private EventAuthority() {
	}

	public static void main(String[] args) {
		// Init all the static variables
		eventAuthorityInitiator();

		while (loop) {
			System.out.println("---------------------------------------------------------------------");
			// Print all the option available
			optionsViewer();
			System.out.println("---------------------------------------------------------------------");
			// Input the option for selection
			optionSelector();
		}

	}

	private static void eventAuthorityInitiator() {
		// created a Scanner for user input
		scanner = new Scanner(System.in);

		// Created an Event Organiser
		eo = new EventOrganiser(scanner);

		// Created an array to store the events
		events = new Event[5];

		// Created a temporary event
		e = new Event();
	}

	private static void optionSelector() {
		int num = Integer.parseInt(scanner.nextLine());
		switch (num) {
		case 1:
			viewAllTheEvents();
			break;
		case 2:
			bookAnEvent();
			break;
		case 3:
			registerAnEvent();
			break;
		case 4:
			runTest();
		case 0:
			loop = false;
			System.out.println("---------------------------------------------------------------------");
			break;
		default:
			System.out.println("Please Enter Correctly");
		}
	}

	private static void optionsViewer() {
		System.out.println("Select an option: ");
		System.out.println("1. Show all the Events");
		System.out.println("2. Book an Event");
		System.out.println("3. Register an Event");
		System.out.println("4. Run the tests");
		System.out.println("0. Exit");
	}

	// 1st option
	public static void viewAllTheEvents() {
		for (Event ve : events) {
			if (ve != null) {
				ve.toString();
			} else {
				System.out.println("End of events");
				return;
			}
		}
	}

	// 2nd option
	public static void bookAnEvent() {
	}

	// 3rd option
	public static boolean registerAnEvent() {
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

	// 4th option
	private static void runTest() {
		Test test = new Test();
		test.run();
	}
}
