package assigment;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		

		Btree bst=new Btree();
		bst.root=bst.insert( bst.root, "large", "genis", "eni cok olan");
		bst.root=bst.insert( bst.root, "false", "yanlis", "bir kurala uymama");
	    bst.root=bst.insert( bst.root, "set off", "tetiklemek", "harekete gecirmek");
		bst.root=bst.insert( bst.root, "carry on", "surdurmek", "devam ettirmek");
		bst.root=bst.insert( bst.root, "look after", "bakmak", "göz kulak olmak");
		bst.root=bst.insert( bst.root, "temporal", "gecici", "belli bir sure icinde");
		
		Scanner input=new Scanner(System.in);
		int choice=-1;
		while(choice!=0) 
		{
		System.out.println("********MENU*******");
		System.out.println("1-insert a new Node: ");
		System.out.println("2-search for a word: ");
		System.out.println("3-print in order: ");
		System.out.println("4-print pre order: ");
		System.out.println("5-print post order: ");
		System.out.println("0-exit: ");
		choice=input.nextInt();
		
		if(choice==1)
		{
			input.nextLine();
			System.out.println("enter a word: ");String wordX=input.nextLine();	
			System.out.println("enter a turkish equivalent: ");String tEqual=input.nextLine();
			System.out.println("enter a mean: ");String mean=input.nextLine();
			bst.root=bst.insert(bst.root,wordX, tEqual, mean);			
		}
		else if(choice==2)
		{
			input.nextLine();
			System.out.println("enter a word: ");String word=input.nextLine();
			bst.search(bst.root,word);
		}
		else if(choice==3)
			bst.inOrder(bst.root);
		else if(choice ==4)
			bst.preOrder(bst.root);
		else if(choice ==5)
			bst.postOrder(bst.root);
		else if(choice==0)	
			System.out.println("program closing...");
		else
			System.out.println("wrong entered! ( enter between 0-5)");
		}
		
	}
}
