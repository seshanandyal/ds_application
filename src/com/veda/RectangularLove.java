package com.veda;

public class RectangularLove {
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(0, 0, 20, 10);
		Rectangle rectangle2 = new Rectangle(5, 5, 30, 40);
	}
	
	static Rectangle findRectangularLove(Rectangle rectangle1, Rectangle rectangle2) {
		
		return null;
	}

}
class Rectangle {

    // "zero" rectangle
    public static final Rectangle NO_RECTANGLE = new Rectangle();

    // coordinates of bottom left corner
    private int leftX;
    private int bottomY;

    // dimensions
    private int width;
    private int height;

    public Rectangle() {}

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width  = width;
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}