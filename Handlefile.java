package com.Lockedme;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Handlefile implements Initial_Screens  {
	private int n;
	private int flag=0;
	
	public void welcomeScreen() {
		System.out.println("Welcome its Lockedme.com");
		System.out.println("Its Azhar's Project");
		firstscreen();
	}
	public void firstscreen() {
		System.out.println("Please select the below option");
		System.out.println("*********************************");
		System.out.println("Option 1: Please press 1 to dispaly all the files ");
		System.out.println("Option 2: Please press 2 to go the displaymenu");
		System.out.println("Option 3: Please press 3 to exit");
		
		
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Please enter the options accordingly");
			n=sc.nextInt();
			
		     }
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please provide correct input");
				flag=1;
				firstscreen();
			}
		
			if (n == 1) {
				listdisplay();
				firstscreen();

			} else if (n == 2) {
				displaymenu();

			}else if(n==3) {
				System.exit(n);
			}
			else if (flag==0) {
				System.out.println("Please provide the correct input");
				firstscreen();
			}
		
		}

	
	public void listdisplay() {
		System.out.println("Displaying all the files in the current working directory");
		System.out.println("*****************************************");
		// taking the input from the user.
		String currentPath = null;
		try {
			currentPath = new java.io.File(".").getCanonicalPath();// getting the current working directory
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathname = currentPath;
		String pathname1 = pathname.replace("\\", "\\\\");//

		try {
			File f = new File(pathname1);
			String[] files2 = f.list();
			for (String string : files2) {
				System.out.println(string);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		

	}
	
	

	public void displaymenu() {
		System.out.println("*********");
		System.out.println("Option 2");
		System.out.println("*********");
		System.out.println("MENU :-");
		System.out.println("*******");
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. Search");
		System.out.println("4. Exit");
		System.out.println("5. Return to Main Menu");
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the option accordingly");
			n=sc.nextInt();
			
		     }
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please provide correct input");
			}
		
		switch (n) {
		case 1: {
			System.out.println("You have selected the option to add the file");
			add();
			break;

		}

		case 2: {
			int l = 0;
			System.out.println("You have selected the option to delete the file");
			System.out.println(
					"Are you sure you want to delete press 1 to confirm or press 2 to go back to the main menu");
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("Please enter the option accordingly");
				l=sc.nextInt();
				
			     }
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please provide correct input");
					displaymenu();
				};
				

			
			if (l == 1) {
				delete();
			} else {
				displaymenu();
			}

			break;

		}
		case 3: {
			System.out.println("You have selected the option to  search  the file");
			search();
			break;

		}
		case 4: {
			int n = 0;
			System.out.print("You have selected the option to exit !");
			System.out.println(
					"Are you sure you want to exit !! press 1 to confirm press  or press 2 go back to main menu");
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("Please enter the option accordingly");
				n=sc.nextInt();
				
			     }
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please provide correct input");
					displaymenu();
				}
			if (n == 1) {
				exit();
			} else {
				displaymenu();
			}

			break;

		}
		case 5: {
			System.out.println("You have selected the option to display Main Menu");
			menu();
			break;

		}
		default:
			System.out.println("You have selected the wrong option !! please select the option from below menu");
			displaymenu();
		}

	}

	public void add() {// this method is used for adding the files.
		String path = "";
		String name = " ";
		System.out.println("Please give the name of the file to add");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			name = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File f1 = new File(name);
		try {
			if (f1.createNewFile()) {
				System.out.println("File created Successfully " + f1.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displaymenu();
	}

	public void delete() {// this method is used to delete the files
		System.out.println("Please give the name of the file to delete");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();// taking the input from the user.
		File f2 = new File(name);
		if (f2.exists()) {// Checking file exits or not.
			f2.delete();
		}

		if (f2.exists()) {
			System.out.println("There is some problem in deleting the file");

		} else {
			System.out.println("File deleted succesfully ");
		}
		displaymenu();
	}

	public void search() {// this method is for searching the files
		int flag = 0;
		System.out.println("Enter the file name you want to search ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next(); // taking the input from the user.
		String currentPath = null;
		try {
			currentPath = new java.io.File(".").getCanonicalPath();// getting the current working directory
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathname = currentPath;
		String pathname1 = pathname.replace("\\", "\\\\");//

		try {
			File f = new File(pathname1);
			String[] files = f.list();

			if (files == null) {
				System.out.println("Empty directory.");
			} else {
				for (int i = 0; i < files.length; i++) {
					String filename = files[i];
					if (filename.equals(name)) {
						System.out.println("File is found :" + filename + " in the current directory i.e " + pathname1);
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					System.out.println("File does not exist in the current directory");
				}

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}

		displaymenu();
	}

	public void exit() {
		System.exit(n);
	}

	public void menu() {
		firstscreen();
	}

	




	
	

}


