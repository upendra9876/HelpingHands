package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.dto.UserDto;
import com.helpinghands.HelpingHands.entities.Location;
import com.helpinghands.HelpingHands.repository.Locationdao;

import com.helpinghands.HelpingHands.Constants;

import com.helpinghands.HelpingHands.services.Usersservice;
import jdk.dynalink.NamedOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.helpinghands.HelpingHands.entities.Users;
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

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUser() {
        List<Users> users = usersservice.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUser/{UserId}")
	public Users getUserById(@PathVariable long Id)
	{
		return this.usersservice.getUserById(Id);
	}


    @PutMapping("/users")
	public Users updateUsers(@RequestBody Users users)
	{
		return this.usersservice.updateUsers(users);
	}
    
    @PostMapping("/createUsers")
    public Users createUsers( @RequestBody UserDto user, @RequestHeader String postal) throws NoSuchElementException,Exception
    {
	return this.usersservice.createUsers(user,postal);
    }
    
    @DeleteMapping("/getUsers/{UserId}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long userId)
	{
		try {
			this.usersservice.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    }





