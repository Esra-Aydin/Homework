package inkedlist;
import java.util.Scanner;

public class ListStructure {

	public static void main(String[] args) {
		Structure	linkedList =new Structure();
		Scanner input=new Scanner(System.in);
		int choice=-1;
		
		while(choice!=4)
		{
			System.out.println("1-add new pet(head): ");
			System.out.println("2-add new pet any where including head,middle and tail : ");
			System.out.println("3-remove pet: ");
			System.out.println("4-exit: ");
			choice=input.nextInt();
		
			 if(choice==1)
			{
				linkedList.enter();
			}
			 else if(choice==2)
			 {
				System.out.println("please enter index (start 0): ");
				int	x=input.nextInt();
				linkedList.enterX(x);
			 }
			else if(choice==3)
			{
				linkedList.remove();
			}
			else if(choice==4)
			{
				System.out.println("program is closing...");
	        }
			else 
			{
				System.out.println("wrong entered !!!");
			}
			linkedList.print();
		}

	}

}
