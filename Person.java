import java.util.ArrayList;
import java.util.List;

public class Person {
	private String personName;
	private Address personAddress;
	
	public Person() {
	}
	
	public Person(String personName, Address personAddress) {
		this.personName = personName;
		this.personAddress = personAddress;
	}
	
	public String toString() {
		return "Name: " + personName + "\nAddress: " + personAddress;
	}
}
