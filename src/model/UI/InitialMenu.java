package model.UI;

import java.sql.SQLException;

import model.BO.LoginProcess;
import model.BO.RegistrationProcess;
import model.main.Main;

public class InitialMenu {
	public static void initialMenu() {
		
		System.out.println("----- PHONEBOOK -----");
		System.out.println("1. LOGIN");
		System.out.println("2. REGISTER");
		
		int menu = Main.intInput();

		while (menu != 1 && menu != 2) {
			menu = Main.intInput();
			System.out.println("Your input is not correct!");
		}

		if (menu == 1)
			try {
				LoginProcess.loginProcess();
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to log you in!");
			}
		else {
			try {
				RegistrationProcess.registerProcess();
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to register you!");
			}
		}
		
	}
	
	
}
