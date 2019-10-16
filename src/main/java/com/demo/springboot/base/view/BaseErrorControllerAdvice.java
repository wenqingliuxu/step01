package com.demo.springboot.base.view;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseErrorControllerAdvice {
  private static final Logger logger = LogManager.getLogger(BaseErrorControllerAdvice.class);

  @ExceptionHandler(value = Exception.class)
  public String handleExceptin(Exception ex, Model model){
    logger.info("捕获异常："+ex.getMessage());
    model.addAttribute("ex",ex);
    return "forward:/error";
  }
}
