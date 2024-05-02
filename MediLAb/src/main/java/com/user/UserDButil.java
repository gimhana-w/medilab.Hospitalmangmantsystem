package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


public class UserDButil {

public static List <User> validate(String email,String password) {
		
		ArrayList <User> uss= new ArrayList<>();
		
		//create DB connection
		String url ="jdbc:mysql://localhost:3306/hospitadbl";
		String use="root";
		String pass="123456";
		
		
		//validation
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//DB connection
			Connection con = DriverManager.getConnection(url,use,pass);
			Statement stat = con.createStatement();
			String sql = "select* from user where email='"+email+"'and password='"+password +"'";
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				int id =rs.getInt(1);
				String name=rs.getString(2);
				String gmail=rs.getString(3);
				String passu=rs.getString(4);
				
				
				User c= new User(id,name,gmail,passu);//Parsing values to array list
				uss.add(c);
				
			}
				 
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
		
		return uss;
	}
}
