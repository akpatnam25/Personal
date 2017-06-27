import java.util.ArrayList;
public class User {
	
	private long ID;
	private int age;
	private char gender;
	private String occupation;
	private String zipCode;
	private ArrayList<Rating> ratings;
	
	public User(long ID, int age, char gender, String occupation, String zipCode) {
		ratings = new ArrayList<Rating>();
		this.ID = ID;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}

	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public String toString() {
		return "ID: " + ID + "\nAge: " + age + "\nGender: " + gender
				+ "\nOccupation: " + occupation + "\nZipCode: " + zipCode;
	}
	
	public long getUserID() {
		return ID;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public String getZipCode() {
		return zipCode;
	}
}
