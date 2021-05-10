package com.crm.miniCRM.dto;

public class AddressDto {
    private Long id;
    private String box;
    private String city;
    private String zip;
    private String country;
    private String number;
    private String street;
    private String type;



    public AddressDto() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AddressDto(Long id, String street, String number, String box, String zip, String city,
                      String country, String type){
        this.box = box;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.number = number;
        this.street = street;
        this.type = type;
    }
}
