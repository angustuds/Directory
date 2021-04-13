//Angus Tudsbery
//180157642
//4 April 2019
//This program implements the directory interface using arrays


import java.util.Collections;		//Import collections method of java util package
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDirectory implements Directory{			//Create a class to implement the interface

	public void add(String name, String initials, int extention) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(Constants.RF.getPeoplePart1()));		//Create a new arraylist and assign the contents of the file
		int index = Collections.binarySearch(list, name);		//Work out position to place new person into list
		if (index < 0) {
		    index = (index * -1) - 1;		//If result is negative then it means it needs to go at the end so the result needs making positive
		}
		list.add(index, name + "\t" + initials + "\t" + extention);		//Add new person to list
		Constants.RF.setPeoplePart1(list.toArray(Constants.RF.getPeoplePart1()));		//Convert list to array and replace old contents of array
	}

	public void delete(String name) {
		ArrayList<String> original = new ArrayList<String>(Arrays.asList(Constants.RF.getPeoplePart1()));		//Create a new arraylist and assign the contents of the file
		List<String> list = new ArrayList<String>(Arrays.asList(Constants.RF.getPeoplePart1()));		//Create a new list and assign the contents of the file
		int i = 0;
		for(String s: original) {		//Loop through each element of the arraylist
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {		//Convert element to lowercase and then check if any part of it contains the name converted to lowercase
				list.remove(i);		//If name is in file then remove it
			}
			i++;
		}
		String [] a = (String[]) list.stream().toArray(String[]::new);		//Create new array containing contents of list
		Constants.RF.setPeoplePart1(a);
	}

	public void delete(int extention) {
		String ext = Integer.toString(extention);		//Convert integer to string
		Constants.AD.delete(ext);			//Call string version of method
	}

	public int lookup(String name) {
		List<String> list = new ArrayList<String>(Arrays.asList(Constants.RF.getPeoplePart1()));
		String ext = "";			//Create an empty string
		for (String s : list) {
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {		//Convert element to lowercase and then check if any part of it contains the name converted to lowercase
				for (char c: s.toCharArray()) {		//Loop through every character in string "s"
					if (Character.isDigit(c)) {		//Check if the character is a number
						ext += c;			//If it is a number add it to the string
					}
				}
			}
		}
		int extention = Integer.parseInt(ext);		//Convert string to integer
		return extention;		//Return extension
	}

	public void change(String name, int extention) {
		List<String> list = new ArrayList<String>(Arrays.asList(Constants.RF.getPeoplePart1()));
		String p = "";		//Create empty string
		int i = 0;		//Create new integer and assign value of 0
		int j = 0;
		for (String s : list) {
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {		//Convert element to lowercase and then check if any part of it contains the name converted to lowercase
				for (char c: s.toCharArray()) {		//Loop through each character of string
					if (!Character.isDigit(c)){		
						p += c;						//If character is not a number then add it to the string
						j = i;			//Get position of person in array
					}
				}
				p += extention;		//Add new extension to end of string containing name an initials
			}
			i++;		//Add 1 to i;
		}
		list.set(j, p);		//Update person in list
		String [] a = (String[]) list.stream().toArray(String[]::new);
		Constants.RF.setPeoplePart1(a);		//Update array
	}

	public String display() {
		List<String> list = new ArrayList<String>(Arrays.asList(Constants.RF.getPeoplePart1()));		//Convert array containing people to list and assing to new list
		String display = "";		//Create empty list
		for (String s : list) {		//Loop through each person
			String name = "Name: ";		//Create new string containing "Name: "
			String ext = "Extention: ";
			for (char c: s.toCharArray()) {		//Loop through each character in string
				if (!Character.isDigit(c)) {		//If character is not a number then add to name
					name += c;
				}
				else {		//If character is a digit is a number then add to ext
					ext += c;
				}
			}
			display += (name + ext + "\n");		//Add to display the name, extension and the a newline
		}
		return display;		//Return the string containing all the people and their extensions
	}


}