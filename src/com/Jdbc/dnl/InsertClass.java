package com.Jdbc.dnl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertClass {
	public static void main(String[] args) {

		// url ���ݿ��ַ
		String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
		// user �û���
		String user = "root";
		// password ����
		String password = "root";

		Connection conn = null;
		Statement st = null;

		try {
			// 1.�������
			// ��com.mysql.jdbc.Driver����ֽ�����ؽ�JVM
			// ��һ���ֽ��뱻���ص�JVMʱ���ͻ�ִ�и��ֽ����еľ�̬�����
			Class.forName("com.mysql.jdbc.Driver");

			// 2.��ȡ���Ӷ���
			conn = DriverManager.getConnection(url, user, password);

			// ����SQL���
			String sql = "insert into student values(1,'Jack',18)";
			st = conn.createStatement();
			// ִ�����
			int row = st.executeUpdate(sql);
			System.out.println(row);

		} catch (Exception e) {

		} finally {
			// �ر�����
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
