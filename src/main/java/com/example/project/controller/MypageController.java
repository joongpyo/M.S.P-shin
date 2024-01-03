package com.example.project.controller;

import com.example.project.dto.UserDto;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String getMypage(){
        return "mypage";
    }

    @GetMapping("/update")
    public String getUpdate(){
        return "mypage/update";
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> setUpdate(@ModelAttribute UserDto userDto){
        userService.updateUser(userDto);
        return Map.of("msg", "success");
    }

    @GetMapping("/myMedList")
    public String getMyMedList(){
        return "mypage/myMedList";
    }

    @GetMapping("/myBoard")
    public String getMyBoard(){
        return "mypage/myBoard";
    }

    @GetMapping("/myQuit")
    public String getMyQuit(){
        return "mypage/myQuit";
    }

    @PostMapping("/myQuit")
    @ResponseBody
    public Map<String, Object> deleteMyQuit(@ModelAttribute UserDto userDto){
        userService.deleteUser(userDto);
        return Map.of("msg", "success");
    }





}
