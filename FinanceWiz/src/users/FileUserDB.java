package users;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import FileIO.FileIO;

public class FileUserDB implements UserDB {
	
	private final String userFile;
	private final List<Person> users;
	
	
	public FileUserDB(String file) {
		userFile = file;
		users = lineToAccount();
	}

	@Override
	public List<Person> getUsers() {
		return users;
	}

	@Override
	public void updateUser(String originalUserName, Person user) {
		for( int i = 0; i<users.size(); i++) {
		
			Person u = users.get(i);
			if(u.getUsername().equals(originalUserName)) {
				users.set(i, user);
			}
		}
		saveUsers();
		
	}
	
	@Override
	public void addUser(Person user) {
		users.add(user);
		saveUsers();
		
	}
	
	

	private void saveUsers() {
		StringBuilder sb = new StringBuilder();
		FileIO writer = new FileIO();
		for(Person u: users) {
			sb.append(u.toString()).append(writer.getLineSeperator());
		}
		
		writer.writeFile(userFile, sb.toString());
	}

	private List<Person> lineToAccount() {
		FileIO reader = new FileIO();
		String[] userData = reader.readFile(userFile).split(
				reader.getLineSeperator());
		ArrayList<Person> users = new ArrayList<Person>();
		for (String s : userData) {
			String[] data = s.split("\\|");
			String username = data[0];
			String password = data[1];
			String gender = data[2];
			String fname = data[3];
			String lname = data[4];
			int age = Integer.parseInt(data[5]);

			Person p = new Person(fname, lname, age, gender, username, password);
			users.add(p);
		}
		return users;
	}


}
