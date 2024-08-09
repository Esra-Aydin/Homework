package exer;

public class BasePlusComissionEmployee extends ComissionEmployee {
	private double baseSalary;
	
	public BasePlusComissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, double grossSales,double commisionRate,double baseSalary) {
			
	super(firstName, lastName, socialSecurityNumber, grossSales, commisionRate);
	this.baseSalary=baseSalary;
	}

	@Override
	public double earning() {
		return super.earning()+this.baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if(baseSalary <1 && baseSalary >0) this.baseSalary = baseSalary;
		else System.out.println("");
	}

	@Override
	public String toString() {
		return "\nUpdated employee information obtained by toString and earnings\n"
	+super.toString()+"\nbaseSalary= " + baseSalary+"\n"+"earnings= "+earning() ;
	}

}
