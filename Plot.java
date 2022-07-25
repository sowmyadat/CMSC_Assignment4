
public class Plot {
	private int x , y;
	private int depth, width;
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		x = 0;
		y = 0;
		depth = 1;
		width = 1;
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * 
	 * @param p
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		depth = p.depth;
		width = p.width;
	}
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * 
	 * @param p
	 * @return - Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot p) {
		
		if(x < p.x + p.width && x + width > p.x && y < p.y + p.depth && y + depth > p.y) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * 
	 * @param p
	 * @return - Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot p) {
		double xRight = x + width;
		double yBot = y + depth;
		
		double nXRight = p.getX() + p.getWidth();
		double nYBot = p.getY() + p.getDepth();
		
		if(x <= p.getX() && p.getX() <= xRight && y <= p.getY() && p.getY() <= yBot && x <= xRight && nXRight <= xRight && y <= nYBot && nYBot <= yBot) {
			return true;
		}
		return false;
	}
	
	/**
	 * Return the x value
	 * 
	 * @return - the x value
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Return the y value
	 * 
	 * @return - the y value
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Return the width value
	 * 
	 * @return - the width value
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Return the depth value
	 * 
	 * @return - the depth value
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Set the x value
	 * 
	 * @param x - the x value to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Set the y value
	 * 
	 * @param y - the y value to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Set the width value
	 * 
	 * @param width - the width value to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Set the depth value
	 * 
	 * @param depth  - the depth value to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * 
	 * @return - the string representation of a Plot object in the following format:
               	 Upper left: (1,1); Width: 3 Depth: 3
	 */	
	@Override
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
	
}