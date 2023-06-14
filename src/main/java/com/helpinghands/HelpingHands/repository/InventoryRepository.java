package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,String> {
}
