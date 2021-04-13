//Angus Tudsbery
//180157642
//17 April 2019
//This file implements the directory interface using hashing
//This is done by using hashmaps and setting the keys to be each letter of the alphabet and then making the values a list of all the people starting with that name


import java.util.ArrayList;
import java.util.Collections;			//Import collections method of java.util package
import java.util.List;

public class HashDirectory implements Directory{		//Define a class that implements directory

	public void add(String name, String initials, int extention) {			//Define a method that takes 2 strings and an integer as an input and returns nothing
		String l = String.valueOf(name.toUpperCase().charAt(0));		//Convert the name to uppercase, get the character at the start (position 0) and then convert the character to a string
		List<String> a = (List<String>) Constants.RF.getPeoplePart3().get(l);		//Get the list value assigned to the key "l" and assign to new list
		int index = Collections.binarySearch(a, name);		//Perform a binary search to work out index of new name
		if (index < 0) {
		    index = (index * -1) - 1;
		}
		a.add(index, name + "\t" + initials + "\t" + extention);		//Add new person to list
		Constants.RF.getPeoplePart3().put(l, a);				//Update list in the hashmap
	}

	public void delete(String name) {
		String l = String.valueOf(name.toUpperCase().charAt(0));		//Convert the name to uppercase, get the character at the start (position 0) and then convert the character to a string
		List<String> a = (List<String>) Constants.RF.getPeoplePart3().get(l);
		for (int i = 0; i < a.size(); i++) {											//For loop to iterate number of times as there are element in list "a"
			String s = ((List<String>) Constants.RF.getPeoplePart3().get(l)).get(i);		//Get the list assigned to key value "l" and get element "i" from the list and assing to a string
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {					//Check if string contains the name
				a.remove(i);			//Delete person from list
			}
		}
		Constants.RF.getPeoplePart3().put(l, a);			//Update hashmap
	}

	public void delete(int extention) {
		boolean x = false;			//Create boolean and make false
		for(char letters = 'a'; letters <='z' && x == false; letters++ ) {		//For loop to go over alphabet and whilst x is false
			String ext = Integer.toString(extention);			//Convert int to string
			String l = String.valueOf(letters);			//Convert char to string
			List<String> a = (List<String>) Constants.RF.getPeoplePart3().get(l.toUpperCase());
			int size = a.size();
			for (int i = 0; i < size && x == false; i++) {
				String s = ((List<String>) Constants.RF.getPeoplePart3().get(l.toUpperCase())).get(i);			//Get list assigned to key "l" and get element "i" from list 
				if (s.trim().contains(ext)) {		//Check if extension is in string
					a.remove(i);		//Remove from list
					x = true;			//Set x to be true
				}
			}
		}
	}

	public int lookup(String name) {
		String l = String.valueOf(name.toUpperCase().charAt(0));		//Assign first letter of name to string
		List<String> a = (List<String>) Constants.RF.getPeoplePart3().get(l);		//Get list assigned to key "l"
		String ext = "";		//Create empty string
		for (String s : a) {
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {		//Check if string contains name
				for (char c: s.toCharArray()) {
					if (Character.isDigit(c)) {
						ext += c;		//Add character to string
					}
				}
			}
		}
		int extention = Integer.parseInt(ext);		//Convert string to int
		return extention;						//Return extension
	}

	public void change(String name, int extention) {
		String l = String.valueOf(name.toUpperCase().charAt(0));
		List<String> a = (List<String>) Constants.RF.getPeoplePart3().get(l);
		String p = "";		//Create empty string
		int i = 0;
		int j = 0;		//Integer with value 0
		for (String s : a) {
			if (s.toLowerCase().trim().contains(name.toLowerCase())) {
				for (char c: s.toCharArray()) {
					if (!Character.isDigit(c)){
						p += c;			//Add any non-digit characters to string
						j = i;			//Set value of j to be i
					}
				}
				p += extention;			//Add new extension to name and initials
			}
			i++;
		}
		a.set(j, p);		//Update list of people
		Constants.RF.getPeoplePart3().put(l, a);		//Update hashmap
	}

	public String display() {
		String display = "";		//Create an empty string
		for(char letters = 'a'; letters <='z'; letters++ ) {				//Loop over each letter of the alphabet	
			String l = String.valueOf(letters).toUpperCase();			//Get current letter, convert to uppercase and then convert to string
			List<String> a = (List<String>) (Constants.RF.getPeoplePart3().get(l));		//Get list assigned to key "l"
			if (!a.isEmpty()) {			//If letter has no element then skip it
				for (String s : a) {
					String name = "Name: ";
					String ext = "Extention: ";
					for (char c: s.toCharArray()) {
						if (!Character.isDigit(c)) {
							name += c;
						}
						else {
							ext += c;
						}
					}
					display += (name + ext + "\n");
				}
			}	
		}
		return display;		//Return string containing all names and extensions
	}

}
