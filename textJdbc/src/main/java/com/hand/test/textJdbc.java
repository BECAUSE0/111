package com.hand.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class textJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/textjdbc";
		String name = "com.mysql.jdbc.Driver";
		String user = "root";
		String pswd = "root";
		
		@SuppressWarnings("resource")
		Scanner in= new Scanner(System.in);
		System.out.println("请输入address_id：");
		int address_id = in.nextInt();
		
		String sql = "SELECT u.`name`,u.hobby,a.address_name "
				+ "FROM JDBC_USER u,JDBC_ADDRESS a "
				+ "WHERE 1 = 1 AND u.address_id = a.address_id "
				+ "AND a.address_id = ?";  
				//System.out.println("sql:" + sql);
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url,user,pswd);
			
			st = conn.prepareStatement(sql);
			st.setInt(1, address_id);
			System.out.println(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()){
				
				System.out.println("居住在"+rs.getString("address_name")+"的人有：");
				System.out.print(rs.getString("name")+",他的愛好是");
				System.out.print(rs.getString("hobby"));
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
