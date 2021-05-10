package com.codespring.poip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//User Authentication Database query
	 @Query("SELECT u FROM User u WHERE u.email = :email and userType='Student'")
    public User findByEmail(String email);
	

	//Admin Authentication Database query
	 @Query("SELECT u FROM User u WHERE u.email = :email and userType='Admin'")
	public User findByAdmin(String email);

	
	//Faculty Authentication Database query
		 @Query("SELECT u FROM User u WHERE u.email = :email and userType='Faculty'")
		public User findByFaculty(String email);

}
