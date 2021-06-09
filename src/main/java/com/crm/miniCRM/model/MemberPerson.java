package com.crm.miniCRM.model;

public class MemberPerson {
    private String firstName;
    private String lastName;
    private Long communityId;

    public MemberPerson() {
    }

    public MemberPerson(String firstName, String lastName, Long communityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.communityId = communityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }
}
