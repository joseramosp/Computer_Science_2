/* Problem set 1 - Problem 3

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

Define a Person class with appropriate fields, setters/getters, constructors, and a toString method. Extend your person
class and create a student class. Your classes should follow the concepts of information hiding and encapsulation. Write
a main program that creates and initializes an ArrayList of 10 Person objects. Fill the arrayList with person and student
objects. Print the name of each object in the list.
*/

import java.util.*;
import java.lang.*;

public class Student extends Person{

    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    private int studentID;
    private double studentGPA;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }

    public Student(String firstName, String lastName, int age, int studentID, double studentGPA) {
        super(firstName, lastName, age);
        this.studentID = studentID;
        this.studentGPA = studentGPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentGPA=" + studentGPA +
                "} " + super.toString();
    }

    private static void printPeopleNames(ArrayList<Person> people){

        for (Person person: people) {
            System.out.println("Person first Name: "+ person.getFirstName());
            System.out.println("Person last Name: "+ person.getLastName());
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        ArrayList<Person> people;
        people = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {

            people.add(new Person("FakeName","FakeLastName", 21));
            i++;
            people.add((Person) new Student("StudentFakeName", "StudentFakeLastName", 20));

        }

        printPeopleNames(people);
    }
}
