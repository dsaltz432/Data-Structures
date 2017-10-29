
public class Graph {
	private int vertices;
	private boolean directed;
	private boolean[][] adjMatrix;
	public Vertex[] v;
	
	
	// creates graph with the given number of vertices
	// entire matrix is set to false
	public Graph(int vertices, boolean directed) {
		adjMatrix = new boolean[vertices][vertices];
		v = new Vertex[vertices];
		this.vertices = vertices;
		this.directed = directed;
		
 	   // fills the data so that the shortest path can be printed
 	   for (int i = 0; i < v.length; i++) {
 		   v[i] = new Vertex();
 		   v[i].data = "" + i;
 	   }
	}
	
	public void insert(Edge e) {
		adjMatrix[e.from][e.to] = true;		
		if (!directed) {
			adjMatrix[e.to][e.from] = true;
		}
	}
	
	public void delete(Edge e) {
		adjMatrix[e.from][e.to] = false;		
		if (!directed) {
			adjMatrix[e.to][e.from] = false;
		}
	}
	
	public int getVertices() {
		return vertices;	
	}
	
	// taken from Figure 9.30 of the textbook
	public void printPath(Vertex x) {
		if (x.path != null) {
			printPath(x.path);
			System.out.print(" to ");
		}
		System.out.print(x.data);
	}
	
	public void show() {
		for (int s = 0; s < getVertices(); s++) {
			System.out.print(s + ": ");
			AdjList A = getAdjList(s);
			for (int t = A.begin(); !A.end(); t = A.next()) // use of iterator
				System.out.print(t + " ");
			System.out.println();
		}
	}
	
	private AdjList getAdjList(int vertex) {
		return new AdjArray(vertex);
	}
	
    // taken from Figure 9.16 of the textbook
		public void unweighted(int s) {
			// Initializing distances to -1, and values to unknown
			for (int i = 0; i < v.length; i++) {
				v[i].distance = -1;
				v[i].known = false;
			}
			
			v[s].distance = 0; // setting the starting vertex distance to zero
			
			for (int currDist = 0; currDist < getVertices(); currDist++) {
				for (int i = 0; i < v.length; i++) {
					if (!v[i].known && v[i].distance == currDist) {
						v[i].known = true;
						for (int j = 0; j < v.length; j++) {
							if (adjMatrix[i][j]) {
								if (v[j].distance == -1) {
									v[j].distance = currDist + 1;
									v[j].path = v[i];
								}
							}
						}
					}
				}
			}
		}
	
	private class AdjArray implements AdjList{
		private int vertex;
		private int index;
		
		public AdjArray(int vertex) {
			this.vertex = vertex;
			index = -1;
		}
		
		public int next() {
			for (++index; index < getVertices(); index++) {
				if (adjMatrix[vertex][index]) {
					return index;
				}
			}
			return -1;
		}
		
		public int begin() {
			index = -1;
			return next();
		}
		
		public boolean end() {
			if (index < getVertices()) {
				return false;
			}
			return true;
		}
	}
}
