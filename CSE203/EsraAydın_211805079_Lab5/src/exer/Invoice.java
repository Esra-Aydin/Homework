package exer;

public class Invoice implements Payable{
	
	private String partNumber;
	private String partDescription;
	private double quantity;
	private double pricePerItem;
	
	public Invoice(String partNumber, String partDescription, double quantity, double pricePerItem) {
		super();
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		if(quantity>=0)
			this.quantity = quantity;
		else
			System.out.println("quantity must be greater than or equal zero");
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		if(pricePerItem>0)
		    this.pricePerItem = pricePerItem;
		else
			System.out.println("price must be greater than zero");
	}
	
	public String toString() 
	{
		return "İnvoice\npartNumber: "+this.partNumber+"("+this.partDescription+")\nquantity "
	+this.quantity+"\npricePerItem: $"+this.pricePerItem;
	}

	@Override
	public double getPaymentAmount() {
		return this.quantity*this.pricePerItem ;
	}

}
