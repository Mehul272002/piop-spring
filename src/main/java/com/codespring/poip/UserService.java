package com.codespring.poip;


import com.codespring.poip.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);

}


