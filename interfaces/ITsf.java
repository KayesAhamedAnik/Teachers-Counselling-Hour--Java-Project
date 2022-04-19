package interfaces

import java.lang.*;

import entity.*;

public interface ITsf
{
	public void UpdateInDB(Tsf t);
	public void insertInDB(Tsf t);
	public String[][] getTsf(String facultyId);
}