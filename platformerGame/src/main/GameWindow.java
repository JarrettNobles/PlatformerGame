package main;
import javax.swing.JFrame;
public class GameWindow 
{
	//global variable
	private JFrame jframe;
	
	//constructor
	public GameWindow(GamePanel gamePanel)
	{
		//create a JFrame object
		jframe = new JFrame();
		//set size of the JFrame 400x400
		//jframe.setSize(400,400);
		//exit on close 
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//insert the game panel into the game window
		jframe.add(gamePanel);
		//set the location of the rectangle
		jframe.setLocationRelativeTo(null);
		//dont want to resize window
		jframe.setResizable(false);
		//new set size, tells jframe to set size of window to preferred components
		jframe.pack();
		//make the game window visible
		jframe.setVisible(true);
		
		
	}

}
