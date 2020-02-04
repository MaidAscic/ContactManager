package model.DTO;

import java.util.ArrayList;

public class User {

	private Integer id;
	private String name;
	private String surname;
	private String password;

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}

	private ArrayList<Contact> contacts = new ArrayList<>();
	public User() {
		
	}
	
	public User (Integer id, String name, String surname, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return (this.id + ". " + this.name + " " + this.surname);
	}
	
	
}
