package fileopeations;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class addFile 
{
	Scanner sc = new Scanner(System.in); // scan user input
	
	public void AddingFiles() throws IOException, NumberFormatException
	{
		System.out.println("Enter directory path:");
		String a = sc.nextLine(); // take user input for directory path
		System.out.println("Enter new file name:");
		String af = sc.nextLine(); // take user input for adding a file
		File adfile = new File(a,af);
//		File adfile = new File("D:\\eclipse-Oxy\\Simplilearn\\Phase1_Project1_FileSADS\\FileFolder");
		boolean result;
		
		try 
		{
			result = adfile.createNewFile(); // create a new file
			if(result) // test if successfully created a new file  
			{	
				System.out.println("New File added: " + adfile.getCanonicalPath());
			}
			else 
			{
				System.out.println("File with same name already exist at a location: " + adfile.getCanonicalPath());
				System.out.println("Please try again.. ");
				AddingFiles();
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("A. Press 9 to return to the main menu");
		System.out.println("B. Press 7 to try again or add more files");
		int i=0;
		/*do while loop to return to the main menu or adding more files. Loop will continue to run till 9 not pressed*/
		do
		{
			try
			{
				i = Integer.parseInt(sc.nextLine());
				if(i==9)
				{
					FileMain.main(null);
				}
				else if(i==7)
				{
					AddingFiles();
				}
				else
				{
					System.out.println("Wrong Input! " +i +" is not a valid number. Press 9 to return or 7 to add more files-");
				}
			}
			catch(NumberFormatException e) 
			{
				System.out.println(e.getMessage()+ " is not a number. Press number 9 and enter to return or 7 to add more files-");
			}
		}
		while(i!=9);
	}
}