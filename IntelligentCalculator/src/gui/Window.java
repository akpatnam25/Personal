package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.*;

/**
 * This class represents the Window of the program, which holds all the panels.
 * @author Aravind
 *
 */
public class Window extends JFrame implements PanelHandler {
	private final JPanel cards;
	private final CardLayout layout;
	
	private static final String MAIN_SCREEN = "Main Screen";
	private static final String OPTIONS_SCREEN = "Options Screen";
	private static final String ARITHMETIC_SCREEN = "Arithmetic Calculator Screen";
	private static final String GRAPHER_SCREEN = "Grapher Screen";
	private static final String CALCULUS_SCREEN = "Calculus Calculator Screen";
	private static final String EQUATION_SCREEN = "Equation Solver Screen";
	private static final String TABLE_SCREEN = "Table Screen";
	private static final String SETTINGS_SCREEN = "Settings Screen";
	
	/**
	 * Constructs a Window.
	 */
	public Window() {
		super("Intelligent Calculator");
		
		layout = new CardLayout();
		cards = new JPanel(layout);
		
		
		cards.add(new MainScreenPanel(this) , MAIN_SCREEN);
		cards.add(new OptionsPanel(this) , OPTIONS_SCREEN);
		
		
		cards.add(new ArithmeticCalculatorPanel(this) , ARITHMETIC_SCREEN);
		
		layout.show(cards, MAIN_SCREEN);
		add(cards, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	/**
	 * Handles the change from the main screen to the options screen.
	 */
	public void handleMainScreen() {
		layout.show(cards, OPTIONS_SCREEN);
	}

	@Override
	/**
	 * Handles the change from the options screen to the Arithmetic Calculator screen.
	 */
	public void handleArithmeticCalculator() {
		layout.show(cards, ARITHMETIC_SCREEN);
	}

	@Override
	/**
	 * Handles the change from the options screen to the Grapher screen.
	 */
	public void handleGrapher() {
		layout.show(cards, GRAPHER_SCREEN);
	}

	@Override
	/**
	 * Handles the change from the options screen to the Calculus Calculator Screen.
	 */
	public void handleCalculusCalculator() {
		layout.show(cards, CALCULUS_SCREEN);
	}

	@Override
	/**
	 * Handles the change from the options screen to the equation solver screen.
	 */
	public void handleEquationSolver() {
		layout.show(cards, EQUATION_SCREEN);	
	}

	@Override
	/**
	 * Handles the change from the options screen to the table screen.
	 */
	public void handleTable() {
		layout.show(cards, TABLE_SCREEN);
	}

	@Override
	/**
	 * Handles the change from the options screen to the Settings screen.
	 */
	public void handleSettings() {
		layout.show(cards, SETTINGS_SCREEN);	
	}
}
