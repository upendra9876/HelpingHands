package com.helpinghands.HelpingHands.services;



import com.helpinghands.HelpingHands.dto.Locationdto;
import com.helpinghands.HelpingHands.dto.UserDto;
import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Location;
import com.helpinghands.HelpingHands.entities.Users;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.NoSuchElementException;

public interface Usersservice
{
	List <Users> getAllUser(); 
	Users getUserById(String userid) throws Exception;
	Users updateUsers(String users) throws NoSuchElementException;
	Users createUsers(UserDto users, String postal) throws Exception;

	Admin createAdmin(Admin admin,String Postal);
	 void deleteUser(String id) throws NoSuchElementException,Exception;
	 String userLogin(String email, String password) throws Exception;

	 Location addLocation(Locationdto locationdto);
	 Location addAdminToLocation(Admin admin, String Postal) throws NoSuchElementException;

}


