package com.icia.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjaxViewController {
    @GetMapping("/ajax-view01")
    public String ajaxView01() {
        return "ajax01";
    }

    @GetMapping("/ajax-view02")
    public String ajaxView02() {
        return "ajax02";
    }

    @GetMapping("/ajax-view03")
    public String ajaxView03() {
        return "ajax03";
    }

    @GetMapping("/ajax-view04")
    public String ajaxView04(){
        return"ajax04";
}
    @GetMapping("/ajax-view05")
    public String ajaxView05(){
        return "ajax05";
    }
    @GetMapping("/ajax-view06")
    public String ajaxView06(){
        return "ajax06";
    }
}
