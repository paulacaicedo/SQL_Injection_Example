package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestDAO {
	
	private Conexion con;
	 
	private PreparedStatement statement;
	
	public TestDAO(String jdbcURL,String jdbcUserName, String jdbcPassword) throws SQLException {
		 con = new Conexion(jdbcURL,jdbcUserName, jdbcPassword);
		 
		 con.connection();
		 System.out.println(con.getJdbcConnection());
	}
	
	public TestDAO() {
		 
	}

	public boolean ingresar(String user, String pass) {
		boolean estado= false;
		String sql = null;
		Statement stm;
	 
		sql= "select * from usuarios where user='"+user+"'";  
		 
		try {
			
			con.connection();
			 			
			stm = con.getJdbcConnection().createStatement();
			stm.executeQuery(sql);
			estado=true;
			
			System.out.println(sql);
			
			con.disccionect();
			 

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			estado=false;
			e.printStackTrace();
		}
		 
		
		
		
		return estado;
		
		
	}

}
