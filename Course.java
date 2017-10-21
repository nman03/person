import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Course {
	private String courseId;
	private String courseTitle;
	private List<Course> courses = new ArrayList<Course>();
	
	public Course() {
	}
	
	public Course(String courseId, String courseTitle) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public List<Course> getCourses() {
		return courses;
	}

	public String toString() {
		return courseId + "; " + courseTitle;
	}
	
}
