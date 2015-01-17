package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	
	
public class Main {
	private static ArrayList<String> labelList;	// ���x�����X�g
	private static ArrayList<Node> nodeList;	// �m�[�h���X�g
	private static ArrayList<Route> routeList;	// ���[�g���X�g
	
	public static void main(String argv[]) {
		
		loadLabel("C:\\�e�[�}����\\label-tyoshi.txt");
		makeNodeList();
		loadRoot("C:\\�e�[�}����\\route-tyoshi.txt");

	    while (true) {
	      boolean cont = false;
	      for (Route route : routeList) {
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

	    System.out.println("distance: " + nodeList.get(nodeList.size()-1).getTotalCost());//����
	    Node node = nodeList.get(nodeList.size()-1);
	    while (node != nodeList.get(0)) {
	      System.out.println(node.getLabel()+",");//����
	      node = node.getFrom();
	    }
	  }
	
	private static void loadLabel(String filePath){
		try{
			labelList = new ArrayList<>();
			File file = new File("C:\\�e�[�}����\\label-tyoshi.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String[] labels = reader.readLine().split(",");
			for(int num = 0; num < labels.length; num++) {
				labelList.add(labels[num]);
			}
		}catch(FileNotFoundException e){  
			System.out.println(e);    
		}catch(IOException e){
		    System.out.println(e);    
		}
	}
	
	private static void makeNodeList(){
		Node node;
		nodeList = new ArrayList<>();	
		for(int num = 0; num < labelList.size(); num++) {
		String nodeLabel = labelList.get(num);
		// �X�^�[�g�n�_�iS�j�̏ꍇ
		// ��nodeList.get(0)��dummy��\���B
		if(nodeLabel.equals("S"))	node = new Node(nodeLabel, nodeList.get(0));
		// �X�^�[�g�n�_�ȊO�̏ꍇ
		else	node = new Node(nodeLabel);
		nodeList.add(node);
		}
	}
	
	private static void loadRoot(String filePath){
		try{
			routeList = new ArrayList<>();
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String str;	
			while((str = reader.readLine()) != null) {
			String[] labels = str.split(",");
			Route route = new Route(getNode(labels[0]), getNode(labels[1]), Integer.valueOf(labels[2]));
			routeList.add(route);
			}
		}catch(FileNotFoundException e){  
			System.out.println(e);    
		}catch(IOException e){
		    System.out.println(e);    
		}
	}
	
	private static Node getNode(String label){
		Node node = null;
		for(int num = 0; num < nodeList.size(); num++) {
		if(label.equals(nodeList.get(num).getLabel()))	node = nodeList.get(num);
		}
		return node;
	}
	
	private static boolean checkBeforeReadfile(File file){
	    if (file.exists()){
	      if (file.isFile() && file.canRead()){
	        return true;
	      }
	    }

	    return false;
	  }
	
}
