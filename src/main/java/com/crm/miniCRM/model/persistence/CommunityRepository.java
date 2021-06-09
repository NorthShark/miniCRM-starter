package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.MemberPerson;
import com.crm.miniCRM.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommunityRepository extends CrudRepository<Community, Long> {

    List<Community> findByDescription(String description);

    Community findById(long id);

    @Query
    (value = "SELECT distinct first_name,last_name from person join member m on person.id = m.person_id join community c on c.id = m.community_id where c.id = ${id}",nativeQuery = true)
    List<Person> findAllByCommunityID(long id);

    @Query(value="select p.last_name, p.first_name, m.community_id, c.description from member m join person p on m.person_id = p.id join community c on c.id = m.community_id where m.community_id = ?1", nativeQuery = true)
    List<Object> findMemberName(Long id);

    @Query(value="select p.last_name, p.first_name, m.community_id, c.description from member m join person p on m.person_id = p.id join community c on c.id = m.community_id", nativeQuery = true)
    List<MemberPerson> ShowMemberName2(Long id);
}