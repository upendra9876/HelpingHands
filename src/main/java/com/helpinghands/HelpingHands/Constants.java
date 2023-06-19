package com.helpinghands.HelpingHands;

public class Constants {

    public static final String DATA_NOT_FOUND = "Data not Found";

    public static final String GET_ALL_INCIDENT="/getAllActiveIncident";
    public static final String TOTAL_CASULAITY_BY_INCIDENT= "/totalCasualityByIncident/{incidentId}";
    public static final String GET_ALL_INCIDENT_HAPPEN ="/getAllIncidentsOfCountry";
    public static final String REPORT_INCIDENT="/reportCasuality";
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


}
