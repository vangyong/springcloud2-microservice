package cn.segema.cloud.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.segema.cloud.rabbitmq.domain.Student;
import cn.segema.cloud.rabbitmq.sender.Producers;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@Autowired
    Producers producers;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public void send() {
        Student s = new Student();
        s.setName("zhangsan");
        s.setAddress("wuhan");
        s.setAge(20);
        producers.send(s);
    }
}
