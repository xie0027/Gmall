package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/21
 */
@RestController
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/index")
    public ResponseEntity<List<UserInfo>> index(){
        List<UserInfo> userInfos = userService.queryAll();

        return ResponseEntity.ok(userInfos);
    }
}
