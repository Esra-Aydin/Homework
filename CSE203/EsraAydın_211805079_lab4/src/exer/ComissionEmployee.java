package exer;

public class ComissionEmployee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private double grossSales;
	private double commisionRate;
	
	public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber,
			double grossSales,double commisionRate) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commisionRate = commisionRate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public double getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(double grossSales) {
		if(grossSales >= 0)this.grossSales = grossSales;
		else  System.out.println("warning!gross sales must be greater than or equal to 0.");	
	}
	public double getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(double commisionRate) {
		if(commisionRate <1 && commisionRate >0)  this.commisionRate = commisionRate;
		else System.out.println("");
	}
	
	public double earning()
	{
		return this.commisionRate*this.grossSales;
	}

	@Override
	public String toString() {
		return "\nfirstName= " + firstName + "\nlastName= " + lastName + "\nsocialSecurityNumber= "
				+ socialSecurityNumber + "\ngrossSales= " + grossSales + "\ncommisionRate= " + commisionRate;
	}
	
	
}
