package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,String> {

    @Query("Select u from Admin u where u.postalcode =:postalcode")
    public Admin getadminofpostalcode(@Param("postalcode") String postalcode);
}
