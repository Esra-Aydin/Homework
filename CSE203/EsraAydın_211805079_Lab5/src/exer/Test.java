package exer;

public class Test {

	public static void main(String[] args) {
		
		Payable payableObjects[] = new Payable[ 6 ];
		 payableObjects[ 0 ] = new Invoice("01234","seat",2,375);
		 payableObjects[ 1 ] = new Invoice(" 56789","tire",4,79.95);
		 payableObjects[ 2 ] = new SalariedEmployee("John"," Smith","111-11-1111",800);
		 payableObjects[ 3 ] = new HourlyEmployee("Karen","Price"," 222-22-2222",16.75,40);
		 payableObjects[ 4 ] = new CommisionEmployee ("Sue","Jones","333-33-3333",10000,0.06);
		 payableObjects[ 5 ] = new BasePlusCommisionEmployee("Bob","Lewis","444-44-4444",5000,0.04,300);
		 System.out.println("------ Invoices and Employees processed polymorphically:------\n");
		 
		 
		 
		 for (int i = 0; i < payableObjects.length; i++) {
	            System.out.println(payableObjects[i]);
	            System.out.println("Payment amount: $" + payableObjects[i].getPaymentAmount() + "\n");

	            // Checking if the element is a BasePlusCommissionEmployee
	            if (payableObjects[i] instanceof BasePlusCommisionEmployee) {
	            	
	            	BasePlusCommisionEmployee employee = (BasePlusCommisionEmployee) payableObjects[i];
	                double oldBaseSalary = employee.getBaseSalary();
	                employee.setBaseSalary(oldBaseSalary * 1.10); // Increase base salary by 10%
	                System.out.printf("New base salary with 10%% increase is: $%.2f%n", employee.getBaseSalary());
	                System.out.println("Updated payment amount: $" + (employee.getPaymentAmount()+employee.getBaseSalary()) + "\n");
	            }
	        }
		
		 
	}
}
