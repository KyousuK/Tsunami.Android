package dijkstra;

class Node {

	  private String label;
	  private int totalCost;
	  private Node from;

	  public Node(String label, Node from) {
	    this.label = label;
	    this.from = from;
	  }
	  public Node(String label) { this(label, null); }

	  public String getLabel() { return label; }
	  public Node getFrom() { return from; }
	  public int getTotalCost() { return totalCost; }
	  public void setFrom(Node from) { this.from = from; }
	  public void setTotalCost(int totalCost) { this.totalCost = totalCost; }
	}

	class Route {
	  private Node srcNode, dstNode;
	  private int cost;

	  public Route(Node srcNode, Node dstNode, int cost) {
	    this.srcNode = srcNode;
	    this.dstNode = dstNode;
	    this.cost = cost;
	  }

	  public Node getSrcNode() { return srcNode; }
	  public Node getDstNode() { return dstNode; }
	  public int getCost() { return cost; }
	}


public class DijkstraSample {
	public static void main(String argv[]) {
	    Node dummy = new Node("X");
	    Node s = new Node("Start", dummy);
	    
	    Node a1 = new Node("A1");
	    Node a2 = new Node("A2");
	    Node a3 = new Node("A3");
	    Node a4 = new Node("A4");
	    Node a5 = new Node("A5");
	    Node a6 = new Node("A6");
	    
	    Node g = new Node("Goal");

	    Route[] routes = {
	    		
	    		new Route(s, a1, 0),
	    		
	    		new Route(a1, a2, 5),
	    		new Route(a2, a1, 5),
	    		new Route(a1, a3, 4),
	    		new Route(a3, a1, 4),
	    		new Route(a1, a4, 2),
	    		new Route(a4, a1, 2),    
	    		new Route(a2, a3, 2),
	    		new Route(a3, a2, 2),
	    		new Route(a3, a4, 3),
	    		new Route(a4, a3, 3),
	    		new Route(a4, a5, 6),
	    		new Route(a5, a4, 6),
	  	        new Route(a3, a5, 2), 
	  	        new Route(a5, a3, 2),
	  	        new Route(a4, a6, 6),
	  	        new Route(a6, a4, 6),
	  	        new Route(a6, a5, 4),
	  	        new Route(a5, a6, 4),
	  	        
	  	        new Route(a6, g, 0),
	  	        
	  	        
	  	        
	    };

	    while (true) {
	      boolean cont = false;
	      for (Route route : routes) {
	        Node src = route.getSrcNode();
	        Node dst = route.getDstNode();
	        if (src.getFrom() == null) continue;

	        if (dst.getFrom() == null ||
	            src.getTotalCost() + route.getCost() < dst.getTotalCost()) {
	          dst.setFrom(src);
	          dst.setTotalCost(src.getTotalCost() + route.getCost());
	          cont = true;
	        }
	      }
	      if (!cont) break;
	    }

	    System.out.println("distance: " + g.getTotalCost());
	    Node node = g;
	    while (node != dummy) {
	      System.out.println(node.getLabel());
	      node = node.getFrom();
	    }
	  }
}
