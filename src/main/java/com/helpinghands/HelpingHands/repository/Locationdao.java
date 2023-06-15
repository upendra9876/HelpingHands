package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Locationdao extends JpaRepository<Location,String> {
       @Query("Select u from Location u where u.postalcode =:postalcode")
        public Location getlocationbypostalcode(@Param("postalcode") String postalcode);

    @Query("SELECT a FROM Location a WHERE a.totaldisaster =( SELECT MAX(a.totaldisaster) FROM Location a)")
    public List<Location> mostPronicToIncident();

    @Query("SELECT a FROM Location a WHERE a.totaldisaster =( SELECT MIN(a.totaldisaster) FROM Location a)")
    public List<Location> leastPronicAreaToIncident();


}
