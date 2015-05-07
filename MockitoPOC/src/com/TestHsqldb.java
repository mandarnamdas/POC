package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestHsqldb extends TestCase{
	
	private Connection conn;
	
	private Statement stmt;
	
	@Before
	public void setup() throws ClassNotFoundException, SQLException{
		Class.forName("org.hsqldb.jdbcDriver");
		conn = DriverManager.getConnection("jdbc:hsqldb:mydb", "sa", "");
		stmt = conn.createStatement();
		stmt.execute("CREATE TABLE IF NOT EXISTS EMP ( id integer, name varchar(20))");
		stmt.executeQuery("INSERT INTO EMP (id,name) VALUES (1,'Mandar')");
	}
	
	@Test
	public void testGetEmp() throws SQLException{
		ResultSet result = stmt.executeQuery("SELECT * FROM EMP");	
		result.next();
		System.out.println(result.getString("name"));
		assertEquals("Mandar", result.getString("name"));
	}
	
	@After
	public void close() throws SQLException{
		stmt.close();
		conn.close();
	}
	
}
