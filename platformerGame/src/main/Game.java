//game class
package main;

public class Game implements Runnable
{
	//create game window object
	private GameWindow gameWindow;
	//create a game panel object
	private GamePanel gamePanel;
	//create the thread
	private Thread gameThread;
	//FPS global variable
	private final int FPS_SET = 120;
	
	//constructor
	public Game() 
	{
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	//method for game thread
	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//run code on game thread game loop
	@Override
	public void run() 
	{
		//nano-seconds
		double timePerFrame = 1000000000.0/ FPS_SET;
		//store last frame
		long lastFrame = System.nanoTime();
		//stores the last frame
		long now = System.nanoTime();
		
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		//while loop
		while (true)
		{
			now = System.nanoTime();
			if(System.nanoTime() - lastFrame >= timePerFrame) 
			{
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000)
			{
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
	}

}
