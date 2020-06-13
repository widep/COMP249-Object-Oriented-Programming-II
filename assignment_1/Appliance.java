package assignment_1;

import assignment_1.Appliance;


public class Appliance {

	//Attributes
	private String type;
	private String brand;
	private long serialNumber;
	private double price;

	//Auxiliary variable to increment serialNumber
	private static int serial = 1000000;
	
	//Auxiliary variable to identify the number of objects
	private static int id = 0;
	
	/**
	 * This is an default constructor (with no arguments) of Appliance
	 */
	public Appliance (){
	type = "Fridge";
	brand = "Bosch";
	price = 1200;
	serialNumber = serial++;
	id++;
	}

	/**
	 * This is a copy constructor of Appliance
	 * @param object object of type Appliance
	 */
	public Appliance (Appliance appliance) {
	type = appliance.getType();
	brand = appliance.getBrand();
	price = appliance.getPrice();
	serialNumber = appliance.getSerialNumber();
	id++;
		
	}
	
	
	
	
	/**
	 * This is a constructor of Appliance with a specified type, brand, and price
	 * @param type the type of the appliance
	 * @param brand the brand of the appliance
	 * @param price the price of the appliance
	 */
	public Appliance (String type, String brand, double price ){
	this.type = type;
	this.brand = brand;
	this.price = price;
	serialNumber = serial++;
	id++;
		}

	/**
	 * Gets appliance type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets appliance type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * Gets appliance brand
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Sets appliance brand
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets appliance serial number
	 * @return serial number
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * Gets appliance price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets appliance price
	 * @param price
	 */
	public void setPrice(double price) {
		if (price >= 1)
			this.price = price;
		else
			this.price = 1;
	}


	/**
	 * This method return the number of created appliance objects
	 * @return the number of created objects
	 */
	//
	public static int findNumberOfCreatedAppliances() {
		return id;
	}
	

	/**
	 * This method compare if two Appliance objects are equal
	 * @param object 
	 * @return true if the two objects are equal, and false otherwise.
	 */
	
	public boolean equals(Appliance appliance) {
		if (brand.equals(appliance.getBrand()) && type.equals(appliance.getType()) && price == appliance.getPrice())
			return true;
		else
			return false;	
	}
	
	
	/**
	 * This method allow all information of an object to be displayed at once
	 */
	public String toString(){
		return "Appliance serial # "+ serialNumber + "\nBrand: " + brand + "\nType: "+type+ "\nPrice: "+price;
	}
	
	
	
	
	
	
	
	
	
	
	
}
