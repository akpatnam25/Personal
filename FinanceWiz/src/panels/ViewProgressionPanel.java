package panels;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import management.IndividualManagement;
import dataAnalysis.PieGraph;

public class ViewProgressionPanel extends JPanel {

	private JLabel daily;
	private JLabel monthly;
	private JLabel yearly;
	
	private IndividualManagement manager;
	
	public ViewProgressionPanel() {
		manager = new IndividualManagement(TrackTransactionsPanel.balance);
		
		daily = new JLabel("Today's Expenses: " + manager.getDailyBalance());
		daily.setText("Today's Expenses: " + manager.getDailyBalance());
		daily.setPreferredSize(new Dimension(300 , 300));
		daily.setFont(new Font("Times New Roman" , Font.BOLD , 20));
		daily.setBackground(Color.RED);
		daily.setOpaque(true);
		
		monthly = new JLabel("Monthly Expenses");
		monthly.setFont(new Font("Times New Roman" , Font.BOLD , 20));
		monthly.setBackground(Color.ORANGE);
		monthly.setOpaque(true);
		
		yearly = new JLabel("Yearly Expenses");
		yearly.setFont(new Font("Times New Roman" , Font.BOLD , 20));
		yearly.setBackground(Color.GREEN);
		yearly.setOpaque(true);
		
		setLayout(new GridLayout(1 , 3));
		add(daily);
		add(monthly);
		add(yearly);
		
	}
}
