package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryVehicleRepository extends JpaRepository<InventoryVehicle,String> {

    @Query("Select v from InventoryVehicle v where v.id = :vehicleId")
    public InventoryVehicle getVehicleDataByType(@Param("vehicleId") String vehicleId);
}
