package utilz;

public class constants 
{
	public static class Directions
	{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	//inner class
	public static class PlayerConstants
	{
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMPING = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK_1 = 6;
		public static final int ATTACK_JUMP_1 = 7;
		public static final int ATTACK_JUMP_2 = 8;
		
		//method that returns amount of sprites per animation we are asking for
		public static int GetSpriteAmount(int player_action)
		{
			//switch that passes player action type and returns the animation output
			switch(player_action)
			{
			case RUNNING:
				return 6;
			case IDLE:
				return 5;
			case HIT:
				return 4;
			case JUMPING:
			case ATTACK_1:
			case ATTACK_JUMP_1:
			case ATTACK_JUMP_2:
				return 3;
			case FALLING:
				default:
					return 1;
			}
		}
	}

}
