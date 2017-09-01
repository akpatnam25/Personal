package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.File;

import gpdraw.*;
import People.*;
import Animals.*;
import FileIO.CreatureTranslator;


public class SimSchoolComponent extends SketchPadPanel implements ControlListener {
	
private ArrayList <ControlListener> listeners;
	
	private  ArrayList<JCheckBox> personButtons; 
	private ArrayList<JCheckBox> studentButtons;
	private ArrayList<JCheckBox> teacherButtons;
	private ArrayList<JCheckBox> collegeStudentButtons;
	private ArrayList<JCheckBox> pigButtons;
	private ArrayList<JCheckBox> cowButtons;
	private ArrayList<JCheckBox> chickButtons;
	
	private DrawingTool marker;
	
	private ArrayList<Person> persons;
	private ArrayList<Student> students;
	private ArrayList<CollegeStudent> collegeStudents;
	private ArrayList<Teacher> teachers;
	private ArrayList<Cow> cows;
	private ArrayList<Pig> pigs;
	private ArrayList<Chick> chicks;
	
	
	public SimSchoolComponent() {	
		super(0);
		
		listeners = new ArrayList <ControlListener>();
		
		personButtons = new ArrayList<JCheckBox>();
		studentButtons = new ArrayList<JCheckBox>();
		teacherButtons = new ArrayList<JCheckBox>();
		collegeStudentButtons = new ArrayList<JCheckBox>();
		pigButtons = new ArrayList<JCheckBox>();
		cowButtons = new ArrayList<JCheckBox>();
		chickButtons = new ArrayList<JCheckBox>();
		
		
		
		marker = new DrawingTool(this);
		
		
		persons = new ArrayList<Person>();
		students = new ArrayList<Student>();
		collegeStudents = new ArrayList<CollegeStudent>();
		teachers = new ArrayList<Teacher>();
		cows = new ArrayList<Cow>();
		pigs = new ArrayList<Pig>();
		chicks = new ArrayList<Chick>();
		
		showGUI();
		
	}	
	
	public void showGUI() {
		ArrayList<Object> objects = new ArrayList<Object>();
		CreatureTranslator pt = new CreatureTranslator();
		
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"SimSchool Save File (xml) " , "xml");
		chooser.setFileFilter(filter); 
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			 objects = pt.translate(chooser.getSelectedFile().getPath());
		}
		
		Person person = null;
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Person && !(objects.get(i) instanceof Student) && !(objects.get(i) instanceof Teacher) && !(objects.get(i) instanceof CollegeStudent)) {								
				personButtons.add(new JCheckBox());				
				person = new Person(-400 , 300 - (60 * i));	
				person.setName(((Person) objects.get(i)).getName());
				person.setAge(((Person) objects.get(i)).getAge());
				person.setGender(((Person) objects.get(i)).getGender());
				person.draw(marker);
				persons.add(person);
			}			
			int xpos = person.getXPos();
			int ypos = person.getYPos();
			
			if (objects.get(i) instanceof Student && (objects.get(i) instanceof Person) && !(objects.get(i) instanceof Teacher) && !(objects.get(i) instanceof CollegeStudent)) {							
				studentButtons.add(new JCheckBox());
				Student student = new Student(xpos + 100 , ypos);
				student.setName(((Student) objects.get(i)).getName());
				student.setAge(((Student) objects.get(i)).getAge());
				student.setGender(((Student) objects.get(i)).getGender());
				student.setIdNum(((Student) objects.get(i)).getIdNum());
				student.setGPA(((Student) objects.get(i)).getGPA());
				student.draw(marker);
				students.add(student);
			}	
			
			
			if (objects.get(i) instanceof Teacher && !(objects.get(i) instanceof Student) && (objects.get(i) instanceof Person) && !(objects.get(i) instanceof CollegeStudent)) {				
				teacherButtons.add(new JCheckBox());
				
				Teacher teacher = new Teacher(xpos + 200 , ypos);
				teacher.setName(((Teacher) objects.get(i)).getName());
				teacher.setAge(((Teacher) objects.get(i)).getAge());
				teacher.setGender(((Teacher) objects.get(i)).getGender());		
				teacher.setSalary(((Teacher) objects.get(i)).getSalary());
				teacher.setSubject(((Teacher) objects.get(i)).getSubject());
				teacher.draw(marker);
				teachers.add(teacher);
			}			
			if (objects.get(i) instanceof CollegeStudent && (objects.get(i) instanceof Student) && !(objects.get(i) instanceof Teacher) && (objects.get(i) instanceof Person)) {			
				collegeStudentButtons.add(new JCheckBox());
				
				CollegeStudent collegeStudent = new CollegeStudent(xpos + 300, ypos);
				collegeStudent.setName(((CollegeStudent) objects.get(i)).getName());
				collegeStudent.setAge(((CollegeStudent) objects.get(i)).getAge());
				collegeStudent.setGender(((CollegeStudent) objects.get(i)).getGender());
				collegeStudent.setIdNum(((CollegeStudent) objects.get(i)).getIdNum());
				collegeStudent.setGPA(((CollegeStudent) objects.get(i)).getGPA());
				collegeStudent.setMajor(((CollegeStudent) objects.get(i)).getMajor());
				collegeStudent.draw(marker);
				collegeStudents.add(collegeStudent);
			}
			if (objects.get(i) instanceof Cow) {				
				cowButtons.add(new JCheckBox());			
				Cow cow = new Cow(xpos + 400 , ypos - 200);
				cow.setSound(((Cow) objects.get(i)).getSound());
				cow.setType(((Cow) objects.get(i)).getType());				
				cow.setColor(Color.BLACK);				
				cow.draw(marker);
				cows.add(cow);
			}
			
			if (objects.get(i) instanceof Pig) {				
				pigButtons.add(new JCheckBox());
				
				Pig pig = new Pig(xpos + 500 , ypos - 200);
				pig.setSound(((Pig) objects.get(i)).getSound());
				pig.setType(((Pig) objects.get(i)).getType());				
				pig.setColor(Color.BLACK);
				pig.draw(marker);
				pigs.add(pig);
			}
			
			if (objects.get(i) instanceof Chick) {
				
				
				chickButtons.add(new JCheckBox());
				
				Chick chick = new Chick(xpos + 500 , ypos - 200);
				chick.setSound(((Chick) objects.get(i)).getSound());
				chick.setType(((Chick) objects.get(i)).getType());				
				chick.setColor(Color.BLACK);
				chick.draw(marker);
				chicks.add(chick);
			}
		}		
	}
	
	public JPanel showButtons() {
		 JPanel spanel = new JPanel();
	     spanel.setLayout(new GridLayout(7,1, 100, 100));
	     
	     for (int i = 0; i < personButtons.size(); i++) {
				personButtons.get(i).setText("Person " + (i + 1));
				personButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(personButtons.get(i));
			}
			
			
			for (int i = 0; i < studentButtons.size(); i++) {
				studentButtons.get(i).setText("Student " + (i + 1));
				studentButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(studentButtons.get(i));
			}
			
			for (int i = 0; i < teacherButtons.size(); i++) {
				teacherButtons.get(i).setText("Teacher " + (i + 1));
				teacherButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(teacherButtons.get(i));
			}
			
			for (int i = 0; i < collegeStudentButtons.size(); i++) {
				collegeStudentButtons.get(i).setText("CollegeStudent " + (i + 1));
				collegeStudentButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(collegeStudentButtons.get(i));
			}
			
			for (int i = 0; i < cowButtons.size(); i++) {
				cowButtons.get(i).setText("Cow " + (i + 1));
				cowButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(cowButtons.get(i));
			}
			
			for (int i = 0; i < pigButtons.size(); i++) {
				pigButtons.get(i).setText("Pig " + (i + 1));
				pigButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(pigButtons.get(i));
			}
			
			for (int i = 0; i < chickButtons.size(); i++) {
				chickButtons.get(i).setText("Chick " + (i + 1));
				chickButtons.get(i).addActionListener(new CheckBoxHandler());
				spanel.add(chickButtons.get(i));
			}		 
		    return spanel;
	}
	
	
	
	
	public void addControlListener(ControlListener l) {
		listeners.add(l);	
	}
	
	
	class CheckBoxHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JCheckBox source = (JCheckBox) e.getSource();				
			String type = source.getText();	
			
			for (ControlListener l : listeners) {
				
				if (type.contains("Person")) {
					for (int i = 0; i < personButtons.size(); i++) {
						if (personButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
				
				if (type.contains("Student") && !type.contains("College")) {
					for (int i = 0; i < studentButtons.size(); i++) {
						if (studentButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
				
				if (type.contains("Teacher")) {
					for (int i = 0; i < teacherButtons.size(); i++) {
						if (teacherButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
				
				if (type.contains("College")) {
					for (int i = 0; i < collegeStudentButtons.size(); i++) {
						if (collegeStudentButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
				
				if (type.contains("Pig")) {
					for (int i = 0; i < pigButtons.size(); i++) {
						if (pigButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
				
				if (type.contains("Cow")) {
					for (int i = 0; i < cowButtons.size(); i++) {
						if (cowButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
				
				if (type.contains("Chick")) {
					for (int i = 0; i < chickButtons.size(); i++) {
						if (chickButtons.get(i).isSelected()) {					
							l.setColor(type, i, ControlListener.GREEN);
						} else {
							l.setColor(type, i, ControlListener.BLACK);
						}
					}
				}
			}
		}
	
	}
	
	public void showGUIDialog (String type, final String infotype) {	
		  JDialog dialog = new JDialog();		
		  dialog.setMinimumSize(new Dimension(300, 100));;
		  dialog.setLocationRelativeTo(null);
		  dialog.setModal(true);		  
		    JLabel label = new JLabel(type);
		    label.addKeyListener(new KeyAdapter(){
		      @Override
		      public void keyPressed(KeyEvent e) {
		    	  Window window = SwingUtilities.getWindowAncestor(e.getComponent());
		    	  window.dispose();
		    	  if (e.getKeyCode() == 73) {
		    		  JOptionPane.showMessageDialog(null, infotype);
		    	  }
		      }		      		      
		    });		    
		    label.setFocusable(true);
		    dialog.add(label);
		    dialog.pack();
		    dialog.setVisible(true);		   		  	    
	}
	
	@Override
	public void setColor(String type, final int index, String color) {
		String output = "";
		if (type.contains("Person")) {
			if (color == ControlListener.GREEN) {
				persons.get(index).setColor(Color.GREEN);
				persons.get(index).draw(marker);
			    output = type + ",   \n" + "Press 'i' for info";		    
			    showGUIDialog(output, persons.get(index).toString());			    
			} else {
				persons.get(index).setColor(Color.BLACK);
				persons.get(index).draw(marker);
			}			
		}
		
		if (type.contains("Student") && !type.contains("College")) {
			if (color == ControlListener.GREEN) {
				students.get(index).setColor(Color.GREEN);
				students.get(index).draw(marker);
				 output = type + ",   \n" + "Press 'i' for info";				    
				 showGUIDialog(output, students.get(index).toString());				 
			} else {				
				students.get(index).setColor(Color.BLACK);
				students.get(index).draw(marker);
			}
		}
		
		if (type.contains("Teacher")) {
			if (color == ControlListener.GREEN) {			
				teachers.get(index).setColor(Color.GREEN);
				teachers.get(index).draw(marker);
				 output = type + ",   \n" + "Press 'i' for info";				    
				 showGUIDialog(output, teachers.get(index).toString());				 
			} else {
				teachers.get(index).setColor(Color.BLACK);
				teachers.get(index).draw(marker);
			}
		}
		
		if (type.contains("College")) {
			if (color == ControlListener.GREEN) {				
				collegeStudents.get(index).setColor(Color.GREEN);
				collegeStudents.get(index).draw(marker);
				output = type + ",   \n" + "Press 'i' for info";			    
				showGUIDialog(output, collegeStudents.get(index).toString());
			} else {
				collegeStudents.get(index).setColor(Color.BLACK);
				collegeStudents.get(index).draw(marker);
			}
		}
		
		if (type.contains("Pig")) {
			if (color == ControlListener.GREEN) {
				pigs.get(index).setColor(Color.GREEN);
				pigs.get(index).draw(marker);				
				output = type + ",   \n" + "Press 'i' for info";			    
				showGUIDialog(output, pigs.get(index).toString());
			} else {
				pigs.get(index).setColor(Color.BLACK);
				pigs.get(index).draw(marker);
			}
		}
		
		if (type.contains("Cow")) {
			if (color == ControlListener.GREEN) {
				cows.get(index).setColor(Color.GREEN);
				cows.get(index).draw(marker);				
				output = type + ",   \n" + "Press 'i' for info";			    
				showGUIDialog(output, cows.get(index).toString());
			} else {
				cows.get(index).setColor(Color.BLACK);
				cows.get(index).draw(marker);
			}
		}
		
		if (type.contains("Chick")) {
			if (color == ControlListener.GREEN) {
				chicks.get(index).setColor(Color.GREEN);
				chicks.get(index).draw(marker);				
				output = type + ",   \n" + "Press 'i' for info";
				showGUIDialog(output, chicks.get(index).toString());
			} else {
				chicks.get(index).setColor(Color.BLACK);
				chicks.get(index).draw(marker);
			}
		}	
	}		
}
