package repository;
import java.lang.*;

import interfaces.*;
import entity.*;

import java.sql.*;

public class UserRepo implements IUser
{
	DatabaseConnection dbc;
	
	public UserRepo()
	{
	dbc=new DatabaseConnection();
	}
	
	
	public User getUser(String userId,String password)
	{
		User user=null;
		String query="SELECT userId,password from login where userId='"+userId+"'and password='"+password+"';";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result=dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				user = new User();
				user.setUserId(dbc.result.getString("userId"));
				user.setPassword(dbc.result.getString("password"));
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
		}
		dbc.closeConnection();
		return user;
	}
	
	
	public void insertUser(User u)
	{
		String query = "INSERT INTO login VALUES ('"+u.getUserId()+"','"+u.getPassword()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void changePassword(String password)
	{
		String query = "UPDATE login SET password='"+password+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void deleteUser(String userId)
	{
		String query = "DELETE from login  WHERE userId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
