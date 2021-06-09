package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
@Qualifier("MemberRepo")
public interface MemberRepository extends CrudRepository<Member, MemberID> {

    Optional<Member> findById(MemberID id);

    @Query(value="select p.last_name, p.first_name, m.community_id from member m join person p on m.person_id = p.id join community c on c.id = m.community_id where c.id = ${id}", nativeQuery = true)
    List<Object> findMemberName(Long id);
}