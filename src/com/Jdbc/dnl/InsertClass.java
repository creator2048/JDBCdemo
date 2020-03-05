package com.Jdbc.dnl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertClass {
	public static void main(String[] args) {

		// url 数据库地址
		String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
		// user 用户名
		String user = "root";
		// password 密码
		String password = "root";

		Connection conn = null;
		Statement st = null;

		try {
			// 1.添加驱动
			// 把com.mysql.jdbc.Driver这份字节码加载进JVM
			// 当一份字节码被加载到JVM时，就会执行该字节码中的静态代码块
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取连接对象
			conn = DriverManager.getConnection(url, user, password);

			// 创建SQL语句
			String sql = "insert into student values(1,'Jack',18)";
			st = conn.createStatement();
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
