import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestGraph {

	public static void main(String[] args) {
		
		System.out.println("Testing Graph Data Structure\n");
		Graph g;
		
		System.out.println("Testing example 9.10:");
		g = makeGraph("9.10.txt");
		g.show();
		g.unweighted(2);
		System.out.print("Shortest path from 2 to 6 is: ");
		g.printPath(g.v[6]);

		System.out.println("\n\nTesting example 9.17:");
		g = makeGraph("9.17.txt");
		g.unweighted(0);
		g.show();
		System.out.print("Shortest path from 0 to 3 is: ");
		g.printPath(g.v[3]);
		
		System.out.println("\n\nTesting example 9.62:");
		g = makeGraph("9.62.txt");
		g.show();
		g.unweighted(4);
		System.out.print("Shortest path from 4 to 2 is: ");
		g.printPath(g.v[2]);
		
		System.out.println("\n\nTesting test1.txt:");
		g = makeGraph("test1.txt");
		g.show();
		g.unweighted(2);
		System.out.print("Shortest path from 2 to 1 is: ");
		g.printPath(g.v[1]);
		
		System.out.println("\n\nTesting test2.txt:");
		g = makeGraph("test2.txt");
		g.show();
		g.unweighted(5);
		System.out.print("Shortest path from 5 to 7 is: ");
		g.printPath(g.v[7]);
		
		System.out.println("\n\nTesting test3.txt:");
		g = makeGraph("test3.txt");
		g.show();
		g.unweighted(0);
		System.out.print("Shortest path from 0 to 3 is: ");
		g.printPath(g.v[3]);
	}

	private static Graph makeGraph(String fileName) {
		try {
			Scanner scanner = new Scanner (new File(fileName));

			int size = Integer.parseInt(scanner.nextLine());
			boolean directed = false;
			if (scanner.nextLine().charAt(0) == 'D') {
				directed = true;
			}
			
			Graph graph = new Graph(size,directed);
			while (scanner.hasNextLine()) {		
				String line = scanner.nextLine();
				String[] nums = line.split(" ");
				if (nums.length != 2) {
					scanner.close();
					throw new NumberFormatException();
				}
				int from = Integer.parseInt(nums[0]);
				int to = Integer.parseInt(nums[1]);
				Edge e = new Edge(from,to);
				graph.insert(e);					
			}
			scanner.close();
			return graph;
			
		} catch (FileNotFoundException e) {
			System.out.println("Your file could not be found");
			return null;
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("You entered invalid input");
			return null;
		}
	}
}
