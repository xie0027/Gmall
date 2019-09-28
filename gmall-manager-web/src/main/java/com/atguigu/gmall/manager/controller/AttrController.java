package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：Jun
 * @version ：  2019/9/24
 */

@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    @ResponseBody
    @GetMapping("/getAttrList")
    public Object getAttrList(String catg3Id) {

        return attrService.getAttrList(catg3Id);
    }

    @ResponseBody
    @GetMapping("/addAttrInfo")
    public Boolean addAttrInfo(BaseAttrInfo baseAttrInfo) {

        int count = attrService.addAttrInfo(baseAttrInfo);

        return count>0;
    }


    @ResponseBody
    @PostMapping("/baseSaleAttrList")
    public Object baseSaleAttrList() {

        return attrService.getSaleAttrList();
    }
}
