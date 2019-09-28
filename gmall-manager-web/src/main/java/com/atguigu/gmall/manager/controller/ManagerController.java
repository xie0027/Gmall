package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：Jun
 * @version ：  2019/9/23
 */

@Controller
public class ManagerController {

    @Reference
    ManagerService managerService;

    @ResponseBody
    @RequestMapping("/getCatalog3")
    public Object getCatalog3(String id){
        return managerService.getCatalog3(id);
    }

    @ResponseBody
    @RequestMapping("/getCatalog2")
    public Object getCatalog2(String id){
        return managerService.getCatalog2(id);
    }


    @ResponseBody
    @RequestMapping("/getCatalog1")
    public Object getCatalog1() {

        return managerService.getCatalog1();
    }

    @RequestMapping("/attrListPage")
    public String attrListPage() {
        return "attrListPage";
    }


    @RequestMapping("/spuListPage")
    public String spuListPage() {
        return "spuListPage";
    }


    @RequestMapping("/test")
    public String index() {
        return "test";
    }
}
