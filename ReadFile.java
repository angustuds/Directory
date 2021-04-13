//Angus Tudsbery
//180157642
//2 April 2019
//This program opens the file and assigns the contents to different variables depending on which directory is being used


import java.io.*;			//Import java.io package
import java.nio.file.Files;		//Import classes from java.nio to count number of lines in file
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;		//Import java.util package

public class ReadFile {
	
	private FileReader from;		//Create a private FileReader
	private String [] PeoplePart1;		//Create a private array of strings
	private LinkedList<String> PeoplePart2;		//Create a private LinkedList of strings
	private HashMap<String, List> PeoplePart3 = new HashMap<String, List>();		//Create and initialise a private HashMap with a string for the key and list for the value 
	
	public void select(int i) throws IOException {		//Create a public method that returns nothing, takes an integer as a parameter
			File selectedFile = new File("sample.txt");		//Create a new file and assign the contents of "sample.txt" to it
			if (i == 1) {									//If the integer parameter is 1 then the code inside will be executed
				Path path = Paths.get("sample.txt");		//Create a new path to "sample.txt"
				long lineCount = Files.lines(path).count();		//Find out the line count and assign to a long
				PeoplePart1 = new String[(int) lineCount];		//Initialise the array of string to be the size of the number of lines in the file
			}
			Constants.RF.open(selectedFile, i);		//Call the open method with the file and integer
		
	}
	
	public void open(File file, int i) throws FileNotFoundException {		//Define a public method that returns nothing, takes a file and an integer as a parameter and throws an error if the file doesn't exist
		if (file.exists() && file.isFile()) {			//Checks the file exists
			Constants.RF.read(file, i);
		}
	}
	
	public void read(File file, int i) throws FileNotFoundException {
		from = new FileReader(file);		//Initialises the FileReader
		Scanner source = new Scanner(from);			//Creates a new scanner and links to the FileReader
		if (i==1) {								//This if statement is used to work out whether the user is using the array, list or hashmap version of the program
			Constants.RF.PeoplePart1(source);
		}
		else if (i==2) {
			Constants.RF.PeoplePart2(source);
		}
		else if (i==3) {
			Constants.RF.PeoplePart3(source);		//Call PeoplePart3 with the scanner
		}
	}
	
	public void PeoplePart1(Scanner source) {
		int i = 0;									//Define an int to equal 0
		while (source.hasNext()) {				//While loop that iterates until there are no more lines in the file
			PeoplePart1[i] = source.nextLine();			//Assign each person with their extension to the array
			i += 1;
		}
		Arrays.sort(PeoplePart1);		//Sort the array to alphabetical order
	}
	
	public void PeoplePart2(Scanner source) {
		PeoplePart2 = new LinkedList<String>();		//Initialise the LinkedList
		while (source.hasNext()) {
			PeoplePart2.add(source.nextLine());		//Add the next line of the file
		}
		Collections.sort(PeoplePart2);
	}
	
	public void PeoplePart3(Scanner source) {
		List<String> a = new ArrayList<>();			//Create a new list
		while (source.hasNext()) {
			a.add(source.nextLine());		//Add all the lines to the list
		}
		Collections.sort(a);		//Sort list alphabetically
		for(char alphabet = 'a'; alphabet <='z'; alphabet++ ) {		//For loop that goes through alphabet
			String x=String.valueOf(alphabet);		//Convert char to string and assign to variable
			List<String> b = new ArrayList<>();
			for (String s: a) {						//For loop that goes through each element of "a"
				if (s.toLowerCase().startsWith(x)) {		//Converts element to lower case and then checks if it starts with the letter being checked
					b.add(s);		//Adds element to "b"
				}
			}
			String y = x.toUpperCase();		//Converts "x" to uppercase
			PeoplePart3.put(y, b);		//Adds the letter and a list of all people starting with that letter to hashmap
		}

	}
	
	public void setPeoplePart1(String [] x) {
		PeoplePart1 = new String[x.length];		//Replaces "PeoplePart1" with new empty array of the length of "x"
		PeoplePart1 = x;			//Assigns "x" to "PeoplePart1"
	}
	
	public String [] getPeoplePart1() {		//Define a method that returns an array of strings
		return PeoplePart1;
	}
	
	public LinkedList getPeoplePart2() {
		return PeoplePart2;					//Return the contents of "PeoplePart2"
	}
	
	public HashMap getPeoplePart3() {		//Method that returns a hashmap
		return PeoplePart3;
	}

}
