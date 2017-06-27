package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import panels.AccountDetailsPanel;
import panels.AccountSettingsPanel;
import panels.BudgetPanel;
import panels.CalendarPanel;
import panels.ChangePasswordPanel;
import panels.ChangeUsernamePanel;
import panels.IndividualOptionsPanel;
import panels.InstructionsPanel;
import panels.LogInPanel;
import panels.MainPanel;
import panels.PlanPanel;
import panels.RegisterPanel;
import panels.WholeUI;
import users.FileUserDB;
import users.Person;
import users.UserDB;
import dataAnalysis.PieGraph;

/**
 * 
 * This class represents the frame which has all the panels, and is used in the
 * main method
 * 
 */
public class Window extends JFrame implements PanelHandler {

	public static final String MAIN_PANEL = "Main Panel";
	public static final String LOG_IN_PANEL = "Log In Panel";
	public static final String REGISTER_PANEL = "Register Panel";
	public static final String INDIVIDUAL_OPTION_PANEL = "Individual Options Panel";
	public static final String COMPANY_OPTION_PANEL = "Company Options Panel";
	public static final String PIE_PANEL = "Pie Panel";
	public static final String INSTRUCTIONS_PANEL = "Instructions Panel";
	public static final String TAB_PANEL = "Tab Panel";
	public static final String CHANGEUSER_PANEL = "Change Username Panel";
	public static final String CHANGEPASS_PANEL = "Change Password Panel";
	public static final String BUDGET_PANEL = "Budget Panel";
	public static final String SETTINGS_PANEL = "Account Settings Panel"; 
	public static final String CALENDAR_PANEL = "Calendar Panel"; 
	public static final String DETAILS_PANEL = "Account Details Panel"; 
	public static final String PLAN_PANEL = "Plan Panel"; 
	
	private final JPanel cards;
	private final CardLayout layout;

	private ArrayList<Person> users;

	private WholeUI tabPanel;
	private final UserDB userDB = new FileUserDB("UserData.txt");
	private Person loginUser = null;
	private AccountDetailsPanel accountDetailsPanel; 

	/**
	 * constructs the window which starts out with the log in screen
	 */
	public Window() {

		super("Finance Wiz");
		setBounds(100, 100, 640, 500);

		users = new ArrayList<Person>();

		layout = new CardLayout();
		cards = new JPanel(layout);

		tabPanel = new WholeUI(this);
		
		accountDetailsPanel = new AccountDetailsPanel(); 
		
		cards.add(new LogInPanel(this), LOG_IN_PANEL);
		cards.add(new MainPanel(this), MAIN_PANEL);
		cards.add(new RegisterPanel(this), REGISTER_PANEL);
		cards.add(new IndividualOptionsPanel(this), INDIVIDUAL_OPTION_PANEL);
		cards.add(new PieGraph(), PIE_PANEL);
		cards.add(new InstructionsPanel(this), INSTRUCTIONS_PANEL);
		cards.add(new ChangeUsernamePanel(this, userDB), CHANGEUSER_PANEL);
		cards.add(new ChangePasswordPanel(this, userDB), CHANGEPASS_PANEL); 
		cards.add(new AccountSettingsPanel(this), SETTINGS_PANEL); 
		cards.add(new AccountDetailsPanel(), DETAILS_PANEL); 
		
		cards.add(tabPanel, TAB_PANEL);
		cards.add(new CalendarPanel(this), CALENDAR_PANEL); 
		cards.add(new BudgetPanel(this), BUDGET_PANEL);
		cards.add(new PlanPanel(this), PLAN_PANEL); 
		setResizable(true);
		
		layout.show(cards, LOG_IN_PANEL);
		add(cards, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	/**
	 * the method represents what happens when one signs into the system
	 */
	public void handleSignIn(String userName, String pwd) {

		
		List<Person> accounts = userDB.getUsers();

		if ("guest".equals(userName) && "homestead".equals(pwd)) {
			layout.show(cards, MAIN_PANEL);
			return;
		}

		for (Person p : accounts) {
			if (p.hasPassword(pwd) && p.hasUserName(userName)) {
				layout.show(cards, MAIN_PANEL);
				loginUser = p; 
				accountDetailsPanel.setUser(p);
				return;
			}
		}

		JOptionPane.showMessageDialog(this, "Incorrect username or password");
	}

	@Override
	/**
	 * the method represents what happens when the user presses the cancel button 
	 */
	public void handleQuit() {
		setVisible(false);
		System.exit(0);
	}

	@Override
	/**
	 * the method represents what happens when the user presses the register button on the log in panel 
	 */
	public void handleRegisterRequest() {
		layout.show(cards, REGISTER_PANEL);
	}

	@Override
	/**
	 * 
	 * @param userName username of the current user used when signing in 
	 * @param password password of the current user used when signing in 
	 * @param gender gender of the current user entered when registering 
	 * @param fName first name of the current user entered when registering 
	 * @param lName last name of the current user entered when registering 
	 * @param age age of the current user entered when registering 
	 */
	public void handleRegistration(String userName, String password,
			String gender, String fName, String lName, String age) {
		int newAge = Integer.parseInt(age);
		for (Person p : users) {
			if (p.getUsername().equals(userName)) {
				JOptionPane.showMessageDialog(this,
						"Sorry, this username already exists");
			}
		}
		Person p = new Person(fName, lName, newAge, gender, userName, password);
		users.add(p);
		layout.show(cards, LOG_IN_PANEL);
		userDB.addUser(p);
	}

	@Override
	/**
	 * method that represents what happens when the user clicks the "individual button" on the main panel 
	 */
	public void handleIndividual() {
		layout.show(cards, INDIVIDUAL_OPTION_PANEL);
	}

	@Override
	/**
	 * switches the panel to the graph panel from the options panel 
	 */
	public void handleGraph() {
		layout.show(cards, PIE_PANEL);
	}

	@Override
	/**
	 * switches the panel to the WholeUI
	 */
	public void handleMoneyManage() {
		layout.show(cards, TAB_PANEL);
	}

	@Override
	/**
	 * switches the panel to the account settings panel
	 */
	public void handleSettings() {
		layout.show(cards, SETTINGS_PANEL); 
	}
	@Override
	/**
	 * moves back from the main panel
	 */
	public void handleBackOptions() {
		layout.show(cards, MAIN_PANEL);

	}

	@Override
	/**
	 * switches the panel to the instructions panel
	 */
	public void handleInstructions() {
		layout.show(cards, INSTRUCTIONS_PANEL);

	}

	@Override
	/**
	 * changes the panel to the username panel
	 */
	public void handleChangeUsername() {
		layout.show(cards, CHANGEUSER_PANEL);
	}

	@Override
	/**
	 * changes the panel to the password panel
	 */
	public void handleChangePassword() {
		layout.show(cards, CHANGEPASS_PANEL);

	}

	@Override
	/**
	 * changes the panel to the options the company manager can do when the company button is clicked 
	 */
	public void handleCompany() {
		layout.show(cards, COMPANY_OPTION_PANEL);

	}

	@Override
	/**
	 * changes the panel to the budget panel 
	 */
	public void handleBudget() {
		layout.show(cards, BUDGET_PANEL);

	}

	@Override
	/**
	 * changes the panel to the first log in screen 
	 */
	public void handleLogin() {
		// TODO Auto-generated method stub
		layout.show(cards, LOG_IN_PANEL);
	}
	
	@Override
	public void handleDetails() {
		layout.show(cards, DETAILS_PANEL);
	}
	
	@Override
	public void handleCalendar() {
		layout.show(cards, CALENDAR_PANEL);
	}
	
	@Override
	public void handlePlan() {
		layout.show(cards, PLAN_PANEL);
	}
}
