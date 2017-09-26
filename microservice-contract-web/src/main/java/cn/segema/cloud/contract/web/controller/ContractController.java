package cn.segema.cloud.contract.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContractController {

    @RequestMapping("contract/contractlist")
    public String page(Model model){
    	model.addAttribute("message","张三");
        return "contract/contractlist";
    }
}
