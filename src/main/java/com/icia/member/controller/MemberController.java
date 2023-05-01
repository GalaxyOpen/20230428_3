package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String saveForm() {
        return "memberSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        int saveResult = memberService.save(memberDTO);
        if (saveResult > 0) {
            return "memberLogin";
        } else {
            return "index";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "memberLogin";
    }
/*
* 세션(session) :
* - 톰캣이 서버가 도는 동안에는 계속 유지가 되는 값.
* - 로그아웃하기 전까지 유지가능.
* 세션에는 뭘 자꾸 담으면 안됨.
* */
@PostMapping("/login")
public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
    boolean loginResult = memberService.login(memberDTO);
    if (loginResult) {
//            model.addAttribute("loginEmail", memberDTO.getMemberEmail());
        session.setAttribute("loginEmail", memberDTO.getMemberEmail());
        return "memberMain";
    } else {
        return "memberLogin";
    }
}

    @GetMapping("/mypage")
    public String myPage() {
        return "memberMain";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에 담긴 값 전체 삭제
//        session.invalidate();
        // 특정 파라미터만 삭제
        session.removeAttribute("loginEmail");
        return "redirect:/";

        // 둘다 쓰면 에러가 나므로 하나만 써야 한다.
    }
    @GetMapping("/members")
    public String findAll(Model model){
    List<MemberDTO> memberDTOList = memberService.findAll();
    model.addAttribute("memberList", memberDTOList);
    return "memberList";
    }
    @GetMapping("/member")
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "memberDetail";
    }
    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model ){
       String loginEmail = (String)session.getAttribute("loginEmail");
       // session은 리턴값이 object이므로 String으로 형변환해줘야 한다.
        MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
        model.addAttribute("member", memberDTO);
        return "memberUpdate";
    }
    @PostMapping("/update")
    public String update (@ModelAttribute MemberDTO memberDTO) {
    memberService.update(memberDTO);
    return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id) {
    memberService.delete(id);
    return "redirect:/members";
    }
}
