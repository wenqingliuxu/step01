package com.demo.springboot.base.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*处理异常的Controller*/
@Controller
public class BaseErrorController implements ErrorController {
  
  private static final Logger logger = LogManager.getLogger(BaseErrorController.class);

  /*相当于web.xml中的<error-page>*/
  @Override
  public String getErrorPath() {
    return "error";
  }

  @RequestMapping("/error")
  public String errorHandle(HttpServletRequest request){
    Exception ex=(Exception) request.getAttribute("ex");
    if(ex!=null) {
      logger.info("准备异常页面的数据：" + ex.getMessage());
    }
    return "error";
  }
}
