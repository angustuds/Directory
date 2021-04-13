//Angus Tudsbery
//180157642
//16 April 2019
//This file demonstrates that all the methods in ListDrectory function as they are supposed to


import java.io.IOException;			//Import IOException method of java.io class

public class TestListDirectory {

	public static void main(String[] args) throws IOException {			//Main method that throws any input or output exceptions
		Constants.RF.select(2);					//Call select method of ReadFile with parameter 2
		System.out.println("File contents:");			//Print message to console
		System.out.println(Constants.LD.display());		//Call display method
		System.out.println("\nContents with new person:");
		Constants.LD.add("Dembele", "M.O", 20040);			//Call add method with name, initials and extension
		System.out.println(Constants.LD.display());
		System.out.println("\nContents after 1 person has been removed by name and 1 removed by extention:");
		Constants.LD.delete("Gape");			//Delete person by name
		Constants.LD.delete(23456);				//Delete by extension
		System.out.println(Constants.LD.display());			//Show results to user
		System.out.println("\nExtention of requested person:");
		System.out.println(Constants.LD.lookup("Neres"));			//Lookup extension of Neres
		System.out.println("\nContents after extention change:");
		Constants.LD.change("Neres", 46703);			//Change extension of Neres
		System.out.println(Constants.LD.display());
	}

}
