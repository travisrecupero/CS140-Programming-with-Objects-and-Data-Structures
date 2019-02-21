package assignment01;

public class Employee {

	private Company company;
	private double salary;
	private Person person;

	public Employee(Company company, double salary, Person person) {
		this.company = company;
		this.salary = salary;
		this.person = person;
		person.getHistory()[2] = this;
	}

	public Company getCompany() {
		return company;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Person getPerson() {
		return person;
	}

}
