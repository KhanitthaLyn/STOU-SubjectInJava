package com.stou.demo3_modelservicelayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired MemberService memberService;

    @GetMapping("/")
    public String getindex(Model model) {
        ArrayList<Member> members = memberService.getMembers();
        model.addAttribute("members", members);
        return "index";
    }

    @GetMapping("/getmemberform")
    public String getmemberform(Model model) {
        Member member = new Member();
        model.addAttribute("formmember", member);
        return "memberform";
    }

    @PostMapping("/addmember")
    public String addmember(@ModelAttribute Member newmember, Model model) {
        Member member = memberService.addMember(newmember);
        return "redirect:/";
    }

    @GetMapping("/deletemember/{email}")
    public String deletemember(@PathVariable String email, Model model) {
        Member found = memberService.findMemberByEmail(email);
        memberService.removeMember(found);
        return "redirect:/";
    }
}
