package panels;

import gui.PanelHandler;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountSettingsPanel extends JPanel {
	
	private JButton accountDetails; 
	private JButton changeUsername; 
	private JButton changePassword; 
	private JButton back; 
	
	private PanelHandler handler; 
	
	public AccountSettingsPanel(PanelHandler handler) {
		
		setLayout(new GridLayout(4, 1, 20, 20)); 
		
		this.handler = handler; 
		
		ActionListener a = new ButtonHandler(); 
		
		accountDetails = new JButton("Account Details"); 
		accountDetails.addActionListener(a); 
		add(accountDetails); 
		
		changeUsername = new JButton("Change Username"); 
		changeUsername.addActionListener(a);
		add(changeUsername); 
		
		changePassword = new JButton("Change Password"); 
		changePassword.addActionListener(a);
		add(changePassword); 
		
		back = new JButton("Back"); 
		back.addActionListener(a);
		add(back); 
		 
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			if(source == changeUsername) {
				handler.handleChangeUsername(); 
			} else if(source == changePassword) {
				handler.handleChangePassword();
			} else if(source == back) {
				handler.handleIndividual();
			} else if(source == accountDetails) {
				handler.handleDetails(); 
			}
			
		}
		
	}

}
