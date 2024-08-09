package application;

public class BasePlusCommissionEmployee extends CommisionEmployee{
	private double baseSalary;
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialN,
			double grossSlaes,double commisionRate,double baseSalary) {
		super(firstName, lastName, socialN, grossSlaes, commisionRate);
		this.baseSalary=baseSalary;	
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		if(baseSalary>=0)this.baseSalary = baseSalary;
		else System.out.println("error,base salary must bu greater than or equal to zero");
	}
	@Override
	public double getPaymentAmount() {
		return super.getPaymentAmount() ;
	}
	@Override
	public String toString() {
		return getFirstName()+" "+getLastName()+" "
				+getSocialN()+" "+getGrossSlaes()+
					" "+getCommisionRate()+" "+getBaseSalary();
    }
}
