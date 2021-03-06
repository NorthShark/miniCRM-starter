package com.crm.miniCRM.dto;

public class CommunityDto {

    private Long id;
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public CommunityDto() {
    }

    public CommunityDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
