package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.MemberDto;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.persistence.CommunityRepository;
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

/*   @GetMapping("/communitymembers")
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

    @GetMapping("newcommunitymember")
    public String newcommunitymember(Model model){
    return "newcommunitymember";
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
