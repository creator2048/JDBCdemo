package com.Jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDao {

	public void save(Student stu) {
		String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
		String user = "root";
		String password = "root";
		Connection conn = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接对象
			conn = DriverManager.getConnection(url, user, password);
			// 创建SQL语句
			Integer id = stu.getId();
			String name = stu.getName();
			Integer age = stu.getAge();
			String sql = "insert into student values("+id+",'"+name+"',"+age+")";
			st = conn.createStatement();
			System.out.println(sql);
			// 执行语句
			int row = st.executeUpdate(sql);
			System.out.println(row);

		} catch (Exception e) {

		} finally {
			// 关闭连接
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}
}
