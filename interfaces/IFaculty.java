package interfaces;

import java.lang.*;

import entity.*;

public interface IFaculty
{
	public void updateInDB(Faculty f);
	public Faculty searchFaculty(String facultyId);
	public String[][] getAllFaculty();
	
}