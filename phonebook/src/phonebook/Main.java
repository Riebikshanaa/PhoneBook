package phonebook;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		PhoneBook phoneBook = new PhoneBook();
		while (true) {

			System.out.println("Menu");
			System.out.println("1. Add Contact");
			System.out.println("2. Display all contacts");
			System.out.println("3. Search contact by phone");
			System.out.println("4. Remove contact");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {

			case 1:

				System.out.println("Add a Contact:");
				System.out.print("Enter the First Name: ");
				String firstName = scanner.next();
				System.out.print("Enter the Last Name: ");
				String lastName = scanner.next();
				System.out.print("Enter the Phone No: ");
				long phoneNumber = scanner.nextLong();
				System.out.print("Enter the Email: ");
				String emailId = scanner.next();
				Contact contact = new Contact(firstName, lastName, phoneNumber, emailId);
				phoneBook.addContact(contact);
				break;

			case 2:

				System.out.println("The contacts in the List are:");
				List<Contact> contacts = phoneBook.viewAllContacts();
				for (Contact c : contacts) {
					System.out.println("First Name: " + c.getFirstName());
					System.out.println("Last Name: " + c.getLastName());
					System.out.println("Phone No.: " + c.getPhoneNumber());
					System.out.println("Email: " + c.getEmailId());

				}

				break;

			case 3:

				System.out.print("Enter the Phone number to search contact: ");
				long searchPhoneNumber = scanner.nextLong();
				Contact searchedContact = phoneBook.viewContactGivenPhone(searchPhoneNumber);
				if (searchedContact != null) {
					System.out.println("The contact is:");
					System.out.println("First Name: " + searchedContact.getFirstName());
					System.out.println("Last Name: " + searchedContact.getLastName());
					System.out.println("Phone No.: " + searchedContact.getPhoneNumber());
					System.out.println("Email: " + searchedContact.getEmailId());

				} else {
					System.out.println("Contact not found.");

				}

				break;

			case 4:

				System.out.print("Enter the Phone number to remove: ");
				long removePhoneNumber = scanner.nextLong();
				Contact contactToRemove = phoneBook.viewContactGivenPhone(removePhoneNumber);
				if (contactToRemove != null) {
					System.out.print("Do you want to remove the contact (Y/N): ");
					String confirmation = scanner.next();
					if (confirmation.equalsIgnoreCase("Y")) {
						boolean removed = phoneBook.removeContact(removePhoneNumber);
						if (removed) {
							System.out.println("The contact is successfully deleted.");
						} else {
							System.out.println("Contact removal failed.");

						}

					} else {
						System.out.println("Contact removal canceled.");

					}

				} else {
					System.out.println("Contact not found.");

				}

				break;

			case 5:
				
				System.out.println("Exiting the program...");
				System.exit(0);
				break;

			default:

				System.out.println("Invalid choice. Please try again.");

			}

		}

	}

}

