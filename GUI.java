//Angus Tudsbery
//180157642
//18 April 2019
//This program embeds the ListDirectory into a graphical user interface using Java Swing components


import javax.swing.*;				//Import java swing package
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI {
	
	private JFrame f = new JFrame("GUI List Directory");		//Create and initialise new frame with a title
	private int ne;			//Create a private integer
	
	public JButton menubut(int a, int b, int c, int d) {		//Create class that returns a button and takes 4 integers as inputs
		JButton mb  = new JButton("Menu");					//Create a new button called menu
		mb.setBounds(a, b, c, d);						//Set the coordinates and size using the 4 integers
		mb.addActionListener(new ActionListener() {			//Set the actions for the button
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().removeAll();			//Remove all elements from frame
				f.revalidate();				
				f.repaint();				//Update frame
				Constants.GUI.menu();			//Call menu method
			}
		});
		return mb;		//Return the button
	}
	
	public JButton quitbut (int a, int b, int c, int d) {
		JButton qb = new JButton("Quit");
		qb.setBounds(a, b, c, d);
		qb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				//Quit the program
			}
		});
		return qb;
	}
	
	public JTextField menuquit (int a, int b, int c, int d) {
		JTextField end = new JTextField(); 						//Create a new text box
		end.setBounds(a, b, c, d);
		end.setEditable(false);				//Make text not editable
		end.setText("Select to return to menu or quit");		//Set the text
		return end;			//Return the text box
	}

	public void frame() {
		f.setSize(600,800);			//Set the size of the frame
		f.setLayout(null);		//Have no layout
		f.setVisible(true);			//Make visible
	}
	
	public void menu() {
		JTextField choice = new JTextField();
		JButton add = new JButton("Add");			//Create a new button with "Add" on it
		JButton delete = new JButton("Delete");
		JButton lookup = new JButton("Lookup");
		JButton change = new JButton("Change");
		JButton display = new JButton("Display");
		
		choice.setEditable(false);
		choice.setText("Please choose an option");
		choice.setBounds(10, 10, 200, 30);
		
		add.setBounds(10, 50, 100, 40);			//Set position and size of button
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(choice);
				f.remove(add);			//Remove all other buttons from page
				f.remove(delete);
				f.remove(lookup);
				f.remove(change);
				f.remove(display);
				Constants.GUI.add();		//Call add method
			}
		});
		
		delete.setBounds(120, 50, 100, 40);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(choice);
				f.remove(add);
				f.remove(delete);
				f.remove(lookup);
				f.remove(change);
				f.remove(display);
				Constants.GUI.delete();
			}
		});
		lookup.setBounds(230, 50, 100, 40);
		lookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(choice);
				f.remove(add);
				f.remove(delete);
				f.remove(lookup);
				f.remove(change);
				f.remove(display);
				Constants.GUI.lookup();
			}
		});
		change.setBounds(340, 50, 100, 40);
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(choice);
				f.remove(add);
				f.remove(delete);
				f.remove(lookup);
				f.remove(change);
				f.remove(display);
				Constants.GUI.change();
			}
		});
		display.setBounds(450, 50, 100, 40);
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(choice);
				f.remove(add);
				f.remove(delete);
				f.remove(lookup);
				f.remove(change);
				f.remove(display);
				Constants.GUI.display();
			}
		});
		f.add(choice);
		f.add(add);			//Add the buttons to the page
		f.add(delete);
		f.add(lookup);
		f.add(change);
		f.add(display);
		f.revalidate();
		f.repaint();			//Refresh the frame
		
	}
	
	public void add() {
		JButton b = new JButton("Submit");			//Create a new button
		
		JTextField title = new JTextField();		//Create a new text field
		title.setText("To add a new person please enter the name, intitials and extension");			//Set text
		title.setBounds(10, 10, 450, 30);			//Set position and size
		title.setEditable(false);				//Make label not editable
		
		JTextField n = new JTextField();
		n.setText("Name:");
		n.setEditable(false);
		n.setBounds(76, 55, 50, 30);
		
		JTextField i = new JTextField();
		i.setText("Initials:");
		i.setEditable(false);
		i.setBounds(76, 105, 60, 30);
		
		JTextField e = new JTextField();
		e.setText("Extension:");
		e.setEditable(false);
		e.setBounds(76, 155, 76, 30);
		
		JTextField name = new JTextField();			//Create an empty text box
		JTextField initials = new JTextField();
		JTextField extension = new JTextField();
		
		name.setBounds(150, 50, 100, 40);			//Set position and size of text box
		initials.setBounds(150, 100, 100, 40);
		extension.setBounds(150, 150, 100, 40);
		
		b.setBounds(150, 200, 100, 40);			//Set button position and size
		b.addActionListener(new ActionListener() {				//Set button actions
			public void actionPerformed(ActionEvent e) {
				String x = name.getText();					//Get text entered into name and assign to string
				String y = initials.getText();
				String z = extension.getText();
				int a = Integer.parseInt(z);				//Convert extension input to integer
				Constants.LD.add(x, y, a);					//Call add method of ListDirectory
				
				f.add(Constants.GUI.menuquit(10, 250, 250, 30));		//Add the end message
				f.add(Constants.GUI.menubut(10, 300, 100, 40));			//Add menu button to frame
				f.add(Constants.GUI.quitbut(120, 300, 100, 40));
				f.revalidate();
				f.repaint();			//Update frame
			}
		});
		
		f.add(title);
		f.add(n);
		f.add(i);
		f.add(e);
		f.add(name);		//Add text box to screen
		f.add(initials);
		f.add(extension);
		f.add(b);
		f.revalidate();
		f.repaint();
	}
	
	public void delete() {
		JButton b = new JButton("Submit");			//Create new button
		
		JTextField title = new JTextField();
		title.setText("To delete a person select whether to use their name or extension");		//Set text
		title.setBounds(10, 10, 440, 30);
		title.setEditable(false);
		
		JTextField name = new JTextField();
		name.setText("Please enter the name:");
		name.setEditable(false);				//Make text box not editable
		name.setBounds(10, 100, 160, 30);
		
		JTextField extension = new JTextField();
		extension.setText("Please enter the extension:");
		extension.setEditable(false);
		extension.setBounds(10, 100, 180, 30);			//Set position and size
		
		JTextField box = new JTextField();			//Create new textfield
		box.setBounds(60, 150, 100, 40);
		
		JButton n = new JButton("Name");
		n.setBounds(10, 50, 100, 40);
		
		JButton ext = new JButton("Extension");
		ext.setBounds(130, 50, 100, 40);
		
		n.addActionListener(new ActionListener() {			//Set what to do when button is clicked
			public void actionPerformed(ActionEvent e) {
				ne = 1;
				f.add(name);			//Add element to screen
				f.remove(n);			//Remove n from frame
				f.remove(ext);
				f.add(box);
				f.add(b);
				f.revalidate();
				f.repaint();			//Update frame
			}
		});
		
		ext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ne = 2;				//Set "ne" to equal 2
				f.add(extension);
				f.remove(n);
				f.remove(ext);
				f.add(box);
				f.add(b);
				f.revalidate();
				f.repaint();
			}
		});
		
		b.setBounds(60, 200, 100, 40);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = box.getText();					//Get user input from textfield and assign to string
				if (ne == 1) {
					Constants.LD.delete(x);		//If "ne" is equal to 1 then call delete method of ListDirectory class
				}
				else if (ne == 2) {
					int y = Integer.parseInt(x);		//If "ne" is equal to 2 then convert to integer and call delete method
					Constants.LD.delete(y);
				}
				
				f.add(Constants.GUI.menuquit(10, 250, 250, 30));		//Add options to quit or return to menu to screen
				f.add(Constants.GUI.menubut(10, 300, 100, 40));
				f.add(Constants.GUI.quitbut(120, 300, 100, 40));
				f.revalidate();
				f.repaint();
			}
		});	
		
		f.add(title);		//Add title and buttons to screen
		f.add(n);
		f.add(ext);
		f.revalidate();
		f.repaint();
	}
	
	public void lookup() {
		JTextField title = new JTextField();			//Create new textfield
		title.setText("Please enter the name of the person to lookup");			//Set text
		title.setBounds(10, 10, 350, 30);			//Set position and size
		title.setEditable(false);			//Make not editable
		
		JTextField box = new JTextField();
		box.setBounds(10, 50, 100, 40);
		
		JButton b = new JButton("Submit");		//Create new button
		b.setBounds(10, 100, 100, 40);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField l = new JTextField();		//Create new textfield
				l.setText("Extension:");
				l.setBounds(10, 150, 80, 30);
				l.setEditable(false);
				
				String name = box.getText();			//Get user input
				int ext = Constants.LD.lookup(name);		//Call lookup method and assign to integer
				String ext2 = Integer.toString(ext);		//Convert int to string
				
				JTextField exten = new JTextField();
				exten.setText(ext2);				//Display extension to user
				exten.setBounds(100, 150, 50, 30);
				exten.setEditable(false);
				
				f.add(l);
				f.add(exten);
				f.add(Constants.GUI.menuquit(10, 200, 250, 30));
				f.add(Constants.GUI.menubut(10, 250, 100, 40));
				f.add(Constants.GUI.quitbut(120, 250, 100, 40));
				f.revalidate();
				f.repaint();
			}
		});	
		
		f.add(title);
		f.add(box);
		f.add(b);
		f.revalidate();
		f.repaint();
	}
	
	public void change() {
		JTextField title = new JTextField();
		title.setText("Please enter the name and the new extension");
		title.setEditable(false);
		title.setBounds(10, 10, 350, 30);
		
		JTextField n = new JTextField();
		n.setText("Name:");
		n.setEditable(false);
		n.setBounds(60, 55, 50, 30);
		
		JTextField ext = new JTextField();
		ext.setText("Extension:");
		ext.setEditable(false);
		ext.setBounds(60, 105, 80, 30);
		
		JTextField name = new JTextField();
		name.setBounds(150, 50, 100, 40);
		
		JTextField extension = new JTextField();
		extension.setBounds(150, 100, 100, 40);
		
		JButton b = new JButton("Submit");
		b.setBounds(100, 150, 100, 40);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = name.getText();					//Get name of person user wants to change extension for
				String y = extension.getText();			//Get new extension
				int z = Integer.parseInt(y);			//Convert string to int
				
				Constants.LD.change(x, z);		//Call change method with name and extension
				
				f.add(Constants.GUI.menuquit(10, 200, 250, 30));
				f.add(Constants.GUI.menubut(10, 250, 100, 40));
				f.add(Constants.GUI.quitbut(120, 250, 100, 40));
				f.revalidate();
				f.repaint();
			}
		});	
		
		f.add(title);
		f.add(n);
		f.add(ext);
		f.add(name);
		f.add(extension);
		f.add(b);
		f.revalidate();
		f.repaint();
		
	}
	
	public void display() {
		JTextField label = new JTextField();
		label.setText("File contents:");
		label.setBounds(20, 20, 400, 30);
		label.setEditable(false);
		f.add(label);
		JTextArea file = new JTextArea();
		file.setText(Constants.LD.display());			//Get file contents
		file.setBounds(20, 50, 400, 500);
		
		f.add(file);						//Add file contents to screen
		f.add(Constants.GUI.menuquit(10, 550, 250, 30));
		f.add(Constants.GUI.menubut(10, 600, 100, 40));
		f.add(Constants.GUI.quitbut(120, 600, 100, 40));
		f.revalidate();
		f.repaint();
	}
	
	public static void main(String[] args) throws IOException {
		JFileChooser chooser = new JFileChooser();				//Create and initialise new JFileChooser
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {		//Get user to select file and check it is valid
			File selectedFile = chooser.getSelectedFile();			//Create new File and assign users choice
			Constants.RF.open(selectedFile, 2);		//Call open method of ReadFile class
		}
		
		Constants.GUI.frame();
		Constants.GUI.menu();

	}

}
