//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                January 29, 2009
//Program Description: This program tests class Student.
//***********************************************************

import java.util.*;

public class StudentTest
{
  static Scanner console = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    String trash;
    
    //creating a new student
    Student studentA = new Student();
    
    //input information
    System.out.println("Enter the following information:");
    System.out.println("--------------------------------");
    System.out.print("Student ID: ");
    studentA.setStudentID(console.nextInt());
    System.out.println(studentA.getStudentID());
    
    trash = console.nextLine();
    System.out.print("First Name: ");
    studentA.setFirstName(console.nextLine());
    
    System.out.print("Middle Name: ");
    studentA.setMiddleName(console.nextLine());
    
    System.out.print("Last Name: ");
    studentA.setLastName(console.nextLine());
    
    System.out.print("Date of Birth: ");
    studentA.setBirthDate(console.nextLine());
    
    System.out.print("Gender: ");
    studentA.setGender(console.nextLine());
    
    System.out.print("Department: ");
    studentA.setDepartment(console.nextLine());
    
    System.out.print("Degree: ");
    studentA.setDegree(console.nextLine());
    
    System.out.print("Address: ");
    studentA.setAddress(console.nextLine());
    
    System.out.print("Phone Number: ");
    studentA.setPhoneNumber(console.nextInt());
    
    //print
    studentA.print();
  }
}
    
    