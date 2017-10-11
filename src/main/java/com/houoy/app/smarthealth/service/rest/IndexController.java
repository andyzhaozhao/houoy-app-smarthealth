package com.houoy.app.smarthealth.service.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author andyzhao
 */
//@RestController("/api/login/")
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String signin() {
        System.out.println("sdfhjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        return "index";
    }
}


