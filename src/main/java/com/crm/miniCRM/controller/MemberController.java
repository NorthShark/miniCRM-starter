package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.MemberDto;
import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.persistence.CommunityRepository;
import com.crm.miniCRM.model.persistence.MemberID;
import com.crm.miniCRM.model.persistence.MemberRepository;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/members")
public class MemberController {
    private MemberRepository memberService;
    private PersonRepository personService;
    private CommunityRepository communityService;
    private Long personid;
    private Long communityid;
    private MemberID memberID = new MemberID(personid, communityid);

    public MemberController(MemberRepository memberService, PersonRepository personService, CommunityRepository communityService) {
        this.memberService = memberService;
        this.personService = personService;
        this.communityService = communityService;
    }

    @GetMapping
    public String getmembers(Model model) {
        Iterable<Member> members = memberService.findAll();
        List<MemberDto> memberDtos = new ArrayList<>();
        members.forEach(m -> memberDtos.add(convertToDto(m)));
        model.addAttribute("members", memberDtos);
        return "members";
    }

    @GetMapping("/foert")
    public String foert(){
        return "error";
    }

    @GetMapping("/new")
    public String newmember(Model model) {
        model.addAttribute("member", new MemberDto());
        return "new-member";
    }

    @PostMapping
    public String addmember(@RequestParam(name="person_ID") Long person_ID, @RequestParam(name="community_ID") Long communityID, MemberDto member) {
        memberService.save(convertToEntity(member));

        return "redirect:/members";
    }

    protected MemberDto convertToDto(Member entity) {
        MemberDto dto = new MemberDto(entity.getSince(), entity.getUntil(), entity.getId().getPerson_ID(), entity.getId().getCommunity_ID());
        return dto;
    }

    protected Member convertToEntity(MemberDto dto) {

        Member member = new Member(dto.getId(), dto.getSince(), dto.getUntil());
        if (!StringUtils.isEmpty(dto.getId())) {
            member.setId(dto.getId());
        }
        return member;
    }
}
