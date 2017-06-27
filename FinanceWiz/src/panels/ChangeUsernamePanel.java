package panels;

import gui.PanelHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.Person;
import users.UserDB;

public class ChangeUsernamePanel extends JPanel {

	private JButton change, back;
	private PanelHandler handler;
	private JTextField originalUsername;
	private JTextField changeUsername;
	private JTextField verifyUsername;
	private final UserDB userDB;

	public ChangeUsernamePanel(PanelHandler handler, UserDB userDB) {
		this.handler = handler;
		this.userDB = userDB;

		ActionListener a = new ButtonHandler(); 
		
		change = new JButton("Change!");
		back = new JButton("Back"); 

		add(new JLabel("Enter your original username"));
		add(Box.createHorizontalStrut(2233)); 
		originalUsername = new JTextField(15);
		add(originalUsername);

		add(Box.createHorizontalStrut(2233));
		add(new JLabel("Enter your new username"));
		add(Box.createHorizontalStrut(2233)); 
		changeUsername = new JTextField(15);
		add(changeUsername);
		
		add(Box.createHorizontalStrut(2233)); 

		add(new JLabel("Verify your username"));
		add(Box.createHorizontalStrut(2233)); 
		verifyUsername = new JTextField(15);
		add(verifyUsername);

		add(Box.createHorizontalStrut(2233)); 
		back.addActionListener(a); 
		add(back); 
		
		add(Box.createHorizontalStrut(25)); 
		
		change.addActionListener(a);
		add(change);

	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == change) {
				for (Person p : userDB.getUsers()) {
					if (p.getUsername().equals(originalUsername.getText())) {
						if (verifyUsername.getText().equals(
								changeUsername.getText())) {
							p.setUsername(changeUsername.getText());
							userDB.updateUser(originalUsername.getText(), p);
						}
					}
				}
				handler.handleSettings(); 

			} else if(source == back) {
				handler.handleSettings();
			}
			
			originalUsername.setText("");
			changeUsername.setText("");
			verifyUsername.setText("");
		}

	}
}
