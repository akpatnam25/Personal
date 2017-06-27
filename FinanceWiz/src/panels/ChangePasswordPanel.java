package panels;

import gui.PanelHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import users.Person;
import users.UserDB;

public class ChangePasswordPanel extends JPanel {

	private JButton change, back; 
	private JPasswordField originalPassword; 
	private JPasswordField changePassword; 
	private JPasswordField verifyPassword; 
	private PanelHandler handler; 
	private final UserDB userDB; 
	
	public ChangePasswordPanel(PanelHandler handler, UserDB userDB) {
		
		this.userDB = userDB; 
		this.handler = handler; 
		
		ActionListener a = new ButtonHandler(); 
		change = new JButton("Change!"); 
		change.addActionListener(a); 
		
		back = new JButton("Back"); 
		back.addActionListener(a); 
		
		add(new JLabel("Enter your old password")); 
		add(Box.createHorizontalStrut(2233)); 
		originalPassword = new JPasswordField(15); 
		add(originalPassword); 
		
		add(Box.createHorizontalStrut(2233)); 
		
		add(new JLabel("Enter your new password")); 
		add(Box.createHorizontalStrut(2233)); 
		
		changePassword = new JPasswordField(15); 
		add(changePassword); 
		
		add(Box.createHorizontalStrut(2233)); 
		add(new JLabel("Verify your new password")); 
		add(Box.createHorizontalStrut(2233)); 
		verifyPassword = new JPasswordField(15); 
		add(verifyPassword); 
		
		add(Box.createHorizontalStrut(2233)); 
		add(back);
		add(Box.createHorizontalStrut(25)); 
		add(change); 
		
	}
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			
			if(source == change) {
				for(Person p: userDB.getUsers()) {
					if(p.getPassword().equals(String.valueOf(originalPassword.getPassword()))) {
						if(String.valueOf(verifyPassword.getPassword()).equals(String.valueOf(changePassword.getPassword()))) {
							p.setPassword(String.valueOf(changePassword.getPassword()));
							userDB.updateUser(String.valueOf(originalPassword.getPassword()), p);
						}
					}
				}
				handler.handleSettings(); 
				originalPassword.setText("");
				changePassword.setText("");
				verifyPassword.setText("");
				
			} else if(source == back) {
				handler.handleSettings(); 
			}
			
		}
		
	}
}
