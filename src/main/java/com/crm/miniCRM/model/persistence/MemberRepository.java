package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
@Qualifier("MemberRepo")
public interface MemberRepository extends CrudRepository<Member, MemberID> {

    Optional<Member> findById(MemberID id);
}