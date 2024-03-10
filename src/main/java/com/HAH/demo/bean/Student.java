package com.HAH.demo.bean;

import java.util.List;

public class Student {

	private String name;
	private int age;
	private List<String> interest;

	public Student(String name, int age, List<String> interest) {
		super();
		this.name = name;
		this.age = age;
		this.interest = interest;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getInterest() {
		return interest;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
