package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.PersonAddress;
import com.crm.miniCRM.model.persistence.PersonAddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/personaddresses")
public class PersonAddressController {
    private PersonAddressRepository personAddressService;
    public PersonAddressController(PersonAddressRepository personAddressService){
        this.personAddressService = personAddressService;
    }
    @GetMapping
    public String getPersonAddresses(Model model){
        Iterable<PersonAddress> personAddresses = personAddressService.findAll();
        List<PersonAddressDto> personAddressDtos = new ArrayList<>();
        personAddresses.forEach(p -> personAddressDtos.add(convertToDto(p)));
        model.addAttribute("personAddresses", personAddressDtos);
        return "personaddresses";
    }
    @GetMapping("/new")
    public String newpersonAddress(Model model) {
        model.addAttribute("personAddress", new PersonAddressDto());
        return "new-personaddress";
    }
    @PostMapping
    public String addpersonAddress(PersonAddressDto personAddress) {
        personAddressService.save(convertToEntity(personAddress));

        return "redirect:/personaddresses";
    }
    protected PersonAddressDto convertToDto(PersonAddress pa) {
        PersonAddressDto dto = new PersonAddressDto(pa.getId(), pa.getEmail(),pa.getPhone(),
                pa.getMobile(), pa.getType());
        return dto;
    }
    protected PersonAddress convertToEntity(PersonAddressDto dto){
        PersonAddress pa = new PersonAddress(dto.getId(),dto.getEmail(),dto.getPhone(),
                dto.getMobile(),dto.getType());
        return pa;
    }
}
