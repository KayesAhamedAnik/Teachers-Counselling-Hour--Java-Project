package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;
public class AdminRepo implements IAdmin
{
	DatabaseConnection dbc;
	
	public AdminRepo()
	{
		dbc=new DatabaseConnection();
	}
	public void insertInDB(Faculty f)
	{
		String query="INSERT INTO faculty (facultyId,name,department) VALUES('"+f.getFacultyId()+"','"+f.getName()+"','"+f.getDepartment()+"');";
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
		String query = "UPDATE faculty SET name='"+f.getName()+"',department='"+f.getDepartment()+"' where `facultyId`='"+f.getFacultyId()+"';";
		
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
	public Faculty searchFaculty(String facultyId)
	{
		{
		Faculty f = null;
		String query = "SELECT `name`, `department` FROM `faculty` WHERE `facultyId`='"+facultyId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				String department = dbc.result.getString("department");
				
				f = new Faculty();
				f.setFacultyId(facultyId);
				f.setName(name);
				f.setDepartment(department);
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
	public String[][] getAllFaculty()
	{
		
		ArrayList<Faculty> ar = new ArrayList<Faculty>();
		String query = "SELECT facultyId,name,department FROM faculty;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String facultyId=dbc.result.getString("facultyId");
				String name = dbc.result.getString("name");
				String department = dbc.result.getString("department");
				
				Faculty f=new Faculty(facultyId,name,department);
				ar.add(f);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Faculty)obj[i]).getFacultyId();
			data[i][1] = ((Faculty)obj[i]).getName();
			data[i][2] = ((Faculty)obj[i]).getDepartment();
		}
		return data;
	
	}
}