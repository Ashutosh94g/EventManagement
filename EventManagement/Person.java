package EventManagement;

class Person {
	public String name;
	public Long phoneNumber;

	public Person(String name, Long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		String person = name.substring(0, 1).toUpperCase() + name.substring(1) + ": " + phoneNumber.toString();
		return String.format(person);
	}
}