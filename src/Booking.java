
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Booking extends Room {
int customerNo;
Customer c;
int counting=0;
int roomCount=0;
File file=new File("JN.txt");
FileWriter writer=null; 
FileReader read=null;
void setCustomerNo(int customerNo) {
	this.customerNo=customerNo;
}
int getCustomerNo() {
	return this.customerNo;
}
void getCustomerNumber() {
	counting++;
	System.out.println("Customer No:"+counting);
}
void BookARoom(Customer c) {
	this.c=c;
	Scanner input=new Scanner(System.in);
	System.out.println("********************Check out the options below to book your desired room****************************");
	System.out.println("1-Delux Room");
	System.out.println("2-Normal Room");
	System.out.print("Enter which type of Room you want to book:");
	int book=input.nextInt();
	switch(book) {
	case 1:{
		System.out.println("Room Numbers Available: 101-110");
		System.out.println("Room numbers get occupied accordingly-So if rooms occupied increase please choose the next room");
		System.out.println("Enter the room no:");
		int rn=input.nextInt();
		setroomNo(rn);
		roomCount++;
	    System.out.println("Room Occupied:"+roomCount);
		System.out.println("Room cost per day-700$");
		setroomType("DeLuxe");
		setDeluxCost(700);
		System.out.println("Enter your informations now:");
		System.out.println("Enter your name:");
		String n=input.next();
		c.setName(n);
		System.out.println("Enter your NID number:");
		String ni=input.next();
		c.setNid(ni);
		System.out.println("Enter your age");
		int a=input.nextInt();
		c.setAge(a);
		System.out.println("Enter your PhoneNumber:");
		int phn=input.nextInt();
		c.setphoneNumber(phn);
		System.out.println("Enter your Nationality:");
		String nat=input.next();
		c.setNationality(nat);
		System.out.println("Your Given Informations Are:");
		System.out.println("Room No:"+getroomNo());
		System.out.println("Room Type:"+getroomType());
		System.out.println("Room Cost:"+getDeluxCost());
		System.out.println("Name:"+c.getName());
		System.out.println("NID:"+c.getNid());
		System.out.println("Age:"+c.getAge());
		System.out.println("Phone Number:"+c.getphoneNumber());
		System.out.println("Nationality:"+c.getNationality());
		System.out.print("Are are the Informations Correct?(y/n):");
		char ch=input.next().charAt(0);
		if(ch=='y') {
			System.out.println("Congrates the room has been succesfully booked");
			System.out.println("Thank you for choosing us and Enjoy our Services ");
			try {
				writer=new FileWriter(file,true);
				writer.write("Nid:"+c.getNid()+"\r"+"\n");
			    writer.write("Name:"+c.getName()+"\r"+"\n");
				writer.write("Age:"+c.getAge()+"\r"+"\n");
				writer.write("Nationality:"+c.getNationality()+"\r"+"\n");
				writer.write("Phone Number:"+c.getphoneNumber()+"\r"+"\n");
				System.out.println("Informations have been added to our customers list");
				writer.flush();
				
				
			}catch(IOException e) {
				System.out.println(e);
				System.out.println("Exception Caught!!");
			}finally {
				try {
					writer.close();
				}
				catch(IOException ioe) {
					
				}
				
			}
			
		}
		else {
			System.out.println("Wrong Choice Inputted-Start from the Beginning");
		}
		break;
	}
	case 2: {
		System.out.println("Room Numbers Available: 200-210");
		System.out.println("Enter the room no:");
		int rn=input.nextInt();
		setroomNo(rn);
		roomCount++;
		System.out.println("Rooms Occupied:"+roomCount);
		System.out.println("Room cost per day-300$");
		setroomType("Normal");
		setNormalCost(300);
		System.out.println("Enter your informations now:");
		System.out.println("Enter your name:");
		String n=input.next();
		c.setName(n);
		System.out.println("Enter your NID number:");
		String ni=input.next();
		c.setNid(ni);
		System.out.println("Enter your age");
		int a=input.nextInt();
		c.setAge(a);
		System.out.println("Enter your PhoneNumber:");
		int phn=input.nextInt();
		c.setphoneNumber(phn);
		System.out.println("Enter your Nationality:");
		String nat=input.next();
		c.setNationality(nat);
		System.out.println("Your Given Informations Are:");
		System.out.println("Room No:"+getroomNo());
		System.out.println("Room Type:"+getroomType());
		System.out.println("Room Cost:"+getNormalCost());
		System.out.println("Name:"+c.getName());
		System.out.println("NID:"+c.getNid());
		System.out.println("Age:"+c.getAge());
		System.out.println("Phone Number:"+c.getphoneNumber());
		System.out.println("Nationality:"+c.getNationality());
		System.out.print("Are are the Informations Correct?(y/n)");
		char ch=input.next().charAt(0);
		if(ch=='y') {
			System.out.println("Congrats the room has been succesfully booked");
			System.out.println("Thank you for choosing us and Enjoy our Services ");
			try {
				writer=new FileWriter(file,true);
				writer.write("Nid:"+c.getNid()+"\r"+"\n");
			    writer.write("Name:"+c.getName()+"\r"+"\n");
				writer.write("Age:"+c.getAge()+"\r"+"\n");
				writer.write("Nationality:"+c.getNationality()+"\r"+"\n");
				writer.write("Phone Number:"+c.getphoneNumber()+"\r"+"\n");
				System.out.println("Informations have been added to our customers list");
				writer.flush();
			}catch(IOException e) {
				System.out.println(e);
				System.out.println("Exception Caught!!");
			}finally {
				try {
					writer.close();
				}
				catch(IOException ioe) {
					
				}
				
			}
		}
		else {
			System.out.println("Wrong Choice Inputted-Start from the Beginning");
		}
		
		
		break;
	}
	default:{
		System.out.println("Wrong Choice-Try Agaian");
		break;
	}
	}
	
}
void DeluxeCheckout(Customer c) {
	this.c=c;
	boolean isFound=false;
	double vat=15.0;
	double meals=80.0;
	Scanner inp=new Scanner(System.in);
	setDeluxCost(700);
	System.out.println("Enter Customer's NID:");
	String nn=inp.next();
	c.setNid(nn);
	try {
		read=new FileReader(file);
		BufferedReader bfr1=new BufferedReader(read);
		String temp=null;
		while((temp=bfr1.readLine())!=null) {
			if(temp.contains(c.getNid())) {
				 isFound=true;
				 break;
			}
		}
		if(isFound) {
			System.out.println("Enter the number of Days you stayed:");
			int stay=inp.nextInt();
			System.out.println("Enter the number of meals you have taken:");
			double meal=inp.nextInt();
			double calc=(stay*getDeluxCost())+(stay*getDeluxCost()*1.5);
			double calc1=stay*3*meals;
			double total=calc+calc1;
			System.out.println("Total Bill for yours " + stay + " Room is:"+calc);
			System.out.println("Total Bill for your " + meal + " meals is:"+calc1);
			System.out.println("So, Your Total Bill is: "+total);
			System.out.print("Do you want to pay the bill now (y/n):");
			char check=inp.next().charAt(0);
			if(check=='y') {
				System.out.println("Enter the way you want to pay:(Credit Card/Cash-**if Credit Card-Type in CC)");
				String p=inp.next();
				if(p.equals("Cash")) {
					System.out.println("******Bill Recipt*****");
					System.out.println("The number of days you stayed:"+stay);
					System.out.println("The number of meals you have taken:"+meal);
					System.out.println("Total Bill for yours " + stay + " days stay in the Room is:"+calc);
					System.out.println("Total Bill for your " + meal + " meals is:"+calc1);
					System.out.println("So, Your Total Bill is: "+total);
					System.out.println("Enter the amount:");
					double am=inp.nextDouble();
					if(am>=total) {
						System.out.print("Are you sure to pay Cash:(y/n):");
						char sh=inp.next().charAt(0);
						if(sh=='y') {
							double f=am-total;
							System.out.println("Congrats your payment has been accepted");
							System.out.println("Here is your changes:"+f + "$");
							System.out.println("Thanks for staying with JNE International INN, Please come again");
							try {
								read=new FileReader(file);
								BufferedReader bf=new BufferedReader(read);
								boolean Found=false;
								String t=null;
								int count=0;
								int linestodelete=4;
								String in="";
								while((t=bf.readLine())!=null) {
									if(t.contains(c.getNid())) {
										Found=true;
										t=null;
										count++;
										continue;
									}
									else if(Found && count<linestodelete) {
										count++;
										t=null;
									}
									else if(Found && count==linestodelete) {
										t=null;
										Found=false;
									}
									else {
										in += t +'\n'; 
									}
									
								}
								writer=new FileWriter(file);
								writer.write(in);
								
							}catch(IOException ioe) {
								System.out.println(ioe);
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
						else {
							System.out.println("Wrong Choice");
						}
					}
					else {
						System.out.println("Insufficient Amount");
					}

				}
				else if(p.equals("CC")) {
					System.out.println("Enter your Credit Card Number:");
					int crt=inp.nextInt();
					System.out.println("Enter your password:");
					int pass=inp.nextInt();
					System.out.println("Login Successfull");
					System.out.println("Enter the amount:");
					double amount=inp.nextDouble();
					double CardBalance=70000;
					if(amount>=total) {
						System.out.println("Your Current Card Balance is:"+CardBalance);
						System.out.print("Are you sure to pay the bill?(y/n):");
						char x=inp.next().charAt(0);
						if(x=='y') {
							System.out.println("The payment has been accepted and the money has been deducted from your card");
							double bills=CardBalance-total;
							
							System.out.println("Your Current Credit Card Balance is:" + bills);
							
							
							System.out.println("Thanks for staying with JNE International INN, Please come again");
							try {
								read=new FileReader(file);
								BufferedReader bf=new BufferedReader(read);
								boolean Found=false;
								String t=null;
								int count=0;
								int linestodelete=4;
								String in="";
								while((t=bf.readLine())!=null) {
									if(t.contains(c.getNid())) {
										Found=true;
										t=null;
										count++;
										continue;
									}
									else if(Found && count<linestodelete) {
										count++;
										t=null;
									}
									else if(Found && count==linestodelete) {
										t=null;
										Found=false;
									}
									else {
										in += t +'\n'; 
									}
									
								}
								writer=new FileWriter(file);
								writer.write(in);
								
							}catch(IOException ioe) {
								System.out.println(ioe);
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
						else {
							System.out.println("Please Try Again");
						}

					}
					else {
						System.out.println("You havent entered the sufficient Amount");
					}
				}
				else {
					System.out.println("There is no other way of Payment-Please start from the beginning");
				}
			
					
				}
			else {
				System.out.println("Please Enter the Menu Again");
			}
			}
		else {
			System.out.println("Customer Nid not found-Please Enter Correctly");
		}
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
		}

void NormalCheckout(Customer c) {
		this.c=c;
		boolean isFound=false;
		double vat=15.0;
		double meals=80.0;
		Scanner inp=new Scanner(System.in);
		setNormalCost(300);
		System.out.println("Enter Customer's NID:");
		String nn=inp.next();
		c.setNid(nn);
		try {
			read=new FileReader(file);
			BufferedReader bfr1=new BufferedReader(read);
			String temp=null;
			while((temp=bfr1.readLine())!=null) {
				if(temp.contains(c.getNid())) {
					 isFound=true;
					 break;
				}
			}
			if(isFound) {
				System.out.println("Enter the number of Days you stayed:");
				int stay=inp.nextInt();
				System.out.println("Enter the number of meals you have taken:");
				double meal=inp.nextInt();
				double calc=(stay*getNormalCost())+(stay*getNormalCost())*1.5;
				double calc1=stay*3*meals;
				double total=calc+calc1;
				System.out.println("Total Bill for yours " + stay + "  days stay in the Room is:"+calc);
				System.out.println("Total Bill for your " + meal + " meals is:"+calc1);
				System.out.println("So, Your Total Bill is: "+total);
				System.out.println("Do you want to pay the bill now (y/n):");
				char check=inp.next().charAt(0);
				if(check=='y') {
					System.out.println("Enter the way you want to pay:(Credit Card/Cash-**if Credit Card-Type in CC)");
					String p=inp.next();
					if(p.equals("Cash")) {
						System.out.println("******Bill Recipt*****");
						System.out.println("Your Room No was:"+getroomNo());
						System.out.println("The number of days you stayed:"+stay);
						System.out.println("The number of meals you have taken:"+meal);
						System.out.println("Total Bill for yours " + stay + " Room is:"+calc);
						System.out.println("Total Bill for your " + meal + " meals is:"+calc1);
						System.out.println("So, Your Total Bill is: "+total);
						System.out.println("Enter the amount:");
						double am=inp.nextDouble();
						if(am>=total) {
							System.out.println("Are you sure to pay Cash:(y/n):");
							char sh=inp.next().charAt(0);
							if(sh=='y') {
								double f=am-total;
								System.out.println("Congrats your payment has been accepted");
								
									System.out.println("Here is your changes:"+f + "$");
								

								System.out.println("Thanks for staying with JNE International INN, Please come again");
								try {
									read=new FileReader(file);
									BufferedReader bf=new BufferedReader(read);
									boolean Found=false;
									String t=null;
									int count=0;
									int linestodelete=4;
									String in="";
									while((t=bf.readLine())!=null) {
										if(t.contains(c.getNid())) {
											Found=true;
											t=null;
											count++;
											continue;
										}
										else if(Found && count<linestodelete) {
											count++;
											t=null;
										}
										else if(Found && count==linestodelete) {
											t=null;
											Found=false;
										}
										else {
											in += t +'\n'; 
										}
										
									}
									writer=new FileWriter(file);
									writer.write(in);
									
								}catch(IOException ioe) {
									System.out.println(ioe);
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
							else {
								System.out.println("Wrong Choice");
							}
						}
						else {
							System.out.println("Insufficient Amount");
						}

					}
					else if(p.equals("CC")) {
						System.out.println("Enter your Credit Card Number:");
						int crt=inp.nextInt();
						System.out.println("Enter your password:");
						int pass=inp.nextInt();
						System.out.println("Login Successfull");
						System.out.println("Enter the amount:");
						double amount=inp.nextDouble();
						double CardBalance=70000;
						if(amount>=total) {
							System.out.println("Your Current Card Balance is:"+CardBalance);
							System.out.println("Are you sure to pay the bill?(y/n):");
							char x=inp.next().charAt(0);
							if(x=='y') {
								System.out.println("The payment has been accepted and the money has been deducted from your card");
								double bills=CardBalance-total;
							    System.out.println("Here is your changes:"+bills + "$");
								
								System.out.println("Thanks for staying with JNE International INN, Please come again");
								try {
									read=new FileReader(file);
									BufferedReader bf=new BufferedReader(read);
									boolean Found=false;
									String t=null;
									int count=0;
									int linestodelete=4;
									String in="";
									while((t=bf.readLine())!=null) {
										if(t.contains(c.getNid())) {
											Found=true;
											t=null;
											count++;
											continue;
										}
										else if(Found && count<linestodelete) {
											count++;
											t=null;
										}
										else if(Found && count==linestodelete) {
											t=null;
											Found=false;
										}
										else {
											in += t +'\n'; 
										}
										
									}
									writer=new FileWriter(file);
									writer.write(in);
									
								}catch(IOException ioe) {
									System.out.println(ioe);
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
							else {
								System.out.println("Please Try Again");
							}

						}
						else {
							System.out.println("You havent entered the sufficient Amount");
						}
					}
					else {
						System.out.println("There is no other way of Payment-Please start from the beginning");
					}
				
						
					}
				else {
					System.out.println("Please Enter the Menu Again");
				}
				}
			else {
				System.out.println("Customer Nid not found-Please Enter Correctly");
			}
			}catch(IOException ioe) {
				System.out.println(ioe);
			}	
	}
void OrderFood(Customer c) {
	this.c=c;
	boolean CustomerFound=false;
	Scanner input=new Scanner(System.in);
	System.out.println("Please Check out the menu:");
	System.out.println("[1]-Noodles-20$");
	System.out.println("[2]-Pasta-30$");
	System.out.println("[3]-Biryani-120$");
	System.out.println("[4]-Coke-15$");
	System.out.print("Enter your choice:");
	int cho=input.nextInt();
	if(cho==1) {
		try {
			System.out.println("Enter your nid:");
			String nd=input.next();
			FileReader fr2=new FileReader("JN.txt");
			BufferedReader bfr2=new BufferedReader(fr2);
			String temp;
			while((temp=bfr2.readLine())!=null) {
				if(temp.contains(nd)) {
					CustomerFound=true;
					break;
				}
				
			}
			if(CustomerFound) {
				System.out.println("Your Food Has been succesfully Ordered");	
				System.out.println("It will be Delivered on time in your room");
			}
			else {
				System.out.println("Customer Nid not found in the database-Please Book a Room First");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Exception Caught");
		}
	}
	if(cho==2) {
		try {
			System.out.println("Enter your nid:");
			String nd=input.next();
			FileReader fr2=new FileReader("JN.txt");
			BufferedReader bfr2=new BufferedReader(fr2);
			String temp;
			while((temp=bfr2.readLine())!=null) {
				if(temp.contains(nd)) {
					CustomerFound=true;
					break;
				}
				
			}
			if(CustomerFound) {
				System.out.println("Your Food Has been succesfully Ordered");	
				System.out.println("It will be Delivered on time in your room");
			}
			else {
				System.out.println("Customer Nid not found in the database-Please Book a Room First");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Exception Caught");
		}
		
	}
	if(cho==3) {
		try {
			System.out.println("Enter your nid:");
			String nd=input.next();
			FileReader fr2=new FileReader("JN.txt");
			BufferedReader bfr2=new BufferedReader(fr2);
			String temp;
			while((temp=bfr2.readLine())!=null) {
				if(temp.contains(nd)) {
					CustomerFound=true;
					break;
				}
				
			}
			if(CustomerFound) {
				System.out.println("Your Food Has been succesfully Ordered");	
				System.out.println("It will be Delivered on time in your room");
			}
			else {
				System.out.println("Customer Nid not found in the database-Please Book a Room First");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Exception Caught");
		}
	}
	if(cho==4) {
		try {
			System.out.println("Enter your nid:");
			String nd=input.next();
			FileReader fr2=new FileReader("JN.txt");
			BufferedReader bfr2=new BufferedReader(fr2);
			String temp;
			while((temp=bfr2.readLine())!=null) {
				if(temp.contains(nd)) {
					CustomerFound=true;
					break;
				}
				
			}
			if(CustomerFound) {
				System.out.println("Your Food Has been succesfully Ordered");
				System.out.println("It will be Delivered on time in your room");
			}
			else {
				System.out.println("Customer Nid not found in the database-Please Book a Room First");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Exception Caught");
		}
	}
	
}

}