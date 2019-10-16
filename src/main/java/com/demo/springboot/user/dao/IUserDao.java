package com.demo.springboot.user.dao;

import com.demo.springboot.user.service.bo.User;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserDao {
  public void add(User user);
}
