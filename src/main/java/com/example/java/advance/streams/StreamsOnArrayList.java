package com.example.java.advance.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsOnArrayList {
	public static void main(String[] args) {
		List<Employee> l1= Arrays.asList(new Employee(1,"Rahul",31, "IT"),
				new Employee(2,"Akash",32, "IT"),
				new Employee(3,"Prakash",35, "Admin")
				);
		
		List<Employee> l2= Arrays.asList(new Employee(1,"Pravin",31, "Admin"),
				new Employee(2,"Rakesh",52, "IT"),
				new Employee(3,"Nagesh",55, "IT")
				);
		
		 l2.stream().filter(em -> em.age > l1.stream().mapToInt(emp -> emp.getAge()).max().getAsInt()).forEach(System.out::print);	

		 System.out.println("***********************************************************************************\n");
		 
		 Map<String, Object> maxAgePerDept =getEmpList().stream()
				 .collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(Collectors.toList(),
						 list -> list.stream().mapToInt(Employee::getAge).max().orElse(0))));
		 
		 maxAgePerDept.forEach((e, v) -> System.out.print("key:"+e+"val:"+v));
		 
	}
	
	public static List<Employee> getEmpList(){
		return Arrays.asList(new Employee(1,"Rahul",31, "IT"),
				new Employee(2,"Akash",32, "IT"),
				new Employee(3,"Prakash",35, "Admin"),
				new Employee(1,"Pravin",31, "Admin"),
				new Employee(2,"Rakesh",52, "IT"),
				new Employee(3,"Nagesh",55, "IT")
				);
	}

}

class Employee{
	int id;
	String name;
	int age;
	String dept;
	public Employee(int id, String name, int age, String dept) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.dept=dept;
	}
	public Employee() {
		
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}
	
}
