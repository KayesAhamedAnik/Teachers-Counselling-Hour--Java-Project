package entity;
import java.lang.*;

public class Tsf
{
	private String facultyId;
	private String day;
	private String t8,t9,t10,t11,t12,t1,t2,t3,t4;
	
	public Tsf(){}
    public Tsf(String day,String t8,String t9,String t10,String t11,String t12,String t1,String t2,String t3,String t4)
	{ 
	   
		this.day=day;
		this.t8=t8;
		this.t9=t9;
		this.t10=t10;
		this.t11=t11;
		this.t12=t12;
		this.t1=t1;
		this.t2=t2;
		this.t3=t3;
		this.t4=t4;
	}
	public void setFacultyId(String facultyId)
	{
		this.facultyId=facultyId;
	}
	public void setDay(String day)
	{
		this.day=day;
	}
	public void setT8(String t8)
	{
		this.t8=t8;
	}
	public void setT9(String t9)
	{
		this.t9=t9;
	}
	public void setT10(String t10)
	{
		this.t10=t10;
	}
	public void setT11(String t11)
	{
		this.t11=t11;
	}
	public void setT12(String t12)
	{
		this.t12=t12;
	}
	public void setT1(String t1)
	{
		this.t1=t1;
	}
	public void setT2(String t2)
	{
		this.t2=t2;
	}
	public void setT3(String t3)
	{
		this.t3=t3;
	}
	public void setT4(String t4)
	{
		this.t4=t4;
	}
	
	public String getFacultyId()
	{
		return facultyId;
	}
	public String getDay()
	{
		return day;
	}
	public String getT8()
	{
		return t8;
	}
	public String getT9()
	{
		return t9;
	}
	public String getT10()
	{
		return t10;
	}
	public String getT11()
	{
		return t11;
	}
	public String getT12()
	{
		return t12;
	}
	public String getT1()
	{
		return t1;
	}
	public String getT2()
	{
		return t2;
	}
	public String getT3()
	{
		return t3;
	}
	public String getT4()
	{
		return t4;
	}
	

}