package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommunityRepository extends CrudRepository<Community, Long> {

    List<Community> findByDescription(String description);

    Community findById(long id);

    @Query
    (value = "SELECT distinct first_name,last_name from person join member m on person.id = m.person_id join community c on c.id = m.community_id where c.id = ${id}",nativeQuery = true)
    List<Member> findAllByCommunityID(long id);
}