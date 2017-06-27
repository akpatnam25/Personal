import java.io.*;  
import java.util.Scanner;

public class FileIO {
	private String lineSeparator;
	
	public FileIO() {
		lineSeparator = System.getProperty("line.separator");
	}
	public String readFile(String filename) { 
		BufferedReader breader = null;
		FileReader reader;
		String fileData = null;
		Scanner in = null;
		
		
		try {
			
			
			reader = new FileReader(filename);
			//BufferedReader bi = new BufferedReader(reader);
			breader = new BufferedReader(reader);
			// in = new Scanner(reader);
			in = new Scanner(breader);
			 StringBuffer changingFileData = new StringBuffer();
			while(in.hasNextLine()) {
				changingFileData.append( in.nextLine());
				changingFileData.append(lineSeparator);
			}
			
			fileData = changingFileData.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return fileData;
	}
	
	public String getLineSeparator() {
		return lineSeparator;
	}
	
	public void writeFile(String filename, String data) { 
		FileWriter writer = null;
		BufferedWriter  bwriter = null;
		
		try {
			writer = new FileWriter(filename);
			//BufferedWriter bw = new BufferedWriter(writer);
			//writer.write(data);
			//bw.write(data);
			//bw.close();
			bwriter = new BufferedWriter(writer);
			bwriter.write(data);
			bwriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // change to a better reaction
		} catch(IOException io) {
			io.printStackTrace();
		} finally {
			if (bwriter != null) {
				try {
				 bwriter.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}