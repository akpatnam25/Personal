/**
 * Aravind Patnam
 * Lab: Crypt
 * 02/11/2015
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Crypt {

	public static final String keyword = "crypt";
	private static final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',	'u', 'v', 'w', 'x', 'y', 'z' };
	private ArrayList<Character> cipheredLetters;
	
	public Crypt() {
		cipheredLetters = new ArrayList<Character>();
	}

	public String lineSeparator = System.getProperty("line.separator");

	public void encrypt(String inputFilename, String outputFilename,String keyword) {
		String keyWordLowerCase = keyword.toLowerCase();
		String keywordMod = keyWordLowerCase.replaceAll("(.)(?=(.*))(?<=(?=\\1.*?\\1\\2$).+)","");
		
		
		StringBuffer keywordBuffer = new StringBuffer(keywordMod);		
		for (int i = 0; i < keywordBuffer.length(); i++) {
			
			cipheredLetters.add(keywordBuffer.charAt(i));
		}
		
		for (int j = 122; j >= 97; j--) {
			if (!cipheredLetters.contains((char)j)) {
				cipheredLetters.add((char)j);
			}
		}
		BufferedReader breader = null;
		FileReader reader = null;
		Scanner in = null;

		BufferedWriter bwriter = null;
		FileWriter writer = null;

		try {
			reader = new FileReader(inputFilename);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);

			writer = new FileWriter(outputFilename);
			bwriter = new BufferedWriter(writer);

			while (in.hasNextLine()) {
				String input = in.nextLine();
				StringBuffer changableData = new StringBuffer(input);
				changableData.append(lineSeparator);

				// ENCRYPT THE LINE
				StringBuffer outBuffer = new StringBuffer();

				for (int i = 0; i < changableData.length(); i++) {
					char letter = changableData.charAt(i);
					if (Character.isUpperCase(letter)) {
						for (int j = 0; j < letters.length; j++) {
							if (Character.toUpperCase(letters[j]) == letter) {
								letter = Character.toUpperCase(cipheredLetters.get(j));
								outBuffer.append(letter);
								break;
							}
						}
					} else if (Character.isLowerCase(letter)) {
						for (int j = 0; j < letters.length; j++) {
							if (letters[j] == letter) {
								letter = cipheredLetters.get(j);
								outBuffer.append(letter);
								break;
							}
						}
					} else {
						outBuffer.append(letter);
					}
				}
				bwriter.write(outBuffer.toString());
			}
			bwriter.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (bwriter != null) {
				try {
					bwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void decrypt(String inputFilename, String outputFilename, String keyword) {
		String keyWordLowerCase = keyword.toLowerCase();
		String keywordMod = keyWordLowerCase.replaceAll("(.)(?=(.*))(?<=(?=\\1.*?\\1\\2$).+)","");
		
		
		StringBuffer keywordBuffer = new StringBuffer(keywordMod);		
		for (int i = 0; i < keywordBuffer.length(); i++) {
			
			cipheredLetters.add(keywordBuffer.charAt(i));
		}
		
		for (int j = 122; j >= 97; j--) {
			if (!cipheredLetters.contains((char)j)) {
				cipheredLetters.add((char)j);
			}
		}
		BufferedReader breader = null;
		FileReader reader = null;
		Scanner in = null;
		BufferedWriter bwriter = null;
		FileWriter writer = null;

		try {
			reader = new FileReader(inputFilename);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
			writer = new FileWriter(outputFilename);
			bwriter = new BufferedWriter(writer);
			while (in.hasNextLine()) {
				String input = in.nextLine();
				StringBuffer changableData = new StringBuffer(input);
				changableData.append(lineSeparator);

				// DECRYPT THE LINE

				StringBuffer outBuffer = new StringBuffer();
				for (int i = 0; i < changableData.length(); i++) {
					char letter = changableData.charAt(i);
					if (Character.isUpperCase(letter)) {
						for (int j = 0; j < cipheredLetters.size(); j++) {
							if (Character.toUpperCase(cipheredLetters.get(j)) == letter) {
								letter = Character.toUpperCase(letters[j]);
								outBuffer.append(letter);
								break;
							}
						}
					} else if (Character.isLowerCase(letter)) {
						for (int j = 0; j < cipheredLetters.size(); j++) {
							if (cipheredLetters.get(j) == letter) {
								letter = letters[j];
								outBuffer.append(letter);
								break;
							}
						}
					} else {
						outBuffer.append(letter);
					}
				}

				bwriter.write(outBuffer.toString());
			}
			bwriter.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
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
