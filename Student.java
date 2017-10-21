import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Student extends Person {
	private int cin;
	private List<Course> studentCourses;
	private List<Course> courses;
	
	public Student() {
	}
	
	public Student(String personName, Address personAddress, int cin) {
		super(personName, personAddress);
		this.cin = cin;
		studentCourses = new ArrayList<Course>();
	}
	
	public int getCin() {
		return cin;
	}
	
	public List<Course> getStudentCourses() {
		return studentCourses;
	}
	
	public void addStudentCourse(Course course) {
		studentCourses.add(course);
	}
	
	public void dropStudentCourse(Course course) {
		studentCourses.remove(course);
	}
	

	public StringBuilder listStudentCourses() {
		List<Course> studentCourses = getStudentCourses();
		
		StringBuilder sb = new StringBuilder("");
		int count = 1;
		
		if (studentCourses.isEmpty()) {
			sb.append("None");
		}
		else {
			for (Course sc: studentCourses) {
				sb.append("\n   " + count + ". " + sc);
				count++;
			}
		}
		
		return sb;
	}
	
	
	public void addStudentCourse(List<Course> courses) {
		this.courses = courses;
		int cin = getCin();
		StringBuilder sb = new StringBuilder( "Available Courses (Course ID; Course Title):\n");
		
		for (Course c: courses) {
				sb.append(c + "\n");
			}
			
		String courseId = JOptionPane.showInputDialog(sb + "\nPlease enter the ID of the course that you wish to add");
		boolean checker = false;
	
		for (int count = 0 ; count < courses.size() ; count++) {
			if (courseId.equals(courses.get(count).getCourseId())) {
				addStudentCourse(courses.get(count));
				checker = true;
			}
		}
		
		if(checker) {
				JOptionPane.showMessageDialog(null, courseId + " has been added to student with CIN: " + cin + ".");
			}
			
		else {
			JOptionPane.showMessageDialog(null, "None matched the Course ID provided.");
		}
	}
	
	public void dropStudentCourse() {
		int cin = getCin();
		List<Course> studentCourses = getStudentCourses();
		
		if (studentCourses.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Student with CIN: " + cin + " is currently not taking any courses.");
		} 
		
		else {
			StringBuilder sb = new StringBuilder( "Current Course Schedule (Course ID; Course Title):\n");
		
			for (Course sc: studentCourses) {
				sb.append(sc + "\n");
			}
			
			String courseId = JOptionPane.showInputDialog(sb + "\nPlease enter the ID of the course that you wish to drop");
			boolean checker = false;
		
			for (int count = 0 ; count < studentCourses.size() ; count++) {
				if (courseId.equals(studentCourses.get(count).getCourseId())) {
					dropStudentCourse(studentCourses.get(count));
					checker = true;
				}
			}
			
			if(checker) {
				JOptionPane.showMessageDialog(null, "Student with CIN: " + cin + " has dropped " + courseId + ".");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Student with CIN: " + cin + " is currently not taking " + courseId + ".");
			}	
		}
	}

	public String toString() {
		return super.toString() + "\nCIN: " + cin + "\nCourse Schedule: " + listStudentCourses();
	}
}
