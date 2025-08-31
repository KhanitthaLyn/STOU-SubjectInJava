package com.stou.demo2_form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController
{
    @GetMapping("")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/commentform")
    public String showcommentform(){
        return "commentform";
    }
    @GetMapping("/getcomment")
    public String getcomment (@RequestParam String subject, @RequestParam String comment, Model model) {
    model.addAttribute("subject", subject);
    model.addAttribute("comment", comment);
    return "showcomment";

    }
}
