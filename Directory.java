//Angus Tudsbery
//180157642
//4 April 2019
//This is the interface that defines all the methods to be implemented


public interface Directory {										//Creates an interface called directory
	public void add(String name, String initials, int extention);		//Define a method that returns nothing and takes 2 strings and an integer as parameters
	public void delete(String name);
	public void delete(int extention);
	public int lookup(String name);										//Define a method that returns an integer and takes a string as an input
	public void change(String name, int extention);
	public String display();											//Method that returns a string
}
