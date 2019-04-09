package test.java;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import main.java.Course;
import main.java.Major;
import main.java.Student;


/*
 * Class:
 * Description:
*/
public class CourseTest {
    Course oneStudent;
	Course twoStudents;
	//Course students;
	Course sameTwoStudents;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
    @Test
    public void testAverageWithoutMinWithoutMax() {
        // One Student
        oneStudent = new Course("SER316");
        oneStudent.set_points("Hanna", 50);
        double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    }

	/*
	 * Method: calculateAverageMinWithoutMax
	 * Inputs: none
	 * Returns: True if the average of 2 students is 77.5
	 * Description: A test to see if the two scores are properly
	 * averaged and not removed as min and max
	*/
	@Test
	public void testAverageTwoStudents() {
		// Two Students
		twoStudents = new Course("SER316");
		twoStudents.set_points("Alex", 75);
		twoStudents.set_points("Casey", 80);
		double ans = twoStudents.calculateAverageWithoutMinWithoutMax();
		assertTrue(Math.abs(ans - 77.5) < 0.001);
	}
	
	/*
	 * Method: calculateAverageMinWithoutMax
	 * Inputs: none
	 * Returns: True if the average of 3 students is 65
	 * Description: A test to see whether or not it can properly remove
	 * the mins and max while still calculating the average off one
	 * grade
	*/
//	@Test
//	public void testAverageMultiStudents() {
//		// Multiple Students
//		students = new Course("MAT343");
//		students.set_points("Juan", 55);
//		students.set_points("Paul", 65);
//		students.set_points("Nick", 75);
//		double ans = students.calculateAverageWithoutMinWithoutMax();
//		System.out.println("AnswerThree: " + ans);
//		assertTrue(ans == 65);
//	}
//	
//	/*
//	 * Method: calculateAverageMinWithoutMax
//	 * Inputs: none
//	 * Returns: True if the average of 3 students is 65
//	 * Description: A test method for calculateAverageMinWithoutMax
//	 * to see if if properly removes the min and max while still
//	 * being able to calculate the average where a min is 0
//	*/
//	@Test
//	public void testAverageMultiStudentsZero() {
//		// Multiple Students
//		students = new Course("MAT343");
//		students.set_points("Juan", 55);
//		students.set_points("Paul", 0);
//		students.set_points("Nick", 75);
//		double ans = students.calculateAverageWithoutMinWithoutMax();
//		System.out.println("AnswerZero: " + ans);
//		assertTrue(ans == 55);
//	}
	
	/*
	 * Method: addStudent
	 * Inputs: Student s
	 * Returns: True if the Student s is not found and False
	 * if the Student s is found.
	 * Description: A test method for addStudent to test uniqueness 
	*/
	@Test
	public void testSameTwoStudents() {
		sameTwoStudents = new Course("CSE230");
		Student a = new Student("Paul", Major.CS);
		sameTwoStudents.addStudent(a);
		Boolean b = sameTwoStudents.addStudent(a);
		assertTrue(b == false);
	}
	
}
