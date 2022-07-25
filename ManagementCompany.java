import java.io.PrintWriter;
import java.text.spi.BreakIteratorProvider;

public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name;
	private Property[] props;
	private String taxId;
	private Plot plot;
	
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty strings and a default Plot. "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		name = "";
		taxId = "";
		mgmFeePer = 0;
		plot = new Plot(0,0,10,1);
		props = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well.
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		props = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxId = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information. "properties" array is initialized here as well.
	 * 
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - management fee
	 * @param x - x location of upper left corner of property's plot
	 * @param y - y location of upper left corner of property's plot
	 * @param width - width - width of the property's plot
	 * @param depth - depth of the property's plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		props = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxId = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. "properties" array is initialized here as well.
	 * 
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.props = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxId = otherCompany.taxId;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
	}
	
	// Getters and Setters for every variable in order to get or set eaach variable 
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public void setMAX_PROPERTY(int mAX_PROPERTY) {
		MAX_PROPERTY = mAX_PROPERTY;
	}

	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}

	public void setMGMT_WIDTH(int mGMT_WIDTH) {
		MGMT_WIDTH = mGMT_WIDTH;
	}

	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}

	public void setMGMT_DEPTH(int mGMT_DEPTH) {
		MGMT_DEPTH = mGMT_DEPTH;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Property[] getProps() {
		return props;
	}

	public void setProps(Property[] props) {
		this.props = props;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public Plot getPlot() {
		return plot;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x,y,width,depth);
		return plot;
	}
	//End of Getters and Setters
	
	/**
	 * Adds the property object to the "properties" array.
	 * 
	 * @param property - a property object
	 * @return - Returns either -1 if the array is full, -2 if property is null,
	 *  -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 *  or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		if(property == null) {
			return -2;
		}
		
		if(!plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i < props.length; i++) {
			if(props[i] != null) {
				if(props[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				props[i] = property;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * 
	 * @param name - property name
	 * @param city - location of the property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @return - Returns either -1 if the array is full, -2 if property is null,
	 *  -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 *  or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array.
	 * 
	 * @param name - property name
	 * @param city - location of the property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @param x - x location of upper left corner of property's plot
	 * @param y - y location of upper left corner of property's plot
	 * @param width - width of the property's plot
	 * @param depth - depth of the property's plot
	 * @return - Returns either -1 if the array is full, -2 if property is null,
	 *  -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 *  or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x,y,width,depth));
	}
	
	/**
	 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	 * 
	 * @return - total rent
	 */
	public double totalRent() {
		double total = 0;
		
		for(Property property: props) {
			if(property == null) {
				break;
			}
			total += property.getRentAmount();
		}
		
		return total;
	}
	
	/**
	 * This method finds the property with the maximum rent amount and returns its toString result. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * 
	 * @return - double, the maximum rent amount
	 */
	public double maxRentProp() {
		double rAmount = 0;
		
		for(Property property: props) {
			if(property == null) {
				break;
			}
			
			if(rAmount < property.getRentAmount()) {
				rAmount = property.getRentAmount();
			}
		}
		
		return rAmount;
	}
	
	/**
	 * This method finds the index of the property with the maximum rent amount. NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * 
	 * @return - int , the index of the property with the maximum rent amount
	 */
	private int maxRentPropertyIndex() {
		int count = 0;
		
		for(int i = 0; i < props.length; i++) {
			if(props[i] == null) {
				break;
			}
			
			if(props[i].getRentAmount() >= props[count].getRentAmount()) {
				count = i;
			}
		}
		
		return count;
	}
	
	/**
	 * Displays the information of the property at index i
	 * 
	 * @param i - The index of the property within the array "properties"
	 * @return - information of the property at index i
	 */
	private String displayPropertyAtIndex(int i) {
		String x = props[i].toString();
		return x;
	}
	
	/**
	 * Displays the information of all the properties in the "properties" array.
	 * 
	 * @return - information of ALL the properties within this management company by accessing the "Properties" array.
	 */
	public String toString() {
		String sout = "";
		
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(props[i] == null) {
				break;
			}
			
			sout += props[i].toString() + "\n";
		}
		
		return "List of the properties for " + name + ", taxID: " + taxId + "\n___________________________________\n"+ sout +"\n"
		+ "___________________________________\ntotal " + "management Fee: "+(totalRent()*mgmFeePer/100);
	}
	
}
