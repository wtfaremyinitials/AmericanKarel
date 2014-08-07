package xyz.will.karelplusplus;

import stanford.karel.SuperKarel;

public class KarelPlusPlus extends SuperKarel {

	private static final long serialVersionUID = 1L;

	// Turn Right
	public void turnRight() {
		for(int i=0; i<3; i++) {
			this.turnLeft();
		}
	}
	
	// Direction Logic
	private Direction currentDirection = Direction.EAST;
	public enum Direction {
		NORTH(0),
		EAST(1),
		SOUTH(2),
		WEST(3);
		
		Direction(int id) {
			this.id = id;
		}
		
		private int id;
		public int getID() {
			return this.id;
		}
		
	}

	// Rotate to face
	public void face(Direction target) {
		int turns = target.getID() - currentDirection.getID();
		if(turns > 0) {
			for(int i=0; i<turns; i++) {
				turnRight();
			}
		}
		if(turns < 0) {
			for(int i=0; i>turns; i--) {
				turnLeft();
			}
		}
		currentDirection = target;
	}
	
	// Reset to East
	public void reset() {
		currentDirection = Direction.EAST;
	}
	
	// Better version of move
	public void move(Direction target) {
		face(target);
		move();
	}
	
	// Move X number of times
	public void move(Direction target, int times) {
		for(int i=0; i<times; i++) {
			move(target);
		}
	}
	
	// Move until you hit a wall
	public void go(Direction target) {
		move(target);
		while(frontIsClear())
			move(target);
	}
	
	// Attempt to put a beeper
	public boolean tryPutBeeper() {
		if(!beepersPresent()) {
			putBeeper();
			return true;
		}
		return false;
	}
 
}
