package users;

import java.util.List;

public interface UserDB {
	
	List<Person> getUsers();
	void updateUser(String originalUserName, Person user);
	void addUser(Person user);
	

}
