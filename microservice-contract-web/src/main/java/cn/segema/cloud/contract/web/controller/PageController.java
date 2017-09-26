package cn.segema.cloud.contract.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/page")
    public String page3(Model model){
        model.addAttribute("userName","张三");
        return "hello";
    }
    @RequestMapping("info/more")
    public String page2(){
        return "hello2";
    }

    @RequestMapping("sys/index")
    public String page(){
        return "sys/index";
    }
}
