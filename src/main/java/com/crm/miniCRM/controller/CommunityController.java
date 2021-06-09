package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.persistence.CommunityRepository;
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
    private MemberController memberController;
    private PersonController personController;
    private PersonRepository personService;
    private MemberRepository memberService;
    private CommunityRepository communityService;

    public CommunityController(CommunityRepository communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public String getcommunities(Model model) {
        Iterable<Community> communities = communityService.findAll();
        List<CommunityDto> CommunityDtos = new ArrayList<>();
        communities.forEach(p -> CommunityDtos.add(convertToDto(p)));
        model.addAttribute("communities", CommunityDtos);
        return "communities";
    }

/*    @GetMapping("/addcommunitymember")
    public CommunityDto getcommunitybyid(@PathVariable("id") long id, Model model) {
        Community community = communityService.findById(id);
        CommunityDto dto = new CommunityDto();
        convertToDto(community);
        model.addAttribute("community",dto);
        return dto;
    }*/


        /*  WERKT VOORLOPIG NIET
    @GetMapping("/communitymembers")
    public String getMembersOfCommunity(Model model, @PathVariable long communityId){
        Iterable<Member> membersOfCommunity = communityService.findAllByCommunityID(communityId);
        List<MemberDto> memberDtos = new ArrayList<>();
        membersOfCommunity.forEach(m->memberDtos.add(memberController.convertToDto(m)));
        model.addAttribute("communitymembers", memberDtos);
        return"communitymembers";
   }*/

    @GetMapping("/communitymembers")
    public String GetCommies(){
        return "communitymembers";
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

/*    @GetMapping("/addcommunitymember")
    public String newcommunitymember(){
        return "redirect:/new-community-member";
   // return "new-community-member";
    }*/

  /*  @PostMapping
    public String addcommunitymember(*//*nog invullen*//*) {
        //hier code schrijven
        return "redirect:/communities";
    }*/
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
