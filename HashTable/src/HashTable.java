import java.util.Arrays;

public class HashTable {
	private String[] data;
	private int size;
	private int numberOfItems;
	
	public HashTable(int size) {
		
		if (size > 0) {
			this.size = size;
		} else {
			System.out.println("The default table size has been set to 13");
			this.size = 13;
		}		
		data = new String[this.size];			
	}
	
	// taken from section 5.2 of textbook
	public int hash(String key) {
		int hashVal = 0;
		for (int i = 0; i<key.length(); i++) 
			hashVal = 37 * hashVal + key.charAt(i);
			hashVal %= size;
			if ( hashVal < 0 ) {
				hashVal += size;				
			}
		return hashVal;
	}
	
	public void insert(String x) {
		
		// checking if capacity is over 50%
		if (getLoadFactor() > 50) {
			expand();
		}
		
		if (!contains(x)) {

			int count = 0;
			int index = hash(x);
			String value = data[index];
			
			while (value != null) {		
				// determining if too many attempts were made
				if (count > size) {
					System.out.println("Could not find a location for your item");
					return;
				}
				
				// returning to -1 index, will add 1 before accessing array
				if (index == size-1) {
					index = -1;
				}
				value = data[++index];		
				count++;
			}
			data[index] = x;	
			numberOfItems++;
		}
	}
	
	// this method rehashes the elements into an array with twice the size
	// it must reset the numberOfItems counter
	private void expand() {
	
		String[] temp = Arrays.copyOf(data,size);	
		size *= 2;
		data = new String[size];
		numberOfItems = 0;
		
		// rehashing elements into new array
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				insert(temp[i]);
			}
		}
		
		// copying elements into temp array
		data = Arrays.copyOf(temp,size);	
	}

	// method that checks whether or not a string already exists in the table
	// checks the hashcode location, and every subsequent location until a null
	// value is found. that is the indication that the string isn't in the table
	private boolean contains(String targetString) {
		
		int index = hash(targetString);
		String value = data[index];
		
		while (value != null) {
			if (value.equals(targetString)) {
				return true;
			}
			
			// returning to -1 index, will add 1 before accessing array
			if (index == size-1) {
				index = -1;
			}
			value = data[++index];
		}
		return false;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public int getSize() {
		return size;
	}
	
	public double getLoadFactor() {
		double size = this.size;
		double numberOfItems = this.numberOfItems;
		Double num = Math.round(10000*numberOfItems/size) / 100.0;
		return num;
	}
	
	public void printHashTable() {
		for (int i = 0; i < size; i++) {
			if (data[i] != null) {
				System.out.println("index: " + i +"  data: " + data[i]);				
			}
		}
		System.out.println();
	}
	
}
