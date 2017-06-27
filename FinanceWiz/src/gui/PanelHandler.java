package gui;

import java.util.ArrayList;

import users.Person;

/**
 * handles the different panels in the program 
 *
 */
public interface PanelHandler {
	
	void handleSignIn(String userName, String password);
	void handleQuit();
	void handleRegisterRequest(); 
	void handleRegistration(String userName, String password, String gender, String fName, String lName, String age); 
	void handleInstructions(); 
	void handleBackOptions(); 
	void handleIndividual(); 
	void handleGraph(); 
	void handleMoneyManage();
	void handleChangeUsername(); 
	void handleChangePassword(); 
	void handleLogin(); 
	void handleBudget();
	void handleCompany();
	void handleSettings();
	void handleDetails(); 
	void handleCalendar(); 
	void handlePlan(); 

}