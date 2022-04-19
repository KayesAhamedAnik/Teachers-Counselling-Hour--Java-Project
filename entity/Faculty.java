package entity;

import java.lang.*;

public class Faculty
{
	private String facultyId;
	private String name;
	private String department;
	private String email;
	private String roomNo;
	
	
	public Faculty(){}
	public Faculty(String name,String facultyId)
	{
		this.facultyId=facultyId;
		this.name=name;
	}
	public Faculty(String facultyId, String name, String department,String email,String roomNo)
	{
		this.facultyId=facultyId;
		this.name = name;
		this.department=department;
		this.email=email;
		this.roomNo=roomNo;

	}
	public Faculty(String facultyId, String name, String department)
	{
		this.facultyId=facultyId;
		this.name = name;
		this.department=department;
		
	}
	
	public void setFacultyId(String facultyId)
	{
		this.facultyId=facultyId;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDepartment(String department)
	{
		this.department=department;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setRoomNo(String roomNo)
	{
		this.roomNo=roomNo;
	}
	
	
	public String getFacultyId()
	{
		return facultyId;
	}
	public String getName()
	{
		return name;
	}
	public String getDepartment()
	{
		return department;
	}
	public String getEmail()
	{
		return email;
	}
	public String getRoomNo()
	{
		return roomNo;
	}

}