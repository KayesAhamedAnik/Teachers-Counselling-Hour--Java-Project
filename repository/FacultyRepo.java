package repository;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.sql.*;

import interfaces.*;
import entity.*;

public class FacultyRepo implements IFaculty
{
	DatabaseConnection dbc;
	
	public FacultyRepo()
	{
		dbc=new DatabaseConnection();
		
	}
	public void insertInDB(Faculty f)
	{
		String query="INSERT INTO faculty VALUES('"+f.getFacultyId()+"','"+f.getName()+"','"+f.getDepartment()+"','"+f.getEmail()+"','"+f.getRoomNo()+"')";
		try
		{
			dbc.openConnection();
			dbc.st.executeQuery(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("Exeception: "+e.getMessage());
		}
	}
	public void deleteFromDB(String facultyId)
	{
		String query = "DELETE from faculty WHERE facultyId='"+facultyId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("Exeception: "+e.getMessage());
		}
	}
	public void updateInDB(Faculty f)
	{                                                                                                                                            
		{
		String query = "UPDATE faculty SET name='"+f.getName()+"',department='"+f.getDepartment()+"',email='"+f.getEmail()+"',roomNo='"+f.getRoomNo()+"' where facultyId='"+f.getFacultyId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
		}
	}
	}
	
	public String[][] getAllFaculty()
	{
		
		ArrayList<Faculty> ar = new ArrayList<Faculty>();
		String query = "SELECT * FROM faculty;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String facultyId=dbc.result.getString("facultyId");
				String name = dbc.result.getString("name");
				String department = dbc.result.getString("department");
				String email = dbc.result.getString("email");
				String roomNo= dbc.result.getString("roomNo");
				
				Faculty f=new Faculty(facultyId,name,department,email,roomNo);
				ar.add(f);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Faculty)obj[i]).getFacultyId();
			data[i][1] = ((Faculty)obj[i]).getName();
			data[i][2] = ((Faculty)obj[i]).getDepartment();
			data[i][3] = ((Faculty)obj[i]).getEmail();
			data[i][4] = ((Faculty)obj[i]).getRoomNo();
		}
		return data;
	
	}
public Faculty searchFaculty(String facultyId)
	{
		Faculty f = null;
		String query = "SELECT * FROM faculty WHERE `facultyId`='"+facultyId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				String department = dbc.result.getString("department");
				String email = dbc.result.getString("email");
				String roomNo= dbc.result.getString("roomNo");
				
			
				
				f = new Faculty();
				f.setDepartment(department);
				f.setFacultyId(facultyId);
				f.setName(name);
				f.setEmail(email);
				f.setRoomNo(roomNo);	
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
		}
		dbc.closeConnection();
		return f;
	}

}