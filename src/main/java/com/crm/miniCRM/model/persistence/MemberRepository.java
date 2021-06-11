package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, MemberID> {

    Optional<Member> findById(MemberID id);

}