package com.Jdbc.dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryClass {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		// url 数据库地址
		String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
		// user 用户名
		String user = "root";
		// password 密码
		String password = "root";

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "select * from emp";
		// String sql = "select count(*) as total from student";
		Statement st = conn.createStatement();

		ResultSet res = st.executeQuery(sql);

		while (res.next()) {
			int empno = res.getInt("empno");
			String ename = res.getString("ename");
			String job = res.getString("job");
			System.out.println("empno = " + empno + " ename = " + ename + " job = " + job);
		}

		st.close();
		conn.close();
	}

	static void test1() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// url 数据库地址
		String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
		// user 用户名
		String user = "root";
		// password 密码
		String password = "root";

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "select * from emp where ename = '鲁班'";
		// String sql = "select count(*) as total from student";
		Statement st = conn.createStatement();

		ResultSet res = st.executeQuery(sql);

		if (res.next()) {
			/*
			 * int count = res.getInt("total"); System.out.println(count);
			 */
			int empno = res.getInt("empno");
			String ename = res.getString("ename");
			String job = res.getString("job");
			System.out.println("empno = " + empno + " ename = " + ename + " job = " + job);
		}

		st.close();
		conn.close();
	}
}
