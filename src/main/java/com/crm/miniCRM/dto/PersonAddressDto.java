package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.persistence.PersonAddressID;

public class PersonAddressDto {

    private PersonAddressID Id;
    private String email;
    private String phone;
    private String mobile;
    private char type;

    public PersonAddressDto(){
    }

    public PersonAddressID getId() {return Id;}
    public void setId(PersonAddressID id) {Id = id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}
    public char getType() {return type;}
    public void setType(char type) {this.type = type;}

    public PersonAddressDto(PersonAddressID id, String email, String phone, String mobile, char type) {
        this.Id = id;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.type = type;
    }
}
