//************************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                November 12, 2008
//Program Description: This program uses GUI to calculate Property Taxes.
//************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PropertyTax1 extends JFrame
{
  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;
  
  private JLabel homeValueL, schoolRateL, countyRateL;
  private JLabel schoolTaxL, countyTaxL, totalTaxL;
  
  private JTextField homeValueTF, schoolRateTF, countyRateTF;
  private JTextField schoolTaxTF, countyTaxTF, totalTaxTF;
  
  private JButton calculateB, exitB;
  
  private CalculateButtonHandler cbHandler;
  private ExitButtonHandler ebHandler;
  
  public PropertyTax1()
  {
    setTitle("Calculation of Property Taxes");
    setSize(WIDTH, HEIGHT);
    
    homeValueL = new JLabel("Assesed Home Value:", SwingConstants.RIGHT);
    schoolRateL = new JLabel("School Tax Rate:", SwingConstants.RIGHT);
    countyRateL = new JLabel("County Tax Rate:", SwingConstants.RIGHT);
    schoolTaxL = new JLabel("School Taxes:", SwingConstants.RIGHT);
    countyTaxL = new JLabel("County Taxes:", SwingConstants.RIGHT);
    totalTaxL = new JLabel("Total Taxes:", SwingConstants.RIGHT);
    
    homeValueTF = new JTextField(10);
    schoolRateTF = new JTextField(10);
    countyRateTF = new JTextField(10);
    schoolTaxTF = new JTextField(10);
    countyTaxTF = new JTextField(10);
    totalTaxTF = new JTextField(10);
    
    calculateB = new JButton("Calculate");
    cbHandler = new CalculateButtonHandler();
    calculateB.addActionListener(cbHandler);
    
    exitB = new JButton("Exit");
    ebHandler = new ExitButtonHandler();
    exitB.addActionListener(ebHandler);
    
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(7, 2));
    
    pane.add(homeValueL);
    pane.add(homeValueTF);
    pane.add(schoolRateL);
    pane.add(schoolRateTF);
    pane.add(countyRateL);
    pane.add(countyRateTF);
    pane.add(schoolTaxL);
    pane.add(schoolTaxTF);
    pane.add(countyTaxL);
    pane.add(countyTaxTF);
    pane.add(totalTaxL);
    pane.add(totalTaxTF);
    pane.add(calculateB);
    pane.add(exitB);
        
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  private class CalculateButtonHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      double homeValue, schoolRate, countyRate;
      double schoolTax, countyTax, totalTax;
		String schlTX, cntTX, ttlTX;
    
      homeValue = Double.parseDouble(homeValueTF.getText());
      schoolRate = Double.parseDouble(schoolRateTF.getText());
      countyRate = Double.parseDouble(countyRateTF.getText());
    
      schoolTax = (schoolRate * homeValue) / 100;
      countyTax = (countyRate * homeValue) / 100;
      totalTax = (schoolTax + countyTax);
		
		schlTX = String.format("%.2f", schoolTax);
		cntTX = String.format("%.2f", countyTax);
		ttlTX = String.format("%.2f", totalTax);
    
      schoolTaxTF.setText("" + schlTX);
      countyTaxTF.setText("" + cntTX);
      totalTaxTF.setText("" + ttlTX);
    }
  }
    private class ExitButtonHandler implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    }
  
  public static void main(String[ ] args)
  {
    PropertyTax1 taxProg = new PropertyTax1();
  }
}