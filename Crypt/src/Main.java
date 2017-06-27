// original tester
public class Main {
	
	public static void main(String[] args) {
		
		FileIO accessor = new FileIO();
		
		String data = accessor.readFile("Romeo.txt");
		
		Crypt c = new Crypt();
		
		
		c.encrypt("Romeo.txt", "RomeoEncrypt.txt", "crypt");
		
		//c.decrypt("RomeoEnc1.txt", "RomeoDecrypt.txt", "crypt");
		
		
		
		accessor.writeFile("Romeo.txt", data);
	} 
	

}
