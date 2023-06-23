package com.helpinghands.HelpingHands.services;



import com.helpinghands.HelpingHands.dto.UserDto;
import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Users;

import java.util.List;
import java.util.NoSuchElementException;

public interface Usersservice
{
	List <Users> getAllUser(); 
	Users getUserById(Long userid);
	Users updateUsers(Users users) throws NoSuchElementException;
	Users createUsers(UserDto users, String postal) throws Exception;

	Admin createAdmin(Admin admin);
	 void deleteUser(Long id);
	
}


