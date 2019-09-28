package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.manager.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.manager.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.manager.mapper.BaseSaleAttrMapper;
import com.atguigu.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/24
 */
@Transactional
@Service
public class AttrServiceImpl implements AttrService {

    private BaseAttrInfo baseAttrInfo = new BaseAttrInfo();

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;

    @Override
    public List<BaseAttrInfo> getAttrList(String id) {

        baseAttrInfo.setCatalog3Id(id);

        return baseAttrInfoMapper.select(baseAttrInfo);
    }

    @Override
    public int addAttrInfo(BaseAttrInfo baseAttrInfo) {

        int index = baseAttrInfoMapper.insertSelective(baseAttrInfo);

        System.out.println(index);
        System.out.println(baseAttrInfo.getId());

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();

        int count = 0;

        for (BaseAttrValue baseAttrValue : attrValueList) {

            baseAttrValue.setAttrId(baseAttrInfo.getId());
            count = baseAttrValueMapper.insert(baseAttrValue);
        }

        return count;
    }

    @Override
    public List<BaseSaleAttr> getSaleAttrList() {

        return baseSaleAttrMapper.selectAll();
    }
}
