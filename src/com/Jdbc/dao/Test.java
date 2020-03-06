package com.Jdbc.dao;

public class Test {
	public static void main(String[] args) {
		
		Student stu = new Student();
		stu.setId(1);
		stu.setName("Àî°×");
		stu.setAge(18);
		StudentDao dao = new StudentDao();
		dao.save(stu);
	}
}
