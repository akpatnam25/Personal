package GUI;

import gpdraw.SketchPad;
import gpdraw.SketchPadPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimSchoolWindow extends JFrame {
	
	public SimSchoolWindow() {
		super();
		
		setBounds(0, 0, 2000, 2000);
		
		SimSchoolComponent drawingPanel = new SimSchoolComponent();
		
		JPanel buttonPanel = drawingPanel.showButtons();
		
		setLayout(new BorderLayout());
		
		add(drawingPanel , BorderLayout.CENTER);
		add(buttonPanel , BorderLayout.EAST);
		
		drawingPanel.addControlListener(drawingPanel);
		
		setResizable(true);
		revalidate();
	}

}
