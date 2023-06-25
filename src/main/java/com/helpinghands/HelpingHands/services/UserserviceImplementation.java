package com.helpinghands.HelpingHands.services;
import com.helpinghands.HelpingHands.dto.UserDto;
import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Location;
import com.helpinghands.HelpingHands.entities.Users;
import com.helpinghands.HelpingHands.exception.EmailAlreadyexistException;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Locationdao;
import com.helpinghands.HelpingHands.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

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

	@Autowired
	private Incidenttrackservice incidenttrackservice;


	@Override
	public List<Users> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public Users getUserById(String userid) throws Exception {
		try{
			Users user= userDao.findById(userid).get();
			return user;
		}

		catch (NoSuchElementException exc){
			throw new NoSuchElementException("No User Found with Id "+ userid);
		}catch(Exception exc){
			throw new Exception();
		}
	}

	@Override
	public Users updateUsers(String users) throws NoSuchElementException {
		return null;
	}

	public Users createUsers(UserDto user, String postal) throws EmailAlreadyexistException {
		try{
			boolean emailcheck= checkexistemail(user.getEmail());
			System.out.println(emailcheck);
			if(!emailcheck)
			{

				Optional<Location> location2 = locationdao.findById(postal);
				Location location = location2.get();

				Users users1 = new Users();
				List<Users> users = location.getUsers();
				users1.setCity(user.getCity());
				users1.setCountry(user.getCountry());
				users1.setDistrict(user.getDistrict());
				users1.setEmail(user.getEmail());
				users1.setGender(user.getGender());
				users1.setName(user.getName());
				users1.setPassword(user.getPassword());
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
			else throw new EmailAlreadyexistException("Email Already Exist");
		}
		catch(NoSuchElementException exc) {
			throw new NoSuchElementException("Location not exist with postal code, please add location first");
		}

	}

	@Override
	public Admin createAdmin(Admin admin, String Postal) {
		return null;
	}

	@Override
	public void deleteUser(String id) throws Exception {
		try{
			Location location= locationdao.findById(incidenttrackservice.getPostalByUserId(id)).get();
			Users user= userDao.findById(id).get();
			List<Users> users= location.getUsers();
			users.remove(user);
			location.setUsers(users);
			locationdao.save(location);
			userDao.delete(user);
		}catch(NoSuchElementException exc){
			throw new NoSuchElementException("no user exist with Id " + id);
		}catch(Exception exc){
			throw new Exception();
		}
	}


	public boolean checkexistemail(String email){
		List<Users> users= userDao.findAll();
		List<String> emails= new ArrayList<>();
		for( Users u : users){
			if(u.getEmail().equals(email)) return true;
		}
		return false;
	}

	public String userLogin(String email, String password) throws Exception{
		Users user= userDao.checklogin(email,password);
		if(user!=null){
			return "Login Successfull";
		}
		else throw new NoSuchElementException("Invalid emailId And Password");
	}


}




