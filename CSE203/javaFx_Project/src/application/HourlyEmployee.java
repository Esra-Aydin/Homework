package application;

public class HourlyEmployee extends Employee{

	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String socialN
			,double wage,double hours) {
		super(firstName, lastName, socialN);
		this.wage=wage;
		this.hours=hours;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		if(wage>=0)this.wage = wage;
		else System.out.println("error,wage must be greater than or equal to zero");
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		if(hours>=0 && hours<168)this.hours = hours;
		else System.out.println("hours must be between 0>= hours <168");
	}
	@Override
	public double getPaymentAmount() {
		if(hours<=40)
			return this.wage*this.hours;
		else if(hours>40) 
		return 40 * this.wage+ (this.hours-40)*this.wage*1.5;
		else return 0;
	}
	@Override
	public String toString() { 
		return getFirstName()+" "+getLastName()+" "
				+ " "+getSocialN()+" "+this.wage+" "+getHours();
	}
	
}
