package inkedlist;

public class Node {
	
	int petID;
	String petName;
	String petType;
	int birthYear;
	double weight;

	Node next;
	public Node (int petID,String petName,String petType,int birthYear,double weight)
	{
		this.petID=petID;
		this.petName=petName;
		this.petType=petType;
		this.birthYear=birthYear;
		this.weight=weight;
		next=null;
	}
}
