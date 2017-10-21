import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FacultyMember extends Person {
	private int employeeId;
	private List<Course> facultyMemberCourses;
	private List<Course> courses;
	
	public FacultyMember() {
	}
	
	public FacultyMember(String personName, Address personAddress, int employeeId) {
		super(personName, personAddress);
		this.employeeId = employeeId;
		facultyMemberCourses = new ArrayList<Course>();
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public List<Course> getFacultyMemberCourses() {
		return facultyMemberCourses;
	}
	
	public void addFacultyMemberCourse(Course course) {
		facultyMemberCourses.add(course);
	}
	
	public void dropFacultyMemberCourse(Course course) {
		facultyMemberCourses.remove(course);
	}
	

	public StringBuilder listFacultyMemberCourses() {
		List<Course> facultyMemberCourses = getFacultyMemberCourses();
		
		StringBuilder sb = new StringBuilder("");
		int count = 1;
		
		if (facultyMemberCourses.isEmpty()) {
			sb.append("None");
		}
		else {
			for (Course fmc: facultyMemberCourses) {
				sb.append("\n   " + count + ". " + fmc);
				count++;
			}
		}
		
		return sb;
	}
	
	
	public void addFacultyMemberCourse(List<Course> courses) {
		this.courses = courses;
		int employeeId = getEmployeeId();
		StringBuilder sb = new StringBuilder( "Available Courses (Course ID; Course Title):\n");
		
		for (Course c: courses) {
				sb.append(c + "\n");
			}

		String courseId = JOptionPane.showInputDialog(sb + "\nPlease enter the ID of the course that you wish to add");
		boolean checker = false;
	
		for (int count = 0 ; count < courses.size() ; count++) {
			if (courseId.equals(courses.get(count).getCourseId())) {
				addFacultyMemberCourse(courses.get(count));
				checker = true;
			}
		}
		
		if(checker) {
				JOptionPane.showMessageDialog(null, courseId + " has been added to faculty member with Employee ID: " + employeeId + ".");
			}
			
		else {
			JOptionPane.showMessageDialog(null, "None matched the Course ID provided.");
		}
	}
	
	public void dropFacultyMemberCourse() {
		int employeeId = getEmployeeId();
		List<Course> facultyMemberCourses = getFacultyMemberCourses();
		
		if (facultyMemberCourses.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faculty Member with Employee ID: " + employeeId + " is currently not teaching any courses.");
		} 
		
		else {
			StringBuilder sb = new StringBuilder( "Current Teaching Schedule (Course ID; Course Title):\n");
		
			for (Course fmc: facultyMemberCourses) {
				sb.append(fmc + "\n");
			}
			
			String courseId = JOptionPane.showInputDialog(sb + "\nPlease enter the ID of the course that you wish to drop");
			boolean checker = false;
		
			for (int count = 0 ; count < facultyMemberCourses.size() ; count++) {
				if (courseId.equals(facultyMemberCourses.get(count).getCourseId())) {
					dropFacultyMemberCourse(facultyMemberCourses.get(count));
					checker = true;
				}
			}
			
			if(checker) {
				JOptionPane.showMessageDialog(null, "Faculty Member with Employee ID: " + employeeId + " has dropped" + courseId + ".");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Faculty Member with Employee ID: " + employeeId + " is currently not teaching " + courseId + ".");
			}	
		}
	}

	public String toString() {
		return super.toString() + "\nEmployee ID: " + employeeId + "\nTeacing Schedule: " + listFacultyMemberCourses();
	}
}
