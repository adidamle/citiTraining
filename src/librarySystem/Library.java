/**
 * 
 */
package librarySystem;


import java.util.*;

/**
 * @author Aditi
 *
 */

// assumptions - just have one copy of each item.
public class Library {
	private int branchID;
	@SuppressWarnings("unchecked")
	private HashSet<LibraryItem> onRent;
	private HashSet<LibraryItem> inBranch;
	
	Library(){
		this.onRent =  new HashSet();
		this.inBranch = new HashSet();
	}
	
	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	// the user uses this method to rent a book
	public String rentItem(LibraryItem item) {
		
		if(item instanceof Periodicals) {
			return "Sorry you cannot rent periodicals";
		}
		
		if(this.onRent.contains(item)) {
			return "Sorry Someone else has it!";
		}
		
		if(this.inBranch.contains(item)) {
			this.onRent.add(item);
			this.inBranch.remove(item);
			
			return "Successfully rented";
		}
		
		return "Sorry this item is unavilable at the library";
	}
	
	// Assumption that the user already has the item 
	// and there is no need to check the item. its valid
	
	public String returnItem (LibraryItem item) {
		this.inBranch.add(item);
		this.onRent.remove(item);
			
		return "Successfully returned";
	}
	
}
