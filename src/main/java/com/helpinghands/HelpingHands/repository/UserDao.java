package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users,String> {

    @Query("Select u from Users u where u.userid =:userId")
    public Users getuserbyuserid(@Param("userId") String userId);
//    @Query("Select u from Users u where u.temporarydatabaseofincidents. =:")
//    public Users getuserbyincidentid(@Param("incidentid") String incidentid);
}
