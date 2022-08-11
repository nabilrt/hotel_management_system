
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class CustomerOperations implements ICustomerOperations {
Customer cu;
File file=new File("JN.txt");
FileWriter writer=null;
FileReader read=null;

public void insertACustomer(Customer cu) {
	this.cu=cu;
	try {
	Scanner input=new Scanner(System.in);
	System.out.println("Enter your name:");
	String n=input.nextLine();
	cu.setName(n);
	System.out.println("Enter your nid:");
	String nan=input.nextLine();
	cu.setNid(nan);
	System.out.println("Enter your Age:");
	int ag=input.nextInt();
	cu.setAge(ag);
	System.out.println("Enter your Nationality:");
	String nation=input.next();
	cu.setNationality(nation);
	System.out.println("Enter Your PhoneNumber:");
	int phn=input.nextInt();
	cu.setphoneNumber(phn);
	System.out.println("Your Given Informations are:");
	System.out.println("Name:"+cu.getName());
	System.out.println("Age:"+cu.getAge());
	System.out.println("Nid:"+cu.getNid());
	System.out.println("Nationality:"+cu.getNationality());
	System.out.println("Phone Number:"+cu.getphoneNumber());
	System.out.print("Are the the informations correct?(y/n):");
	char c=input.next().charAt(0);
	if(c=='y') {
		writer=new FileWriter(file,true);
		writer.write("Nid:"+cu.getNid()+"\r"+"\n");
		writer.write("Name:"+cu.getName()+"\r"+"\n");
		writer.write("Age:"+cu.getAge()+"\r"+"\n");
		writer.write("Nationality:"+cu.getNationality()+"\r"+"\n");
		writer.write("Phone Number:"+cu.getphoneNumber()+"\r"+"\n");
		System.out.println("All the informations have been Recorded Succesfully");
		writer.flush();
		writer.close();
	}
	else {
		System.out.println("Please Enter the Informations again");
		
	}
	

}catch(IOException e) {
	System.out.println(e);
	System.out.println("Exception Caught!!");
}
	
}
public void showAllCustomer(Customer cu) {
	this.cu=cu;
	try {
		read=new FileReader(file);
		BufferedReader buff=new BufferedReader(read);
		String x="";
		String temp;
		while((temp=buff.readLine())!=null) {
			x=x+temp+"\n"+"\r";
		}
		System.out.println(x);
		read.close();
	}catch(Exception e) {
		System.out.println(e);
		System.out.println("Exception Caught!!");
		e.printStackTrace();
	}
	
}
public void searchACustomer(Customer cu) {
	this.cu=cu;
	boolean searchon=false;
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the Nid:");
	String names=in.next();
	cu.setNid(names);
	try {
		read=new FileReader(file);
		BufferedReader buff1=new BufferedReader(read);
		String temp=null;
		int count=0;
		int linesToprint=4;
		while((temp=buff1.readLine())!=null) {
			if(temp.contains(cu.getNid())) {
				searchon=true;
				System.out.println(temp);
				count++;
				continue;
				
			}
			else if(searchon && count<linesToprint) {
				count++;
				System.out.println(temp);
			}
			else if(searchon && count==linesToprint) {
				System.out.println(temp);
				searchon=false;
			}
		}
		if(count==0) {
			System.out.println("Customer Not Found");
		}
	}catch(IOException e) {
		System.out.println(e);
		System.out.println("Exception Caught!!");
		e.printStackTrace();
	}
}
public void deleteACustomer(Customer cu) {
	this.cu=cu;
	Scanner input=new Scanner(System.in);
	boolean isFound=false;
	String temp=null;
	int count=0;
	int linestodelete=4;
	String inp="";
	System.out.println("Enter the Customer NID to delete:!!");
	String np=input.next();
	cu.setNid(np);
	try {
		read=new FileReader(file);
		BufferedReader bfr2=new BufferedReader(read);
		while((temp=bfr2.readLine())!=null) {
			if(temp.contains(cu.getNid())) {
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
				inp += temp +'\n'; 
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
	System.out.println("Customer Succesfully Deleted!!!");
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
