package fileopeations;

import java.io.File;
import java.io.IOException;
import java.util.*;



public class sortFiles
{
		Scanner sc = new Scanner(System.in); // scan user input
		
		public void SortingFiles() throws IOException, NumberFormatException
		{
			System.out.println("Enter your directory path where you want to sort the files - ");
			String afn = sc.nextLine(); // take user input
			File fd = new File(afn); // create new file instance
//			File fd = new File("D:\\eclipse-Oxy\\Simplilearn\\Phase1_Project1_FileSADS\\FileFolder");
			if(fd.isDirectory()) // check if the given input is a directory or not
			{
				List<String> l = Arrays.asList(fd.list()); // Returns an array of strings as a list
				/*if condition to check any file present or not if yes then list of files pass to collection sort method to sort the files in ascending order*/
				if(fd.list().length>0) 
				{
					Collections.sort(l);
					System.out.println("Sorting the files in ascending Order...\n");
					for(String s:l) // iterate the list
					{
						File f = new File(s); // creating new file instance
						if(f.isFile()) // check only for files 
						System.out.println(f);
					}
				}
				else 
				{
					System.out.println(fd.getName() + " This folder is empty...");
					System.out.println("Please choose option 2 and add some files.\n");
					FileMain.main(null);
				}			
			}
			else 
			{
				System.out.println(fd.getAbsolutePath() + " is not a directory");
				System.out.println("Please Enter correct path and try again..\n");
				SortingFiles();
			}
					
				System.out.println();
				System.out.println("Press 9 to return to the main menu: ");
				int i=0;
				
				/*do while loop to return to the main menu will continue to run till 9 not pressed*/
				do
				{
					try
					{
						i = Integer.parseInt(sc.nextLine());
						if(i==9)
						{
							FileMain.main(null);
						}
						else
						{
							System.out.println("Wrong Input! " +i +" is not a valid number. Press 9 to return-");
						}
					}
					catch(NumberFormatException e) 
					{
						System.out.println(e.getMessage()+ " is not a number. Press number 9 and enter to return-");
					}
				}
				while(i!=9);
		}
}
		