package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.SpuInfo;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/25
 */
public interface SpuInfoService {

    List<SpuInfo> getSpuList(String id);

    int addSpuSaleAttr(SpuInfo spuInfo);
}
