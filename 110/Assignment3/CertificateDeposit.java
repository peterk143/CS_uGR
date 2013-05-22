//***********************************************************
//Programmer:			  Peter Kirkpatrick
//Date:					  November 14,	2008
//Program Description: This program	computes the amount of
//							  a certificate of deposit on maturity.
//Question:				  Ch 6, Ex 7, Pg 375
//***********************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//makes CertificateDeposit a subclass of JFrame
//thus allowing it to inherite JFrames methods
public class CertificateDeposit extends JFrame
{
	//dimensions of the window
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
		
	private JLabel amtDepL, rateL, yearL, totAmtL;
	
	private JTextField amtDepTF, rateTF, yearTF, totAmtTF;
	
	private JButton calculateB, exitB;
	
	private CalculateButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	
	private CertificateDeposit()
	{
		setTitle("Certificate of Deposit");
		setSize(WIDTH, HEIGHT);
		
		//instintiates the labels
		amtDepL = new JLabel("Amount Deposited:", SwingConstants.CENTER);
		rateL = new JLabel("Interest Rate:", SwingConstants.CENTER);
		yearL = new JLabel("Years:", SwingConstants.CENTER);
		totAmtL = new JLabel("Total Amount:", SwingConstants.CENTER);
		
		//instintiates the textfields
		amtDepTF = new JTextField(10);
		rateTF = new JTextField(10);
		yearTF = new JTextField(10);
		totAmtTF = new JTextField(10);
		
		//instintiates the buttons, handlers, action listeners
		calculateB = new JButton("Calculate");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);
		
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		//instintiates the contents of the window
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5, 2));
		
		//adds each component to the window
		pane.add(amtDepL);
		pane.add(amtDepTF);
		pane.add(rateL);
		pane.add(rateTF);
		pane.add(yearL);
		pane.add(yearTF);
		pane.add(totAmtL);
		pane.add(totAmtTF);
		pane.add(calculateB);
		pane.add(exitB);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class CalculateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//declarations
			double amtDep, rate, totAmt, temp;
			int year;
			String ad, rt, ta, yr, ttlAmt;
			
			//obtains information for the user
			ad = amtDepTF.getText();
			rt = rateTF.getText();
			yr = yearTF.getText();
			
			//converts the info given from the user
			//into its appropriate number value
			amtDep = Double.parseDouble(ad);
			rate = Double.parseDouble(rt);
			year = Integer.parseInt(yr);
			
			//calculations
			temp = Math.pow(1 + rate / 100, year);
			totAmt = amtDep * temp;
			ttlAmt = String.format("%.2f", totAmt);
			
			//outputs the total amount
			totAmtTF.setText("" + ttlAmt);
		}
	}
	
	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		CertificateDeposit calcProgram = new CertificateDeposit();
	}
}