package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.MemberDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.CommunityRepository;
import com.crm.miniCRM.model.persistence.MemberID;
import com.crm.miniCRM.model.persistence.MemberRepository;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/communities")
public class CommunityController {

    private CommunityRepository communityService;
    private PersonRepository personService;

    public CommunityController(CommunityRepository communityService, PersonRepository personService) {
        this.communityService = communityService;
        this.personService = personService;
    }

    @GetMapping
    public String getcommunities(Model model) {
        Iterable<Community> communities = communityService.findAll();
        List<CommunityDto> CommunityDtos = new ArrayList<>();
        communities.forEach(p -> CommunityDtos.add(convertToDto(p)));
        model.addAttribute("communities", CommunityDtos);
        return "communities";
    }

    @GetMapping("/communitymembers/{id}")
    public String GetCommies(@PathVariable("id") long id, Model model){
            Community community = communityService.findById(id);
            List<Object> membernames = communityService.findMemberName(id);
            model.addAttribute("commie", community);
            model.addAttribute("namesofmembers", membernames);

        return "communitymembers";
    }
    @GetMapping("/addcommunitymember/{id}")
    public String getmemberpersons(@PathVariable("id") long id, Model model) {
        Community community = communityService.findById(id);
        Iterable<Person> persons = personService.findAll();
        List<Object> membernames = communityService.findMemberName(id);

        model.addAttribute("commie", community);
        model.addAttribute("namesofmembers", membernames);
        model.addAttribute("persons", persons);

        return "new-community-member";
    }
    @GetMapping("/new")
    public String newcommunity(Model model) {
        model.addAttribute("community", new CommunityDto());

        return "new-community";
    }

    @PostMapping
    public String addcommunity(CommunityDto community) {
        communityService.save(convertToEntity(community));
        return "redirect:/communities";
    }

    protected CommunityDto convertToDto(Community entity) {
        CommunityDto dto = new CommunityDto(entity.getID(), entity.getDescription());
         return dto;
    }

    protected Community convertToEntity(CommunityDto dto) {
        //29-06-1963

        Community community = new Community(dto.getDescription());
        if (!StringUtils.isEmpty(dto.getId())) {
            community.setID(dto.getId());
        }
        return community;
    }



}
