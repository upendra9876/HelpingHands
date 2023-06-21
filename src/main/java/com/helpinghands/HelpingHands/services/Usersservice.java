package com.helpinghands.HelpingHands.services;



import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Users;

import java.util.List;

public interface Usersservice
{
	List <Users> getAllUser(); 
	Users getUserById(Long userid);
	Users updateUsers(Users users);
	Users createUsers(Users users);
	 void deleteUser(Long id);
	
}


