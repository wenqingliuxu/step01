package com.demo.springboot.user.dao2;

import com.demo.springboot.user.service.bo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao2 {
  public void add(User user);
}