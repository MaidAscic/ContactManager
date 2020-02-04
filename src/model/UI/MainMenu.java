package model.UI;

import java.sql.SQLException;
import java.util.ArrayList;

import model.DAO.ContactDAOImplementation;
import model.DAO.UserDAOImplementation;
import model.DTO.Contact;
import model.DTO.User;
import model.main.Main;

public class MainMenu {

	private User currentUser;
	ArrayList<Contact> alc;
	static ContactDAOImplementation accessContacts = new ContactDAOImplementation();
	static UserDAOImplementation accessUsers = new UserDAOImplementation();

	public MainMenu(User currentUser) {
		this.currentUser = currentUser;
	}
	//needs revision
	public void mainMenu() {


		System.out.println("----- PHONEBOOK: " + currentUser.getName() + " -----");
		System.out.println("1. Add new contact");
		System.out.println("2. Edit existing contact");
		System.out.println("3. Delete existing contact");
		System.out.println("4. List all contacts");
		System.out.println("5. Search by name");
		System.out.println("6. Search by surname");
		System.out.println("7. Search by phone number");
		System.out.println("8. Log out");
		System.out.println("9. Delete this user (This action cannot be undone!!)");

		int menu = 0;

		while ((menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7 && menu != 8 && menu!=9 ))
			menu = Main.intInput();
		switch (menu) {
			case 1: {
				addNewContact();
				break;
			}
			case 2: {
				editExistingContact();
				break;
			}
			case 3: {
				deleteExistingContact();
				break;
			}
			case 4: {
				listAllContacts();
				break;
			}
			case 5: {
				searchByName();
				break;
			}
			case 6: {
				searchBySurname();
				break;
			}
			case 7: {
				searchByPhoneNumber();
				break;
			}
			case 8: {
				logOut();
				break;
			}
			case 9:{
				deleteThisUser();
				break;
			}
		}
		mainMenu();
	}

	public void addNewContact() {

		System.out.println("Name: ");
		String name = Main.input.next();

		System.out.println("Surname: ");
		String surname = Main.input.next();

		System.out.println("Phone number: ");
		String phoneNumber = String.valueOf(Main.intInput());

		try {
			accessContacts.addContact(currentUser.getId(), name, surname, phoneNumber);
			System.out.println("New contact has been successfully added!");
		} catch (SQLException e) {
			System.out.println("There was an issue while trying to add new contact!");
		}

//		mainMenu();
	}

	public void editExistingContact() {

		System.out.println("Enter phone number of the contact you want to edit: ");
		String phoneNumberForEditing = String.valueOf(Main.intInput());

		System.out.println("Enter new name: ");
		String newName = Main.input.next();

		System.out.println("Enter new surname: ");
		String newSurname = Main.input.next();

		System.out.println("Enter new phone number: ");
		String newPhoneNumber = String.valueOf(Main.intInput());


		try {
			accessContacts.editContact(currentUser.getId(), newName, newSurname, newPhoneNumber, phoneNumberForEditing);
		} catch (SQLException e) {
			System.out.println("There was an issue while trying to edit contact!");
		}

//		mainMenu();

	}

	public void deleteExistingContact() {

		System.out.println("Enter phone number of the contact you want to delete: ");
		String phoneNumberForDeleting =String.valueOf(Main.intInput());


		try {
			accessContacts.deleteContact(currentUser.getId(), phoneNumberForDeleting);
		} catch (SQLException e) {
			System.out.println("There was an issue while trying to delete contact!");
		}

//		mainMenu();
	}

	public void listAllContacts() {
		try {
			alc = accessContacts.retrieveAllContacts(currentUser.getId());
		} catch (SQLException e) {
			System.out.println("An error occurred");
		}
		for (Contact c : alc )
			System.out.println(c.toString());

//		mainMenu();
	}

	public void searchByName() {
		try {
			alc = accessContacts.retrieveAllContacts(currentUser.getId());
		} catch (SQLException e) {
			System.out.println("An error occurred");
		}
		System.out.println("Name you are searching for: ");
		String nameForSearching = Main.input.next();

		for (Contact c : alc)
			if (c.getName().equals(nameForSearching))
				System.out.println(c.toString());

//		mainMenu();
	}

	public void searchBySurname() {
		try {
			alc = accessContacts.retrieveAllContacts(currentUser.getId());
		} catch (SQLException e) {
			System.out.println("An error occurred");
		}
		System.out.println("Surname you are searching for: ");
		String surnameForSearching = Main.input.next();

		for (Contact c : alc)
			if (c.getSurname().equals(surnameForSearching))
				System.out.println(c.toString());

//		mainMenu();

	}

	public void searchByPhoneNumber() {
		try {
			alc = accessContacts.retrieveAllContacts(currentUser.getId());
		} catch (SQLException e) {
			System.out.println("An error occurred");
		}
		System.out.println("Phone number you are searching for: ");
		String phonenumberForSearching = String.valueOf(Main.intInput());

		for (Contact c : alc)
			if (c.getPhoneNumber().equals(phonenumberForSearching))
				System.out.println(c.toString());

//		mainMenu();
	}

	public void logOut() {
		InitialMenu.initialMenu();
	}

	public void deleteThisUser() {

		try {
			accessUsers.deleteUser(currentUser.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There was an issue while trying to delete user!");
		}

		InitialMenu.initialMenu();
	}
}
