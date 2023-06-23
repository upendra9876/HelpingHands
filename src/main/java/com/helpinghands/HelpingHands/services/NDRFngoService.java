package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.helpinghands.HelpingHands.entities.NDRFngo;
import com.helpinghands.HelpingHands.repository.NDRFngoDao;


@Service
public class NDRFngoService {

	@Autowired
private NDRFngoDao ndrfNgoDao;	
	
	public NDRFngoService(NDRFngoDao ndrfNgoDao) {
		super();
		this.ndrfNgoDao = ndrfNgoDao;
	}




	public long availablePersonNdrf_Ngo(long id) {
		NDRFngo ndrfngo = ndrfNgoDao.findById(id).get();
		long availiablePerson= ndrfngo.getAvailable_person();
		return availiablePerson;
	}

	public NDRFngo addNoofPerson(NDRFngo ndrFngo)
	{
		return  ndrfNgoDao.save(ndrFngo);
	}

	public NDRFngo addNoofVehicle(NDRFngo ndrFngo)
	{
		return ndrfNgoDao.save(ndrFngo);
	}
	

}
