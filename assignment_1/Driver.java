package assignment_1;

import java.util.Scanner;
import java.lang.System;


public class Driver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// auxiliary variables
		int choice;
		int index = 0;
		int failedAttemps = 0;
		boolean validPassword = false;
		int emptySpace = 0;

		// Part II, 1(a)
		// Display the welcome banner
		System.out.println("***************************************************");
		System.out.println("\tWelcome to Appliance Management Program");
		System.out.println("\tDeveloped by: William de Paula Ferreira");
		System.out.println("***************************************************");
		System.out.println();

		// Part II, 1(b)
		// Define the maximum number of appliance to manage
		System.out.print("Enter the maximum number of appliances: ");
		int maxAppliances = input.nextInt();
		Appliance[] inventory = new Appliance[maxAppliances];

		while (failedAttemps < 3) {

			while (failedAttemps < 3 && validPassword == false) {

				// Part II, 1(c)
				// Display a main menu and keep prompting the user until they enter a number
				// between 1 and 5 inclusive
				do {
					printMainMenuOptions();
					choice = input.nextInt();
				} while (choice < 1 || choice > 6);

				switch (choice) {

				// Part II, 1(d)
				// When option 1 is entered
				case 1:
					validPassword = handlingPassword();
					failedAttemps++;

					if (validPassword == true) {
						failedAttemps = 0;

						System.out.print("How many appliances he/she wants to enter? ");
						int inputAppliances = input.nextInt();

						if (inputAppliances > inventory.length) {
							System.out.println("The maximum remaining places in inventory is " + inventory.length);
						} else if (inputAppliances > (inventory.length - emptySpace))
							System.out.println(
									"The maximum remaining places in inventory is " + (inventory.length - emptySpace));

						else {

							for (int j = 0; j < inventory.length; j++) {
								if (inventory[j] == null)
									emptySpace = j;
								break;
							}

							for (int i = emptySpace; i < inputAppliances + emptySpace; i++) {

								inventory[i] = new Appliance();

								System.out.print("Enter the type of the appliance n." + (i + 1) + " :");
								inventory[i].setType(input.next());

								System.out.print("Enter the brand of the appliance n." + (i + 1) + " :");
								inventory[i].setBrand(input.next());

								System.out.print("Enter the price of the appliance n." + (i + 1) + " :");
								inventory[i].setPrice(input.nextDouble());
							}
							emptySpace++;
						}

						validPassword = false;
						break;

					} else
						break;

					// Part II, 1(e)
					// When option 2 is entered
				case 2:
					boolean itemFound = false;

					validPassword = handlingPassword();

					while (validPassword == true && itemFound == false) {
					
							System.out.print("Enter the serial number of the appliance you wishe to update: ");
							long updateSerialNumber = input.nextLong();

							for (int i = 0; i < inventory.length; i++) {
								if (inventory[i] != null && updateSerialNumber == inventory[i].getSerialNumber()) {
									itemFound = true;
									index = i;
									System.out.println(inventory[i]);
									break;
								}
							} // close for loop
							
							if(itemFound == false) { 
								System.out.println("There is no object with that serial number in inventory");
								System.out.println("What do you want to do?");
								System.out.println("\t 1.Re-enter another serial number");
								System.out.println("\t 2.Quit this operation and go back to the main menu");

								int choseNext = input.nextInt();

								if (choseNext == 1) {
									continue;
								}
								else { 
									validPassword = false;
									break;
								}					
							}
							
					} // close while loop

					boolean quit = false;

					if (validPassword == true && itemFound == true) {

						while (quit == false) {
							printUpdateMenuOptions();
							System.out.print("Enter your choice > ");
							int changeChoice = input.nextInt();
							switch (changeChoice) {
							case 1:
								System.out.print("Enter the new brand: ");
								String brand = input.next();
								inventory[index].setBrand(brand);
								System.out.println(inventory[index]);
								break;

							case 2:
								System.out.print("Enter the new type: ");
								String type = input.next();
								inventory[index].setType(type);
								System.out.println(inventory[index]);
								break;

							case 3:
								System.out.print("Enter the new price: ");
								double price = input.nextDouble();
								inventory[index].setPrice(price);
								System.out.println(inventory[index]);
								break;

							case 4:
								quit = true;
								validPassword = false;
								break;

							} // close switch

						} // close while

						break;
					}
					else
						break; // 
				
					// Part II, 1(f)
					// When option 3 is entered
				case 3:
					System.out.print("Enter a brand name: ");
					String brandName = input.next();
					findApplianceBy(brandName, inventory);
					break;

				// Part II, 1(g)
				// When option 4 is entered
				case 4:
					System.out.print("Enter a value (representing a price): ");
					double price = input.nextDouble();
					findCheaperThan(price, inventory);
					break;

				// Part II, 1(h)
				// When option 5 is entered
				case 5:
					// Closing message
					System.out.println("\n\nThank you for using the Appliance Program!");
					System.exit(0); // end the program

				} // end switch

			} // end while

			if (validPassword == false) {
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				System.exit(0);
			}

		}

	}

	/**
	 * This method display the main menu options
	 */
	public static void printMainMenuOptions() {
		System.out.println("What do you want to do?");
		System.out.println("\t1. Enter new appliances (password required)");
		System.out.println("\t2. Change information of an appliance (password required)");
		System.out.println("\t3. Display all appliances by a specific brand");
		System.out.println("\t4. Display all appliances under a certain price");
		System.out.println("\t5. Quit");

	}

	/**
	 * This method display the submenu options
	 */
	public static void printUpdateMenuOptions() {
		System.out.println("What information would you like to change? ");
		System.out.println("\t1. brand");
		System.out.println("\t2. type");
		System.out.println("\t3. price");
		System.out.println("\t4. Quit");

	}

	/**
	 * This method verify 3 attempts to enter the correct password
	 * 
	 * @return true if the entered password is correct and false otherwise.
	 */
	// Method handlingPassword()
	public static boolean handlingPassword() {

		Scanner input = new Scanner(System.in);
		final String key = "c249";

		for (int i = 0; i < 3; i++) {
			System.out.print("Type your password: ");
			String password = input.next();
			if (password.equals(key) == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method displays the information of all appliances in the inventory with
	 * that entered brand
	 * 
	 * @param brand
	 * @param inventory
	 */
	// Method findAppliancesBy
	public static void findApplianceBy(String brand, Appliance[] inventory) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null && inventory[i].getBrand().equals(brand)) {
				System.out.println(inventory[i]);
				System.out.println();
			}
		}
	}

	/**
	 * This method displays all appliances in the store that have a price smaller
	 * than that entered value
	 * 
	 * @param price
	 * @param inventory
	 */
	public static void findCheaperThan(double price, Appliance[] inventory) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null && inventory[i].getPrice() < price) {
				System.out.println(inventory[i]);
				System.out.println();
			}
		}

	}

}
