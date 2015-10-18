package dancers;

import java.util.AbstractMap.SimpleEntry;

public class DancersTest {
	
	public static Dancers d = new Dancers();
	
	public static void main(String[] args) {
		
		Dancer d1 = new Dancer(1, true, 180);
		Dancer d2 = new Dancer(2, true, 190);
		Dancer d3 = new Dancer(3, true, 181);
		Dancer d4 = new Dancer(4, true, 191);
		Dancer d5 = new Dancer(5, false, 170);
		Dancer d6 = new Dancer(6, false, 190);
		Dancer d7 = new Dancer(7, false, 200);
		Dancer d8 = new Dancer(8, false, 160);		
		
		d.findPartnerFor(d1);
		d.findPartnerFor(d3);
		d.findPartnerFor(d4);
		d.findPartnerFor(d5);
		d.findPartnerFor(d6);
		d.findPartnerFor(d7);
		d.findPartnerFor(d8);	

		SimpleEntry<IDancer, IDancer> partner1 = d.findPartnerFor(d2);
		
		System.out.println("Partner: " + partner1);
		
	}
}
