package com.demo.springboot.user.service.impl;

import com.demo.springboot.user.service.IUserService;
import com.demo.springboot.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
  private static final Logger logger = LogManager.getLogger(UserService.class);

  @Autowired
  private com.demo.springboot.user.dao1.IUserDao1 userDao1;

  @Autowired
  private com.demo.springboot.user.dao2.IUserDao2 userDao2;

  @Override
  @Transactional
  public void add(User user) {
    if(user.getId()%2!=0){
      userDao1.add(user);
      logger.info("dao1.userid:"+user.getId());
      userDao1.add(user);
    }else{
      userDao2.add(user);
      logger.info("dao2.userid:"+user.getId());
      userDao2.add(user);

    }

  }
}
