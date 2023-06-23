package com.helpinghands.HelpingHands.services;
import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Location;
import com.helpinghands.HelpingHands.entities.Users;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Locationdao;
import com.helpinghands.HelpingHands.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	
	public Users createUser(Users users, String postal) {
//		Location location= locationdao.findById(postal).get();
//		List<Users> user1= new ArrayList<>();
//		user1.add(users);
//		locationdao.save(location);
//		userDao.save(users);
//			return users;
		return new Users();
	}
	public Admin createAdmin(Admin admin, String postal)
	{
		Location locations = locationdao.findById(postal).get();
		locations.setAdmin(admin);

		//admin1.add(admin);
		locationdao.save(locations);
		adminDao.save(admin);
		return admin;

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



