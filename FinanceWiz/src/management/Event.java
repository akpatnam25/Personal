package management;

public class Event {

	private String event; 
	private String date; 
	
	public Event(String event, String date) {
		this.event = event; 
		this.date = date; 
	}
	
	public String getEvent() {
		return event; 
	}
	
	public String getDate() {
		return date; 
	}
	
	public void setDate(String date) {
		this.date = date; 
	}
	
	public void setEvent(String event) {
		this.event = event; 
	}
}
