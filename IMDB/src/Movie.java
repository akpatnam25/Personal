import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Movie {
	
	private String title;
	private long id;
	
	private String[] genres;
	
	public Movie(long id, String title, String[] genres) {
		this.genres = genres;
		this.title = title;
		this.id = id;
		
		genres = new String[19];
		genres[0] = "Unknown";
		genres[1] = "Action";
		genres[2] = "Adventure";
		genres[3] = "Animation";
		genres[4] = "Children's";
		genres[5] = "Comedy";
		genres[6] = "Crime";
		genres[7] = "Documentary";
		genres[8] = "Drama";
		genres[9] = "Fantasy";
		genres[10] = "Film-Noir";
		genres[11] = "Horror";
		genres[12] = "Musical";
		genres[13] = "Mystery";
		genres[14] = "Romance";
		genres[15] = "Sci-Fi";
		genres[16] = "Thriller";
		genres[17] = "War";
		genres[18] = "Western";
		
	}
	
	public String toString() {
		return "Genre: " + Arrays.toString(genres) + "\nTitle: " + title + "\nID: " + id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public long getMovieID() {
		return id;
	}
	
}
