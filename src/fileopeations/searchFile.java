package fileopeations;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class searchFile 
{
	private Scanner sc;

	public void SearchingFile() throws IOException, FileNotFoundException
	{
		sc = new Scanner(System.in); // scan the input
		System.out.println("Enter directory path: ");
		String dir = sc.nextLine(); // take user input for directory path
		File dp = new File(dir);    // creates new file instance and passing user given input
	      
	    String contents[] = dp.list(); //creating the list and passing it to array contents
	    System.out.println("List of files in the specified directory:");
	    for(int i=0; i<contents.length; i++) //iterate the array list and print the list of files
	    {	
	    	System.out.println(contents[i]);
	    }
	    System.out.println("Enter File name to search:");
	    String searchfile = sc.nextLine(); //take user input for file name to search
	    int i=0;
	   
	    try
	    {
	    	while(i<=contents.length) //loop runs until all file iterate and finds a match
	    	{
	    		/* check the file name entered matches the file in directory with respect to case sensitivity if yes then print the location and break the loop*/
	    		if(contents[i].equals(searchfile))
	    		{
	    			File f = new File(dir,searchfile);
	    			if(f.isFile()&&f.exists())
	    			{
	    				System.out.println(f.getName()+ " found at location: " +f.getAbsolutePath());
	    				break;
	    			}
	    		}
	    		
	    		i++;
	    	}
	    }
	    catch(Exception e)
	    {
	    	System.out.println("FILE NOT FOUND");	    
	    }
		System.out.println();
		System.out.println("A. Press 9 to return to the main menu");
		System.out.println("B. Press 7 to try again or search more files");
		int k=0;

		/*do while loop to return to the main menu or searching more files. Loop will continue to run till 9 not pressed*/
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
					SearchingFile();
				}
				else
				{
					System.out.println("Wrong Input! " +k +" is not a valid number. Press 9 to return to main menu or 7 to search more-");
				}
			}
			catch(NumberFormatException e) 
			{
				System.out.println(e.getMessage()+ " is not a number. Press number 9 and return to main menu or 7 to search more-");
			}
		}
		while(k!=9);
	}
}