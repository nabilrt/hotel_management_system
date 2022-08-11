//Main Class
import java.util.Scanner;
public class Start {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Employee e1=new Employee();
        Customer c1=new Customer();
        Booking b1=new Booking();
        EmployeeOperations eo1=new EmployeeOperations();
        CustomerOperations co1=new CustomerOperations();
        int choice;
        System.out.println("\t\t\t\t\t\t\tHOTEL MANAGEMENT SYSTEM\n\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t\tJNE INTERNATIONAL INN\n\t\t\t\t\t\t");
        do {
        	
            System.out.println("\n\t\t\t\t\t\t\tWelcome to the menu,\n\t\t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t[1]-Employee Management\n\t\t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t[2]-Customer Management\n\t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t[3]-Booking/Food Ordering\n\t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t[4]-Checkout\n\t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t[5]-Exit the Menu\n\t\t\t\t\t\t\t");
            System.out.print("Choose from the options given upwards:");
        	choice=input.nextInt();
        	switch(choice) {
        	case 1:{
        		System.out.println("Welcome to Employee Management");
        		System.out.println("[1]-Insert An Employee");
        		System.out.println("[2]-Show All Employees");
        		System.out.println("[3]-Search an Employee");
        		System.out.println("[4]-Delete An Employee");
        		System.out.print("Enter your Choice:");
        		int c=input.nextInt();
        		if(c==1) {
        			System.out.println("Please Give the Informations Correctly:");
        		      eo1.insertAnEmployee(e1);
        		}
        		else if(c==2) {
        			System.out.println("Below is the list of all Employees");
        			eo1.showAllEmployee(e1);
        		}
        		else if(c==3) {
        			System.out.println("Please type in the correct name to search");
        			eo1.searchAnEmployee(e1);
        		}
        		else if(c==4) {
        			System.out.println("Please type in the employee id correctly:");
        			eo1.deleteAnEmployee(e1);
        		}
        		else {
        			System.out.println("Wrong Choice");
        		}
        		break;
        	}
        	case 2:{
        		System.out.println("Welcome to Customer Management");
        		System.out.println("[1]-Insert a Customer");
        		System.out.println("[2]-Show All Customer");
        		System.out.println("[3]-Search a Customer");
        		System.out.println("[4]-Delete a Customer");
        		System.out.print("Enter your choice:");
        		int y=input.nextInt();
        		if(y==1) {
        			System.out.println("Please Enter the informations correctly:");
        		      co1.insertACustomer(c1);
        		}
        		else if(y==2) {
        			System.out.println("Below is the list of all Customers");
        			co1.showAllCustomer(c1);
        		}
        		else if(y==3) {
        			System.out.println("Please type in the correct name to search:");
        	        co1.searchACustomer(c1);
        		}
        		else if(y==4) {
        			System.out.println("Type in the nid correctly to delete:");
        			co1.deleteACustomer(c1);
        		}
        		else {
        			System.out.println("Wrong Input");
        		}
        		 break;
        	}
        	case 3:{
        		System.out.println("Welcome to the Room Booking Hub");
        		System.out.println("[1]-Book a Room");
        		System.out.println("[2]-Order Food");
        		System.out.print("Enter your Choice:");
        		int h=input.nextInt();
        		if(h==1) {
        			b1.getCustomerNumber();
           		    b1.BookARoom(c1);
        		}
        		else if(h==2) {
        			b1.OrderFood(c1);
        		}
        		else {
        			System.out.println("Wrong Choice-Going Back to the main menu");
        		}
        		
        		 break;
        	}
        	case 4:{
        		System.out.println("Welcome to the Checkout Menu");
        		 System.out.println("[1]-Deluxe Room Checkout");
        		 System.out.println("[2]-Normal Room Checkout");
        		 System.out.print("Enter the type of room you stayed in:");
        		 int st=input.nextInt();
        		 if(st==1) {
        			 b1.DeluxeCheckout(c1);
        		 }
        		 else if(st==2) {
        			 b1.NormalCheckout(c1);
        		 }
        		 else {
        			 System.out.println("Wrong Input");
        		 }
        		 break;
        	}
        	case 5:{
        		System.out.println("Program Exiting......................");
        		break;
        	}
        	default:{
        		System.out.println("Wrong choice");
        		break;
        	}
        	}
        	
        }while(choice!=5);{
        	System.out.println("Thank You For Using our Services");
        }
        
	}

}
