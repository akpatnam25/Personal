package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.PanelHandler;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import computations.Arithimetic;

public class ArithmeticCalculatorPanel extends JPanel {
	private final PanelHandler handler;
	private JLabel display;
	private JButton[] calcButtons;
	
	private JPanel displayPanel;
	private JPanel buttonPanel;
	
	private String text;
	private String enter;
	
	private boolean isAdd;
	private boolean isSubtract;
	private boolean isMultiply;
	private boolean isDivide;
	
	private Arithimetic aCalc;
	
	
	public ArithmeticCalculatorPanel(PanelHandler handler) {
		super();
		
		this.handler = handler;
		
		isAdd = false;
		isSubtract = false;
		isMultiply = false;
		isDivide = false;
		
		aCalc = new Arithimetic();
		
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4 , 5 , 30 , 50));
		calcButtons = new JButton[20];
		calcButtons[0] = new JButton("1");
		calcButtons[1] = new JButton("2");
		calcButtons[2] = new JButton("3");
		calcButtons[3] = new JButton("4");
		calcButtons[4] = new JButton("5");
		calcButtons[5] = new JButton("6");
		calcButtons[6] = new JButton("7");
		calcButtons[7] = new JButton("8");
		calcButtons[8] = new JButton("9");
		calcButtons[9] = new JButton("0");
		calcButtons[10] = new JButton("+");
		calcButtons[11] = new JButton("-");
		calcButtons[12] = new JButton("x");
		calcButtons[13] = new JButton("/");
		calcButtons[14] = new JButton("(-)");
		calcButtons[15] = new JButton("DEL");
		calcButtons[16] = new JButton("AC");
		calcButtons[17] = new JButton(".");
		calcButtons[18] = new JButton("=");
		calcButtons[19] = new JButton("Back");

		for (int i = 0; i < calcButtons.length; i++) {
			calcButtons[i].setFont(new Font("Times New Roman" , Font.BOLD , 30));
			calcButtons[i].setPreferredSize(new Dimension(250 , 100));
			calcButtons[i].addActionListener(new ButtonHandler());
			buttonPanel.add(calcButtons[i]);
		}
		
		text = "";
		displayPanel = new JPanel();
		display = new JLabel(text);
		display.setPreferredSize(new Dimension(1350 , 100));
		display.setFont(new Font("Times New Roman" , Font.BOLD , 30));
		display.setBackground(Color.YELLOW);
		display.setOpaque(true);
		displayPanel.add(display);
		
		add(displayPanel);
		
		add(buttonPanel , BorderLayout.CENTER);
	}
	
	private void updateDisplayPanel(String enter) {
		this.enter = enter;
		text += (enter);
		display.setText("    " + text);
	}
	
	private void delete(String newText) {
		
	}
	
	class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == calcButtons[0])
				updateDisplayPanel("1");
			else if (source == calcButtons[1]) 
				updateDisplayPanel("2");
			else if (source == calcButtons[2]) 
				updateDisplayPanel("3");
			else if (source == calcButtons[3])
				updateDisplayPanel("4");
			else if (source == calcButtons[4]) 
				updateDisplayPanel("5");
			else if (source == calcButtons[5]) 
				updateDisplayPanel("6");
			else if (source == calcButtons[6]) 
				updateDisplayPanel("7");
			else if (source == calcButtons[7]) 
				updateDisplayPanel("8");
			else if (source == calcButtons[8]) 
				updateDisplayPanel("9");
			else if (source == calcButtons[9]) 
				updateDisplayPanel("0");
			else if (source == calcButtons[10]) {
				updateDisplayPanel("+");
				isAdd = true;
			}
			else if (source == calcButtons[11]) {
				updateDisplayPanel("-");
				isSubtract = true;
			}
			else if (source == calcButtons[12]) {
				updateDisplayPanel("x");
				isMultiply = true;
			}
			else if (source == calcButtons[13]) {
				updateDisplayPanel("/");
				isDivide = true;
			}
			else if (source == calcButtons[14]) 
				updateDisplayPanel("-");
			else if (source == calcButtons[15]) 
				delete(""); // still not working
			else if (source == calcButtons[16]) {
				display.setText("");
			}
			else if (source == calcButtons[17]) 
				updateDisplayPanel(".");
			else if (source == calcButtons[18]) {
				
			}
			else if (source == calcButtons[19]) 
				handler.handleMainScreen();
		}
	}
}
