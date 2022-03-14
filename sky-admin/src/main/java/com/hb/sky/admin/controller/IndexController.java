package com.hb.sky.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转
 *
 * @author Mr.huang
 * @date 2022/2/25
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String workbench() {
        return "workbench";
    }

}
