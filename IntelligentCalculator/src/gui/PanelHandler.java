package gui;

/**
 * Interface to handle the changing of all the panels in the program. This interface is implemented by several
 * other panels in the program.
 * @author Aravind
 *
 */
public interface PanelHandler {
	
	void handleMainScreen();
	void handleArithmeticCalculator();
	void handleGrapher();
	void handleCalculusCalculator();
	void handleEquationSolver();
	void handleTable();
	void handleSettings();
}
