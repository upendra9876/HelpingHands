package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Users;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Locationdao;
import com.helpinghands.HelpingHands.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserserviceImplementation {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private Locationdao locationdao;


    public List<Users> findAll() {
        return userDao.findAll();
    }
}


//@Override
//    public List<Centralrepositoryofincident> findincidentsbetweenduration() {
//        return null;
//    }



