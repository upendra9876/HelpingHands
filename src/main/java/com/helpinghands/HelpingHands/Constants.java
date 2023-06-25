package com.helpinghands.HelpingHands;

public class Constants {
    public static final String REQUEST_MAPPING= "/api/v1";

    public static final String DATA_NOT_FOUND = "Data not Found";

    public static final String GET_ALL_INCIDENT="/getAllActiveIncident";
    public static final String TOTAL_CASULAITY_BY_INCIDENT= "/totalCasualityByIncident/{incidentId}";
    public static final String GET_ALL_INCIDENT_HAPPEN ="/getAllIncidentsOfCountry";
    public static final String REPORT_INCIDENT="/reportIncident";
    public static final String VERIFY_INCIDENT_BY_AREA_ADMIN="/verifyIncident";
    public static final String GET_ADMIN_OF_AREA="/getAdmin";
    public static final String SET_INCIDENT_EFFECT_END_DATE="/setIncidentEndDate";
    public static final String GET_ALL_INCIDENT_OF_AREA="/getAllIncidentOfArea";
    public static final String FIND_TOTAL_INCIDENT_APPROVE_BY_ADMIN=  "/findTotalIncidentApproveByAdmin";
    public static final String GET_POSTAL_WHICH_USER_BELONGS="/getPostalByUser/{userId}";
    public static final String GET_POSTAL_IN_WHICH_INCIDENT_HAPPENS="/getPostalByIncidentId/{incidentId}";
    public static final String GET_POSTAL_BY_ADMIN="/getPostalByAdminId";
    public static final String OVERALL_CASULAITIES_IN_AREA="/overAllCasualitiesInArea/{postal}";
    public static final String FIND_ALL_INCIDENT_RAISE_BY_USER= "/findAllIncidentRaiseByUser";
    public static final String GET_ADMIN_WHO_APPROVE_INCIDENT="/getAdminByIncident";
    public static final String GET_USER_WHO_REPORT_INCIDENT="/getUserByIncident";

    public static final String GET_ALL_LOCATION="/getAllLocation";
    public static final String GET_ALL_INCIDENT_BETWEEN_DATE="/getAllIncidentBetweenDate";
    public static final String GET_ALL_INCIDENT_AFTER_DATE="/getAllIncidentAfterDate";
    public static final String UPDATE_CASULAITY_IN_INCIDENT="/updateCasuality/{casuality}";

    public static final String INCIDENT_IS_FALSE="/incidentIsFalse/{incidentId}";

    public static final String MOST_PRONIC_AREA="/mostPronicArea";

    public static final String LEAST_PRONIC_AREA="/leastPronicArea";
    public static final String INCIDENT_WITH_MAXIMUM_CASUALTY="/getincidentwithmaximimcasualty";
    public static final String GET_LOCATION_BY_POSTAL_CODE="/getLOcationByPostalCode";
    public static final String GET_ALL_INVENTORY="/inventory";
    public static final String GET_AMBULANCE_USED_IN_INCIDENT="/inventory/ambulance/{incidentId}";
    public static final String GET_WATERGALLONS_USED_IN_INCIDENT="/inventory/watergallon/{incidentId}";
    public static final String GET_FOODPACKETS_USED_IN_INCIDENT="/inventory/foodpacket/{incidentId}";
    public static final String GET_ANIMALFOOD_USED_IN_INCIDENT="/inventory/animalsfood/{incidentId}";
    public static final String GET_FIRSTAIDS_USED_IN_INCIDENT="/inventory/firstaids/{incidentId}";
    public static final String GET_BEDS_USED_IN_INCIDENT="/inventory/beds/{incidentId}";
    public static final String GET_NURSE_POSTED_IN_INCIDENT="/inventory/nurse/{incidentId}";
    public static final String GET_DOCTOR_POSTED_IN_INCIDENT="/inventory/doctors/{incidentId}";
    public static final String GET_BLOOD_USED_IN_INCIDENT="/inventory/blood/{incidentId}";
    public static final String ADD_INVENTORY_TO_INCIDENT="/addInventoryToIncident/{incidentId}";
    public static final String GET_COUNT_OF_VEHICLES_USED_INCIDENT="/getCountOfVehicleUsedInIncident/{incidentId}";

    public static final String UPDATE_BLOOD_DEPOSIT_FOR_INCIDENT="updateBloodBankForIncident/{incidentId}";

    public static final String UPDATE_VEHICLE_COUNT_FOR_INCIDENT="/updateVehicleForIncident/{incidentId}";
    public static final String UPDATE_NURSE_COUNT_FOR_INCIDENT="/updateNurseForIncident/{incidentId}";
    public static final String UPDATE_DOCTOR_COUNT_FOR_INCIDENT="/updateDoctorForIncident/{incidentId}";
    public static final String UPDATE_ANIMALFOOD_FOR_INCIDENT="/updateAnimalFoodForIncident/{incidentId}";
    public static final String UPDATE_FOODPACKETS_FOR_INCIDENT="/updateFoodPacketForIncident/{incidentId}";
    public static final String UPDATE_BEDS_FOR_INCIDENT="/updateBedsForIncident/{incidentId}";
    public static final String UPDATE_AMBULANCE_FOR_INCIDENT="/updateAmbulanceForIncident/{incidentId}";
    public static final String UPDATE_FIRSTAID_FOR_INCIDENT="/updateFirstAidsForIncident/{incidentId}";

    public static final String UPDATE_WATER_GALLON_FOR_INCIDENT="/updateWaterGallonForIncident/{incidentId}";

    public static final String GET_INVENTORY_BY_ID= "/inventory/{inventoryId}";
    public static final String USER_LOGIN ="/userLogin";
    public static final String GET_ALL_USER_OF_POSTAL_CODE = "/getAllUsersOfPostalCode/{postal}";
    public static final String DELETE_USE_BY_ID = "/DeleteUserById/{UserId}";
    public static final String NEW_USER_SIGNUP = "/SignUpNewUser";
    public static final String FIND_USER_BY_ID = "/getUserById/{UserId}";
    public static final String GET_ALL_USERS = "/getAllUsers";




}
