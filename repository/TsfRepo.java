package repository;

import java.lang.*;
import java.sql.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class TsfRepo

{
	Tsf t;
	DatabaseConnection dbc;
	public TsfRepo()
	{
		dbc=new DatabaseConnection();
	}
	public void UpdateInDB(Tsf t)
	{
		String query = "UPDATE tsftable SET 8-9='"+t.getT8()+"',9-10='"+t.getT9()+"',10-11='"+t.getT10()+"',11-12='"+t.getT11()+"',12-1='"+t.getT12()+"',1-2='"+t.getT1()+"',2-3='"+t.getT2()+"',3-4='"+t.getT3()+"',4-5='"+t.getT4()+"' WHERE facultyId='"+t.getFacultyId()+"' AND day='"+t.getDay()+"'";
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
	public void insertInDB(Tsf t)
	{
		String query="INSERT INTO tsftable VALUES('"+t.getFacultyId()+"','"+t.getDay()+"','"+t.getT8()+"','"+t.getT9()+"','"+t.getT10()+"','"+t.getT11()+"','"+t.getT12()+"','"+t.getT1()+"','"+t.getT2()+"','"+t.getT3()+"','"+t.getT4()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("Exception :: Tsf insert: "+e.getMessage());
		}
	}
	public String[][] getTsf(String facultyId)
	{ 
	    
		
		ArrayList<Tsf> ar = new ArrayList<Tsf>();
		String query = "SELECT * FROM tsftable WHERE facultyId='"+facultyId+"';";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String day= dbc.result.getString("day");
				String t8=dbc.result.getString("8-9");
				String t9=dbc.result.getString("9-10");
				String t10=dbc.result.getString("10-11");
				String t11=dbc.result.getString("11-12");
				String t12=dbc.result.getString("12-1");
				String t1=dbc.result.getString("1-2");
				String t2=dbc.result.getString("2-3");
				String t3=dbc.result.getString("3-4");
				String t4=dbc.result.getString("4-5");
	
				
				Tsf t=new Tsf(day,t8,t9,t10,t11,t12,t1,t2,t3,t4);
				ar.add(t);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception: getTsf:: "+e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][10];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Tsf)obj[i]).getDay();
			data[i][1] = ((Tsf)obj[i]).getT8();
			data[i][2] = ((Tsf)obj[i]).getT9();
			data[i][3] = ((Tsf)obj[i]).getT10();
			data[i][4] = ((Tsf)obj[i]).getT11();
			data[i][5] = ((Tsf)obj[i]).getT12();
			data[i][6] = ((Tsf)obj[i]).getT1();
			data[i][7] = ((Tsf)obj[i]).getT2();
			data[i][8] = ((Tsf)obj[i]).getT3();
			data[i][9] = ((Tsf)obj[i]).getT4();
		}
		return data;
	
	}
	
}

