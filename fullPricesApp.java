//Author: Paul Walker
//Project: Assessment
//Date: 3/1/15

package assessmentProgramver2;

import java.io.BufferedReader;// Import the required utilities
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class assessmentProgramver2 {

	private static int choice;
	private static String combined;
	private static BufferedReader bufRead;
	private static Scanner input;
	
	public static void main(String[] args) {
		
		
		do {// starts the loop
			
			InputStreamReader in = new InputStreamReader(System.in);
			bufRead = new BufferedReader(in);
			input = new Scanner(System.in);
			
			displayMenu();
			
			choice = input.nextInt();
			
			
		if (choice <0){// If 0 is greater than the users input then prevents the user from proceeding until a valid value is entered.
			System.out.println("Invalid Entry, please try again");
			System.out.println("							   ");
			}
	
		if (choice >2){// If a greater number than 2 is entered then prevents the user from proceeding until a valid value is entered.
			System.out.println("Invalid Entry, please try again");
			System.out.println("							   ");
			}
	
		else if (choice == 1){// If 1 is selected then the program will execute switchString
		
			combined = switchString();
			}


			else if (choice == 2){// If 2 is selected then the program will execute expenses
	
			expenses(combined);// while expenses is active, combined's value will be used
			}
		
		
			
		if (choice == 0){// Entering this will terminate the program
		
			System.out.println("0 - Exit");
			System.err.println("Program Terminated by User");
			}
	
	
	
	
	} while (choice != 0) ;

}

	

	private static String fullName, surName;
	private static int space;
	private static char initial;
	
		public static String switchString() {
			
			boolean reTry = true; 
			
			System.out.println("1. Re-arrange name"); // comfirms the users selection
			System.out.println("        ");
			
			
			System.out.println("Enter Full Name: "); // Asks user for input
			try {
			fullName = bufRead.readLine();
			} catch (IOException e) {	
			e.printStackTrace(); }
			
			do{
				try{
					reTry = true; // Retains the initial boolean of reTry to true
					space = fullName.indexOf(" "); // Inputs a space into the middle of the fullName String	
					surName = fullName.substring(space); // Creates the lastName String by halving the fullName String
					initial = fullName.charAt(0); // Sets the initial value to be the first character from the full name
					combined = initial + "" + surName; // Combines the variables of initial and lastName to create the user name
					System.out.println("Your username is " + combined + ""); // Outputs the variable combined
					System.out.println("		");
				} 	
				
			catch(Exception e){// sets the program to display an error message if they enter an invalid entry
				System.err.println("Invalid entry, please enter your first and last name.");
				System.out.println("		");
				while(reTry = false); // sets reTry to false if the user enter an incorrect value
				
			}
			} while(reTry = false); // loops the program until the user enters a correct value
			
			
			return combined; // Returns the username to be used in other sections of the program
				
			
			}
			
			
		public static void displayMenu(){
			
			System.out.println("   		ASSESSMENT PROGRAM		 ");
			System.out.println("  			MENU	 ");
			System.out.println("          ");
			System.out.println("	1 - Re - arrange name");
			System.out.println("          ");
			System.out.println("	2 - Calculate expenses");
			System.out.println("          ");
			System.out.println("	0 - Exit");
			System.out.println("          ");
			System.out.println("	Type in your selected number 0, 1 or 2");
			System.out.println("          ");
			
			
			// All text the user will see to help work their way through the program
			
		}	
		
	private static int engineSize;
	private static float miles, amount, rate;
		
		public static void expenses(String combined){
			
			
			Currency currency = Currency.getInstance(Locale.UK);// Allows the program to collect the local currency (UK)

			System.out.println("2 - Calculate expenses");// Outputs this to confirm the users selection
			System.out.println("        ");
			
			System.out.println("Enter the size of engine:");// Tells the user to enter the size of their engine
			System.out.println("	    ");
			
			
			engineSize = input.nextInt();// Allows user input to be caught in this case only integers	
			System.out.println("Enter miles traveled:");// Asks the user to enter miles travelled
			miles = input.nextFloat();// Catches the users float value
			

		    if (miles < 0) {// if statement to display an error if an invalid number is entered then prompts user to retry
		        System.out.println("Invalid Entry, Please enter a valid mileage");
		        System.out.println("		");
		        System.out.println("Enter miles traveled:\n");
		        miles = input.nextInt();
		    }
			
			rate = calculateRate(engineSize);// Defines rate as what rateValue is depending on the users input
			amount = rate * miles;// Defines amount is the rate multiplied by the miles travelled
			System.out.println("Your Name is:" + combined + " and the engine size is: " + engineSize + " with " + miles + " travelled.");
			// Displays the engine size and miles travelled.
			System.out.println("The rate is " + currency.getSymbol(Locale.UK) + rate + " and the total amount is " + currency.getSymbol(Locale.UK) + amount + "");
			// Displays the calculated rate and amount in the local currency (�) 
			
		}
	
	public static float calculateRate(float engineSize){

		float rateValue = 0; // sets rateValue to 0
		
		if (engineSize < 1100){ // sets rateValue to 0.64 if the users input is lower than 1100
			rateValue = (float) 0.64;	
		}
		if (engineSize <= 2000){ // sets the rateValue to 0.72 if the users input is lower or equal to 2000
			rateValue = (float) 0.72;
		}
		if ((engineSize < 1100) || engineSize > 2000){ // sets the rateValue to 0.79 if the input is either lower than 1100 or greater than 2000
			rateValue = (float) 0.79;
		}
		
		return rateValue; // returns the required value of rateValue to expenses
	
	}

}		
