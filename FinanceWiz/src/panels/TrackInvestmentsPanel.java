package panels;

import gui.PanelHandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import panels.TrackTransactionsPanel.ButtonHandler;

public class TrackInvestmentsPanel extends JPanel {
	/*
	* DO THIS CLASS. COPY PASTE FROM TRACKTRANSACTIONSPANEL!!! ADD "ADD STOCK , REMOVE STOCK , ADD BOND, REMOVE BOND" IN INDIVIDUALMANANGEMENT. UPDATE ITEM IF NEEDED.
	*/
	private final PanelHandler handler; 
	private JButton addStock;
	private JButton removeStock;
	private JButton addBond;
	private JButton removeBond;
	
	private JLabel totalInvestmentsLabel;
	int indexinvRow = 0;
	private int indexinvCol = 0;
	JTable invtable;
	public static int totalInvBal;
	private boolean tablePanelExist;
	
	public TrackInvestmentsPanel(PanelHandler handler) {
		super();
		this.handler = handler;
		ActionListener a = new InvButtonHandler();
		
		addStock = new JButton("Add Stock");
		addStock.addActionListener(a);
		
		removeStock = new JButton("Remove Stock");
		removeStock.addActionListener(a);
		
		addBond = new JButton("Add Bond");
		addBond.addActionListener(a);
		
		removeBond = new JButton("Remove Bond");
		removeBond.addActionListener(a);
		
		totalInvestmentsLabel = new JLabel("Total Investments:    $" + gettotalInvBal());
		totalInvestmentsLabel.setFont(new Font("Times New Roman" , Font.BOLD , 20));
		totalInvestmentsLabel.setBackground(Color.GREEN);
		totalInvestmentsLabel.setOpaque(true);
		
		JPanel buttonPanel = new JPanel();
		BorderLayout layout = new BorderLayout();
		buttonPanel.setLayout(new GridLayout(5 , 1));
		setLayout(layout);
		
		buttonPanel.add(addStock);
		buttonPanel.add(removeStock);
		buttonPanel.add(addBond);
		buttonPanel.add(removeBond);
		buttonPanel.add(totalInvestmentsLabel);	
		
		
		
		add(buttonPanel , BorderLayout.WEST);
	}
	
	public int gettotalInvBal() {
		return totalInvBal;
	}
	
	class InvButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == addStock) {
				processAddStock();
			} else if (source == removeStock) {
				processRemoveStock();
				
			} else if (source == addBond) {
				processAddStock();
				
			} else if (source == removeBond) {
				processRemoveStock();
			}
		
		}	
	}
	
	private void processAddStock() {
		
		
		JTextField invtype = new JTextField(5);
	   JTextField invvalue = new JTextField(20);
	   JTextField invcost = new JTextField(20);

	   JPanel invPanel = new JPanel();
	   
	   invPanel.add(new JLabel("Investment Type"));
	   invPanel.add(invtype);
	     
	   invPanel.add(Box.createHorizontalStrut(15));
	   invPanel.add(new JLabel("Investment Value: "));
	   invPanel.add(invvalue);
	     
	   invPanel.add(Box.createHorizontalStrut(15)); 
	   invPanel.add(new JLabel("Investment Cost: "));
	   invPanel.add(invcost);
	   
	  
	  
		
	
		
	   int result = JOptionPane.showConfirmDialog(this, invPanel ,"Transaction Data", JOptionPane.OK_CANCEL_OPTION);
	   
	   if(result == JOptionPane.OK_OPTION) {
	   	
	   	if (tablePanelExist == false) {
	   	
	   		invtable = new JTable(100, 3);
	   	
	   	//invtable = new JTable(invdata, columnNames);
	   	//JTable invtable = new JTable(new invTableModel());
	   		
	   		
	   	JScrollPane invPane = new JScrollPane(invtable);
	   	
		
	   	//invPanel.add(invPane);
	   	// System.out.println("here in add stock");
	   	//super.add(invPanel);
	   	super.add(invPane);
	   	
	  

	   	invtable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Investment Type");
	   	invtable.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Investment Value");
	   	invtable.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Investment Cost");
            
	   	//System.out.println("Before rows: " + invtable.getRowCount() + "cols: " + invtable.getColumnCount());
	   	//System.out.println("Before indexRow: " + indexinvRow + "indexinvCol: " + indexinvCol);
		   	
           
	   	//System.out.println(invtype.getText());
            invtable.setValueAt(invtype.getText(), indexinvRow, 0);
            invtable.setValueAt(invvalue.getText(), indexinvRow, 1);
            invtable.setValueAt(invcost.getText(), indexinvRow, 2);
            tablePanelExist = true;
            
	   	} else {
	   		
	  
	   		invtable.setValueAt(invtype.getText(), indexinvRow, 0);
	           invtable.setValueAt(invvalue.getText(), indexinvRow, 1);
	           invtable.setValueAt(invcost.getText(), indexinvRow, 2);
             
          

	   	int numRows = invtable.getRowCount();
            int numCols = invtable.getColumnCount();
	   	
            //System.out.println("After indexRow: " + indexinvRow + "indexinvCol: " + indexinvCol);
	   	}
	   	 
	   	totalInvBal = totalInvBal + Integer.parseInt(invvalue.getText());
	   	//System.out.println("totalInvBal: " + totalInvBal);
	   	gettotalInvBal();
	   	
            
	   	indexinvRow++;
	   
	   	
	   	repaint();
	   	revalidate();
	   
	   	
	   }
	   
	   
	   totalInvestmentsLabel.setText("Total Investments: " + gettotalInvBal());
	   
	}
	
	
	
	private void processRemoveStock() {
		int rrow = invtable.getSelectedRow();

		
		
		String reminvvalue = (String) invtable.getValueAt(rrow, 1);
		totalInvBal = totalInvBal - Integer.parseInt(reminvvalue);
		
		invtable.setValueAt("", rrow, 0);
        invtable.setValueAt("", rrow, 1);
        invtable.setValueAt("", rrow, 2);
		repaint();
		revalidate();
		indexinvRow--;
		
		
		totalInvestmentsLabel.setText("Total Investments: " + gettotalInvBal());
		super.repaint();
	}
	
	
}
