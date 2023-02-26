package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName,lastName,deptName,password,alternateEmail,email,companySuffix="aeycompany.com";
	private int mailBoxCapacity=500,defaultPasswordLength=10;
	static Scanner input=new Scanner(System.in);
	
	//constructor to hold the value of first and last name.
	
	public Email(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
		
		//calling a method to ask for the department and return the department
		this.deptName=setDepartment();
		
		
		//calling a method to generate a random password
		password=this.randomPassword(defaultPasswordLength);
		System.out.println("Your Password is :" + this.password);
		
		//calling a method that generates email
		if(deptName==null)
		  email=firstName.toLowerCase() + "." + lastName.toLowerCase() +"@" + companySuffix;
		else
		  email=firstName.toLowerCase() + "." + lastName.toLowerCase() +"@" +deptName +"." + companySuffix;
		
		//calling a method to return mail box capacity
		this.mailBoxCapacity=getMailBoxCapacity();
	}
	
	//Ask the Department Name
	public String setDepartment() {
		System.out.println("Enter the deparment name");
		System.out.println("Press 1 for sales");
		System.out.println("Press 2 for development");
		System.out.println("Press 3 for accounting");
		System.out.println("Press 4 for testing");
		System.out.println("Press any other number for none of the department");
		int deptChoice=input.nextInt();
		if(deptChoice == 1) {return "sales"; }
		else if(deptChoice == 2) {return "development";}
		else if (deptChoice == 3) {return "accounting";}
		else if(deptChoice == 4) {return "testing";}
		else {return null;}
	}
	
	//Generate the random password
	public String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^abcd...xyz";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int random=(int)(Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(random);
		}
		return new String(password);
	}
	
	//Set the mailBoxcapacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity=capacity;
	}
	
	//Set the alternate emailId
	public void setAlternateEmailId(String altEmail) {
		this.alternateEmail=altEmail;
	}
	
	
	//Change the password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	
	public String altEmailId() {return alternateEmail;}
	
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Display Name: "+firstName + " " +lastName+
				"\nCompany Email: "+ email+
				"\nMail Box capacity: " +mailBoxCapacity+" MB ";}
}
