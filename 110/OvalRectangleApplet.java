import java.awt.*;
import javax.swing.*;

public class OvalRectangleApplet extends JApplet
{
	private final int SIZE = 200;
	
	public void paint(Graphics g)
	{
		int shape;
		int numOfFigures;
		int x;
		int y;
		int width;
		int height;
		int red;
		int green;
		int blue;
		int i;
		
		numOfFigures = 5 + (int)(Math.random() * 10);
		
		for(i = 0; i < numOfFigures; i++)
		{
			red = (int)(Math.random() * 256);
			green = (int)(Math.random() * 256);
			blue = (int)(Math.random() * 256);
			
			g.setColor(new Color(red, green, blue));
			
			x = (int)(Math.random() * SIZE);
			y = (int)(Math.random() * SIZE);
			width = (int)(Math.random() * SIZE);
			height = (int)(Math.random() * SIZE);
			
			shape = (int)(Math.random() * 4);
			
			switch(shape)
			{
				case 0:
					g.drawRect(x, y, width, height);
					break;
					
				case 1:
					g.fillRect(x, y, width, height);
					break;
				
				case 2:
					g.drawOval(x, y, width, height);
					break;
					
				case 3:
					g.fillOval(x, y, width, height);
			}
		}
	}
}