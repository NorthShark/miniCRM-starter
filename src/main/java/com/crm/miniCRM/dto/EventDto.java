package com.crm.miniCRM.dto;

import java.time.LocalDate;
import java.util.Date;

public class EventDto {
    private Long id;
    private LocalDate date;
    private String description;

    public EventDto() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}
    public String getDescription() {return description;}
    public void setDescription(String description) {
        this.description = description;
    }

    public EventDto(Long id, String description, LocalDate date) {
        this.id = id;
        this.description = description;
        this.date = date;
           }
}
