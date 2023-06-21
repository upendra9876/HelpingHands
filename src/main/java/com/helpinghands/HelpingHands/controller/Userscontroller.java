package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.services.Usersservice;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.helpinghands.HelpingHands.entities.Users;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(Constants.REQUEST_MAPPING)
@Log4j2
public class Userscontroller {

    private Usersservice usersservice;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUser() {
        List<Users> users = usersservice.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }




    }





