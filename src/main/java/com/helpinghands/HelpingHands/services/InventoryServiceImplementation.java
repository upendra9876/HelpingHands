package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import com.helpinghands.HelpingHands.repository.InventoryBloodBankRepository;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import com.helpinghands.HelpingHands.repository.InventoryVehicleRepository;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Log4j2
public class InventoryServiceImplementation implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryVehicleRepository inventoryVehicleRepository;

    @Autowired
    private InventoryBloodBankRepository inventoryBloodBankRepository;

    @Autowired
    private Temporarydatabaseofincidentdao temporarydatabaseofincidentdao;

    @Override
    public Temporarydatabaseofincident addInventoryToIncident(String incidentId, Inventory inventory)
    {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
                inventoryRepository.save(inventory);
                incident.setInventory(inventory);
                temporarydatabaseofincidentdao.save(incident);
                return incident;
        }
        else throw new NoSuchElementException("no incident found");
    }

    @Override
    public ResponseEntity getAllInventory(){
        List<Inventory> allInventory = this.inventoryRepository.findAll();
        if(allInventory.isEmpty()){
            return new ResponseEntity<>("No Inventory Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allInventory,HttpStatus.OK);
    }

    @Override
    public Inventory getInventoryById(String incidentId) throws NoSuchElementException {
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return incident.getInventory();
        } else throw new NoSuchElementException("no incident found");

    }
    @Override
    public ResponseEntity<Object> getVehicleByType(String vehicleType, String inventoryId){
        Optional<Inventory> inventory= this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        InventoryVehicle data = this.inventoryVehicleRepository.getVehicleDataByType(inventory.get().getVehicle().getId());
        if(vehicleType.equals("land")){
            return new ResponseEntity<>(vehicleType+":"+data.getLand(),HttpStatus.OK);
        }else if (vehicleType.equals("air")){
            return new ResponseEntity<>(vehicleType+":"+data.getAir(),HttpStatus.OK);
        } else if (vehicleType.equals("water")) {
            return new ResponseEntity<>(vehicleType+":"+data.getWater(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String getAmbulanceData(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {

            return " Ambulance = "+incident.getInventory().getAmbulance();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String getWaterGallon(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return "waterGallon = "+ incident.getInventory().getWaterGallon();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String  getFoodPacket(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return "foodPacket "+ incident.getInventory().getFoodPacket();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String getAllBloodData(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return "Bllod Available = "+ incident.getInventory().getBloodBank();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String getBedData(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return "Bed Available = " + incident.getInventory().getBeds();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String  getAnimalsFood(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return " Animal food = "+ incident.getInventory().getAnimalsFood();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String  getFirstAids(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return " first aids =" + incident.getInventory().getFirstAids();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String  getDoctorsData(String incidentId)throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return "Doctors Available = "+ incident.getInventory().getDoctor();
        } else throw new NoSuchElementException("no incident found");
    }

    @Override
    public String updateWaterGallon(String incidentId, long waterGallon) {
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setWaterGallon(inventory.getWaterGallon()+waterGallon);
            inventoryRepository.save(inventory);
            return "Available waterGallons are " + inventory.getWaterGallon();
        }
        else throw new NoSuchElementException("wrong incident id");
    }

    @Override
    public String updateFirstAids(String incidentId, long firstAids) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setFirstAids(inventory.getFirstAids()+firstAids);
            inventoryRepository.save(inventory);
            return "Availale first aids are " + inventory.getFirstAids();

        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String updateNurse(String incidentId, long nurse) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setNurse(inventory.getNurse()+nurse);
            inventoryRepository.save(inventory);
            return "Available nurses are " + inventory.getNurse();
        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String updateDoctor(String incidentId, long doctors) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setDoctor(inventory.getDoctor()+doctors);
            inventoryRepository.save(inventory);
            return "Available doctors are " + inventory.getDoctor();
        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String updateAmbulance(String incidentId, long ambulance) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setAmbulance(inventory.getAmbulance()+ambulance);
            inventoryRepository.save(inventory);
            return "available ambulance are "+ inventory.getAmbulance();
        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String updateAnimalFoods(String incidentId, long animalFoods) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setAnimalsFood(inventory.getAnimalsFood()+animalFoods);
            inventoryRepository.save(inventory);
            return "available Animal Foods are "+ inventory.getAnimalsFood();
        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String updateBeds(String incidentId, long beds)throws NoSuchElementException {
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setBeds(inventory.getBeds()+beds);
            inventoryRepository.save(inventory);
            return "available Beds are "+ inventory.getBeds();
        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String updateFoodPacket(String incidentId, long foodPackets) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory = incident.getInventory();
            inventory.setFoodPacket(inventory.getFoodPacket()+foodPackets);
            inventoryRepository.save(inventory);
            return "available foodpackets are "+ inventory.getFoodPacket();
        }
        else throw new NoSuchElementException("wrong incident id");

    }

    @Override
    public String getNurseData(String incidentId)throws NoSuchElementException {
        Temporarydatabaseofincident temporarydatabaseofincident= temporarydatabaseofincidentdao.findById(incidentId).get();
        if(temporarydatabaseofincident!=null){
            return "Nurse available ="+ temporarydatabaseofincident.getInventory().getNurse();
        }
        else throw new NoSuchElementException("no incident found");
    }




}
