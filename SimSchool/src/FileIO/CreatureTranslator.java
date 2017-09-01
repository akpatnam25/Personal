package FileIO;
import People.*;

import java.util.*;
import java.io.*;

import Animals.*;
/**
 * 
 * @author Aravind Patnam
 *
 */
public class CreatureTranslator {
	// ArrayLists to hold details of each type of person
	private ArrayList<String> personsAL;
	private ArrayList<String> teachersAL;
	private ArrayList<String> collegeStudentsAL;
	private ArrayList<String> studentsAL;
	private ArrayList<String>animalsAL;
	
	// ArrayList to hold the objects of the people
	private ArrayList<Object> objects;
	
	public CreatureTranslator() {
		personsAL = new ArrayList<String>();;
		teachersAL = new ArrayList<String>();
		collegeStudentsAL = new ArrayList<String>();
		studentsAL = new ArrayList<String>();
		animalsAL = new ArrayList<String>();
		
		objects = new ArrayList<Object>();
	}
	
	public ArrayList<Object> translate(String filename) {
		BufferedReader breader = null;
		FileReader reader = null;
		Scanner in = null;
		BufferedWriter bwriter = null;
		String input = " ";
		boolean personStart = false;
		boolean teacherStart = false;
		boolean collegeStudentStart = false;
		boolean studentStart = false;
		boolean animalStart = false;
		String changingString = "";
		
		try {		
			reader = new FileReader(filename);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
			while (in.hasNextLine()) {
				 input = in.nextLine();								 
			 
				 //Get Person details				 
				 if (input.matches("<Person>")) 
					 personStart = true;			  
				 if (personStart) {
					changingString = loadPerson(input);
					
					if (changingString != "") {
						personsAL.add(changingString);
					}

				 }				 
				 if (input.matches("</Person>")) {
					 personStart = false;					 
					int intAge = Integer.parseInt(personsAL.get(1));
					Person person = new Person(personsAL.get(0), intAge, personsAL.get(2));					
					objects.add(person);
					personsAL.clear();
					
				 }
				 
				 //Get Teacher  details
				 if (input.matches("<Teacher>")) 
					 teacherStart = true;				  
				 if (teacherStart) {
					changingString =  loadTeacher(input);	
					if (changingString != "")
						teachersAL.add(changingString);
				 }
				 if(input.matches("</Teacher>")) {
					 teacherStart = false;
					 int intAge = Integer.parseInt(teachersAL.get(1));
					 double doubleSalary = Double.parseDouble(teachersAL.get(4));
					 Teacher teacher = new Teacher(teachersAL.get(0) , intAge , teachersAL.get(2), teachersAL.get(3) , doubleSalary);
					 objects.add(teacher);
					 teachersAL.clear();					 
				 }
				 
				 // Get CollegeStudent Details				 
				 if (input.matches("<CollegeStudent>"))
					 collegeStudentStart = true;
				 if (collegeStudentStart) {
					 changingString = loadCollegeStudent(input);
					 if (changingString != "")
						 collegeStudentsAL.add(changingString);
				 }
				 if (input.matches("</CollegeStudent>")) {
					 collegeStudentStart = false;
					 int intAge = Integer.parseInt(collegeStudentsAL.get(1));
					 double doubleGPA = Double.parseDouble(collegeStudentsAL.get(4));
					 int intYear = Integer.parseInt(collegeStudentsAL.get(5));
					 CollegeStudent collegeStudent = new CollegeStudent(collegeStudentsAL.get(0) , intAge , collegeStudentsAL.get(2), collegeStudentsAL.get(3), doubleGPA, intYear, collegeStudentsAL.get(6));
					 objects.add(collegeStudent);
					 collegeStudentsAL.clear();
				 }
				 
				 // Get Student Details
				 if (input.matches("<Student>"))
					 studentStart = true;
				 if (studentStart) {
					 changingString = loadStudent(input);
					 if (changingString != "")
						 studentsAL.add(changingString);
				 }
				 if (input.matches("</Student>")) {
					 studentStart = false;
					 int intAge = Integer.parseInt(studentsAL.get(1));
					 double doubleGPA = Double.parseDouble(studentsAL.get(4));
					 Student student = new Student(studentsAL.get(0) , intAge , studentsAL.get(2) , studentsAL.get(3) , doubleGPA);
					 objects.add(student);
					 studentsAL.clear();
				 }
				 
				 // Get Animal Details
				 if (input.matches("<Animal>")) {
					 animalStart = true;
				 }
				 if (animalStart) {
					 changingString = loadAnimal(input);
					 if (changingString != "")
						 animalsAL.add(changingString);
				 }
				 
				 if (input.matches("</Animal>")) {
					 animalStart = false;					 
					 if (animalsAL.get(0).equals("Pig")) {
						 Pig pig = new Pig(animalsAL.get(0), animalsAL.get(1));
						 objects.add(pig);
					 } else if (animalsAL.get(0).equals("Cow")) {
						 Cow cow = new Cow(animalsAL.get(0) , animalsAL.get(1));
						 objects.add(cow);
					 } else if (animalsAL.get(0).equals("Chick")) {
						 Chick chick = new Chick(animalsAL.get(0) , animalsAL.get(1));
						 objects.add(chick);
					 }
					 animalsAL.clear();
				 }
			}
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
		return objects;
	}
	
	private String loadPerson(String input) {
		if (input.matches("<age>([^<]*)</age>")) {
			  String age = input.replaceAll("<age>([^<]*)</age>", "$1");
			 return age;
		} 
		
		if (input.matches("<name>([^<]*)</name>")) {
		  String name = input.replaceAll("<name>([^<]*)</name>", "$1");
		 return name;
		}
		
		if (input.matches("<gender>([^<]*)</gender>")) {
		  String gender = input.replaceAll("<gender>([^<]*)</gender>", "$1");
		 return gender;
		}		
		return "";
	}
	
	private String loadTeacher(String input) {
		if (input.matches("<age>([^<]*)</age>")) {
			  String age = input.replaceAll("<age>([^<]*)</age>", "$1");
			  return age;
		} 
		
		if (input.matches("<name>([^<]*)</name>")) {
		  String name = input.replaceAll("<name>([^<]*)</name>", "$1");
		  return name;
		}
		
		if (input.matches("<gender>([^<]*)</gender>")) {
		  String gender = input.replaceAll("<gender>([^<]*)</gender>", "$1");
		  return gender;
		}
		
		if (input.matches("<subject>([^<]*)</subject>")) {
			  String subject = input.replaceAll("<subject>([^<]*)</subject>", "$1");
			  return subject;
			}
		
		if (input.matches("<salary>([^<]*)</salary>")) {
			  String salary = input.replaceAll("<salary>([^<]*)</salary>", "$1");
			  return salary;
		}
		return "";
	}
	
	private String loadCollegeStudent(String input) {
		if (input.matches("<age>([^<]*)</age>")) {
			  String age = input.replaceAll("<age>([^<]*)</age>", "$1");
			  return age;
		} 
		
		if (input.matches("<name>([^<]*)</name>")) {
		  String name = input.replaceAll("<name>([^<]*)</name>", "$1");
		  return name;
		}
		
		if (input.matches("<gender>([^<]*)</gender>")) {
		  String gender = input.replaceAll("<gender>([^<]*)</gender>", "$1");
		  return gender;
		}
		
		if (input.matches("<ID>([^<]*)</ID>")) {
			  String ID = input.replaceAll("<ID>([^<]*)</ID>", "$1");
			  return ID;
		}
		
		if (input.matches("<GPA>([^<]*)</GPA>")) {
			  String GPA = input.replaceAll("<GPA>([^<]*)</GPA>", "$1");
			  return GPA;
		}
		
		if (input.matches("<year>([^<]*)</year>")) {
			  String year = input.replaceAll("<year>([^<]*)</year>", "$1");
			  return year;
		}
		
		if (input.matches("<major>([^<]*)</major>")) {
			  String major = input.replaceAll("<major>([^<]*)</major>", "$1");
			  return major;
		}
		return "";
	}
	
	private String loadStudent(String input) {
		if (input.matches("<age>([^<]*)</age>")) {
			  String age = input.replaceAll("<age>([^<]*)</age>", "$1");
			  return age;
		} 
		
		if (input.matches("<name>([^<]*)</name>")) {
			  String name = input.replaceAll("<name>([^<]*)</name>", "$1");
			  return name;
		}
			
		if (input.matches("<gender>([^<]*)</gender>")) {
			  String gender = input.replaceAll("<gender>([^<]*)</gender>", "$1");
			  return gender;
		}
		
		if (input.matches("<ID>([^<]*)</ID>")) {
			  String ID = input.replaceAll("<ID>([^<]*)</ID>", "$1");
			  return ID;
		}
		
		if (input.matches("<GPA>([^<]*)</GPA>")) {
			  String GPA = input.replaceAll("<GPA>([^<]*)</GPA>", "$1");
			  return GPA;
		}
		return "";
	}
	
	private String loadAnimal(String input) {
		if (input.matches("<type>([^<]*)</type>")) {
			  String type = input.replaceAll("<type>([^<]*)</type>", "$1");
			  return type;
		} 
		
		if (input.matches("<sound>([^<]*)</sound>")) {
			  String sound = input.replaceAll("<sound>([^<]*)</sound>", "$1");
			  return sound;
		}
		return "";
	}
}

