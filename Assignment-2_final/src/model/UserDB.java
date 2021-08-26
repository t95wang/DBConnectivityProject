package model;

public class UserDB {

    public static boolean CkeckUser(User user) {
    	//TODO: Modify this code that check the user from the database
    	boolean ok = false;
    	if ("hr".equals(user.getUsername()) 
    		  && "hr".equals(user.getPassword())) {
    		ok = true;
    	}
    	return ok;
    }
}
