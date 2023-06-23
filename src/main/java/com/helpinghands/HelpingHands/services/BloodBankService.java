package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpinghands.HelpingHands.entities.BloodBank;
import com.helpinghands.HelpingHands.repository.BloodBankDao;

import java.util.List;


@Service
public class BloodBankService {
	
	
	public BloodBankService(BloodBankDao bloodbankDao) {
		super();
		this.bloodbankDao = bloodbankDao;
	}
	
	@Autowired
	private BloodBankDao bloodbankDao;

	public List<BloodBank> getAllBloodBank() {
		return bloodbankDao.findAll();
	}
	public BloodBank findBloodBankByName(String name) {
		return bloodbankDao.findByName(name);
	}

	public BloodBank saveBloodBankByCity(BloodBank bloodBank)
	{
		return bloodbankDao.save(bloodBank);
	}

	public void deleteBloodBank(Long id) {
		BloodBank bloodBank= bloodbankDao.findById(id).get();
		bloodbankDao.delete(bloodBank);
	}
}
