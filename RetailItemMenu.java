
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//Peter McLane 05/17/21
//This program will allow us to be able to modify a retail item list from a menu like input 
public class RetailItemMenu {
	//Making scanner static so we can use it wherever we need 
		static Scanner keyboard;
	public static void main(String[] args) {
		//Array list that will store data needed for file
		ArrayList<RetailItem> RetailItemMembers = new ArrayList<RetailItem>();
		displayMenu();
	}
		
	public static void displayMenu(){
		//Here we print out the menu options to select
		System.out.println("MENU: ");
		System.out.println("\t1. Display All Retail Items.");
		System.out.println("\t2. Display a Specific Retail Item.");
		System.out.println("\t3. Remove Retail Item Units.");
		System.out.println("\t4. Add Retail Item Units.");
		System.out.println("\t5. Change retail items price.");
		System.out.println("\t6. Change retail items description.");
		System.out.println("\t7. Exit");
		
	}
	
	public static int getMenuSelection() {
		System.out.print("Menu Choice: ");
		return keyboard.nextInt();
		
		}
	public static void executeSelectedMenuItem(int menuItemSelected, ArrayList<RetailItem> RetailItemMembers) throws IOException {
		//Based on what the user selects each option will perform a different command
		if(menuItemSelected == 1) {
			displayAllItems(RetailItemMembers);
			
		} else if (menuItemSelected == 2) {
			displaySpecificItem(RetailItemMembers);
			
		} else if (menuItemSelected == 3) {
			removeallItemUnits(RetailItemMembers);
			
		} else if (menuItemSelected == 4) {
			addRetailItemUnits(RetailItemMembers);
			
		} else if (menuItemSelected == 5) {
			changeItemPrice(RetailItemMembers);
			
		} else if (menuItemSelected == 6) {
			changeItemDescription(RetailItemMembers);
			
		} else if (menuItemSelected == 7) {
			System.out.println("Saving Changes.....");
			saveDataToFile(RetailItemMembers);
			System.out.println("Exiting.....");
			
		} else {
			//In case the user enters a invalid selection we make them try again
			System.out.println("Invaild Selection Please try again.");
			
		}
	}

//This method will save the new data to file
	public static void saveDataToFile(ArrayList<RetailItem> retailItemMembers) {
		PrintWriter w = new PrintWriter("newRetailItemDatabase.txt");
    	for(int i = 0; i < RetailItemMembers.size(); i++)
    	{
			RetaiItemMembers.get(i).writeData(w);
    	}
    	w.close();

	}
	//This method will allow us to change an items description
	private static void changeItemDescription(ArrayList<RetailItem> retailItemMembers) {
		System.out.println("Which item would you like to change the description for?");
		String changeItem = keyboard.nextLine();
		if(changeItem.contentEquals("")) {
			System.out.println("Please enter the item you want to change the description for.");
		}
		String newDescription = keyboard.nextLine();
		System.out.println("Please enter the new description for" + changeItem);
		System.out.println("the new description is: " + newDescription);
		
	}
//This method will allow us to change a items price
	private static void changeItemPrice(ArrayList<RetailItem> retailItemMembers) {
		System.out.println("Please enter the items price you want to change: ");
		String changePrice = keyboard.nextLine();
		if(changePrice.contentEquals("")) {
			System.out.println("Please enter the item you want to change the price for.");
		}
		System.out.println("What would you like to change (changePrice) to?");
		double newPrice = keyboard.nextDouble();
		System.out.println("The new price is: "+ newPrice);
	}
//This method will allow us to add a unit to the item
	public static void addRetailItemUnits(ArrayList<RetailItem> retailItemMembers) {
		System.out.println("Please enter then name of the Item you would like to add: ");
		String addedItem = keyboard.nextLine();
		if(addedItem.contentEquals("")) {
			System.out.println("Please enter the item you want to add");
		}
		System.out.println(addedItem + "has been added");
	}
//This method will allow us to remove all units 
	public static void removeallItemUnits(ArrayList<RetailItem> retailItemMembers) {
		System.out.println("What retail item unit would you like to remove?");
		String removeAnswer = keyboard.nextLine();
		if(removeAnswer.equals("")){
			System.out.println("Please retype the item you want to remove.");
		}
		System.out.println(removeAnswer + "has been removed");
		
	}
//This method will allow us to display a specific item from the list
	public static void displaySpecificItem(ArrayList<RetailItem> retailItemMembers) {
		System.out.println("Please type in the name of the item you wish to display: ");
		String specificItem = keyboard.nextLine();
		if(specificItem.equals("")){
			System.out.println("Please retype the item you want to display.");
		System.out.println(specificItem);
		
		}
		
	}	
	//this method will display all items 
	public static void displayAllItems(ArrayList<RetailItem> retailItemMembers) {
		System.out.println(RetailItemMembers);
		
	}
	
	
}




