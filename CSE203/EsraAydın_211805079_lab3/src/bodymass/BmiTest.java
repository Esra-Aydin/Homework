package bodymass;

import java.util.Scanner;

public class BmiTest {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		final int SIZE=1;
		Bmi[] bmiArray= new Bmi[SIZE];
		
			for(int i=0;i<SIZE;i++) {
				System.out.println("enter person "+(i+1)+"'s values");
				System.out.println("name,age,weight(pounds),height(inches): ");
				String input=scanner.nextLine();
				//using two different function separating input values,calling one of them
				bmiArray[i]=inputSplit(input);
				//or can be used bmiArray[i] = InputUsingSubstring(input);
				
	     }
			
			for(Bmi bmi:bmiArray) {
				System.out.println(bmi);
			}
   }
	
	//first separate function
	public static Bmi inputSplit(String input) {
	
	 String[] data=input.split(" ");	
     String name =data[0];
     int age=Integer.parseInt(data[1]);
     double weight=Double.parseDouble(data[2]);
     double height = Double.parseDouble(data[3]);
     
     return new Bmi(name,age, weight,height);
  }
	
	//second separate function
	public static Bmi InputUsingSubstring(String input) {
        int firstSpace = input.indexOf(' ');
        String name = input.substring(0, firstSpace);

        int secondSpace = input.indexOf(' ', firstSpace + 1);
        int age = Integer.parseInt(input.substring(firstSpace + 1, secondSpace));

        int thirdSpace = input.indexOf(' ', secondSpace + 1);
        double weight = Double.parseDouble(input.substring(secondSpace + 1, thirdSpace));

        double height = Double.parseDouble(input.substring(thirdSpace + 1));

        return new Bmi(name, age, weight, height);
    }
}
