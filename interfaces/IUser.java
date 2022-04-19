package interfaces;
import java.lang.*;

import entity.*;

public interface IUser
{
	User getUser(String userId, String password);
	void insertUser(User u);
	void changePassword(String password);
	void deleteUser(String userId);
}
	
