import java.io.*;
import java.util.Scanner;

public class FileIO {
	private String lineSeparator;
	
	public FileIO() {
		lineSeparator = System.getProperty("line.separator");
	}
	public String readFile(String filename) { 
		FileReader reader;
		String fileData = null;
		Scanner in = null;
		
		try {
			reader = new FileReader(filename);
			 in = new Scanner(reader);
			 StringBuffer changingFileData = new StringBuffer();
			while(in.hasNextLine()) {
				changingFileData.append( in.nextLine() + lineSeparator);
			}
			
			fileData = changingFileData.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
		return fileData;
	}
	
	public String getLineSeparator() {
		return lineSeparator;
	}
}