
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class EmployeeOperations implements IEmployeeOperations {
Employee emp;
File file=new File("JNE.txt");
FileWriter writer=null;
FileReader read=null;
	public void insertAnEmployee(Employee emp) {
	this.emp=emp;
	Scanner input=new Scanner(System.in);
	try{
		System.out.println("Enter employee name:");
		String i=input.nextLine();
		emp.setName(i);
		System.out.println("Enter employee id:");
		String id=input.next();
		emp.setId(id);
		System.out.println("Enter the age:");
		int ag=input.nextInt();
		emp.setAge(ag);
		System.out.println("Enter your Nationality:");
		String nt=input.next();
		emp.setNationality(nt);
		System.out.println("Enter the Designation:");
		String des=input.next();
		emp.setDesignation(des);
		System.out.println("Given Informations are:");
		System.out.println("Name:"+emp.getName());
		System.out.println("Employee id:"+emp.getId());
		System.out.println("Age:"+emp.getAge());
		System.out.println("Nationality:"+emp.getNationality());
		System.out.println("Designation:"+emp.getDesignation());
		System.out.print("Are all the informations correct?(y/n):");
		char ch=input.next().charAt(0);
		if(ch=='y') {
			writer=new FileWriter(file,true);
			writer.write("Employee ID:"+emp.getId()+"\r"+"\n");
			writer.write("Name:"+emp.getName()+"\r"+"\n");	
			writer.write("Age:"+emp.getAge()+"\r"+"\n");
			writer.write("Nationality:"+emp.getNationality()+"\r"+"\n");
			writer.write("Designation:"+emp.getDesignation()+"\r"+"\n");
			System.out.println("The informations have been succesfully recorded");
			writer.flush();
			writer.close();
		}
		else if(ch=='n') {
			System.out.println("Please,Give the Informations Again");
		}
	}catch(Exception e) {
		System.out.println(e);
		System.out.println("Exception Caught!!");
	}

}
	
	public void showAllEmployee(Employee emp) {
		this.emp=emp;
		try {
			read=new FileReader(file);
			BufferedReader buff=new BufferedReader(read);
			String x="",temp;
			while((temp=buff.readLine())!=null) {
				x=x+temp+"\n"+"\r";
			}
			System.out.println(x);
			read.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void searchAnEmployee(Employee emp) {
		boolean search=false;
		int count=0;
		int linetoprint=4;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the employee id to search:");
		String st=in.next();
		emp.setId(st);
		try {
			read=new FileReader(file);
			BufferedReader bf1=new BufferedReader(read);
			String temp=null;
			while((temp=bf1.readLine())!=null) {
				if(temp.contains(emp.getId())) {
					search=true;
					System.out.println(temp);
					count++;
					continue;
				}
				else if(search && count<linetoprint) {
					count++;
					System.out.println(temp);
				
				}
				else if(search && count==linetoprint) {
					System.out.println(temp);
					search=false;
				}
			}
			if(count==0) {
				System.out.println("Employee Not Found");
			}

		}catch(IOException e) {
			System.out.println(e);
			System.out.println("Exception Caught!!");
		}
	}
	@Override
	public void deleteAnEmployee(Employee emp) {
		this.emp=emp;
		Scanner input=new Scanner(System.in);
		boolean isFound=false;
		String temp=null;
		int count=0;
		int linestodelete=4;
		String inp="";
		System.out.println("Enter the employee id to delete all the informations:");
		String np=input.next();
		emp.setId(np);
		try {
			read=new FileReader(file);
			BufferedReader bfr2=new BufferedReader(read);
			while((temp=bfr2.readLine())!=null) {
				if(temp.contains(emp.getId())) {
					isFound=true;
					temp=null;
					count++;
					continue;
				}
				else if(isFound && count<linestodelete) {
					count++;
					temp=null;
				}
				else if(isFound && count==linestodelete) {
					temp=null;
					isFound=false;
				}
				else {
					inp+=temp +'\n'; 
				}
				
			}
			writer=new FileWriter(file);
			writer.write(inp);
			switch(count) {
			case 0:{
				System.out.println("There is no such ID Found,Please Try Again!!");
				break;
			}
			default:{
                System.out.println("Employee Succesfully Deleted!!!");
				break;
			}
			}
			
		}catch(IOException e) {
			System.out.println(e);
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
				read.close();
			}
			catch(IOException io) {
				System.out.println("Can not close the resource!!");
			}
		}
		
	}
}
