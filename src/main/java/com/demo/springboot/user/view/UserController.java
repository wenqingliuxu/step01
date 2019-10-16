package com.demo.springboot.user.view;

import com.demo.springboot.user.service.IUserService;
import com.demo.springboot.user.service.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @RequestMapping("/add")
  public String add(User user){
    userService.add(user);
    return "list";
  }
}
