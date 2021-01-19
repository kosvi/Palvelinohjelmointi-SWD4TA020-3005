package domain;

public class Student implements Comparable<Student> {
	private String firstname;
	private String lastname;

	public Student(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return firstname + " " + lastname + "\n";
	}

	@Override
	public int compareTo(Student o) {
		if (!this.lastname.equalsIgnoreCase(o.lastname)) {
			return this.lastname.compareTo(o.lastname);
		} else {
			return this.firstname.compareTo(o.firstname);
		}
	}

}
