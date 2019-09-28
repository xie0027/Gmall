package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseSaleAttr;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/24
 */
public interface AttrService {

    List<BaseAttrInfo> getAttrList(String id);

    int addAttrInfo(BaseAttrInfo baseAttrInfo);

    List<BaseSaleAttr> getSaleAttrList();
}
