package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Main extends Application {
	ChoiceBox<String> choice;
    //an array list of Employee objects named employeeList
	private List<Employee> employeeList = new ArrayList<>();
	
	//text fields
	TextField tfName= new TextField();
	TextField tfLast=new TextField();
	TextField tfSSN=new TextField();
	TextField tfWage= new TextField();
	TextField tfGross= new TextField();
	TextField tfComm=new  TextField();
	TextField tfBase= new  TextField();
	TextField tfWeek=new  TextField();
	TextField tfHours= new  TextField();
	TextField tfSearch=new  TextField();
	TextField tfSalary=new TextField();
	//labels
	Label lbName=new Label("First Name");
	Label lbLast=new Label("Last Name");
	Label lbSSN=new Label("SSN");
	Label lbGross=new Label("Gross Sales");
	Label lbComm=new Label("Comission Rate");
	Label lbBase=new Label("Base Salary");
	Label lbWage=new Label("Wage");
	Label lbWeek=new Label("Weekly Salary");
	Label lbHours=new Label("Hours");
	Label lbType=new Label("Choose Employee Type ");
	Label lbSearch= new Label("Search/Update SSN");
	Label lbSalary=new Label("Salary");
	// Buttons
	Button btAdd=new Button("Add");
	Button btSearch=new Button("Search by SSN");
	Button btUpdate=new Button("Update by SSN");
	Button btClear=new Button("Clean Text Fields");

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane p1=new GridPane();
			p1.setAlignment(Pos.CENTER);
			p1.setHgap(5);p1.setVgap(5);
			p1.add(lbName, 0, 0);p1.add(tfName, 1, 0);
			p1.add(lbGross, 2, 0);p1.add(tfGross, 3, 0);
			p1.add(lbLast, 0, 1);p1.add(tfLast, 1, 1);
			p1.add(lbComm, 2, 1);p1.add(tfComm, 3, 1);
			p1.add(lbSSN, 0, 2);p1.add(tfSSN, 1, 2);
			p1.add(lbBase, 2, 2);p1.add(tfBase, 3, 2);
			p1.add(lbWeek, 2, 3);p1.add(tfWeek, 3, 3);
			p1.add(lbWage, 2, 4);p1.add(lbSearch, 0, 3);
			p1.add(tfSearch, 1, 3);p1.add(tfWage, 3, 4);
			p1.add(lbHours, 2, 5);p1.add(tfHours, 3, 5);
			p1.add(lbSalary, 0, 4);p1.add(tfSalary, 1, 4);
			
			BorderPane borderpane = new BorderPane();
			choice= new ChoiceBox<>();
			choice.getItems().addAll("Salaried Employee","Hourly Employee",
					"Commision Employee","Base Plus Commision Employee","None");
			choice.setOnAction(e -> updateFieldsBasedOnType());
			
			HBox p2=new HBox(10);
			p2.getChildren().addAll(btAdd,btSearch,btUpdate,btClear);
			p2.setAlignment(Pos.CENTER);
			
			HBox p3=new HBox(10);
			p3.setPadding(new Insets(20,20,20,20));
			p3.getChildren().addAll(lbType,choice);
			p3.setAlignment(Pos.TOP_CENTER);
			
			Line line=new Line();
			line.setStartX(0);
			line.setStartY(50);
			line.setEndX(600);
			line.setEndY(50);
			line.setStroke(Color.BLUE);
			
			borderpane.getChildren().add(line);
			borderpane.setCenter(p1);
			borderpane.setBottom(p2);
			borderpane.setTop(p3);
			
			tfSSN.setEditable(false); // SSN's text fiels read only 
			loadEmployeesFromFile();
			
            btAdd.setOnAction(e -> {
            	tfSSN.setText(generateSSN());// SSN dont take from user
    			try {
    				addEmployee();
    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
    		});
            
            btSearch.setOnAction(e -> searchEmployee());
            
            btUpdate.setOnAction(e ->{
    			try {
    				updateEmployee();
    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
    		} );

    		btClear.setOnAction(e -> cleanTextFields()); 
    		
			Scene scene = new Scene(borderpane,600,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Employee Salary Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateFieldsBasedOnType() {
		// Enable/Disable fields based on the selected type
		disableAllFields();
		switch (choice.getValue()) {
			case "Salaried Employee":
				enableSalariedFields();
				disableSalariedFields();
				break;
			case "Hourly Employee":
				enableHourlyFields();
				disableHourlyFields();
				break;
			case "Commision Employee":
				enableCommissionFields();
				disableCommissionFields();
				break;
			case "Base Plus Commision Employee":
				enableBasePlusCommissionFields();
				disableBasePlusCommissionFields();
				break;
			case "None":
				break;
		}
	}
	
	private String generateSSN() {
		//genarare ssn ,dont take from user
	    return String.format("%09d", new Random().nextInt(1000000000));
	}
	
	public void addEmployee() throws IOException {
		
		 String ssn = tfSSN.getText();String last=tfLast.getText();
		 String name = tfName.getText();String hour = tfHours.getText();
         String wage = tfWage.getText();String com = tfComm.getText();
         String gros = tfGross.getText();String base=tfBase.getText();
         String week = tfWeek.getText();
		 Employee employee=null;

		 switch (choice.getValue()) {
	        case "Salaried Employee":	           
	            employee= new SalariedEmployee(name, last, ssn, Double.parseDouble(week));
	            break;
	        case "Hourly Employee":           
	            employee= new HourlyEmployee( name, last,ssn,Double.parseDouble(wage),Double.parseDouble(hour));
	            break;
	        case "Commision Employee":
	            employee= new CommisionEmployee( name, last,ssn, Double.parseDouble(gros), Double.parseDouble(com));
	            break;
	        case "Base Plus Commision Employee":
	            employee= new BasePlusCommissionEmployee( name, last ,ssn, Double.parseDouble(gros),
	            		Double.parseDouble(com), Double.parseDouble(base));
	            break;
	      }
		 employeeList.add(employee);
		 overwriteFile();	
	}
	
	private void loadEmployeesFromFile() {
	    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\esra\\OneDrive\\Desktop\\.vs\\java file\\Employee.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Parse the line to create an Employee object and add to employeeList
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading from the file: " + e.getMessage());
	    }
	}
	
	private void overwriteFile() {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\esra\\OneDrive\\Desktop\\.vs\\java file\\Employee.txt"))) {
	        for (Employee employee : employeeList) {
	            writer.write(employee.toString()); // Adjust the format to match file structure
	            writer.newLine();
	            System.out.println("Data has been written to the file successfully.");
	        }
	    } catch (IOException e) {
	        System.err.println("Error writing to the file: " + e.getMessage());
	    }
	}
	
	private void searchEmployee() {
		 String ssnToSearch = tfSearch.getText(); // searching ssn

		    Employee foundEmployee = null;
			for (Employee employee : employeeList) {
		        if (employee.getSocialN().equals(ssnToSearch)) {
		            foundEmployee = employee;
		            break;
		        }
		    }
		    if (foundEmployee != null) {
		       
		        tfName.setText(foundEmployee.getFirstName());
		        tfLast.setText(foundEmployee.getLastName());
		        tfSSN.setText(foundEmployee.getSocialN());
		        
		        //employee-specific fields
		        if (foundEmployee instanceof BasePlusCommissionEmployee) {
		        	choice.setValue("Base Plus Commision Employee");
		        	tfComm.setText(String.valueOf(((BasePlusCommissionEmployee) foundEmployee).getCommisionRate())); 
		            tfGross.setText(String.valueOf(((BasePlusCommissionEmployee) foundEmployee).getGrossSlaes())); 
		            tfBase.setText(String.valueOf(((BasePlusCommissionEmployee) foundEmployee).getBaseSalary()));
		        }else if (foundEmployee instanceof SalariedEmployee) {
		        	 choice.setValue("Salaried Employee");
		        	 tfWeek.setText(String.valueOf(((SalariedEmployee) foundEmployee).getWeeklySalary())); 
		        } else if (foundEmployee instanceof HourlyEmployee) {
		        	choice.setValue("Hourly Employee");
		            tfHours.setText(String.valueOf(((HourlyEmployee) foundEmployee).getHours())); 
		            tfWage.setText(String.valueOf(((HourlyEmployee) foundEmployee).getWage())); 
		        } else if (foundEmployee instanceof CommisionEmployee) {
		        	choice.setValue("Commision Employee");
		            tfComm.setText(String.valueOf(((CommisionEmployee) foundEmployee).getCommisionRate())); 
		            tfGross.setText(String.valueOf(((CommisionEmployee) foundEmployee).getGrossSlaes())); 
		        }  
		        
		    } 
	}
	private void updateEmployee() throws IOException {
	    String ssnToUpdate = tfSearch.getText(); // SSN to search for update

	    Employee foundEmployee = null;
	    int indexToUpdate = -1;

	    // Search for the employee in the employee list
	    for (int i = 0; i < employeeList.size(); i++) {
	        if (employeeList.get(i).getSocialN().equals(ssnToUpdate)) {
	            foundEmployee = employeeList.get(i);
	            indexToUpdate = i;
	            break;
	        }
	    }

	    if (foundEmployee != null && indexToUpdate != -1) {
	        // Update the employee's details
	        String updatedName = tfName.getText();
	        String updatedLast = tfLast.getText();

	        // Update common fields
	        foundEmployee.setFirstName(updatedName);
	        foundEmployee.setLastName(updatedLast);

	        // Update specific fields based on employee type
	         if (foundEmployee instanceof BasePlusCommissionEmployee) {
	            double updatedBaseSalary = Double.parseDouble(tfBase.getText());
	            double updatedCommRate = Double.parseDouble(tfComm.getText());
	            double updatedGrossSales = Double.parseDouble(tfGross.getText());
	            ((BasePlusCommissionEmployee) foundEmployee).setBaseSalary(updatedBaseSalary);
	            ((BasePlusCommissionEmployee) foundEmployee).setCommisionRate(updatedCommRate);
	            ((BasePlusCommissionEmployee) foundEmployee).setGrossSlaes(updatedGrossSales);
	        }else if (foundEmployee instanceof SalariedEmployee) {
	            double updatedWeeklySalary = Double.parseDouble(tfWeek.getText());
	            ((SalariedEmployee) foundEmployee).setWeeklySalary(updatedWeeklySalary);
	        } else if (foundEmployee instanceof HourlyEmployee) {
	            double updatedHours = Double.parseDouble(tfHours.getText());
	            double updatedWage = Double.parseDouble(tfWage.getText());
	            ((HourlyEmployee) foundEmployee).setHours(updatedHours);
	            ((HourlyEmployee) foundEmployee).setWage(updatedWage);
	        } else if (foundEmployee instanceof CommisionEmployee) {
	            double updatedCommRate = Double.parseDouble(tfComm.getText());
	            double updatedGrossSales = Double.parseDouble(tfGross.getText());
	            ((CommisionEmployee) foundEmployee).setCommisionRate(updatedCommRate);
	            ((CommisionEmployee) foundEmployee).setGrossSlaes(updatedGrossSales);
	        } 

	        // Update the employee list
	        employeeList.set(indexToUpdate, foundEmployee);

	        // Update the file with the new employee data
	        overwriteFile();
	        System.out.println("Employee updated successfully.");

	    } else {
	        // Handle case where no employee was found for the given SSN
	        System.out.println("Employee with SSN " + ssnToUpdate + " not found.");
	    }
}

	
	public void cleanTextFields() {
		tfName.clear();tfBase.clear();
		tfLast.clear();tfHours.clear();
		tfSSN.clear();tfWage.clear();
		tfWeek.clear();tfComm.clear();
		tfGross.clear();tfSalary.clear();
		tfSearch.clear();
		// Clear other fields
	}

	// Methods to enable/disable specific fields based on employee type
	private void enableSalariedFields() {
		tfWeek.setDisable(false);
	}

	private void disableSalariedFields() {
		tfWage.setDisable(true);tfHours.setDisable(true);
		tfComm.setDisable(true);tfGross.setDisable(true);
		tfBase.setDisable(true);
	}

	private void enableHourlyFields() {
		tfWage.setDisable(false);
		tfHours.setDisable(false);
	}

	private void disableHourlyFields() {
		tfComm.setDisable(true);tfBase.setDisable(true);
		tfGross.setDisable(true);tfWeek.setDisable(true);	
	}

	private void enableCommissionFields() {
		tfComm.setDisable(false);tfGross.setDisable(false);
	}

	private void disableCommissionFields() {
		tfWage.setDisable(true);tfBase.setDisable(true);
		tfHours.setDisable(true);tfWeek.setDisable(true);
	}

	private void enableBasePlusCommissionFields() {
		tfBase.setDisable(false);tfGross.setDisable(false);
		tfComm.setDisable(false);
	}

	private void disableBasePlusCommissionFields() {
		tfWage.setDisable(true);
		tfHours.setDisable(true);
		tfWeek.setDisable(true);
	}

	private void disableAllFields() {
		disableSalariedFields();
		disableHourlyFields();
		disableCommissionFields();
		disableBasePlusCommissionFields();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}