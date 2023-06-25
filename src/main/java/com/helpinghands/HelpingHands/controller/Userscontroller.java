package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.dto.UserDto;
import com.helpinghands.HelpingHands.entities.Location;
import com.helpinghands.HelpingHands.repository.Locationdao;

import com.helpinghands.HelpingHands.Constants;

import com.helpinghands.HelpingHands.repository.UserDao;
import com.helpinghands.HelpingHands.services.Usersservice;
import jakarta.validation.Valid;
import jdk.dynalink.NamedOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.helpinghands.HelpingHands.entities.Users;

import java.security.cert.TrustAnchor;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(Constants.REQUEST_MAPPING)
@Log4j2
public class Userscontroller {
	@Autowired
    private Usersservice usersservice;
	@Autowired
	private Locationdao locationdao;

	@Autowired
	private UserDao userDao;

    @GetMapping(Constants.GET_ALL_USERS)
    public ResponseEntity<Object> getAllUser() {
        List<Users> users = usersservice.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(Constants.FIND_USER_BY_ID)
	public Users getUserById(@PathVariable String UserId) throws NoSuchElementException,Exception
	{
		return this.usersservice.getUserById(UserId);
	}



    
    @PostMapping(Constants.NEW_USER_SIGNUP)
    public Users createUsers(@RequestBody @Valid UserDto user, @RequestHeader String postal) throws Exception
    {
		//return "hn";
	return this.usersservice.createUsers(user,postal);
    }
    
    @DeleteMapping(Constants.DELETE_USE_BY_ID)
	public String deleteOrder(@PathVariable String UserId) throws NoSuchElementException,Exception
	{
		this.usersservice.deleteUser(UserId);
		return "done";
	}
	@GetMapping(Constants.GET_ALL_USER_OF_POSTAL_CODE)
	public List<Users> getAllUsersOfPostalcode(@PathVariable String postal){
		Location l= locationdao.findById(postal).get();
		return l.getUsers();
	}

	@GetMapping(Constants.USER_LOGIN)
	public String userLogin(@RequestHeader String email, @RequestHeader String password)throws Exception {
		return this.usersservice.userLogin(email,password);

	}


}





