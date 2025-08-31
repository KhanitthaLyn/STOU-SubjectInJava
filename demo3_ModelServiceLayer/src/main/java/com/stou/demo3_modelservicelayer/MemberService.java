package com.stou.demo3_modelservicelayer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private ArrayList<Member> members = new ArrayList<>();


    public ArrayList<Member> getMembers(){
        return members;
    }

    public Member addMember(Member member){
        members.add(member);
        return member;
    }

    public void removeMember(Member member){
        members.remove(member);
    }

    public Member findMemberByEmail(String email) {
        for (Member member : members) {
            if(member.getEmail().equalsIgnoreCase(email)) {
                return member;
            }
        }
        return null;
    }
}
