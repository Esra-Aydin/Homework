package exer;

public class InheritanceTest {

	public static void main(String[] args) {
		
		BasePlusComissionEmployee employe=new BasePlusComissionEmployee("bob","lewis","3333-33-3"
				,5000,0.04,300);
		// Print the object’s information using getter and related methods.
		System.out.println("employee information obtained by get methods and earnings\n");
		System.out.println("first name: "+employe.getFirstName());
		System.out.println("last name: "+employe.getLastName());
		System.out.println("social security number: "+employe.getSocialSecurityNumber());
		System.out.println("gross sales: "+employe.getGrossSales());
		System.out.println("commision rate: "+employe.getCommisionRate());
		System.out.println("base salary: "+employe.getBaseSalary());
		System.out.println("earning: "+employe.earning());
		
		// Print the object’s updated information using toString() method and related methods
		BasePlusComissionEmployee employe2=new BasePlusComissionEmployee("bob","lewis","3333-33-3"
				,5000,0.04,1000);
		System.out.println(employe2);
		
	}
}
