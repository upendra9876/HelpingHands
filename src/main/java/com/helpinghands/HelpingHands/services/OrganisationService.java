package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrganisationService
{
    @Autowired
    private OrganisationDao organisationDao;

    @Autowired
    private Incidenttrackservice incidenttrackservice;
    @Autowired
    private ReliefDao reliefDao;

    @Autowired
    private HospitalDao hospitalDao;

    @Autowired
    private BloodBankDao bloodBankDao;

    @Autowired
    private Temporarydatabaseofincidentdao temporarydatabaseofincidentdao;

    public Temporarydatabaseofincident addRelief(String incidentId) throws Exception {
        try {
            Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
            List<Relief> relieforg = reliefDao.addReliefOrganisations(incident.getState());

            incident.setRelief_personal(relieforg);
            temporarydatabaseofincidentdao.save(incident);
            return incident;

        } catch (NoSuchElementException exc) {
            throw new NoSuchElementException("invalidincident Id");
        } catch (Exception exc) {
            throw new Exception();
        }
    }

        public Temporarydatabaseofincident addHospitals(String incidentId) throws Exception {
            try {
                Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();

                List<Hospital> hospitals = hospitalDao.allHospitalsInPostal(incidenttrackservice.getPostalByIncidentId(incidentId));


                incident.setHospital(hospitals);

                temporarydatabaseofincidentdao.save(incident);
                return incident;

            } catch (NoSuchElementException exc) {
                throw new NoSuchElementException("invalidincident Id");
            } catch (Exception exc) {
                throw new Exception();
            }
        }
            public Temporarydatabaseofincident addBloodbanks(String incidentId) throws Exception {
                try{
                    Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();

                    List<BloodBank> bloodBanks=bloodBankDao.allBloodBanksInPostal(incidenttrackservice.getPostalByIncidentId(incidentId));
                    incident.setBloodbanks(bloodBanks);

                    temporarydatabaseofincidentdao.save(incident);
                    return incident;

                }catch(NoSuchElementException exc){
                    throw new NoSuchElementException("invalidincident Id");
                }
                catch(Exception exc){
                    throw new Exception();
                }
    }
    public Hospital registerHospital(Hospital hospital){
        return hospitalDao.save(hospital);
    }
    public BloodBank registerbloodbank(BloodBank bloodBank){
        return this.bloodBankDao.save(bloodBank);
    }

    public Relief registerRelief(Relief relief){
        return this.reliefDao.save(relief);
    }




}
