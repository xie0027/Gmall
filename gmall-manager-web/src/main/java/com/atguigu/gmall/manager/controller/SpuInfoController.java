package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.manager.MyFileUploadUtil;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/25
 */
@Controller
public class SpuInfoController {

    @Reference
    SpuInfoService spuInfoService;

    @ResponseBody
    @GetMapping("/getSpuList")
    public Object getSpuList(String catg3Id){

        return spuInfoService.getSpuList(catg3Id);

    }


    @ResponseBody
    @PostMapping("/addSpuSaleAttr")
    public Boolean addSpuSaleAttr(SpuInfo spuInfo){

        int count = spuInfoService.addSpuSaleAttr(spuInfo);

        return count>0;

    }

    @ResponseBody
    @PostMapping ("/fileUpload")
    public String fileUpload(MultipartFile file){


        return MyFileUploadUtil.uploadImg(file);
    }
}
