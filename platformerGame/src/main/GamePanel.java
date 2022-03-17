package main;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import these methods from other classes
import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.constants.PlayerConstants.*;
import static utilz.constants.Directions.*;

public class GamePanel extends JPanel
{
	private MouseInputs mouseInputs;
	private float xDelta = 100;
	private float yDelta = 100;
	private BufferedImage img;
	//array for idle animation
	private BufferedImage[][] animations;
	//variables for animation tick
	private int aniTick, aniIndex, aniSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;



	//constructor
	public GamePanel()
	{

		
		mouseInputs = new MouseInputs(this);
		//call import img constructor
		importImg();
		//load animations
		loadAnimations();
		
		setPanelSize();
		
		//Scanner KeyBoardInputs = new Scanner(System.in);
		addKeyListener(new KeyBoardInputs(this));
		
		//add mouse inputs
		addMouseListener(mouseInputs);
		
		//add mouse motion listener
		addMouseMotionListener(mouseInputs);
		
	}
	
	private void loadAnimations() 
	{
		//initialize array 9 in y, 6 in x
		
		animations = new BufferedImage[9][6];
		//load animations
		for(int j = 0; j < animations.length; j++)
		{
			for(int i = 0; i < animations[j].length; i++)
			{
				animations[j][i] = img.getSubimage(i * 64, j* 40, 64, 40);
			}
		}
		
		
	}

	//import images
	private void importImg() 
	{
		InputStream is = getClass().getResourceAsStream("../../res/player_sprites.png");
		//try catch if the program cant find image
		try 
		{
			img = ImageIO.read(is);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	//set window size
	private void setPanelSize() 
	{
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}
	
	//set direction if moving is true
	public void setDirection(int direction)
	{
		this.playerDir = direction;
		moving = true;
	}

	//method to set direction if moving is false and key is released
	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}
	
	//set animation method
	private void setAnimation()
	{
		if(moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
	}
	
	//update position method
	private void updatePos()
	{
		if(moving)
		{
			switch(playerDir)
			{
			case LEFT:
				xDelta -= 5;
				break;
			case UP:
				yDelta -= 5;
				break;
			case RIGHT:
				xDelta += 5;
				break;
			case DOWN:
				yDelta += 5;
				break;
			}
		}
	}
	
	//paint component
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		updateAnimationTic();
		
		setAnimation();
		updatePos();
		g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 160, null);
		
	}
	
	//goes 0,1,2,3,4 and gets to 5 and resets
	private void updateAnimationTic() 
	{
		aniTick++;
		if(aniTick >= aniSpeed)
		{
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction))
			{
				aniIndex = 0;
			}
		}
		
	}
	

	

	
	
	
}
