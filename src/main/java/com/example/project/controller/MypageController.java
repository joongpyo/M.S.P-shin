package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping("")
    public String getMypage(){
        return "mypage";
    }

    @GetMapping("/update")
    public String getUpdate(){
        return "mypage/update";
    }

    @GetMapping("/myMedList")
    public String getMyMedList(){
        return "mypage/myMedList";
    }

    @GetMapping("/myBoard")
    public String getMyBoard(){
        return "mypage/myBoard";
    }




}
