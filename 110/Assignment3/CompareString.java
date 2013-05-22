//*******************************************************
//Programmer:			  Peter Kirkpatrick
//Date:					  November 14,	2008
//Program Description: This program	compares two strings
//							  and displays the larger one.
//Question:				  Ch 6, Ex 3, Pg 374
//*******************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//makes CompareString a subclass of JFrame
//thus allowing it to inherite JFrames methods
public class CompareString extends JFrame
{
	//dimensions for the window
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	
	private JLabel str1L, str2L, maxL;
	
	private JTextField str1TF, str2TF, maxTF;
	
	private JButton compareB, exitB;
	
	private CompareButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	
	private CompareString()
	{
		setTitle("Comparing Strings");
		setSize(WIDTH, HEIGHT);
		
		//instintiates the labels
		str1L = new JLabel("Enter a String:", SwingConstants.CENTER);
		str2L = new JLabel("Enter another String:", SwingConstants.CENTER);
		maxL = new JLabel("Largest String:", SwingConstants.CENTER);
		
		//instintiates the text fields
		str1TF = new JTextField(10);
		str2TF = new JTextField(10);
		maxTF = new JTextField(10);
		
		//instintiates the buttons, handlers, action listeners
		compareB = new JButton("Compare");
		cbHandler = new CompareButtonHandler();
		compareB.addActionListener(cbHandler);
		
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		//instintiates the contents of the window
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 2));
		
		//adds each component to the window
		pane.add(str1L);
		pane.add(str1TF);
		pane.add(str2L);
		pane.add(str2TF);
		pane.add(maxL);
		pane.add(maxTF);
		pane.add(compareB);
		pane.add(exitB);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class CompareButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//declarations
			String str1, str2, max;
			int ans;
			
			//obtains inputs from the user
			str1 = str1TF.getText();
			str2 = str2TF.getText();
					
			//calls the compareTo method and
			//sets it to the variable ans
			ans = str1.compareTo(str2);
			
			//determines which string is 
			//greater according to ASCII code
			if(ans < 0)
				max = str2;
			
			else
				max = str1;
				
			//outputs the larger string
			maxTF.setText("" + max);
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
		CompareString compareProg = new CompareString();
	}
}