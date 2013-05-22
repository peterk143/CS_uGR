//****************************************************************************
//Programmer:			  Peter Kirkpatrick
//Date:					  November 14,	2008
//Program Description: This program	prints the day	number of the year,
//							  given the	date entered is in the	form month-day-year.
//Question:				  Ch 7, Ex 13, Pg 462
//****************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//makes DayNumberYear a subclass of JFrame
//thus allowing it to inherite JFrames methods
public class DayNumberYear	extends JFrame
{
	//dimensions for the window
	private static	final	int WIDTH =	400;
	private static	final	int HEIGHT = 300;

	private JLabel	dateL, dayNumL;

	private JTextField dateTF,	dayNumTF;

	private JButton calculateB, exitB;

	private CalculateButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;

	public DayNumberYear()
	{
		setTitle("Day Number	in	a Year");
		setSize(WIDTH,	HEIGHT);
 
		//instintiates the labels
		dateL	= new	JLabel("Date (MM-DD-YYYY):", SwingConstants.CENTER);
		dayNumL = new JLabel("Day Number:",	SwingConstants.CENTER);

		//instintiates the text fields
		dateTF =	new JTextField(10);
		dayNumTF	= new	JTextField(10);

		//instintiates the buttons, handlers, action listeners
		calculateB = new JButton("Calculate");
		cbHandler =	new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);

		exitB	= new	JButton("Exit");
		ebHandler =	new ExitButtonHandler();
		exitB.addActionListener(ebHandler);

		//instintiates the contents of the window
		Container pane	= getContentPane();
		pane.setLayout(new GridLayout(3,	2));

		//adds each	component to the window
		pane.add(dateL);
		pane.add(dateTF);
		pane.add(dayNumL);
		pane.add(dayNumTF);
		pane.add(calculateB);
		pane.add(exitB);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class CalculateButtonHandler implements	ActionListener
	{
		public void	actionPerformed(ActionEvent e)
		{
			//declarations
			String day,	month, year;
			String date;
			int mnth, yr;
			int dayNum = 0;
			int dy =	0;
			int counter;

			//array declaration and instantiation
			int[]	monthS =	{31, 28,	31, 30, 31,	30, 31, 31,	30, 31, 30,	31};
			
			//obtaining inputs from the user
			date = dateTF.getText();
			
			//breaks the date apart into smaller pieces
			month	= date.substring(0, 2);
			day =	date.substring(3,	5);
			year = date.substring(6, 10);

			mnth = Integer.parseInt(month);
			dy	= Integer.parseInt(day);
			yr	= Integer.parseInt(year);

			//sets the number of days in feburary to 29 days
			//if its a leap year
			if((yr %	4 == 0) && (yr	% 100	!=	0))
			{
				monthS[1] =	29;
			}

			if((yr %	100 == 0) && (yr % 400 == 0))
			{
				monthS[1] =	29;
			}

			dayNum =	dy;
			counter = mnth	- 1;
			
			//adds the days of each month up
			if(mnth > 1)
			{
				while(counter > 0)
				{
					dayNum =	monthS[counter	- 1] + dayNum;
					counter = counter	- 1;
				}
			}
			
			//outputs the number of days in the year
			dayNumTF.setText("" + dayNum);
		}
	}

		private class ExitButtonHandler implements ActionListener
		{
			public void	actionPerformed(ActionEvent e)
			{
			  System.exit(0);
			}
		}

	public static void main(String[ ] args)
	{
		DayNumberYear dayProg =	new DayNumberYear();
	}
}
