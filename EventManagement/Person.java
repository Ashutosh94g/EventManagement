package EventManagement;

import java.util.Scanner;

class Person {
	public String name;
	public Long phoneNumber;

	public Person(String name, Long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	static protected Person getPerson(String printText, Scanner scanner) {
		System.out.println(printText);
		System.out.print("Enter Name        : ");
		String name = scanner.nextLine();
		String phoneString;
		// Checking if the phone is a number
		do {
			System.out.print("Enter Phone Number: ");
			phoneString = scanner.nextLine();
		} while (!phoneString.matches("[0-9]+"));
		Long phoneNumber = Long.parseLong(phoneString);
		return new Person(name, phoneNumber);
	}

	@Override
	public String toString() {
		String person = name.substring(0, 1).toUpperCase() + name.substring(1) + ": " + phoneNumber.toString();
		return String.format(person);
	}
}