package dancers;

public class BinarySearchTree {
	
	public Dancer getPartner(Dancer d){
		
		Dancer focusDancer = root;	
		
		if (focusDancer != null) {
			
			if(d.isMale() == true){
				
				 if (d.getHeight() < focusDancer.getHeight()) { //kui mehe pikkus lyhem
					 
					// do {
						 focusDancer = focusDancer.leftChild; // liigun lyhemate naiste poole
					// } while (d.getHeight() > focusDancer.getHeight()); //kuni mees on naisest pikem					 
				 } 
				 
				 if (d.getHeight() > focusDancer.getHeight()) { //kui mees pikem
					 
					 //do {
						 focusDancer = focusDancer.rightChild; // liigun pikemate naiste juurde						
					 //} while (focusDancer.getHeight() < d.getHeight()); // nii kaua kuni mees on veel naisest pikem
					 
				 } else if(d.getHeight() == focusDancer.getHeight()) {
					 return null;
				 }
				 
			} else if (d.isMale() == false) {
				
				if (d.getHeight() < focusDancer.getHeight()) { //kui naine mehest lyhem 
					
					//do {
						 focusDancer = focusDancer.leftChild; // liigun lyhemate meeste poole						
					 //} while (focusDancer.getHeight() > d.getHeight()); //kuni naine veel on mehest lyhem

				} else if (d.getHeight() > focusDancer.getHeight()) { //kui naine pikem
					
					//do {
						focusDancer = focusDancer.rightChild; // liigun pikemate meeste juurde				
					//} while (d.getHeight() < focusDancer.getHeight()); // kuni naine saab mehest lyhemaks

				} else if (d.getHeight() == focusDancer.getHeight()) {
					return null;
				}
			}
			
			return focusDancer;
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
	
	public boolean removeDancer(IDancer d) {
        Dancer x = root;
        Dancer parent = root;
        boolean isItALeftChild = true;
        // otsib yles
        while(x.getHeight() != d.getHeight()) {
                parent = x;
                if (d.getHeight() < x.getHeight()) { // kui tantsija on lyhem kui vaadeldav,
                        isItALeftChild = true;    // siis tuleb vasakult edasi otsida
                        x = x.leftChild;
                } else {                      // kui tantsija on vaadeldavast pikem,
                        isItALeftChild = false;   // siis tuleb otsida paremalt
                        x = x.rightChild;    
                }
                if(x == null) {               // ei leidnud yles otsitavat
                        return false;
                }      
        }
        //delete
        if(x.leftChild == null && x.rightChild == null) { // kui eemaldataval ei ole lapsi
                if(x == root) {               // kui puus ainult yks element
                        root = null;
                } else if(isItALeftChild) {
                        parent.leftChild = null;  // kustuta vanemalt ara jarglane
                } else parent.rightChild = null;
        } else if(x.rightChild == null) { // kui eemaldataval ei ole paremat last
                if(x == root) {
                        root = x.leftChild;
                } else if (isItALeftChild) {
                        parent.leftChild = x.leftChild;
                } else parent.rightChild = x.leftChild;
        } else if(x.leftChild == null) {  // kui eemaldataval ei ole vasakut last
                if(x == root) {
                        root = x.rightChild;
                } else if (isItALeftChild) {
                        parent.leftChild = x.rightChild;
                } else parent.rightChild = x.leftChild;
        } else {                         // kui eemaldataval on molemad lapsed
                Dancer replacement = getReplacementDancer(x);
               
                if(x == root) {              
                        root = replacement;
                }
                else if (isItALeftChild)     // kui vaadeldav on juur, siis vasak asemele
                        parent.leftChild = replacement;
                else parent.rightChild = replacement;
                replacement.leftChild = x.leftChild;
        }
        return true;
}
	
	public Dancer getReplacementDancer(Dancer replacedDancer) {
        Dancer replacementParent = replacedDancer;
        Dancer replacement = replacedDancer;
        Dancer x = replacedDancer.rightChild;
       
        while (x != null) {             // niikaua kuni ei ole vasakuid lapsi
                replacementParent = replacement;
                replacement = x;
                x = x.leftChild;
        }
        if(replacement != replacedDancer.rightChild) {
                replacementParent.leftChild = replacement.rightChild;
                replacement.rightChild = replacedDancer.rightChild;
        }
        return replacement;
	}
}
