package com.helpinghands.HelpingHands.services;
import com.helpinghands.HelpingHands.dto.UserDto;
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
import java.util.NoSuchElementException;
import java.util.Optional;

@Service

public class UserserviceImplementation implements Usersservice{
    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private Locationdao locationdao;


    public List<Users> getAllUser() {
        return userDao.findAll();
    }

	@Override
	public Users getUserById(Long userid) {
		return null;
	}

	@Override
	public Users updateUsers(Users users) {
		return null;
	}


	public Users getAllUserById(String Id) {
		
		return userDao.findById(Id).get();
	}
	
	public Users updateUser(Users users) {
		userDao.save(users);
		return users;
	}
	
	public Users createUsers(UserDto user, String postal) throws Exception {
		try{
			System.out.println("Hhhhhhhhhhhhhhhhh");
			Optional<Location> location2= locationdao.findById(postal);
			Location location = location2.get();

			Users users1= new Users();
			List<Users> users= location.getUsers();
			users1.setCity(user.getCity());
			users1.setCountry(user.getCountry());
			users1.setDistrict(user.getDistrict());
			users1.setEmail(user.getEmail());
			users1.setGender(user.getGender());
			users1.setName(user.getName());
			users1.setAvailableforvolunteer(false);
			users1.setState(user.getState());
			users1.setCity(user.getCity());
			users1.setMoblieno(user.getMoblieno());

			users.add(users1);
			userDao.save(users1);
			location.setUsers(users);
			locationdao.save(location);


			return users1;
		}
		catch(NoSuchElementException exc) {
			throw new NoSuchElementException("Location not exist with postal code, please add location first");
		}
		catch(Exception exc){
			throw new Exception();
		}


	}

	@Override
	public Admin createAdmin(Admin admin) {
		return null;
	}

	@Override
	public void deleteUser(Long id) {

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



