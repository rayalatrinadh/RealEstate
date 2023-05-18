package com.cs425.web.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RealEstateApplication {
	SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String args[]) throws SQLException {
		System.out.println("Menu");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("1.User (as Agent) Registration\n" + "2.User (as Renter) Registration\n" + "3.Add Property\n"
				+ "4.Edit Property(Agent only)\n" + "5.Search for Property\n"
				+ "6.Book Property(Renter only)\n" + "7.Register card Details\n" + "8.Edit card Details\n"
				+ "9.View Property\n" + "10.View User Information\n" + "11.view Renter Information\n"
				+ "12.view Agent Information\n"
				+ "13.view Booking Details\n"
				+"Enter 0 to exit application\n");

		System.out.println("Please choose option from menu : ");
		int userInput = input.nextInt();
		
		while(userInput != 0) {
			

		switch (userInput) {

		case 0:
			System.out.println("Thank you for using the application.");
			break;

		case 1:
			//-------------------------------------> user registration details;
			String email = null;
			String userId = null;
			String jobTitle = null;
			String agencyName = null;
			String phoneNumber01 = null;
			String phoneNumber02 = null;
			String agentName = null;

			System.out.println("Enter agent email : ");
			email = input.next() + input.nextLine();
			System.out.println("Enter userID : ");
			userId = input.next()+ input.nextLine();
			System.out.println("Enter jobtitle : ");
			jobTitle = input.next()+ input.nextLine();
			System.out.println("Enter agencyName : ");
			agencyName = input.next()+ input.nextLine();
			System.out.println("Enter primaryPhoneNumber : ");
			phoneNumber01 = input.next()+ input.nextLine();
			System.out.println("Enter secondaryPhoneNumber : ");
			phoneNumber02 = input.next()+ input.nextLine();
			System.out.println("Enter agentName : ");
			agentName = input.next()+ input.nextLine();

			AgentRegistrationDao.agentRegistration(email, userId, jobTitle, agencyName, phoneNumber01, phoneNumber02,
					agentName);
			break;
			
			
			
		case 2:
			//--------------------------> renter registration details.
			String renterEmail = null;
			String userID = null;
		    Date moveindate = null;
			String location = null;
			int budget = 0;
			int rewards = 0;
			String renterName = null;
			
			
			System.out.println("Enter renter email : ");
			renterEmail = input.next() + input.nextLine();
			System.out.println("Enter userID : ");
			userID = input.nextLine();
			System.out.println("userID :" + userID);
			
			System.out.println("Enter moveInDate in the format yyyy-MM-dd:");
				String dateString = input.nextLine();
	
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        try {
		            java.util.Date utilDate = dateFormat.parse(dateString);
		            moveindate = new java.sql.Date(utilDate.getTime());
		            System.out.println("The move-in date is: " + moveindate);
		        } catch (ParseException e) {
		            System.out.println("Invalid date format");
		        }
			
			
			System.out.println("Enter location ");
			location = input.next()+ input.nextLine();
			System.out.println("Enter budget : ");
			budget = input.nextInt();
			System.out.println("Enter rewards : ");
			rewards = input.nextInt();
			System.out.println("Enter renterName : ");
			renterName = input.next()+ input.nextLine();
			 
			RenterRegistration.renterRegistration(renterEmail, userID, moveindate, location, budget,  rewards, renterName);
			break;
			
		case 3:
			//------------------------------------->> property registration
			System.out.println("Please select property type : ");
			System.out.println("1 House\n"
					+"2 Apartment\n"
					+"3 Commercial\n");
			int propertyType = input.nextInt();
			
			switch(propertyType) {
			
			case 1:
				//---------------------------------------> House
				long propertyID = 00L;
				int noOfRooms = 0;
				int SquareFoot = 0;
				String Address = null;
				boolean Availability = false;
				String HouseLocation = null;
				String HouseType = null;
				int crimeRate = 0;
				boolean nearBySchools = false;
				String Neighbourhood = null;
				String city = null;
				String Street = null;
				String State = null;
				int Zipcode = 0;
				
				
				System.out.println("Long -> Enter propertyID : " );
				propertyID = input.nextLong();
				System.out.println("propertyID : " + propertyID);
				System.out.println("Int -> Enter noOfRooms : ");
				noOfRooms = input.nextInt();
				System.out.println("Int -> Enter squareFoot : ");
				SquareFoot = input.nextInt();
				System.out.println("String -> Enter Address : ");
				Address = input.next();
				System.out.println("Boolean -> Enter Availability : ");
				Availability = input.nextBoolean();
				System.out.println("String -> Enter HouseLocation : ");
				HouseLocation = input.next();
				System.out.println("String -> Enter HouseType : ");
				HouseType = input.next();
				System.out.println("int -> Enter crimeRate : ");
				crimeRate = input.nextInt();
				System.out.println("Boolean -> Enter nearBySchools : ");
				nearBySchools = input.nextBoolean();
				
				System.out.println("String -> Enter neighbourhood : " );
				Neighbourhood = input.next();
				
				System.out.println("String -> Enter city : ");
				city = input.next();
				System.out.println("String -> Enter Street : ");
				Street = input.next();
				System.out.println("String -> Enter State : ");
				State = input.next();
				System.out.println("int -> Enter zipcod : ");
				Zipcode = input.nextInt();

				PropertyTypeDao.propertyHouseInsertion( propertyID, noOfRooms, SquareFoot,
						 Address, Availability, HouseLocation, HouseType,
						 crimeRate, nearBySchools, Neighbourhood, city,
						 Street, State, Zipcode);
				
			  break;
			
			}
			break;
			
		case 6:
			long BookingID = 0;
			String UserID_R = null;
			String UserID_Agnt = null;
			long CCID = 0;
			long PropertyID = 0;
			Date Start_Date = null;
			Date End_Date = null;
			
			System.out.println("long -> Please Enter BookingID : ");
			BookingID = input.nextLong();
			System.out.println("String -> Please Enter renterUserID : ");
			UserID_R = input.next();
			System.out.println("String -> Please Enter agentUserID : ");
			UserID_Agnt = input.next();
			System.out.println("long -> Please Enter CCID : ");
			CCID = input.nextLong();
			System.out.println("long -> Please Enter propertyID : ");
			PropertyID = input.nextLong();
			
			
			System.out.println("Enter Start_Date in the format yyyy-MM-dd:");
			String dateString2 = input.next();

			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            java.util.Date utilDate = dateFormat2.parse(dateString2);
	            Start_Date = new java.sql.Date(utilDate.getTime());
	        } catch (ParseException e) {
	            System.out.println("Invalid date format");
	        }
		
			
	        System.out.println("Enter End_Date in the format yyyy-MM-dd:");
			String dateString3 = input.next();

			SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            java.util.Date utilDate = dateFormat3.parse(dateString3);
	            End_Date = new java.sql.Date(utilDate.getTime());
	        } catch (ParseException e) {
	            System.out.println("Invalid date format");
	        }
	        
	        
	        
	        
			BookingDao.insertBookingDetails(BookingID, UserID_R, UserID_Agnt, CCID,PropertyID, Start_Date, End_Date);
			
			
			
			break;
			
		case 7:
			int cardUserID = 0;
			int ccID = 0;
			int addressID = 0;
			
			System.out.println("int -> Enter userID : ");
			cardUserID = input.nextInt();
			System.out.println("int -> Enter ccID : " );
			ccID = input.nextInt();
			System.out.println("int -> Enter addressID : ");
			addressID = input.nextInt();
			CreditCardDetailsDao.creditCardInsertDetails( cardUserID, ccID, addressID);
			
			break;
			
		case 8:
			int cardAddressID = 0;
			int cardCcID = 0;
			System.out.println("update/edit/Modify AddressID where ccid = ?");
			System.out.println("Please Enter AddressID : ");
			cardAddressID = input.nextInt();
			System.out.println("Please Enter CCID : ");
			cardCcID = input.nextInt();
			CreditCardDetailsDao.creditCardUpdateDetails(cardAddressID,cardCcID);
			
			
			
			break;
		case 9:
			//-----------------------> view Property
			 
			break;
		case 10:
			//view user information;
			UserDetailsFetchDao.userDetailsFetch();
			break;
			
		case 11:
			RenterRegistration.renterDetailsFetch();
			break;
		case 12:
			AgentRegistrationDao.agentDetailsFetch();
			break;
		case 13:
			BookingDao.viewBookingDetails();
			
			break;
			
		default :
				 System.out.println("Please Enter options listed in the Menu");
				 break;
		}
		
		System.out.println("Please choose option from menu : ");
		System.out.println("1.User (as Agent) Registration\n" + "2.User (as Renter) Registration\n" + "3.Add Property\n"
				+ "4.Edit Property(Agent only)\n" + "5.Search for Property\n"
				+ "6.Book Property(Renter only)\n" + "7.Register card Details\n" + "8.Edit card Details\n"
				+ "9.View Property\n" + "10.View User Information\n" + "11.view Renter Information\n"
				+ "12.view Agent Information\n"
				+ "13.view Booking Details\n"
				+ "Enter 0 to exit application\n");
		 userInput = input.nextInt();
		
		}
		System.out.println("Thank you for using the application.");
		
	}

}
