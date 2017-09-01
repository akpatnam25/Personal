package panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.PanelHandler;

import javax.swing.*;

public class MainScreenPanel extends JPanel {
	private final PanelHandler handler;
	private JButton useCalculator;
	private JLabel message;
	
	public MainScreenPanel(PanelHandler handler) {
		this.handler = handler;
		useCalculator = new JButton("Use Calculator!");
		useCalculator.setPreferredSize(new Dimension(400 , 100));
		useCalculator.setFont(new Font("Arial" , Font.ITALIC , 30));
		useCalculator.setBackground(Color.LIGHT_GRAY);
		useCalculator.setContentAreaFilled(false);
		useCalculator.setOpaque(true);
		useCalculator.addActionListener(new ButtonHandler());
		add(useCalculator);
		
		
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
	}
	
	protected void paintComponent(Graphics g) {
		Image bg = new ImageIcon("mainscreenimage.jpg").getImage();
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == useCalculator) {
				handler.handleMainScreen();
			}
		}		
	}
}
