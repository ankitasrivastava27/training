package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.lti.entity.Customer;

//data access object
public class CustomerDao {
	// public void add(int id,String name,String email) {
	public void add(Customer customer) {
		Connection conn = null;
		PreparedStatement smt = null;
		try {
			
			Properties dbProps =new Properties();
			dbProps.load(this.getClass().getClassLoader().getResourceAsStream("dev-db.properties"));
			//Class.forName("oracle.jdbc.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			Class.forName(dbProps.getProperty("driverClassName"));
			conn = DriverManager.getConnection(dbProps.getProperty("url"),dbProps.getProperty("username"),dbProps.getProperty("password"));
			String sql = "insert into customer values(?,?,?)";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, customer.getId_number());
			smt.setString(2, customer.getName());
			smt.setString(3, customer.getEmail());
			smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				smt.close();
			} catch (Exception e) {
			}
			try {
				smt.close();
			} catch (Exception e) {
			}
		}

	}

}
