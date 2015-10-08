package com.superbpm.apps.app1.controller.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestController {

  @RequestMapping("/app1")
  public String app1(Model model,HttpServletRequest request){
    return "app1";
  }

  @RequestMapping(value="app1login",method = {RequestMethod.GET})
  public String loginGet(Map<String, Object> model) {
    model.put("username","");
    return "app1login";
  }

  @RequestMapping(value="app1login",method = {RequestMethod.POST})
  public String loginPost(Map<String,String> model,
                          @RequestParam("loginName") String username,
                          @RequestParam("loginPass") String password,
                          RedirectAttributesModelMap modelMap) {
    String error = null;
    model.put("username", username);
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
    try {
      subject.login(token);
    } catch (UnknownAccountException e) {
      error = "用户名/密码错误";
    } catch (IncorrectCredentialsException e) {
      error = "用户名/密码错误";
    } catch (AuthenticationException e) {
      //其他错误，比如锁定，如果想单独处理请单独catch处理
      error = "其他错误：" + e.getMessage();
    }
    if(StringUtils.isBlank(error)){
      //传参
      modelMap.addFlashAttribute("username",username);
      return ("redirect:/");
    } else {
      model.put("error", error);
      return "app1login";
    }
  }
}
