import java.util.ArrayList;


public class Rating {
	private long movieID;
	private double stars;
	private long userID;
	
	public Rating(long userID, long movieID, int stars) {
		this.userID = userID;
		this.movieID = movieID;
		this.stars = stars;
	}
	
	public String toString() {
		return "Rating: " + stars;
	}
	
	public long getMovieID() { 
		return movieID;
	}
	
	public double getStars() {
		return stars;
	}
	
	public long getUserID() {
		return userID;
	}
	
	
}
