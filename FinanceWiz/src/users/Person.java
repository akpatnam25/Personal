package users;

import java.util.ArrayList;

import FileIO.FileIO;
import FileIO.TextToPersonConverter;

/**
 * This class represents a Person. It has various methods to manage the person. 
 * @author Aravind Patnam , Anand Rajiv, Srini Rangarajan
 *
 */
public class Person {
	
	private String fname;
	private String lname;
	private int age;
	private String gender;
	private String username;
	private String password;
	/**
	 * Constructs a Person
	 * @param name name of the person
	 * @param age age of the person
	 * @param gender gender of the person
	 * @param username username of the person to enter the database
	 * @param password password of the person to enter the database
	 */
	public Person(String fname, String lname, int age, String gender , String username , String password) {
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	
	public int getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
		
		/*ArrayList<Person> accounts = new ArrayList<Person>(); 
		FileIO f = new FileIO(); 
		TextToPersonConverter converter = new TextToPersonConverter(); 
		String[] data = converter.getUserData(); 
		for(String d: data) {
			String[] newData = d.split("\\|"); 
			if(newData[0].equals(this.username)) {
				newData[0] = username; 
			}
			
			Person p = new Person(newData[3], newData[4], Integer.parseInt(newData[5]) ,newData[2],newData[0], newData[1]); 
			accounts.add(p); 
		}
		StringBuffer newData = new StringBuffer(""); 
		Recorder r = new Recorder(); 
		for(Person p: accounts) {
			newData.append(r.getOneLine(username, p.getPassword(), p.getGender(), p.getFirstName(), p.getLastName(), p.getAge() + "")); 
		}
		String finalData = newData.toString(); 
		f.writeFile("UserData.txt", finalData);
		*/

		
		
		
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String toString()
	{
		return username + "|" + password + "|" + gender + "|" + fname + "|" + lname + "|" + age;
	}
	
	public boolean hasUserName(String username)
	{
		if(this.username.equals(username))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasPassword(String password)
	{
		if(this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String getFirstName() {
		return fname; 
	}
	
	public String getLastName() {
		return lname; 
	}
}
