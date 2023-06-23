package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Organisation;
import com.helpinghands.HelpingHands.repository.OrganisationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {



    @Autowired
    private OrganisationDao organisationDao;



    public OrganisationService(OrganisationDao organisationDao) {
        super();
        this.organisationDao = organisationDao;
    }


    public List<Organisation> getAllOrganisation()
    {
        return organisationDao.findAll();
    }
}
