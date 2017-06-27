import java.util.ArrayList;


public class Main {
	
	public static void main(String [] args) {
		FileIO reader = new FileIO();
		String userData = reader.readFile("u.user");
		String movieData = reader.readFile("u.item");
		String ratingData = reader.readFile("u.data");
		
		String userLineData[] =  userData.split(reader.getLineSeparator());
		String movieLineData[] =  movieData.split(reader.getLineSeparator());
		String ratingLineData[] =  ratingData.split(reader.getLineSeparator());
		
		ArrayList <User> users = new ArrayList<User>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		
		MovieLens100kTranslator translator = new MovieLens100kTranslator();
		
		for (String s : userLineData) {
			User u = translator.lineToUser(s);
			users.add(u);
		}
		
		for (String s : movieLineData) {
			Movie m = translator.lineToMovie(s);
			movies.add(m);
		}
		
		for (String s : ratingLineData) {
			Rating r = translator.lineToRating(s);
			ratings.add(r);
		}
		
		for (User u : users) {
			System.out.println(u);
		}
		
		for (Movie m : movies) {
			System.out.println(m);
		}
		
		for (Rating r : ratings) {
			System.out.println(r);
		}
		
		System.out.println(users);
		System.out.println(movies);
		//System.out.println(ratings);
		
	}
}

