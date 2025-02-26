/*
 * 2/26/2025
 * ImageFirstEx.java
 * Aarav Goyal
 * 
 * This program shows:
 * 	1. loading an image from a file
 *  2. three ways to display the image to the screen.
Working on: loading and drawing images
*/

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO; 

public class ImageFirstEx
{
	public static void main (String [] args)
	{
		ImageFirstEx ife = new ImageFirstEx();
		ife.run();
	}
	
	public ImageFirstEx()
	{
		
	}
	
	public void run()	
	{					
		JFrame frame = new JFrame("Draw image to panel");
		frame.setSize(700, 600);				
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 		
		frame.setLocation(300,50);
		frame.setResizable(true);
		
		ImageFirstExPanel ifePanel = new ImageFirstExPanel(); 		
		frame.getContentPane().add(ifePanel); 
		frame.setVisible(true);	
	}
}

class ImageFirstExPanel extends JPanel
{
	private String pictName;
	private Image picture;	
	
	public ImageFirstExPanel()
	{			
		picture = null;
		pictName = new String("beckenbauer.jpg");
		getMyImage();
	}
	
	public void getMyImage() 
	{	
		try
		{
			picture = ImageIO.read(new File(pictName));
		}
		
		catch (IOException e)
		{
			System.err.println("\n\n" + pictName + " can't be found.\n\n");
			e.printStackTrace();
		}
	}
	
	public void paintComponent (Graphics g)
	{	
		g.drawImage(picture, 50, 30, 600, 500, this);
		
		/*
			for (int i = 1000; i > 0; i-=20)
				g.drawImage(picture, 0 + i, 0 + i, 0 + i, 0 + i, this);
		*/
	}
}

