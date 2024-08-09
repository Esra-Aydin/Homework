package examples;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
		
		System.out.println("please enter number between 1-50(q is exit): ");
	    while (true) {
            String input = scanner.next();
             // if input equals q ,program termineteds 
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                for (int i = 1; i <= number; i++) {
                    for (int j = number; j >= 1; j--) {
                        if (i >= j)
                        	//if two digits print one space,one digits print two space
                            System.out.print(j + (j < 10 ? "  " : " "));
                        else
                            System.out.print("   ");
                    }
                    for (int j = 1; j <= number; j++) {
                        if (i > j)
                            System.out.print((j + 1) + (j + 1 < 10 ? "  " : " "));
                        else
                            System.out.print("   ");
                    }
                    System.out.println();
                }
            } catch (NumberFormatException e) {
  
            }
        }
     scanner.close();	 
	}
}
