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
    (value = "SELECT * FROM Member m join Community c on m.community_id == c.id ",nativeQuery = true)
    List<Member> findAllByCommunityID();
}