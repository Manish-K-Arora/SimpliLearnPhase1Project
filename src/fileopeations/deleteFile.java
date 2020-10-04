package fileopeations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class deleteFile
{
	//Scanner d = new Scanner(System.in); //
	private Scanner sc;
	public void DeletingFiles() throws IOException, FileNotFoundException
	{
		sc = new Scanner(System.in); // take user input for directory path
		System.out.println("Enter directory path: ");
		String dir = sc.nextLine();
		File dp = new File(dir);    // creating new file instance passing user input
		      
		String contents[] = dp.list(); //creating the list and passing it to array contents
		System.out.println("List of files in the specified directory:");
		for(int i=0; i<contents.length; i++) //iterate the array list and print the list of files
		{
			System.out.println(contents[i]);
		}
		System.out.println("\nEnter the name of file you want to delete: ");
		String name = sc.nextLine(); //take user input for file name to delete 
		int i=0;
		try 
		{
			while(i<=contents.length) //loop runs until all file iterate and finds a match
			{	
				/* check the file name entered matches the file in directory with respect to case sensitivity if yes then delete else break the loop*/
				if(contents[i].equals(name)) 
				{
					File f = new File(dir,name); //creating new file instance and passing path and file name to it.
					if(f.delete())
					{
						System.out.println(f.getName()+ " deleted successfully");
						break;
					}
				}
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println("File Not Found ");
		}

					
			System.out.println();
			System.out.println("A. Press 9 to return to the main menu");
			System.out.println("B. Press 7 to try again or delete more files");
			int k=0;

		/*do while loop to return to the main menu or deleting more files. Loop will continue to run till 9 not pressed*/
		do
		{
			try
			{
				k = Integer.parseInt(sc.nextLine());
				if(k==9)
				{
					FileMain.main(null);
				}
				else if(k==7)
				{
					DeletingFiles();
				}
				else
				{
					System.out.println("Wrong Input! " +k +" is not a valid number. Press 9 to return-");
				}
			}
			catch(NumberFormatException e) 
			{
				System.out.println(e.getMessage()+ " is not a number. Press number 9 and enter to return-");
			}
		}
		while(k!=9);
	}
}