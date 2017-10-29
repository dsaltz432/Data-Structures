public class Edge {
	public int from, to; 
	
	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
    // Another constructor to take in Strings and convert to ints
    public Edge(String from, String to) {
    	this.from = Integer.parseInt(from);
    	this.to = Integer.parseInt(to);
    }
	
	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
