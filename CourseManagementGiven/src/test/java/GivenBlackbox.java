package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.Course;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades5;
import main.java.Major;
import main.java.Student;
import main.java.CourseGrades4;
import main.java.CourseGrades0;
import main.java.CourseGrades3;

import java.lang.reflect.Constructor;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;
    
    
    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }
    
    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }
    
    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }
    
    /*
     * Name: Grade Tests
     * Method: countOccurencesLetterGrades()
     */
    // A sample course
    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with two Students having
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);
    }
    
    // Sample test
    /*
    @Test
    public void twoStudent() {
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue("more or less than two students have A's", ans.equals(twoStudentExpected));
    }
    */
    
    /*
     * Name: Grade F Tests
     * Method: countOccurencesLetterGrades()
     */
    // A sample course
    Course oneStudentFlow;
    Course oneStudentFup;
    Course oneStudentFmid;
    HashMap<String, Integer> oneStudentFExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp1() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with one Student having (lower boundary)
        oneStudentFlow = createCourse("SER316");
        oneStudentFlow.set_points("Ralph", 0);
        // Course created with one Student having (upper boundary)
        oneStudentFup = createCourse("SER316");
        oneStudentFup.set_points("Johnny", 35);
     // Course created with one Student having (between boundary)
        oneStudentFmid = createCourse("SER316");
        oneStudentFmid.set_points("Alex", 28);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        oneStudentFExpected.put("A", 0);
        oneStudentFExpected.put("B", 0);
        oneStudentFExpected.put("C", 0);
        oneStudentFExpected.put("D", 0);
        oneStudentFExpected.put("F", 1);
    }
    
    // Sample test
    /*
    @Test
    public void oneFLow() {
    	// Lower boundary Assert
        HashMap<String, Integer> ansLow = oneStudentFlow.countOccurencesLetterGrades();
        System.out.println(ansLow);
        assertTrue("more or less than one Student has an F", ansLow.equals(oneStudentFExpected));
        //Fails 0,3,4,5
        //Error at CourseGrade1
    }
    
    @Test
    public void oneFUp() {
    	// Upper boundary Assert
        HashMap<String, Integer> ansUp = oneStudentFup.countOccurencesLetterGrades();
        System.out.println(ansUp);
        assertTrue("more or less than one Student has an F", ansUp.equals(oneStudentFExpected));
        //Fails 0,1,3,4,5
        //Does not Fail at CourseGrade1
    }
    
    @Test
    public void oneFMid() {
    	// Middle boundary Assert
        HashMap<String, Integer> ansUp = oneStudentFmid.countOccurencesLetterGrades();
        System.out.println(ansUp);
        assertTrue("more or less than one Student has an F", ansUp.equals(oneStudentFExpected));
        //Fails 0,1,3,4,5
        //Does not Fail at CourseGrade1
    }
    */
    
    
    
    /*
     * Name: Grade D Tests
     * Method: countOccurencesLetterGrades()
     */
    // A sample course
    Course oneStudentDlow;
    Course oneStudentDup;
    Course oneStudentDmid;
    HashMap<String, Integer> oneStudentDExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp2() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with one Student having (lower boundary)
        oneStudentFlow = createCourse("SER316");
        oneStudentFlow.set_points("Ralph", 36);
        // Course created with one Student having (upper boundary)
        oneStudentFup = createCourse("SER316");
        oneStudentFup.set_points("Johnny", 40);
     // Course created with one Student having (between boundary)
        oneStudentFmid = createCourse("SER316");
        oneStudentFmid.set_points("Alex", 49);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        oneStudentDExpected.put("A", 0);
        oneStudentDExpected.put("B", 0);
        oneStudentDExpected.put("C", 0);
        oneStudentDExpected.put("D", 1);
        oneStudentDExpected.put("F", 0);
    }
    
    // Sample test
    @Test
    public void oneDLow() {
    	// Lower boundary Assert
        HashMap<String, Integer> ansLow = oneStudentFlow.countOccurencesLetterGrades();
        System.out.println(ansLow);
        assertTrue("more or less than one Student has an D", ansLow.equals(oneStudentDExpected));
        //Only CourseGrades2 fits this condition, therefore, all students in CourseGrade2 besides Ralph are above an F
        //Fails at CourseGrade1
    }
    
    @Test
    public void oneDUp() {
    	// Upper boundary Assert
        HashMap<String, Integer> ansUp = oneStudentFup.countOccurencesLetterGrades();
        System.out.println(ansUp);
        assertTrue("more or less than one Student has an D", ansUp.equals(oneStudentDExpected));
        //Only CourseGrades2 fits this condition, therefore, all students in CourseGrade2 besides Johnny are above an F
        //Does not Fail at CourseGrade1
    }
    
    @Test
    public void oneDMid() {
    	// Middle boundary Assert
        HashMap<String, Integer> ansUp = oneStudentFmid.countOccurencesLetterGrades();
        System.out.println(ansUp);
        assertTrue("more or less than one Student has an D", ansUp.equals(oneStudentDExpected));
        //Only CourseGrades2 fits this condition, therefore, all students in CourseGrade2 besides Johnny are above an F
        //Does not Fail at CourseGrade1
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    Course studentDouble;
    ArrayList<Student> studentAddAttempt = new ArrayList<Student>();
    Student a = new Student("john", Major.valueOf("SER"));
    Student b = new Student("anna", Major.valueOf("CS"));
    
    @Before
    public void setUp1() throws Exception {
    	
    	studentDouble = createCourse("SER315");
    	studentDouble.addStudent(a);
    	//attempting to add the student to the class
    	studentAddAttempt.add(b);
    }
   
    
    //Test to see if student already added
    @Test
    public void studentDouble() {
    	//Asurite ID's should be unique so if the Asurite already exists it can't be added. 
    	//A simple check can be done
    	String s1 = studentDouble.getStudents().get(0).getAsurite();
    	String s2 = studentAddAttempt.get(0).getAsurite();
    	if (s1.equals(s2)) {
    		System.out.println(true);
    	} else {
    		System.out.println(false);
    	}
    	assertNotSame("Cannot add - already in the class", s1, s2);
    }
    */

}
