package bodymass;

public class Bmi {

	private String name;
	private int age;
	private double weight;
	private double height;
	static final double KILOGRAMS_PER_POUND= 0.45359237;
	static final double METERS_PER_INCH=0.0254;
	
	public Bmi(){
		name="John Black";
		age=25;
		weight=100.0;
		height=50.0;
	}
   
	public Bmi(String name, double weight, double height) {
		this.name = name;
		this.age = 20;
		this.weight = weight;
		this.height = height;
	}
	public Bmi(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getBmi(){
		//bmi=weight/(height^2);
		return ( weight* KILOGRAMS_PER_POUND)/(Math.pow(height*METERS_PER_INCH,2));	
	}
	
	public String getStatus() {
		double bmi=getBmi();
		if(bmi<18.5) {
			return "underweight";
		}else if(bmi >= 18.5 && bmi<25.0) {
			return "normal";
		}else if(bmi>=25.0 && bmi < 30.0) {
			return "overweight";
		}else
			return "obese";
	}

	@Override
	public String toString() {
		return "[ name=" + name + ", age=" + age + ", weight=" + weight + ", height=" 
	+ height + " ]" + " BMI is: " + getBmi() + ", Status: " + getStatus();
	}
	
	
}
	

		

