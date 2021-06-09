package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.Person;

import java.util.List;
import java.util.Optional;

public class MemberRepositoryQuery implements MemberRepository {
    Person person;

    @Override
    public <S extends Member> S save(S s) {return null;}
    @Override
    public <S extends Member> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }
    @Override
    public Optional<Member> findById(MemberID id) {
        return Optional.empty();
    }

    @Override
    public List<Object> findMemberName(Long id) {
        return null;
    }

    @Override
    public boolean existsById(MemberID memberID) {return false;}
    @Override
    public Iterable<Member> findAll() {return null;}
    @Override
    public Iterable<Member> findAllById(Iterable<MemberID> iterable) {
        return null;
    }
    @Override
    public long count() {
        return 0;
    }
    @Override
    public void deleteById(MemberID memberID) {}
    @Override
    public void delete(Member member) {}
    @Override
    public void deleteAll(Iterable<? extends Member> iterable) {}
    @Override
    public void deleteAll() {}
}
