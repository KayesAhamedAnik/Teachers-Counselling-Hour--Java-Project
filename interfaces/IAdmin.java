package interfaces;
import java.lang.*;

import entity.*;

public interface IAdmin
{
    public void insertInDB(Faculty f);
	public void deleteFromDB(String facultyId);
	public void updateInDB(Faculty f);
	public Faculty searchFaculty(String facultyId);
	public String[][] getAllFaculty();	
	
}