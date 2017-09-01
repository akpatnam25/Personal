package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.PanelHandler;

public class OptionsPanel extends JPanel {
	
	private final PanelHandler handler;
	private JButton[] optionButtons;
	
	public OptionsPanel(PanelHandler handler) {
		this.handler = handler;
		setLayout(new GridLayout(2 , 2 , 10 , 10));
		optionButtons = new JButton[6];
		optionButtons[0] = new JButton("ARITHMETIC CALCULATOR");
		optionButtons[1] = new JButton("GRAPHER");
		optionButtons[2] = new JButton("CALCULUS CALCULATOR");
		optionButtons[3] = new JButton("EQUATION SOLVER");
		optionButtons[4] = new JButton("TABLE");
		optionButtons[5] = new JButton("SETTINGS");
		for (int i = 0; i < optionButtons.length; i++) {
			optionButtons[i].setFont(new Font("Arial" , Font.ITALIC , 20));
			optionButtons[i].setBackground(Color.PINK);
			optionButtons[i].setContentAreaFilled(false);
			optionButtons[i].setOpaque(true);
			optionButtons[i].addActionListener(new ButtonHandler());
			add(optionButtons[i]);
		}
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();;
			if (source == optionButtons[0])
				handler.handleArithmeticCalculator();
			else if (source == optionButtons[1]) 
				handler.handleGrapher();
			else if (source == optionButtons[2])
				handler.handleCalculusCalculator();
			else if (source == optionButtons[3])
				handler.handleEquationSolver();
			else if (source == optionButtons[4]) 
				handler.handleTable();
			else if (source == optionButtons[5])
				handler.handleSettings();
		}		
	}
}	
