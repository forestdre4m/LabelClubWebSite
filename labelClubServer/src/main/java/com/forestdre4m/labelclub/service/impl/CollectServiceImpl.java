package com.forestdre4m.labelclub.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.CollectDao;
import com.forestdre4m.labelclub.entity.Collect;
import com.forestdre4m.labelclub.entity.Label;

import com.forestdre4m.labelclub.service.CollectService;
import com.forestdre4m.labelclub.service.LabelService;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("collectService")
public class CollectServiceImpl  extends ServiceImpl<CollectDao, Collect> implements CollectService {

    @Resource
    private CollectDao collectDao;
	
	@Resource
private LabelService labelService;


   

    public Collect add(Collect collect) {
        Collect collect1 = collectDao.findByUser(collect);
        if(collect1 == null) {
            collectDao.insert(collect);
            return collect;
        }else {
            return null;
        }
    }

    public void delete(Integer id) {
        collectDao.deleteById(id);
    }

    public void update(Collect collect) {
        collectDao.updateById(collect);
    }

    public Collect findById(Long id) {
        return collectDao.selectById(id);
    }

    public List<Collect> findFrontPages(Integer userId) {
        List<Collect> collects;
        if (userId != null){
            collects = collectDao.findByEndUserId(userId);
        } else {
            collects = new ArrayList<>();
        }
        for (Collect collect : collects) {
            packOrder(collect);
        }
        return collects;
    }
    /**
     * 包装收藏的用户和商品信息
     */

	public List<Label> findPaperByChangpai(Integer id) {
        List<Collect> collects = collectDao.findByEndUserId(id);
        List<Label> labelList = new ArrayList<>();
        for (Collect collect : collects) {
            Integer foreignId = collect.getShangpinxinxiID();
            Label label = null;
            if(foreignId != null){
                label = labelService.findById(foreignId);
            };
            if(label != null){
                labelList.add(label);
            }
        }
        return labelList;
    }

	
	private void packOrder(Collect collect) {
        collect.setLabel(labelService.findById(collect.getUserId()));
        List<Label> goodsList = CollUtil.newArrayList();
        collect.setProductList(goodsList);
        Label goodsDetail = labelService.findById(collect.getShangpinxinxiID());
        if (goodsDetail != null) {
            goodsList.add(goodsDetail);
        }
    }

	@Override
    public void deleteByUserId(Integer id, Integer userId) {
        collectDao.deleteByUserId(id,userId);
    }
    
}
