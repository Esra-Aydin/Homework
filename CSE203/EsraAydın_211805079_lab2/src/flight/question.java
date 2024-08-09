package flight;

import java.util.Scanner;

public class question {
	
	private static final Scanner input=new Scanner(System.in);
	private static final boolean[] seat= {false,false,false,false,false,false,false,false,false,false};
	
	public static void main(String[] args) {
		
		int choice;		
		while(true)
		{
			System.out.println("please type 1 buying first class ticket: ");
			System.out.println("please type 2 buying economy class ticket: ");
			System.out.println("please type 3 for Ticket Validation: ");
			choice=input.nextInt();
			
			if(choice==1) {	
				assignSeat(seat,0,5,"First Class");
			}else if(choice==2) {
				assignSeat(seat,5,10,"Economy Class");
			}else if(choice==3) {
				 System.out.println("Enter Seat ID to validate (1-10): ");
                 int seatID = input.nextInt();
                 validateTicketBySeatId(seatID);
			}else {
				System.out.println("wrong entered !!!");
			}
			
			
			if(isPlaneFull()) {
				System.out.println("the plane is now full.");
			}
		}
		
}	
	
public static void assignSeat(boolean seat[],int start,int end,String section){
	boolean assign = false;
	for(int i=start;i<end;i++)
	{
		if(!seat[i]) {
			seat[i]=true;
			System.out.println("Seat assigned: " + (i + 1) + " (" + section + ")");
			assign =true;
			break;
		}
		
	}
	if(!assign) {
		String answer;
		System.out.println(section + " is full. Would you like to be placed in the other section? (1.yes/2.no)");
		answer=input.next();
		if(answer.equals("1") ) {
			if(section.equals("First Class")){
				assignSeat(seat,5,10,"Economy Class");
				
			}else {
				assignSeat(seat, 0, 5, "First Class");
			}
		}
		else {
			System.out.println("Next flight leaves in 3 hours");}
		}	
}


public static void validateTicketBySeatId(int seatID) {
	
	if (seatID < 1 || seatID > 10) {
        System.out.println("Invalid Seat ID. Please enter a number between 1 and 10.");
    }else if(seat[seatID - 1]) {
		System.out.println("Seat " + seatID + " is sold.");
    } else {
        System.out.println("Seat " + seatID + " is available.");
    }
	
}


public static boolean isPlaneFull() {
	for(boolean seats: seat) {
		if(!seats) {
			return false;
		}
	}
	return true;
  }

}

