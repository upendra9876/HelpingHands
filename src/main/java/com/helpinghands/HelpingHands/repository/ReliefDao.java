package com.helpinghands.HelpingHands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.helpinghands.HelpingHands.entities.Relief;

import java.util.List;


@Repository
public interface ReliefDao extends JpaRepository<Relief,Long> {


    @Query("select a from Relief a where a.state =:state")
    public List<Relief> addReliefOrganisations(@Param("state") String state);
}
