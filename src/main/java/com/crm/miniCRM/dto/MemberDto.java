package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.persistence.MemberID;

import java.time.LocalDate;

public class MemberDto {

    private MemberID Id;
    private Long person_ID;
    private Long community_ID;
    private LocalDate since;
    private LocalDate until;

    public MemberDto() {}

    public MemberID getId() {
        return Id;
    }

    public void setId(MemberID id) {
        Id = id;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public Long getPerson_ID() {
        return person_ID;
    }

    public void setPerson_ID(Long person_ID) {
        this.person_ID = person_ID;
    }

    public Long getCommunity_ID() {
        return community_ID;
    }

    public void setCommunity_ID(Long community_ID) {
        this.community_ID = community_ID;
    }

    public MemberDto(LocalDate since, LocalDate until, Long person_ID, Long community_ID) {
        this.Id = new MemberID(person_ID, community_ID);
        this.since = since;
        this.until = until;
    }
}
