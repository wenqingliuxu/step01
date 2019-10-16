package com.demo.springboot.user.dao1;

import com.demo.springboot.user.service.bo.User;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserDao1 {
  public void add(User user);
}
