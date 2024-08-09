package application;

public class SalariedEmployee extends Employee {
private double weeklySalary ;
	
	public SalariedEmployee(String firstName, String lastName,
			String socialN,double weeklySalary) {
		super(firstName, lastName, socialN);
		this.weeklySalary=weeklySalary;
	}

	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}
	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary>=0){
			this.weeklySalary = weeklySalary;
		}else
			System.out.println("Error: Weekly salary must be greater than or equal to 0.");
	}
	@Override
	public String toString() {
			return getFirstName()+" "+getLastName()+" "
					+ " "+getSocialN()+" "+getWeeklySalary();
	}
}
