package panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import users.Person;

public class AccountDetailsPanel extends JPanel {

	private Person user; 
	
	public AccountDetailsPanel() {
		
		
		
	}
	
	public void setUser(Person p) {
		this.user = p;
		
		setLayout(new FlowLayout()); 
		setBackground(Color.CYAN); 
		
		add(new JLabel("Name: " + p.getFirstName() + " " + p.getLastName())); 
		add(Box.createHorizontalStrut(2233)); 
		add(new JLabel("Age: " + p.getAge())); 
		add(Box.createHorizontalStrut(2233)); 
		add(new JLabel("Username: " + p.getUsername())); 
		add(Box.createHorizontalStrut(2233)); 
		add(new JLabel("Password: " + p.getPassword())); 
	}
}
