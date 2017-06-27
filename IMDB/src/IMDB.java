import java.util.ArrayList;
/**
 * @author Aravind Patnam
 * Lab IMDB
 *
 */

public class IMDB {

	private static final String usersFile = "u.user";
	private static final String moviesFile = "u.item";

	// Add fields to represent your database.
	private String userData;
	private String movieData;
	private String ratingData;
	
	private String [] userLineData;
	private String [] movieLineData;
	private String [] ratingLineData;
	
	
	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<Rating> ratings;
	
	/**
	 * Use ratingsFile to read all data into some local structures.
	 * 
	 * @param ratingsFile The filename of the ratings database.
	 */
	public IMDB(String ratingsFile) {
		FileIO reader = new FileIO();
		userData = reader.readFile(usersFile);
		movieData = reader.readFile(moviesFile);
		ratingData = reader.readFile(ratingsFile);
		
		  userLineData =  userData.split(reader.getLineSeparator());
		  movieLineData =  movieData.split(reader.getLineSeparator());
		  ratingLineData =  ratingData.split(reader.getLineSeparator());
		
		 users = new ArrayList<User>();
		 movies = new ArrayList<Movie>();
		 ratings = new ArrayList<Rating>();
		
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
		
	}
	
	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() {
		return movies.toArray(); 
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() {
		return users.toArray();
	}

	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(long userID, long movieID) {
		for (int i = 0; i < ratings.size(); i++) {
			if (ratings.get(i).getMovieID() == movieID && ratings.get(i).getUserID() == userID)
				return ratings.get(i).getStars();
		}
		return -1;
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(long userID, long movieID) {
		/* UNCOMMENT IF BELOW CODE DOES NOT FIT EXACT REQUIRMENTS OF LAB */
		
		
		/*
		double total = 0;
		double count = 0;
		double rating = getRating(userID , movieID);
		
		
		for (int i = 0; i < ratings.size(); i++) {
			if (ratings.get(i).getMovieID() == movieID) {
				total = total +  ratings.get(i).getStars();
				count++;
			}
			if (ratings.get(i).getUserID() == userID) {
				total = total + ratings.get(i).getStars();
				count++;
			}			
		}
		double avg = total / count;
				
		return avg;
		*/
		
		// CODE THAT WILL RUN WHEN YOU RUN IT AS OF NOW
		double total = 0, r_total = 0;
		double count = 0, r_count = 0;
		double rating = getRating(userID , movieID);
		
		int age = users.get((int) userID-1).getAge();
		char gender = users.get((int) userID-1).getGender();
		String occupation = users.get((int) userID-1).getOccupation();
		String zipCode = users.get((int) userID-1).getZipCode();
		
		for (int i = 0; i < ratings.size(); i++) {
			long r_movieID = ratings.get(i).getMovieID();
			long r_userID = ratings.get(i).getUserID();
			
			int r_age = users.get((int) r_userID-1).getAge();
			char r_gender = users.get((int) r_userID-1).getGender();
			String r_occupation = users.get((int) r_userID-1).getOccupation();
			String r_zipCode = users.get((int) r_userID-1).getZipCode();
			
			if (r_movieID == movieID) {
				total = total +  ratings.get(i).getStars();
				count++;
				
				// get ratings from similar gender for this movie
				if (r_gender == gender) {				
					r_total = r_total +  ratings.get(i).getStars();
					r_count++;
				}
				
				// get ratings from age group and older for this movie
				if (age >= r_age) {					
					r_total = r_total +  ratings.get(i).getStars();
					r_count++;
				}
				
				// get ratings from similar occupation for this movie
				if (r_occupation == occupation) {
					r_total = r_total +  ratings.get(i).getStars();
					r_count++;
				}
				
				// get ratings from similar zipcode for this movie
				if (r_zipCode == zipCode) {
					r_total = r_total +  ratings.get(i).getStars();
					r_count++;
				}
				
			}
			if (r_userID  == userID) {
				total = total + ratings.get(i).getStars();
				count++;
			}	
								
		}		
		double r_avg = r_total / r_count;
		double avg = total / count;
		r_avg = Math.round(r_avg);
		avg =  Math.round(avg);
		if(r_avg > avg)
			return r_avg;
		else
			return avg;
		}			
	}	

