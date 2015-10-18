package dancers;

public class BinarySearchTree {
	
	public Dancer getPartner(Dancer d){
		
		Dancer focusDancer = root;		
		
		while (focusDancer != null) {
		
			if(d.isMale() == true){
				
				 if (d.getHeight() < focusDancer.getHeight()) { //kui mehe pikkus lyhem
				
					 do {
						 focusDancer = focusDancer.leftChild; // liigun lyhemate naiste poole
					 } while (d.getHeight() > focusDancer.getHeight()); //kuni mees on naisest pikem	
					 
					 return focusDancer;
				 
				 } else { //kui mees pikem
					 
					 do {
						 focusDancer = focusDancer.rightChild; // liigun pikemate naiste juurde
					 } while (d.getHeight() > focusDancer.getHeight()); // nii kaua kuni mees on veel naisest pikem
					 
					 return focusDancer;
				 }
				 
			} else if (d.isMale() == false) {
				
				if (d.getHeight() < focusDancer.getHeight()) { //kui naine mehest lyhem 
					
					do {
						 focusDancer = focusDancer.leftChild; // liigun lyhemate meeste poole
					 } while (d.getHeight() < focusDancer.getHeight()); //kuni naine veel on mehest lyhem
					
					return focusDancer;
					 
				} else { //kui naine pikem
					
					do {
						focusDancer = focusDancer.rightChild; // liigun pikemate meeste juurde
					} while (d.getHeight() < focusDancer.getHeight()); // kuni naine saab mehest lyhemaks
					 
					return focusDancer;
					 
					}
			}				
		 }
	
		// Node not found
		return null;		 		 
	}
	
	Dancer root;
	
	public void addDancer(Dancer d){
		
		Dancer newDancer = new Dancer(d.getID(), d.isMale(), d.getHeight());
		
		if(root == null) {
			
			root = newDancer;
			
		} else {
			
			Dancer focusDancer = root;
			Dancer parent;
			
			while(true) {
				
				parent = focusDancer;
				
				if(d.getHeight() < focusDancer.getHeight()){
					
					focusDancer = focusDancer.leftChild;
					
					if(focusDancer == null) {
						
						parent.leftChild = newDancer;
						return;
					}
					
				} else {
					
					focusDancer = focusDancer.rightChild;
					
					if(focusDancer == null){
						
						parent.rightChild = newDancer;
						return;
					}
				}				
			}
		}		
	}	
}
