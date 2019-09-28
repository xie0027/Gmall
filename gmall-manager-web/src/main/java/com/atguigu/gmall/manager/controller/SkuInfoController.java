package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.service.SkuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkuInfoController {

    @Reference
    SkuInfoService skuInfoService;

    @ResponseBody
    @GetMapping("/skuInfoListBySpu")
    public Object skuInfoListBySpu(String spuId){

        return skuInfoService.skuInfoListBySpu(spuId);
    }

}
