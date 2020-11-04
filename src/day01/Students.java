package day01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Students {
private static int id=1000;
private String studentId;
private String firstName;
private String lastName;
private int gradeYear;
private String courses="";
private int costOfCourse=600;
private int tuitionBalance;


//unique id
public void setStudentId() {
	
	// StudentId = gradeYear =3 + id=1001; ==>3101
				// StudentId = gradeYear =3 + id=1002; ==>3102
	
	
	
	
	id++;
	this.studentId=gradeYear +""+id;
}
public Students () {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter students first name");
	this.firstName=in.nextLine();
	
	System.out.println("Enter students class level");
	System.out.println("1-Freshman");
	System.out.println("1-Sophmore");
	System.out.println("1-Junior");
	System.out.println("1-Senior");
	this.gradeYear = in.nextInt();
	setStudentId();
}
public void enroll() {
	do {
		Scanner in=new Scanner (System.in);
		System.out.println("Enter course to enrol(Q to quit");
		String course=in.nextLine();
		if(!course.equals("Q")) {
			courses=courses +"\n"+ course;
			tuitionBalance=tuitionBalance+costOfCourse;
		}
		else {
			break;
		}
	}
	while(true);
	System.out.println("You enrolled in :" + courses);

	
	
}
public void payTutition() {
	System.out.println("Your balance is $:" + tuitionBalance);
	Scanner in=new Scanner (System.in);
	System.out.println("how much do you want to pay");
	int payment=in.nextInt();
	tuitionBalance=tuitionBalance- payment;
	System.out.println("Thanks for payment of$:" + payment);
	System.out.println("Your Balance:$:" +tuitionBalance);
}
public String toString() {
	return"STUDENT ID:"+ studentId+"\nSTUDENT NAME:" + firstName + " "+ lastName+ 
			"\nGARADE NAME:"+gradeYear+
			"\nCOURSES ENROLLED:"+ courses +
			"\nREMAINING BALANCE:"+ tuitionBalance;

}
static Map<String,String>studentInfo = new HashMap<>();

public static void addStudentsToMap() {
	Scanner scan=new Scanner (System.in);
	String exit="";
	while(!exit.equals("S")) {
		Students s = new Students();
		s.enroll();
		s.payTutition();
		studentInfo.put(s.studentId, s.toString());
		System.out.println("Press 'S' to stop entrance.");
		System.out.println("Press enter to go on etrance. ");
		exit=scan.nextLine();
}
selectOptions();
}
public static void getStudentInfo() {
	Scanner scan = new Scanner(System.in);
	String idOfStudent= "";
	String result = "";
	
	do {
		System.out.println("Enter student id to get information!");
		System.out.println("Press 'X' to end the program");
		
		idOfStudent = scan.nextLine();
		result = studentInfo.get(idOfStudent);
		
		if(!idOfStudent.equals("X")) {				
			System.out.println(result);
			}
		}
	while(!idOfStudent.equals("X"));
	selectOptions();
	
}
public static void removeStudent() {
	Scanner scan = new Scanner(System.in);
	String idOfStudent= "";
	String result = "";
	
	do {
		System.out.println("Enter student id to remove!");
		System.out.println("Press 'X' to end the program");
		
		idOfStudent = scan.nextLine();
		result = studentInfo.remove(idOfStudent); // remove() with the key value in a map
		if(!idOfStudent.equals("X")) {
			System.out.println(result);
			System.out.println("Removed from the students list");	
		}				
	}
	while(!idOfStudent.equals("X"));
	selectOptions();

}		

public static void selectOptions() {
	
	System.out.println("Select the options:");
	System.out.println("1- Add students:");
	System.out.println("2- Get the student's information by id:");
	System.out.println("3- Remove student by id:");
	
	Scanner scan = new Scanner(System.in);
	int option = scan.nextInt();
	
	switch(option) {
	case 1:
		addStudentsToMap();
		break;
		
	case 2:
		getStudentInfo();
		break;
	
	case 3:
		
		removeStudent();
		break;
	default:
		System.out.println("Invalid selection, please select 1, 2, or 3 !!!");
	}
	
	
	
	
	
}
}









