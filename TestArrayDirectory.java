//Angus Tudsbery
//180157642
//5 April 2019
//This file shows that all the methods in ArrayDirectory work as they are supposed to


import java.io.IOException;

public class TestArrayDirectory {

	public static void main(String[] args) throws IOException {
		Constants.RF.select(1);					//Call select method with parameter 1
		System.out.println("File contents:");
		System.out.println(Constants.AD.display());
		System.out.println("\nContents with new person:");
		Constants.AD.add("Mane", "S", 10004);			//Add new person
		System.out.println(Constants.AD.display());
		System.out.println("\nContents after 1 person has been removed by name and 1 removed by extention:");
		Constants.AD.delete("Hazard");			//Delete by name
		Constants.AD.delete(12345);				//Delete by extension
		System.out.println(Constants.AD.display());
		System.out.println("\nExtention of requested person:");
		System.out.println(Constants.AD.lookup("Ziyech"));			//Lookup extension of Ziyech
		System.out.println("\nContents after extention change:");
		Constants.AD.change("Ziyech", 46703);				//Change extension of Ziyech
		System.out.println(Constants.AD.display());
	}

}
