package com.simplilearn.ProjectPhase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) throws IOException {
		
	Scanner sc= new Scanner(System.in);
	
	while(true) {

	System.out.println("Enter\n 1 for Display\n 2 for Menu\n 3 for Exit");
	int choice=sc.nextInt();

	switch(choice)
	{      
	case 1:
		
        String Path= "C:\\Thilo\\";
		
		File f= new File(Path);
		
		File filenames[]= f.listFiles();
		for(File ff: filenames) {
			System.out.println(ff.getName());
		}
		break;
		
	case 2:	
		
		boolean value=true;
		while(value) {

		System.out.println("You have taken Menu ");
		System.out.println("Enter subMenu\n 2.1 Add\n 2.2 Delete\n 2.3 Search\n 2.4 Exit");
		int choice2=sc.nextInt();
		

		switch(choice2) 
		{
		case 1:			
			String Path1="C:\\Thilo\\";			
			Scanner in= new Scanner(System.in);
			System.out.println("Add the File from Directory");
			System.out.println();
			System.out.println("Enter the File into the Directory "+Path1);
			String FileName= in.next();
			
			File f1= new File(Path1+FileName);
			
			boolean b= f1.createNewFile();
			
			if(b==true) {
				System.out.println("File is added");
			}
			else {
				System.out.println("File is Not Added");
			}
		    break;
		
	     case 2:
	    	 			
		    String Path2="C:\\Thilo\\";
	    	Scanner io= new Scanner(System.in);
			System.out.println("Delete the File from Directory");
			System.out.println();
	 		System.out.println("Enter the File for delete into the path "+Path2);
	 		String Name= io.next();
	 		
	 		File f2= new File(Path2+Name);
	 		
	 		boolean b1= f2.delete();
	 		
	 		if(b1==true) {
	 			System.out.println("File has been deleted");
	 		}
	 		else {
	 			System.out.println("File not Found");
	 		}
	 		break;
	 		
	     case 3:
	    	 
	    	String Path3= "C:\\Thilo\\";
	 		Scanner input= new Scanner(System.in);
	 		System.out.println("Search the File from Directory");
	 		System.out.println();
	 		System.out.println("Enter the File for search into the Directory "+Path3);
	 		String name= input.next();
	 		
	 		File f3= new File(Path3);
	 		
	 		File FileNames[]= f3.listFiles();
	 		
	 		int flag=0;
	 		for(File ff: FileNames) {
	 			if(ff.getName().equals(name)) {
	 				flag=1;
	 				break;
	 			}
	 			else {
	 				flag=0;
	 			}
	 		    }
	 			if(flag==1) {
	 				System.out.println("Files Found");
	 			}
	 			else {
	 				System.out.println("Files Not Found");
	 			}
	 		   break;
	 		
	     case 4:System.out.println("Exit"); 
	     
	 		value=false;
	 		
	 		default:System.out.println("You have entered invalid choice");
	 		break;
		}
		
	}
		break;

	case 3:System.exit(0);
	
     default:System.out.println("Invalid Choice");
     break;
	   }
     }
   }
}

