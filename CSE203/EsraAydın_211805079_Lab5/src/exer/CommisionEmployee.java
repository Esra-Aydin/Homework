package exer;

public class CommisionEmployee extends Employee {
	private double grossSlaes;
	private double commisionRate;

	public CommisionEmployee(String firstName, String lastName, String socialN,
			double grossSlaes,double commisionRate) {
		super(firstName, lastName, socialN);
		this.grossSlaes=grossSlaes;
		this.commisionRate=commisionRate;
	}
	
	public double getGrossSlaes() {
		return grossSlaes;
	}
	public void setGrossSlaes(double grossSlaes) {
		if(grossSlaes>=0)this.grossSlaes = grossSlaes;
		else System.out.println("error,gross Sales must be greater than or equal to zero");
	}
	public double getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(double commisionRate) {
		if(commisionRate>0 && commisionRate<1)this.commisionRate = commisionRate;
		else System.out.println("error,commisionRate must be between 0-1 ");		
	}
	@Override
	public double getPaymentAmount() {
		
		return this.commisionRate*this.grossSlaes;
	}
	@Override
	public String toString() {
		return "Commision Employee: "+getFirstName()+" "+getLastName()+"\nsocial security number:"
				+getSocialN()+"\ngross sales: "+this.grossSlaes+
				"\ncommison rate: "+this.commisionRate;
	}
}

	


	


