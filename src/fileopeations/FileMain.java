package fileopeations;

import java.io.*;
import java.util.Scanner;

public class FileMain 
{
	private static Scanner sc;

	public static void main(String[] args) throws IOException, FileNotFoundException, NumberFormatException
	{
		
		sc = new Scanner(System.in); // scan the input
		int option = 0;
		int suboption = 0;
		//creating class objects
		sortFiles sf = new sortFiles(); 
		addFile af = new addFile(); 
		deleteFile df = new deleteFile(); 
		searchFile sef = new searchFile(); 
		
		//Welcome Screen and Menu
		System.out.println("©2020 - Virtual Key Repositories-(VKR) by Manish Kumar Arora\n");
		
			System.out.println("---Main Menu---");
			System.out.println("1. Sort the files in asscending order");
			System.out.println("2. Add, Delete or Search a file");
			System.out.println("3. Close");
			System.out.println("Choose your option between 1 to 3 and press enter: ");
		/*do while loop includes switch statement cases runs till you didn't press option 3 and option 2 includes further sub-switch statements  */ 	
		do 
		{
			try 
			{
				option = Integer.parseInt(sc.nextLine());	// take input from user
			}
			catch(NumberFormatException e) 
			{
			
			}
			switch(option) // pass the user specified input
			{
				case 1:
				System.out.println("You choose an option 1 to sort files.");
				sf.SortingFiles(); // calls the method to sort files
				break;
				
				case 2:
				System.out.println("A. Press 1 to Add a file");
				System.out.println("B. Press 2 to Delete a file");
				System.out.println("C. Press 3 to Search a file");
				suboption = Integer.parseInt(sc.nextLine());
				
				switch(suboption) 
				{
					case 1:
					System.out.println("You choose option 1 to add a file");
					af.AddingFiles(); // calls the method to add a file
					break;
					
					case 2:
					System.out.println("You choose option 2 to delete a file");
					df.DeletingFiles(); // calls the method to delete files
					break;
					
					case 3:
					System.out.println("You choose option 3 to search a file");
					sef.SearchingFile(); // calls the method to search files
					break;
				}
				break;
				
				case 3:
				System.out.println("Thank you for using VKR. Bye-Bye..");
				break;
				
				default:
				System.out.println("Invalid Option! Choose only number between 1 to 3");
				break;
			}
		}
		while(option!=3);
	}
}