package assigment;

public class Node {
	String word;
	String tEqual;
	String mean;
	Node left;
	Node right;
	
	public Node() {
		word="";
		tEqual="";
		mean="";
		left=null;
		right=null;
	}

	public Node(String word, String tEqual, String mean) {
		this.word = word;
		this.tEqual = tEqual;
		this.mean = mean;
		left=null;
		right=null;
	}
}
