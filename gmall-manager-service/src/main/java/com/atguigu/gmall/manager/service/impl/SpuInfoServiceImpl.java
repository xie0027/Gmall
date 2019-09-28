package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.bean.SpuSaleAttrValue;
import com.atguigu.gmall.manager.mapper.SpuImageMapper;
import com.atguigu.gmall.manager.mapper.SpuInfoMapper;
import com.atguigu.gmall.manager.mapper.SpuSaleAttrMapper;
import com.atguigu.gmall.manager.mapper.SpuSaleAttrValueMapper;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/25
 */
@Transactional
@Service
public class SpuInfoServiceImpl implements SpuInfoService {


    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Autowired
    SpuImageMapper spuImageMapper;

    @Override
    public List<SpuInfo> getSpuList(String id) {

        SpuInfo spuInfo = new SpuInfo();

        spuInfo.setCatalog3Id(id);

        return spuInfoMapper.select(spuInfo);
    }

    @Override
    public int addSpuSaleAttr(SpuInfo spuInfo) {


        int count = spuInfoMapper.insert(spuInfo);

        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();

        List<SpuImage> spuImageList = spuInfo.getSpuImageList();

        for (SpuImage spuImage : spuImageList) {
            spuImage.setSpuId(spuInfo.getId());
            count = spuImageMapper.insert(spuImage);
        }

        for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {

            spuSaleAttr.setSpuId(spuInfo.getId());

            count = spuSaleAttrMapper.insert(spuSaleAttr);

            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();

            for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {

                spuSaleAttrValue.setSpuId(spuSaleAttr.getSpuId());
                spuSaleAttrValue.setSaleAttrId(spuSaleAttr.getSaleAttrId());
                count = spuSaleAttrValueMapper.insert(spuSaleAttrValue);

            }

        }

        return count;
    }
}
