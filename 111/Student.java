//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                January 29, 2009
//Program Description: This program implements a class called
//                     Student.
//***********************************************************

public class Student
{
  private int studentID;
  private String firstName;
  private String middleName;
  private String lastName;
  private String birthDate;
  private String gender;
  private String department;
  private String degree;
  private String address;
  private int phoneNumber;
  
  //default constructor
  public Student()
  {
    studentID = 000000000;
    firstName = "unknown";
    middleName = "unknown";
    lastName = "unknown";
    birthDate = "unknown";
    gender = "unknown";
    department = "unknown";
    address = "unknown";
    phoneNumber = 0000000000;
  }
  
  //other constructor
  public Student(int id, String first, String middle, String last,
                   String birth, String gen, String dept, String deg,
                   String addy, int num)
  {
    studentID = id;
    firstName = first;
    middleName = middle;
    lastName = last;
    birthDate = birth;
    gender = gen;
    department = dept;
    address = addy;
    phoneNumber = num;
  }
  
  //methods
  public void setStudentID(int num)
  {
    studentID = num;
  }
  
  public int getStudentID()
  {
    return studentID;
  }
  
  public void setFirstName(String first)
  {
    firstName = first;
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public void setMiddleName(String middle)
  {
    middleName = middle;
  }
  
  public String getMiddleName()
  {
    return middleName;
  }
  
  public void setLastName(String last)
  {
    lastName = last;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public void setBirthDate(String birth)
  {
    birthDate = birth;
  }
  
  public String getBirthdate()
  {
    return birthDate;
  }
  
  public void setGender(String gen)
  {
    gender = gen;
  }
  
  public String getGender()
  {
    return gender;
  }
  
  public void setDepartment(String dept)
  {
    department = dept;
  }
  
  public String getDepartment()
  {
    return department;
  }
  
  public void setDegree(String deg)
  {
    degree = deg;
  }
  
  public String getDegree()
  {
    return degree;
  }
  
  public void setAddress(String addy)
  {
    address = addy;
  }
  
  public String getAddress()
  {
    return address;
  }
  
  public void setPhoneNumber(int num)
  {
    phoneNumber = num;
  }
  
  public int getPhoneNumber()
  {
    return phoneNumber;
  }
  
  public void print()
  {
    System.out.println("Student ID\t\t" + studentID);
    System.out.println("First Name\t\t" + firstName);
    System.out.println("Middle Name\t" + middleName);
    System.out.println("Last Name\t\t" + lastName);
    System.out.println("Date of Birth\t" + birthDate);
    System.out.println("Gender\t\t" + gender);
    System.out.println("Department\t\t" + department);
    System.out.println("Degree\t\t" + degree);
    System.out.println("Address\t\t" + address);
    System.out.println("Phone Number\t" + phoneNumber);
  }
}