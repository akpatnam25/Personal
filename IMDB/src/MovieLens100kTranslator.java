import java.util.ArrayList;


public class MovieLens100kTranslator {
	public User lineToUser(String line) {
		String[] data = line.split("\\|");
		long userID = Long.parseLong(data[0]);
		int age = 0;
		if (data[1].length() > 0)
			age = Integer.parseInt(data[1]);
		char gender = 'U';
		if (data[2].length() > 0)
			gender = data[2].charAt(0);		
		User user = new User(userID, age, gender, data[3], data[4]);
		return user;
	}
	
	public Movie lineToMovie(String line) {
		String[] data = line.split("\\|");
        long id = Long.parseLong(data[0]);       
        String title = "";
        if(data[1].length() > 0)
            title = data[1];       
        String[] genres = new String[19];
        
        for(int i = 5; i < data.length; i++) {
            genres[i-5] = data[i];
        }       
        Movie movie = new Movie(id, title, genres);
        return movie;
	}
	
	public Rating lineToRating(String line) { 
		 String[] data = line.split("	");	        
	        int movieID = Integer.parseInt(data[1]);
	        int rating = Integer.parseInt(data[2]);
	        long userID = Integer.parseInt(data[0]);	        
	        Rating r = new Rating(userID,movieID, rating);
	        return r;
	}
}