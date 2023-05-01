package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AjaxController {
    @GetMapping(value="/ajax01", produces ="application/text; charset=utf-8")
    public @ResponseBody String ajax01(){
        System.out.println("AjaxController.ajax01");
        return "안녕하세요 저는 리턴입니다.";
    }
    @PostMapping(value="/ajax02", produces ="application/text; charset=utf-8")
    public @ResponseBody String ajax02(){
        System.out.println("AjaxController.ajax02");
        return "Hello, I'm return man.";
    }
    @GetMapping("/ajax03")
    public @ResponseBody String ajax03(@RequestParam("param1") String param1,
                                       @RequestParam("param2") String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "good";
    }
    @PostMapping("/ajax04")
    public @ResponseBody String ajax03(@RequestParam("param1") String param1,
                                       @RequestParam("param2") String param2,
                                       @RequestParam("qqqq") String qqqq){
        System.out.println("param1 = " + param1 + ", param2 = " + param2+"qqqq ="+qqqq);
        return "good";
    }
    @GetMapping("/ajax05")
    public @ResponseBody MemberDTO ajax05(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return memberDTO;
    }
    @Autowired
    private MemberService memberService;
    @GetMapping("/ajax06")
    public @ResponseBody List<MemberDTO> ajax06(){
        List<MemberDTO> memberDTOList = memberService.findAll();
        return memberDTOList;
    }
}
