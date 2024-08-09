package exer;

public abstract class Employee implements Payable{

	private String firstName;
	private String lastName;
	private String socialN;
	public Employee(String firstName, String lastName, String socialN) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialN = socialN;
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
	public String getSocialN() {
		return socialN;
	}
	public void setSocialN(String socialN) {
		this.socialN = socialN;
	}
	public String toString() 	
	{
		return "first name: "+this.firstName+" "+this.lastName+"\nsocial security number: "
	+this.socialN;
	}
	
}
