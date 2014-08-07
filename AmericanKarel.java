import java.awt.Color;

import xyz.will.karelplusplus.*;

public class AmericanKarel extends KarelPlusPlus {

	public void run() {
		reset();
		int width  = countWidth();
		int height = countHeight();
		paintStripes(width, height, RED, WHITE);
		paintBlock(width/2, height/2, BLUE);
		paintStars(width/2, height/2, WHITE);
	}
	
	public void paintBlock(int width, int height, Color color) {
		face(Direction.EAST);
		for(int h=0; h<height; h++) {
			paintStripe(width, BLUE);
			move(Direction.SOUTH);
		}
	}
	
	public void paintStars(int width, int height, Color color) {
		move(Direction.NORTH);
		move(Direction.EAST);
		paintStripes(width-2, height-1, BLUE, WHITE);
		paintDownStripes(width-2, height-1, BLUE);
	}
	
	public void paintStripes(int width, int height, Color one, Color two) {
		for(int i=0; i<height+1; i++) {
			face(Direction.EAST);
			if(i%2==0)
				paintStripe(width, one);
			else
				paintStripe(width, two);
			face(Direction.NORTH);
			if(frontIsClear())
				move(Direction.NORTH);
		}
		
	}
	
	public void paintStripe(int width, Color color) {
		for(int j=0; j<width; j++) {
			paintCorner(color);
			if(frontIsClear())
				move(Direction.EAST);
		}
		paintCorner(color);
		for(int k=0; k<width; k++) {
			face(Direction.WEST);
			if(frontIsClear())
				move(Direction.WEST);
		}
	}
	
	public void paintDownStripes(int width, int height, Color color) {
		for(int i=0; i<width+1; i++) {
			face(Direction.NORTH);
			if(i%2!=0)
				paintDownStripe(height, color);
			face(Direction.EAST);
			if(frontIsClear())
				move(Direction.EAST);
		}
		
	}
	
	public void paintDownStripe(int height, Color color) {
		for(int j=0; j<height; j++) {
			paintCorner(color);
			face(Direction.SOUTH);
			if(frontIsClear())
				move(Direction.SOUTH);
		}
		paintCorner(color);
		for(int k=0; k<height; k++) {
			face(Direction.NORTH);
			if(frontIsClear())
				move(Direction.NORTH);
		}
	}
	
	public int countHeight() {
		int height = 0;
		face(Direction.NORTH);
		while(frontIsClear()) {
			move(Direction.NORTH);
			height++;
		}
		for(int i=0; i<height; i++)
			move(Direction.SOUTH);
		return height;
	}
	
	public int countWidth() {
		int width = 0;
		face(Direction.EAST);
		while(frontIsClear()) {
			move(Direction.EAST);
			width++;
		}
		for(int i=0; i<width; i++)
			move(Direction.WEST);
		return width;
	}
	
	private static final long serialVersionUID = 1L;
	
}
