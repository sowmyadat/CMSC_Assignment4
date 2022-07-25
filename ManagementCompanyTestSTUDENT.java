

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany m;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		p1 = new Property("Belmar", "Silver Spring", 1200.00, "John Smith", 2,1,2,2);
		p2 = new Property("Camden Lakeway", "Rockville", 2450.00, "Ann Taylor", 4,1,2,2);
		p3 = new Property("Hamptons", "Rockville", 1250.00, "Rick Stevens", 6,1,2,2);
				
		m = new ManagementCompany("Mackey", "555555555",6);
		
		//student add three properties, with plots, to mgmt co
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=p4=p5=p6=null;
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("Lakewood", "Rockville", 3000.00, "Alex Tan",0,0,1,1);
		assertEquals(m.addProperty(p4),3,0);
		//student should add property with 8 args
		p5 = new Property("Mallory Square", "Wheaton", 1000.00, "Abbey McDonald", 4,5,2,2);
		assertEquals(m.addProperty(p5),4,0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property("ALOT", "Maryland", 2000.00, "Joe Mana", 6,5,2,2);
		assertEquals(m.addProperty(p6), -1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(), 2450.00, .001);
		
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(), 4900.00, .001);
	}

 }
