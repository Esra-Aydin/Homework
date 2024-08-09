package examples;

public class Question2 {

	public static void main(String[] args) {
		System.out.println("term" + "\t\t" + "pi");
		double sum=0,pi,x=0;

		for(int i=1;i<=200;i++)
		{
			System.out.print(i+"\t\t");
			for(int j=1;j<=i;j++)
			{
				//pi= 4 - 4/3 +4/5 - 4/7 +....+ = 4*(1- 1/3 + 1/5 - 1/7 + ... + (-1)^(i+1) /( 2*i - 1))
				pi=(Math.pow(-1, j+1));
				x=4*(pi/(2*j-1));
			}
			sum+=x;
			System.out.printf("%.6f ",sum);
			System.out.println();	
		}

	}

}
