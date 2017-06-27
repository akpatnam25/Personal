package management;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.swing.JOptionPane;

import users.*;

/**
 * manages the individual aspect of the program
 *
 */
public class IndividualManagement {
	
	/*
	 * track account for Checking accnt, investment, and savings
	 * track saving by entering transactions
	 * schedule income 
	 * create a budget
	 * create a custom calendar
	 * 
	 * https://secure.budgettracker.com/login.php?sp=nouser
	 */
	private ArrayList<Account> accounts;
	private double balance;
	private ArrayList <Item> items;
	private ArrayList<Event> events;
	private double investmentValue;
	private static final Calendar cal = Calendar.getInstance();
	
	/**
	 * constructs an individual manager
	 * @param currentBalance is the balance the account has right now.  
	 */
	public IndividualManagement(double currentBalance) {
		accounts = new ArrayList<Account>();
		items = new ArrayList<Item>();
		balance = currentBalance;
		events = new ArrayList<Event>(); 
	}
	
	public IndividualManagement(double investmentValue , boolean check) {
		this.investmentValue = investmentValue;
	}
	/**
	 * allows for accessibility to a specific checking account of the individual
	 * @param amount amount of money added to the certain account 
	 * @param account account that the money is added to 
	 */
	public void addMoneyToSpecificAccount(double amount , Account account) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(account.getName()))
				accounts.get(i).deposit(amount);
		}
	}
	
	/**
	 * allows for accessibility to a specific checking account of the individual
	 * @param amount amount of money removed from the account 
	 * @param account the account that the money is removed from
	 */
	public void removeMoneyFromSpecificAccount(double amount , Account account) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(account.getName()))
				accounts.get(i).withdraw(amount);
		}
	}
	
	/**
	 * adds to a generic transaction tracker made within the program
	 * @param amount takes away an amount of money when the transaction is mad 
	 * @param place where the money was spent 
	 * @param itemOrService what the money was spent on 
	 */
	public void addTransaction(double amount , String place , String itemOrService) {
		balance -= amount;
	    Date date = new Date();
	    DateFormat f = new SimpleDateFormat("MM/dd/yyyy" , Locale.US);
	    String formattedDate = f.format(date);
	    Random r = new Random(System.currentTimeMillis());
	    int id =  (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
		Item item = new Item(itemOrService , amount , place , formattedDate , id);
		items.add(item);
	}
	
	public void addEvent(String event, String date) {
		Event e = new Event(event, date); 
		events.add(e); 
	}
	
	/**
	 * removes from a generic transaction tracker made within the program
	 * @param id the id of the item to be removed 
	 */
	public void removeTransaction(int id) {
		for (int i = 0 ; i < items.size(); i++) {
			if (items.get(i).getID() == id) {
				balance += items.get(i).getPrice();
				items.remove(i);
			}
		}
	}
	
	public void removeEvent(Event event) {
		for(int i = 0; i < events.size(); i++) {
			if(events.get(i).getEvent().equals(event.getEvent())) {
				events.remove(i); 
			}
		}
	}
	
	// entered in the order of MM/DD/YYYY
	public void changeDate(String name , String dateEntered) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				String date = parseString(dateEntered);
				items.get(i).setDate(date);
			}
		}
	}
	
	private String parseString(String dateEntered) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String formattedDate = "";
		try {	 
			date = formatter.parse(dateEntered);	
			DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
			formattedDate = f.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formattedDate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double bal) {
		System.out.println(bal);
		balance = bal;
	}
	
	public ArrayList <Item> getItems() {
		return items;
	}
	
	public ArrayList<Event> getEvents() {
		return events; 
	}
	
	public double getDailyBalance() {
		if (isNewDay())
			return 10;
		else
			return balance;
	}
	
	private boolean isNewDay() {
		Calendar c = Calendar.getInstance();
		int hours = c.get(Calendar.HOUR_OF_DAY);
		int minutes = c.get(Calendar.MINUTE);
		int seconds = c.get(Calendar.SECOND);

		if(hours*3600 + minutes*60 + seconds < 1800){
		    return true;
		}
		return false;
	}
	
	public void addStock(String name , double price , String boughtFrom , int numShares) {
		investmentValue -= price;
	    Date date = new Date();
	    DateFormat f = new SimpleDateFormat("MM/dd/yyyy" , Locale.US);
	    String formattedDate = f.format(date);
	    Random r = new Random(System.currentTimeMillis());
	    int id =  (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
		Item item = new Item(name , price , boughtFrom , formattedDate , numShares , id);
		items.add(item);
	}
	
	public void removeStock(int id) {
		for (int i = 0 ; i < items.size(); i++) {
			if (items.get(i).getID() == id) {
				investmentValue += items.get(i).getPrice();
				items.remove(i);
			}
		}
	}
	
}
