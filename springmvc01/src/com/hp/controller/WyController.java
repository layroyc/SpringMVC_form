package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WyController {
    @RequestMapping("/wy")
    public String wy(){
        System.out.println("请求进入roy中");
        return "roy";
    }
}
