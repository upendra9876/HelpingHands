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
    
    
	public Users getUserById(String Id) {
		
		return userDao.findById(Id).get();
	}
	
	public Users updateUser(Users users) {
		userDao.save(users);
		return users;
	}
	
	public Users createUser(Users users) {
			userDao.save(users);
			return users;
	}
	
	public void deleteUser(String id) {
		Users entity = userDao.getOne(id);
		userDao.delete(entity);
	}

}


//@Override
//    public List<Centralrepositoryofincident> findincidentsbetweenduration() {
//        return null;
//    }



