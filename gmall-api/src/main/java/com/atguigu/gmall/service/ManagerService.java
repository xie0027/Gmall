package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseCatalog1;
import com.atguigu.gmall.bean.BaseCatalog2;
import com.atguigu.gmall.bean.BaseCatalog3;

import java.util.List;

/**
 * @author ：Jun
 * @version ：  2019/9/23
 */

public interface ManagerService {

    List<BaseCatalog1> getCatalog1();

    List<BaseCatalog2> getCatalog2(String id);

    List<BaseCatalog3> getCatalog3(String id);

}
