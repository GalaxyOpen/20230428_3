package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    @PostMapping("/ajax07")
    public @ResponseBody MemberDTO ajax07(@RequestBody MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        return memberDTO;
    }
    @PostMapping("/ajax08")
    public @ResponseBody List<MemberDTO> ajax08(@RequestBody MemberDTO memberDTO){
    List<MemberDTO> memberDTOList = memberService.findAll();
    memberDTOList.add(memberDTO);
    return memberDTOList;
    }
    @PostMapping("/ajax09")
    public ResponseEntity ajax09(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
//        return new ResponseEntity<>(memberDTO, HttpStatus.Not_Found);
    }
    //REST API, restful api 저장할 때 post, 조회할떄 get
    @PostMapping("/ajax10")
    public ResponseEntity ajax10(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        List<MemberDTO> memberDTOList = memberService.findAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("member", memberDTO);
        resultMap.put("memberList", memberDTOList);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    @PostMapping("/email_check")
    public ResponseEntity email_check(@ModelAttribute String email, Model model){
        MemberDTO memberDTO = memberService.findByMemberEmail(email);
        model.addAttribute("member",memberDTO);
        if(memberDTO == null) {
            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(memberDTO, HttpStatus.CONFLICT);
        }
    }

}
