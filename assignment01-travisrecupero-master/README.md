# assignment01

<h1>Due Wednesday August 29, 11:59pm</h1>

This is a lot about writing classes with private fields, constructors, getter and setter methods, plus a couple of other methods and a driver.

All the classes need to be in <b>package assignment01</b>. All the classes - Person, HighSchool, HighSchoolStudent, University, UniversityStudent, Employee, Company and Driver - are public classes, each one in its own file (Person.java, HighSchool.java, HighSchoolStudent.java, University.java,  UniversityStudent.java,  Employee.java, Company.java, and Driver.java).

 
<b>Person</b> has private fields <b>String name</b>, <b>LocalDate birthdate</b> (you need to import <b>java.time.LocalDate</b> for your class), and <b>Object[] history = new Object[3]</b>. This is an array, which we will be covering pretty soon in class—for now just follow all the instructions about working with arrays.

<b>HighSchool</b> has a private field <b>String name</b> (this is the high school name)
<b>University</b> has private fields <b>String name</b> (this is the university name) and <b>String city</b> (the city where the university is located).
<b>Company</b> has private fields <b>String name</b> (this is the company name) and <b>String city</b> (the city of the headquarters of the company).

<b>HighSchoolStudent</b> has private fields <b>HighSchool highSchool</b> and <b>Person person</b>.
<b>UniversityStudent</b> has private fields <b>University university</b> and <b>Person person</b>.
<b>Employee</b> has private fields <b>Company company</b>, <b>double salary</b>, and <b>Person person</b>.

Provide constructors to set all the fields of all the classes and provide *getter* methods for all the fields. The only tricky constructor is <b>Person</b>, here it is:

```java
public Person(String aName, int day, int month, int year) {
    name = aName;
    birthdate = LocalDate.of(year, month, day);
}
```

A *getter* method would be (the name of a *getter* starts with “get” and then has the name of the field but with the first letter changed to upper cases):

```java
LocalDate getBirthdate( ) {
    return birthdate;
}
```

<b>Employee</b> needs a *setter* method to change <b>salary</b>. It is a <b>void</b> method called <b>setSalary</b> that has a <b>double</b> parameter, which is the new value of <b>salary</b>.

In the constructor of <b>HighSchoolStudent</b>, you need to include the instruction 
 > person.getHistory()[0] = this;  
 
In the constructor of <b>UniversityStudent</b>, you need to include the instruction 
> person.getHistory()[1] = this;  

In the constructor of <b>Employee</b>, you need to include the instruction 
> person.getHistory()[2] = this;  

In <b>HighSchoolStudent</b>, provide a method <b>public UniversityStudent goToUniversity(University univ)</b>, which returns a new <b>UniversityStudent</b> object, with <b>univ</b> as its <b>university</b> field and the same <b>person</b> field as this <b>HighSchoolStudent</b>’s <b>person</b> field.

In <b>UniversityStudent</b>, provide a method <b>public Employee getAJob(Company comp, double startingSalary)</b>, which returns a new <b>Employee</b> object, with <b>comp</b> as its <b>Company</b> field, <b>startingSalary</b> as its <b>salary</b> and the same <b>person</b> field as this <b>UniversityStudent</b>’s <b>person</b> field.



In the class <b>Person</b>, complete the method <b>printHistory</b> (since there are things that we have not got to, part of the code is provided):


```java
public void printHistory() {
	System.out.println("History of " + name);
	if(history[0] != null) {
		// in the next line we "cast" history[0] to a HighSchoolStudent object
		HighSchoolStudent hss = (HighSchoolStudent)history[0];
		// in the next line the char '\t' provides a tab indent
		System.out.println("\tHigh school: " + hss.getHighschool().getName());
	}
	if(history[1] != null) {
		//Use the similar approach to "cast" history[1] to a UniversityStudent object.
		//From that object, the getUniversity method gives you the university and from that
		//the getter methods will give the name and city of the university.
		//In the System.out.println, start with "\tUniversity: " + followed by the name of the university
		//next comes + " in " + followed by the city where the university is located.
		//Example: 	University: Duke in Durham, NC
		}
	if(history[2] != null) {
		Employee e = (Employee)history[2];
		//we have not explained the format or printf methods that were in Lab 1, so 
		//this is provided:
		System.out.format("\tJob at %s in %s, with a salary of %.2f\n", 
			e.getCompany().getName(), e.getCompany().getCity(), e.getSalary());
	}
}
```

Create a class <b>Driver</b> with a main method--this must be <b>public static void main(String[] args)</b>.



[yes this is tedious but it has to be done--I found I had made a couple of mistakes in typing up the assignment code]



(You are permitted to use arrays for the following different groups but it is not required.)  
Make FOUR <b>Person</b> objects with different <b>name</b>s.  

Make THREE <b>HighSchool</b> objects, with different <b>name</b>s (by the way, did you hear that a local high school Maine-Endwell won the Little League World championship last week by beating Korea?).

Make THREE <b>HighSchoolStudent</b> objects using the 3 different <b>HighSchool</b> objects and 3 of the different <b>Person</b> objects.

Make TWO <b>University</b> objects, for example <b>new University("Duke", "Durham, NC")</b> could be one, and use the <b>goToUniversity</b> method of TWO of the <b>HighSchoolStudent</b> objects to make two <b>UniversityStudent</b> objects.

Make one <b>Company</b> object and use it with the <b>getAJob</b> of one of the <b>UniversityStudent</b> objects to make an <b>Employee</b> object (be optimistic and provide a 6-figure salary).  

Call <b>printHistory()</b> on each of the four <b>Person</b> objects. Separate the <b>printHistory</b> calls by 
> <b>System.out.println("---------------------");</b>  

to separate the outputs. The different <b>Person</b> objects will have 1, 2, 3, and 4 lines of output.
