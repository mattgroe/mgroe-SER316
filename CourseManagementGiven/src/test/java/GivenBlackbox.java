package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
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
    @Test
    public void twoStudent() {
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue("more or less than two students have A's", ans.equals(twoStudentExpected));
    }
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

    @Test
    public void oneFLow() {
    	// Lower boundary Assert
        HashMap<String, Integer> ansLow = oneStudentFlow.countOccurencesLetterGrades();
        System.out.println(ansLow);
        assertTrue("more or less than one Student has an F", ansLow.equals(oneStudentFExpected));
        //Success 2
        //Fails 0,3,4,5
        //Errors 1
    }
    
    @Test
    public void oneFUp() {
    	// Upper boundary Assert
        HashMap<String, Integer> ansUp = oneStudentFup.countOccurencesLetterGrades();
        System.out.println(ansUp);
        assertTrue("more or less than one Student has an F", ansUp.equals(oneStudentFExpected));
        //Success 2
        //Fails 0,1,3,4,5
        //No error
    }
    
    @Test
    public void oneFMid() {
    	// Middle boundary Assert
        HashMap<String, Integer> ansMid = oneStudentFmid.countOccurencesLetterGrades();
        System.out.println(ansMid);
        assertTrue("more or less than one Student has an F", ansMid.equals(oneStudentFExpected));
        //Success 2
        //Fails 0,1,3,4,5
        //No error
    }   
    
    
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
        oneStudentDlow = createCourse("SER316");
        oneStudentDlow.set_points("Ralph", 36);
        // Course created with one Student having (upper boundary)
        oneStudentDup = createCourse("SER316");
        oneStudentDup.set_points("Johnny", 50);
     // Course created with one Student having (between boundary)
        oneStudentDmid = createCourse("SER316");
        oneStudentDmid.set_points("Alex", 40);
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
        HashMap<String, Integer> ansLow = oneStudentDlow.countOccurencesLetterGrades();
        //System.out.println(ansLow);
        assertTrue("more or less than one Student has an D", ansLow.equals(oneStudentDExpected));
        //Success 0
        //Fails 2,3,4,5
        //Errors 1
    }
    
    @Test
    public void oneDUp() {
    	// Upper boundary Assert
        HashMap<String, Integer> ansUp = oneStudentDup.countOccurencesLetterGrades();
        //System.out.println(ansUp);
        assertTrue("more or less than one Student has an D", ansUp.equals(oneStudentDExpected));
        //Fails 0,1,2,3,4,5
        //No errors
    }
    
    @Test
    public void oneDMid() {
    	// Middle boundary Assert
        HashMap<String, Integer> ansMid = oneStudentDmid.countOccurencesLetterGrades();
        //System.out.println(ansUp);
        assertTrue("more or less than one Student has an D", ansMid.equals(oneStudentDExpected));
        //Fails 0,1,2,3,4,5
        //No errors
    }
//    
//    
//    /*
//     * Name: Grade C Tests
//     * Method: countOccurencesLetterGrades()
//     */
//    // A sample course
    Course oneStudentClow;
    Course oneStudentCup;
    Course oneStudentCmid;
    HashMap<String, Integer> oneStudentCExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp3() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with one Student having (lower boundary)
        oneStudentClow = createCourse("SER316");
        oneStudentClow.set_points("Ralph", 51);
        // Course created with one Student having (upper boundary)
        oneStudentCup = createCourse("SER316");
        oneStudentCup.set_points("Johnny", 65);
     // Course created with one Student having (between boundary)
        oneStudentCmid = createCourse("SER316");
        oneStudentCmid.set_points("Alex", 58);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        oneStudentCExpected.put("A", 0);
        oneStudentCExpected.put("B", 0);
        oneStudentCExpected.put("C", 1);
        oneStudentCExpected.put("D", 0);
        oneStudentCExpected.put("F", 0);
    }
    
    // Sample test
    @Test
    public void oneCLow() {
    	// Lower boundary Assert
        HashMap<String, Integer> ansLow = oneStudentClow.countOccurencesLetterGrades();
        System.out.println("ansLow C: " + ansLow);
        assertTrue("more or less than one Student has an C", ansLow.equals(oneStudentCExpected));
        //Success 
        //Fails 0,1,2,3,4,5
        //No errors
    }
    
    @Test
    public void oneCUp() {
    	// Upper boundary Assert
        HashMap<String, Integer> ansUp = oneStudentCup.countOccurencesLetterGrades();
        System.out.println("ansUp C: " + ansUp);
        assertTrue("more or less than one Student has an C", ansUp.equals(oneStudentCExpected));
        //Fails 0,1,2,3,4,5
        //No errors
    }
    
    @Test
    public void oneCMid() {
    	// Middle boundary Assert
        HashMap<String, Integer> ansMid = oneStudentCmid.countOccurencesLetterGrades();
        System.out.println("andMid C: " + ansMid);
        assertTrue("more or less than one Student has an C", ansMid.equals(oneStudentCExpected));
        //Fails 0,1,2,3,4,5
        //No errors
    }
    
    
    /*
     * Name: Grade B Tests
     * Method: countOccurencesLetterGrades()
     */
    // A sample course
    Course oneStudentBlow;
    Course oneStudentBup;
    Course oneStudentBmid;
    HashMap<String, Integer> oneStudentBExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp4() throws Exception {
        
        // all courses should be created like this
        // Course created with one Student having (lower boundary)
        oneStudentBlow = createCourse("SER316");
        oneStudentBlow.set_points("Ralph", 66);
        // Course created with one Student having (upper boundary)
        oneStudentBup = createCourse("SER316");
        oneStudentBup.set_points("Johnny", 80);
     // Course created with one Student having (between boundary)
        oneStudentBmid = createCourse("SER316");
        oneStudentBmid.set_points("Alex", 73);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        oneStudentBExpected.put("A", 0);
        oneStudentBExpected.put("B", 1);
        oneStudentBExpected.put("C", 0);
        oneStudentBExpected.put("D", 0);
        oneStudentBExpected.put("F", 0);
    }
    
    // Sample test\
    @Test
    public void oneBLow() {
    	// Lower boundary Assert
        HashMap<String, Integer> ansLow = oneStudentBlow.countOccurencesLetterGrades();
        System.out.println(ansLow);
        assertTrue("more or less than one Student has an B", ansLow.equals(oneStudentBExpected));
        //Success 0
        //Fails 2,3,4,5
        //Errors 1
    }
    
    @Test
    public void oneBUp() {
    	// Upper boundary Assert
        HashMap<String, Integer> ansUp = oneStudentBup.countOccurencesLetterGrades();
        System.out.println(ansUp);
        assertTrue("more or less than one Student has an B", ansUp.equals(oneStudentBExpected));
        //Fails 0,1,2,3,4,5
        //No errors
    }
    
    @Test
    public void oneBMid() {
    	// Middle boundary Assert
        HashMap<String, Integer> ansMid = oneStudentBmid.countOccurencesLetterGrades();
        System.out.println(ansMid);
        assertTrue("more or less than one Student has an B", ansMid.equals(oneStudentBExpected));
        //Fails 0,1,2,3,4,5
        //No errors
    }
    
    
    /*
     * Name: No Student Test
     * Method: countOccurencesLetterGrades()
     */
    // A sample course
    Course noStudents;
    HashMap<String, Integer> noStudentsExpected = new HashMap<String, Integer>(); 
    
    @Before
    public void setUp5() throws Exception {
        
        // all courses should be created like this
        // Course created with no students
        noStudents = createCourse("SER316");
        // this would be the expected result after the method countOccurencesLetterGrades is called
        noStudentsExpected.put("A", 0);
        noStudentsExpected.put("B", 0);
        noStudentsExpected.put("C", 0);
        noStudentsExpected.put("D", 0);
        noStudentsExpected.put("F", 0);
    }
    // Sample test\
    @Test(expected=NullPointerException.class)
    public void noStudent() {
    	HashMap<String, Integer> ansNo = noStudents.countOccurencesLetterGrades();
        //Success 0,2,3,4,5
        //Fails 1
        //No errors
    }
    
}   
//    
//    
//    
//    
//    
//    /*
//    Course studentDouble;
//    ArrayList<Student> studentAddAttempt = new ArrayList<Student>();
//    Student a = new Student("john", Major.valueOf("SER"));
//    Student b = new Student("anna", Major.valueOf("CS"));
//    
//    @Before
//    public void setUp1() throws Exception {
//    	
//    	studentDouble = createCourse("SER315");
//    	studentDouble.addStudent(a);
//    	//attempting to add the student to the class
//    	studentAddAttempt.add(b);
//    }
//   
//    
//    //Test to see if student already added
//    @Test
//    public void studentDouble() {
//    	//Asurite ID's should be unique so if the Asurite already exists it can't be added. 
//    	//A simple check can be done
//    	String s1 = studentDouble.getStudents().get(0).getAsurite();
//    	String s2 = studentAddAttempt.get(0).getAsurite();
//    	if (s1.equals(s2)) {
//    		System.out.println(true);
//    	} else {
//    		System.out.println(false);
//    	}
//    	assertNotSame("Cannot add - already in the class", s1, s2);
//    }
//    */
//
//}
