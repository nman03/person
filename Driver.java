import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Driver {
	private String driverName;
	private List<Student> students;
	private List<FacultyMember> facultyMembers;
	private List<Course> courses;
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
	}	
	
	public List<FacultyMember> getFacultyMembers() {
		return facultyMembers;
	}
	
	public void addFacultyMember(FacultyMember facultyMember) {
		facultyMembers.add(facultyMember);
	}
	
	public void removeFacultyMember(FacultyMember facultyMember) {
		facultyMembers.remove(facultyMember);
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	public Driver(String driverName) {
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
		facultyMembers = new ArrayList<FacultyMember>();
		this.driverName = driverName;
	}
	
	public void administer() {
		
		String[] choices = {"Quit", "Student Menu", "Faculty Member Menu", "Course Menu"}; //Main Menu
		
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "Main Menu", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices, "null");
			
			switch (choice) {
				case 0: break;
				case 1: String[] choices1 = {"Return to Main Menu", "Add Student", "Delete Student", "List Students", "Add Course For A Student", "Drop Course For A Student" }; //Student Menu
						int choice1;
						
						do {
							choice1 = JOptionPane.showOptionDialog(null, "Student Menu", "Student Menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices1, "null");
							
							switch (choice1) {
								case 0: break;
								case 1: addStudent();
										break;
								case 2: removeStudent();
										break;
								case 3: listStudents();
										break;
								case 4: addCourseForStudent();
										break;
								case 5: dropCourseForStudent();
										break;
							}
						} while (choice1 != 0);
						
						break;
				case 2: String[] choices2 = {"Return to Main Menu", "Add Faculty Member", "Delete Faculty Member", "List Faculty Members", "Add Course For A Faculty Member", "Drop Course For A Faculty Member" }; //Faculty Member Menu
						int choice2;
						
						do {
							choice2 = JOptionPane.showOptionDialog(null, "Faculty Member Menu", "Faculty Member Menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices2, "null");
							
							switch (choice2) {
								case 0: break;
								case 1: addFacultyMember();
										break;
								case 2: removeFacultyMember();
										break;
								case 3: listFacultyMembers();
										break;
								case 4: addCourseForFacultyMember();
										break;
								case 5: dropCourseForFacultyMember();
										break;
							}
						} while (choice2 != 0);
						break;
				case 3: String[] choices3 = {"Return to Main Menu", "Add Course", "List Courses"}; //Course Menu
						int choice3;
						
						do {
							choice3 = JOptionPane.showOptionDialog(null, "Course Menu", "Course Menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices3, "null");
							
							switch (choice3) {
								case 0: break;
								case 1: addCourse();
										break;
								case 2: listCourses();
										break;
							}
						} while (choice3 != 0);
						
						break;			
			}
			
		} while (choice != 0);
	}
	
	private void addStudent() {
		String personName = JOptionPane.showInputDialog("Please enter the name of the student");
		int streetNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter the student's home street number"));
		String streetName = JOptionPane.showInputDialog("Please enter the student's home street name");
		String city = JOptionPane.showInputDialog("Please enter the name of the city where the student lives");
		String stateOrProvince = JOptionPane.showInputDialog("Please enter the name of the state or province where the student lives");
		String country = JOptionPane.showInputDialog("Please enter the name of the country where the student lives");
		int cin = Integer.parseInt(JOptionPane.showInputDialog("Please enter the student's CIN"));
		addStudent(new Student(personName, new Address(streetNum, streetName, city, stateOrProvince, country), cin));
	}
	
	private void removeStudent() {
		List<Student> students = getStudents();
			
		if (students.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no student data available.");
		} 
		
		else {
			int cin = Integer.parseInt(JOptionPane.showInputDialog("Please enter the CIN of the student that you wish to delete"));
			boolean checker = false;
		
			for (int count = 0 ; count < students.size() ; count++) {
				if (cin == students.get(count).getCin()) {
					removeStudent(students.get(count));
					checker = true;
				}
			}
			
			if(checker) {
				JOptionPane.showMessageDialog(null, "Student with CIN: " + cin + " has been deleted.");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "None matched the CIN provided.");
			}	
		}
	}
	
	private void listStudents() {
		List<Student> students = getStudents();
		
		StringBuilder sb = new StringBuilder("Students:\n");
		
		if (students.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no student data available.");
		}
		else {
			for (Student s: students) {
				sb.append(s + "\n\n");
			}
			JOptionPane.showMessageDialog(null, sb);
		}
	}
	
	private void addCourseForStudent() {
		List<Student> students = getStudents();
		List<Course> courses = getCourses();
			
		if (students.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no student data available.");
		} 
		
		else if (courses.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no available courses at this time.");
		}
			
		else {
			int cin = Integer.parseInt(JOptionPane.showInputDialog("Please enter the CIN of the student that you wish to add a course to"));
			boolean checker = false;
		
			for (int count = 0 ; count < students.size() ; count++) {
				if (cin == students.get(count).getCin()) {
					students.get(count).addStudentCourse(courses);
					checker = true;
				}
			}
			
			if(!checker) {
				JOptionPane.showMessageDialog(null, "None matched the CIN provided.");
			}	
		}
		
		
	}
	
	private void dropCourseForStudent() {
		List<Student> students = getStudents();
			
		if (students.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no student data available.");
		} 
		
		else {
			int cin = Integer.parseInt(JOptionPane.showInputDialog("Please enter the CIN of the student that you wish to drop a course from"));
			boolean checker = false;
		
			for (int count = 0 ; count < students.size() ; count++) {
				if (cin == students.get(count).getCin()) {
					students.get(count).dropStudentCourse();
					checker = true;
				}
			}
			
			if(!checker) {
				JOptionPane.showMessageDialog(null, "None matched the CIN provided.");
			}	
		}
	}
	
	private void addFacultyMember() {
		String personName = JOptionPane.showInputDialog("Please enter the name of the faculty member");
		int streetNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter the faculty member's home street number"));
		String streetName = JOptionPane.showInputDialog("Please enter the faculty member's home street name");
		String city = JOptionPane.showInputDialog("Please enter the name of the city where the faculty member lives");
		String stateOrProvince = JOptionPane.showInputDialog("Please enter the name of the state or province where the faculty member lives");
		String country = JOptionPane.showInputDialog("Please enter the name of the country where the faculty member lives");
		int employeeId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the faculty member's Employee ID"));
		addFacultyMember(new FacultyMember(personName, new Address(streetNum, streetName, city, stateOrProvince, country), employeeId));
	}
	
	private void removeFacultyMember() {
		List<FacultyMember> facultyMembers = getFacultyMembers();
			
		if (facultyMembers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no faculty member data available.");
		} 
		
		else {
			int employeeId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Employee ID of the faculty member that you wish to delete"));
			boolean checker = false;
		
			for (int count = 0 ; count < facultyMembers.size() ; count++) {
				if (employeeId == facultyMembers.get(count).getEmployeeId()) {
					removeFacultyMember(facultyMembers.get(count));
					checker = true;
				}
			}
			
			if(checker) {
				JOptionPane.showMessageDialog(null, "Faculty Member with Employee ID: " + employeeId+ " has been deleted.");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "None matched the Employee ID provided.");
			}	
		}
	}
	
	private void listFacultyMembers() {
		List<FacultyMember> facultyMembers = getFacultyMembers();
		
		StringBuilder sb = new StringBuilder("Faculty Members:\n");
		
		if (facultyMembers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no faculty member data available");
		}
		else {
			for (FacultyMember fm: facultyMembers) {
				sb.append(fm + "\n\n");
			}
			JOptionPane.showMessageDialog(null, sb);
		}
	}
	
	private void addCourseForFacultyMember() {
		List<FacultyMember> facultyMembers = getFacultyMembers();
		List<Course> courses = getCourses();
			
		if (facultyMembers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no faculty member data available.");
		} 
		
		else if (courses.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no available courses at this time.");
		}
			
		else {
			int employeeId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Employee ID of the faculty member that you wish to add a course to"));
			boolean checker = false;
		
			for (int count = 0 ; count < facultyMembers.size() ; count++) {
				if (employeeId == facultyMembers.get(count).getEmployeeId()) {
					facultyMembers.get(count).addFacultyMemberCourse(courses);
					checker = true;
				}
			}
			
			if(!checker) {
				JOptionPane.showMessageDialog(null, "None matched the Employee provided.");
			}	
		}
		
		
	}
	
	private void dropCourseForFacultyMember() {
		List<FacultyMember> facultyMembers = getFacultyMembers();
			
		if (facultyMembers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no faculty member data available.");
		} 
		
		else {
			int employeeId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Employee ID of the faculty member that you wish to drop a course from"));
			boolean checker = false;
		
			for (int count = 0 ; count < facultyMembers.size() ; count++) {
				if (employeeId == facultyMembers.get(count).getEmployeeId()) {
					facultyMembers.get(count).dropFacultyMemberCourse();
					checker = true;
				}
			}
			
			if(!checker) {
				JOptionPane.showMessageDialog(null, "None matched the Employee ID provided.");
			}	
		}
	}
	
	private void listCourses() {
		List<Course> courses = getCourses();
		
		StringBuilder sb = new StringBuilder( "Available Courses (Course ID; Course Title):\n");
		
		if (courses.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no available courses at this time.");
		}
		
		else {
			for (Course c: courses) {
				sb.append(c + "\n");
			}
			JOptionPane.showMessageDialog(null, sb);
		}
		
	}
	
	private void addCourse() {
		String courseId = JOptionPane.showInputDialog("Please enter the Course Identifier");
		String courseTitle = JOptionPane.showInputDialog("Please enter the title of the course");
		addCourse(new Course(courseId, courseTitle));
	}
	
	public static void main(String[] args) {
		Driver start = new Driver("Finally");
		start.administer();
	}
}
