package assignment03;

public class Employee implements Occupation {

	private Company company;
	private double salary;
	private Person person;

	public Employee(Company company, double salary, Person person) {
		this.company = company;
		this.salary = salary;
		this.person = person;
		person.addOccupation(this);
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

	public Employee changeJob(Company comp) {
		return new Employee(comp, this.salary, this.person);
	}
	
	@Override
	public void print() {
		System.out.println("\tCompany: " + getCompany().getName());
	}

}
