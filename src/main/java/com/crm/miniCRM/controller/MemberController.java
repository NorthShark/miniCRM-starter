package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.MemberDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.CommunityRepository;
import com.crm.miniCRM.model.persistence.MemberID;
import com.crm.miniCRM.model.persistence.MemberRepository;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
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
        return "foert";
    }

    @GetMapping("/new")
    public String newmember(Model model) {
        model.addAttribute("memberid", new MemberID());
        model.addAttribute("member", new Member());
        return "new-member";
    }

    @PostMapping
    public String addmember(Member member) {
        memberService.save(member);

        return "redirect:/members";
    }

    protected MemberDto convertToDto(Member entity) {
        MemberDto dto = new MemberDto(entity.getId(), entity.getSince(), entity.getUntil());
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
