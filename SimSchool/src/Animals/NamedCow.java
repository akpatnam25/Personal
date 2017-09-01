package Animals;

public class NamedCow extends Cow {
	private String name;
	
	public NamedCow(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return super.toString() + " " + name;
	}
}
