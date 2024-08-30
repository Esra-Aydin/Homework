package inkedlist;

import java.util.Scanner;

public class Structure {
	Node head=null;
	Node tail=null;
	Node temp=null;
	Node temp2=null;
	
	int petID;
	String petName;
	String petType;
	int birthYear;
	double weight;
	
	Scanner input=new Scanner(System.in);
	
void enter() 
{
	System.out.println("A NEW PET TO BEİNG ADDED: ");
	System.out.println("-------------------");
	System.out.println("enter a pet ID: "); petID=input.nextInt();
	System.out.println("enter a pet name: "); petName=input.next();
	System.out.println("enter a pet type: "); petType=input.next();
	System.out.println("enter a pet birth year: "); birthYear=input.nextInt();
	System.out.println("enter a pet weight: "); weight=input.nextDouble();
	
	Node eleman= new Node (petID,petName,petType,birthYear,weight);
	if(head==null)
	{
		head=eleman;
	}
	else
	{
		eleman.next=head;
		head=eleman;
	}
}
void enterX(int index)
{
	System.out.println("A NEW PET TO BEİNG ADDED İNDEX: " + index);
	System.out.println("-------------------");
	System.out.println("enter a pet ID: "); petID=input.nextInt();
	System.out.println("enter a pet name: "); petName=input.next();
	System.out.println("enter a pet type: "); petType=input.next();
	System.out.println("enter a pet birth year: "); birthYear=input.nextInt();
	System.out.println("enter a pet weight: "); weight=input.nextDouble();
	
	Node eleman= new Node (petID,petName,petType,birthYear,weight);
	if(head==null && index==0)
	{
		head=eleman;
	}
	else if(head!=null && index==0)
	{
		eleman.next=head;
		head=eleman;
	}
	else
	{
		int i=0;
		temp=head;
		temp2=head;
		while(temp!=null)
		{
			i++;
			temp2=temp;
			temp=temp.next;
		}
		if(i==index)
		{
			temp2.next=eleman;
			eleman.next=temp;
		}
		else
		{
			temp=head;
			temp2=head;
			int n=0;
			while(n!=index)
			{
				temp2=temp;
				temp=temp.next;
				n++;
			}
			temp2.next=eleman;
			eleman.next=temp;	
		}
	}
}
void remove()
{
	if(head==null)
	{
		System.out.println("there is no pet to delete !");
	}
	else 
	{
		System.out.println("please enter a petID for the delete: ");
		petID=input.nextInt();
		if(petID==head.petID && head.next==null)
		{
		head=null;
		tail=null;
		System.out.println("delete that petID -> " + petID );
		}
		else if(petID==head.petID && head.next!=null)
		{
			head=head.next;
			System.out.println("delete that petID -> " + petID);
		}
		else 
		{	
			temp=head;
			temp2=head;
			while(temp.next!=null)
			{
				if(petID==temp.petID ) 
				{
					temp2.next=temp.next;
					System.out.println("delete that petID -> " + petID);
				}
				temp2=temp;
				temp=temp.next;
			}
			if(petID==temp.petID)
			{
				temp2.next=null;
				tail=temp2;
				System.out.println("delete that petID -> " + petID);
			}	
		}
	}
}
void print()
{
    if(head==null)
    {
    	System.out.println("there is no pet in list.!");
    }
    else
    {
    	Node temp=head;
    	while(temp!=null)
    	{
    		System.out.println("*************************");
    		System.out.println("INFORMATION ABOUT THE PET");
    		System.out.println("pet ID: "+temp.petID);
    		System.out.println("pet name: "+temp.petName);
    		System.out.println("pet type: "+temp.petType);
    		System.out.println("pet birth year: "+temp.birthYear);
    		System.out.println("pet  weight: "+temp.weight);
    		
    		temp=temp.next;
    	}
    	    System.out.println("--------------------------");
    } 
  }

}
