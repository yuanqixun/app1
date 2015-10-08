package com.superbpm.platform.core.app1.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

  @RequestMapping("/app1")
  public String app1(Model model,HttpServletRequest request){
    return "app1";
  }
}
