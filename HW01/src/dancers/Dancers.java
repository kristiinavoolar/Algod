package dancers;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class Dancers implements IDancers {	
	
	public BinarySearchTree maleDancers = new BinarySearchTree();
	public BinarySearchTree femaleDancers = new BinarySearchTree();
	
	List<IDancer> withoutPartner = new ArrayList<IDancer>();
		
	/*public void addDancer(IDancer d) {
		withoutPartner.add(d);
	}*/
	
	@Override
    public SimpleEntry<IDancer, IDancer> findPartnerFor(IDancer d) throws IllegalArgumentException {
		
		IDancer partner;
		Dancer dancer = new Dancer(d.getID(), d.isMale(), d.getHeight());
		
		//int count = 0;
		
		if (d == null || d.getHeight() <= 0){
			throw new IllegalArgumentException();
		}
		
		if (dancer.isMale() == true){
			partner = femaleDancers.getPartner(dancer);
			if (partner == null) {
				maleDancers.addDancer(dancer);
				withoutPartner.add(dancer);
				return null;
			} else {
				femaleDancers.removeDancer(partner);
				return new SimpleEntry<IDancer, IDancer>(dancer, partner);
			}
		}else if (dancer.isMale() == false) {
			partner = maleDancers.getPartner(dancer);
			if (partner == null) {
				femaleDancers.addDancer(dancer);
				withoutPartner.add(dancer);
				return null;
			} else {
				maleDancers.removeDancer(partner);
				return new SimpleEntry<IDancer, IDancer>(dancer, partner);
			} 
		}
		return null;
		
        /*if(d.isMale() == true){
        	for(IDancer dancer : withoutPartner){
        		if(dancer.isMale() == false) {
        			if(d.getHeight() < dancer.getHeight()) {
        				continue;
        			} else if(dancer.getHeight() > d.getHeight()) {
	        			count++;
	        			partner = dancer;	        		}        		
        	}
        	}        	
        }
        else if (d.isMale() == false){
        	for(IDancer dancer : withoutPartner){
        		if(dancer.isMale() == true) {
	        		if(dancer.getHeight() < d.getHeight()) {
	    				continue;
	    			} else if(dancer.getHeight() > d.getHeight()) {     
	        			count++;
	        			partner = dancer;
	        		}        		
        	}
        	}        	
        }      
        
        if (count == 0){
        	withoutPartner.add(dancer);
        	return null;
        } else {
        	withoutPartner.remove(partner);
        	return new SimpleEntry<IDancer, IDancer>(dancer, partner);
        }*/
    }

	@Override
	public List<IDancer> returnWaitingList() {
		// TODO Auto-generated method stub
		return withoutPartner;
	}
}