package com.Jdbc.dao;

public class Test1 {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setId(2);
		stu.setName("Â³°à");
		stu.setAge(16);
		StudentDao dao = new StudentDao();
		dao.save(stu);
	}
}
