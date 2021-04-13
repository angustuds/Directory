//Angus Tudsbery
//180157642
//17 April 2019
//This file shows all the methods in HashDirectory work as they are supposed to


import java.io.IOException;

public class TestHashDirectory {

	public static void main(String[] args) throws IOException {
		Constants.RF.select(3);			//Call select method with parameter 3
		System.out.println("File contents:");
		System.out.println(Constants.HD.display());			//Display file
		System.out.println("\nContents with new person:");
		Constants.HD.add("Becker", "A.R", 10308);			//Add new person
		System.out.println(Constants.HD.display());
		System.out.println("\nContents after 1 person has been removed by name and 1 removed by extention:");
		Constants.HD.delete("Samuel");			//Delete by name
		Constants.HD.delete(68398);				//Delete by extension
		System.out.println(Constants.HD.display());
		System.out.println("\nExtention of requested person:");
		System.out.println(Constants.HD.lookup("Vidal"));			//Lookup extension of Vidal
		System.out.println("\nContents after extention change:");
		Constants.HD.change("Vidal", 46703);			//Change extension of Vidal
		System.out.println(Constants.HD.display());
	}

}
