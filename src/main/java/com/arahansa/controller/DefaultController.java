package com.arahansa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kangyong on 2016-08-27.
 */
@Slf4j
@Controller
public class DefaultController {

  @GetMapping("/")
  public String index(){
    log.debug("index....");
    return "index";
  }

}
