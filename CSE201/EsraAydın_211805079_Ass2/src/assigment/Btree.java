package assigment;

public class Btree {
 
	Node root;

	public Btree() {
		root = null;
	}
	Node newNode(String word,String tEqual,String mean)
	{
		root=new Node(word,tEqual,mean);
		return root;
	}
	Node insert(Node root,String word,String tEqual,String mean)
	{
		if(root!=null)
		{
			if(word.compareTo(root.word) < 0)
                root.left = insert(root.left, word, tEqual, mean);
			else if (word.compareTo(root.word) > 0)
		       root.right = insert(root.right, word, tEqual, mean);
		}		
		else
			root=newNode(word,tEqual,mean);
		return root;
	}
	void inOrder(Node root)
	{
		if(root!=null)
		{
			inOrder(root.left);
			System.out.println("word= "+root.word+"\nturkishEquivalent= "+root.tEqual+"\nmeaning= "+root.mean+"\n");
			inOrder(root.right);
		}
	}
	void postOrder(Node root)
	{
		if(root!=null)
		{
			postOrder(root.left);
			postOrder(root.right);
			System.out.println("word= "+root.word+"\nturkishEquivalent= "+root.tEqual+"\nmeaning= "+root.mean+"\n");
		}
	}
	void preOrder(Node root) 
	{
		if(root!=null)
	    {
		   System.out.println("word= "+root.word+"\nturkishEquivalent= "+root.tEqual+"\nmeaning= "+root.mean+"\n");
		   preOrder(root.left);
		   preOrder(root.right);  
	    }
	}
    Node search(Node root,String wordX)
	{
		if(root!=null)
		{	 
		    if( wordX.compareTo(root.word) == 0 ) 
		       {
			      System.out.println("'"+root.word+"' exist in binary search tree.");
		          System.out.println("word= "+root.word+"\nturkishEquivalent= "+root.tEqual+
				  "\nmeaning= "+root.mean+"\n");
		        } 
		    else if(wordX.compareTo(root.word)<0)
		    	root.left=search(root.left,wordX);
		    else if(wordX.compareTo(root.word)>0)
		    	root.right=search(root.right,wordX);
		    return root;
		}
		else
			System.out.println("'"+wordX+"' is not in binary search tree.");
		return null;    
	}	
}



