package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import org.springframework.http.ResponseEntity;

public interface InventoryService {

    Temporarydatabaseofincident addInventoryToIncident(String incidentId, Inventory inventory);
    ResponseEntity<Object> getAllInventory();
    Inventory getInventoryById(String incidentId);
    ResponseEntity<Object> getVehicleByType(String vehicleType, String inventoryId);
    String  getAmbulanceData(String incidentId);
    String getWaterGallon(String incidentId);
    String getFoodPacket(String incidentId);
    String getAllBloodData(String incidentId);
    String getBedData(String incidentId);
    String getNurseData(String incidentId);
    String getFirstAids(String incidentId);
    String getAnimalsFood(String incidentId);
    String getDoctorsData(String incidentId);

    public String updateWaterGallon(String incidentId, long waterGallon);
    public String updateFirstAids(String incidentId, long firstAids);
   public String  updateNurse(String incidentId, long nurse);
    public String updateDoctor(String incidentId, long doctors);
    public String updateAmbulance(String incidentId, long ambulance);
    public String updateAnimalFoods(String incidentId,long animalFoods);
    public String updateBeds(String incidentId, long beds);
    public String updateFoodPacket(String incidentId, long foodPackets);

}
