
public class Property {
	private String city;
	private String pOwner;
	private String pName;
	private double rAmount;
	private Plot plot;
	
	/**
	 *  No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, 
	 *  and default Plot (sets the x, y values to zero, depth and width to 1)
	 */
	public Property() {
		city = "";
		pOwner = "";
		pName = "";
		rAmount = 0;
		plot = new Plot();
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * 
	 * @param p
	 */
	public Property(Property p) {
		city  = p.city;
		pOwner = p.pOwner;
		pName = p.pName;
		rAmount = p.rAmount;
		plot = new Plot(p.plot);
	}
	
	/**
	 * Parameterized Constructor, no Plot information provided
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */ 
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.pName = propertyName;
		this.city = city;
		this.rAmount = rentAmount;
		this.pOwner = owner;
	}
	
	/**
	 * Constructor, Parameterized constructor
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.pName = propertyName;
		this.city = city;
		this.rAmount = rentAmount;
		this.pOwner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Return the property Name
	 * 
	 * @return - the propertyName
	 */
	public String getPropertyName() {
		return pName;
	}
	
	/**
	 * Return the city
	 * 
	 * @return - the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * return the Plot for the property
	 * 
	 * @return - the Plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * return the rent amount
	 * 
	 * @return - the rentAmount
	 */
	public double getRentAmount() {
		return rAmount;
	}
	
	/**
	 * return the owner name
	 * 
	 * @return - the owner
	 */
	public String getOwner() {
		return pOwner;
	}
	
	/**
	 * Set the property name
	 * 
	 * @param propertyName - the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		pName = propertyName;
	}
	
	/**
	 * set the Plot values
	 * 
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 * @return - the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x, y, width, depth);
	}
	
	/**
	 * set the city
	 * 
	 * @param city - the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * set the rent amount
	 * 
	 * @param rentAmount - the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		rAmount = rentAmount;
	}
	
	/**
	 * set the owner name
	 * 
	 * @param owner - the owner to set
	 */
	public void setOwner(String owner) {
		pOwner = owner;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * 
	 * @return - the string representation of a Property object in the following format:
                 Property Name: propertyName
                 Located in city
                 Belonging to: owner
                 Rent Amount: rentAmount
                 Be sure the last item is the rent amount, preceded by a space
	 */
	@Override
	public String toString() {
		return "Property Name: " + pName + "\nLocated in city: " + city + "\nBelonging to: " + pOwner + "\nRent Amount: " + rAmount;
	}
	
}
