import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHashTable {

	public static void main(String[] args) {
		
		System.out.println("\nStarting tests\n");

		//creating hash table of size 13
		HashTable hashTable = new HashTable(13);
		
		// inserting 5 names into hash table
		System.out.println("Printed hash table:");
		hashTable.insert("jimmy");
		hashTable.insert("jonny");
		hashTable.insert("jared");
		hashTable.insert("george");
		hashTable.insert("bob");
		
		//  printing hash table
		hashTable.printHashTable();

		// testing capacity, unique items, and load factor getters
		System.out.println("Size: " + hashTable.getSize());
		System.out.println("Number of unique items: " + hashTable.getNumberOfItems());
		System.out.println("Load factor: " + hashTable.getLoadFactor());

		// adding elements to test that hash table will expand
		// once the load factor exceeds 50%
		System.out.println("\nTesting that the hash table expands:");
		hashTable.insert("fred");
		hashTable.insert("harry");
		System.out.println("Added elements:\nNew load factor: " + hashTable.getLoadFactor());
		hashTable.insert("greg");
		System.out.println("Added element and expanded hash table:\nNew load factor: " + hashTable.getLoadFactor());

		
		// testing hash table by reading text file of random text
		readFile();
		
	}

	private static void readFile() {
		System.out.println("\nTesting with lorem ipsum paragraphs:");
		HashTable hashTable = new HashTable(13);
		int wordsReadIn = 0;
		
		try {
			Scanner scanner = new Scanner(new File("ipsum.txt"));
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(" ");
				for (String s : line) {
					hashTable.insert(s);
					wordsReadIn++;
				}
			}
			
			// printing results
			System.out.println("Size of hash table: " + hashTable.getSize());
			System.out.println("Number of words read in: " + wordsReadIn);
			System.out.println("Number of unique items: " + hashTable.getNumberOfItems());
			System.out.println("Load factor: " + hashTable.getLoadFactor());
			System.out.println("\nHere are the unique words in the hash table:\n");
			hashTable.printHashTable();
			
			scanner.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("Your file cannot be found.");
		}
		
	}

}
