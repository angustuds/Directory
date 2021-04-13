//Angus Tudsbery
//180157642
//16 April 2019
//This file implements the directory interface using LinkedLists


import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;			//Import list class of java.util package
import java.util.ArrayList;

public class ListDirectory implements Directory{

	public void add(String name, String initials, int extention) {
		int index = Collections.binarySearch(Constants.RF.getPeoplePart2(), name.toUpperCase());		//Perform a binary search to work out where in the list the person should go
		if (index < 0) {
		    index = (index * -1) - 1;		//If the person needs to go at the end of the list then make the index correct
		}
		Constants.RF.getPeoplePart2().add(index, name + "\t" + initials + "\t" + extention);		//Add the person to the LinkedList
	}

	public void delete(String name) {		//Define a method that returns nothing and takes a string as an input
		List<String> a = new ArrayList<>(Constants.RF.getPeoplePart2());		//Create a list of strings and assign the current directory to it
		int i = 0;		//Create an integer with 0 value
		for(String s: a) {			//For loop to iterate over every string in the list
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {		//Convert the name and list element to lowercase and see if the name is in any part of the list element
				Constants.RF.getPeoplePart2().remove(i);		//Delete person from list
			}
			i++;		//Add 1 to i
		}
	}
	

	public void delete(int extention) {
		String ext = Integer.toString(extention);		//Convert integer parameter to a string and assign to variable
		Constants.LD.delete(ext);					//Call string delete method
	}
	
	public int lookup(String name) {
		List<String> a = new ArrayList<>(Constants.RF.getPeoplePart2());
		String ext = "";			//Create an empty string
		for (String s : a) {
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {
				for (char c: s.toCharArray()) {		//For loop to go over every character in string element from list that contains the name
					if (Character.isDigit(c)) {			//Check if character is a digit
						ext += c;				//Add to string "ext"
					}
				}
			}
		}
		int extention = Integer.parseInt(ext);		//Convert string to an integer and assign to variable
		return extention;			//Return value of "extension"
	}
	
	public void change(String name, int extention) {	
		List<String> a = new ArrayList<>(Constants.RF.getPeoplePart2());
		String p = "";
		int i = 0;		//Create integer variable with value 0
		int j = 0;
		for (String s : a) {
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {
				for (char c: s.toCharArray()) {
					if (!Character.isDigit(c)){		//Check if character is not a digit
						p += c;		//Add the non-digit character to the string
						j = i;			//Set j to be equal to i
					}
				}
				p += extention;			//Add the new extension to the end of the string
			}
			i++;
		}
		Constants.RF.getPeoplePart2().set(j, p);		//Update the person
	}
	
	public String display() {			//Define a method that takes no inputs and returns a string
		List<String> a = new ArrayList<>(Constants.RF.getPeoplePart2());
		String display = "";		//Create an empty string
		for (String s : a) {
			String name = "Name: ";			//Create a string containing "Name: "
			String ext = "Extention: ";
			for (char c: s.toCharArray()) {
				if (!Character.isDigit(c)) {		//If the character is not a digit then add it to the name variable
					name += c;
				}
				else {
					ext += c;				//If the character is a digit add it to the extension variable
				}
			}
			display += (name + ext + "\n");			//Add the name, extension and a new line to the display variable
		}
		return display;		//Return the entire list of people and extensions
	}
	
}
