package com.forestdre4m.labelclub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.*;
import com.forestdre4m.labelclub.dao.XinwentongzhiDao;
import com.forestdre4m.labelclub.entity.Xinwentongzhi;
import com.forestdre4m.labelclub.service.XinwentongzhiService;
import com.forestdre4m.labelclub.vo.XinwentongzhiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("xinwentongzhiService")
public class XinwentongzhiServiceImpl extends ServiceImpl<XinwentongzhiDao, Xinwentongzhi> implements XinwentongzhiService {

    @Resource
    private XinwentongzhiDao xinwentongzhiDao;

    public Xinwentongzhi add(Xinwentongzhi xinwentongzhi) {
		
	   //youquchong1
        xinwentongzhi.setAddtime(new Date());
        xinwentongzhiDao.insert(xinwentongzhi);
        return xinwentongzhi;
    }
	
	
	
    public void delete(Long id) {
        xinwentongzhiDao.deleteById(id);
    }

    public void update(Xinwentongzhi xinwentongzhi) {
        //youquchong2
        xinwentongzhiDao.updateById(xinwentongzhi);
    }

    @Override
    public Xinwentongzhi findById(Integer id) {
        return xinwentongzhiDao.selectById(id);
    }

    public XinwentongzhiVo findPage(XinwentongzhiVo xinwentongzhiVo) {
        LambdaQueryWrapper<Xinwentongzhi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(xinwentongzhiVo.getBiaoti()), Xinwentongzhi::getBiaoti,xinwentongzhiVo.getBiaoti());
        wrapper.like(ObjectUtils.isNotEmpty(xinwentongzhiVo.getLeibie()), Xinwentongzhi::getLeibie,xinwentongzhiVo.getLeibie());
        wrapper.like(ObjectUtils.isNotEmpty(xinwentongzhiVo.getNeirong()), Xinwentongzhi::getNeirong,xinwentongzhiVo.getNeirong());
        wrapper.like(ObjectUtils.isNotEmpty(xinwentongzhiVo.getDianjilv()), Xinwentongzhi::getDianjilv,xinwentongzhiVo.getDianjilv());
        
        Page<Xinwentongzhi> page = new Page<>(xinwentongzhiVo.getCurrent(),xinwentongzhiVo.getCurrentNum());
        xinwentongzhiDao.selectPage(page,wrapper);
        List<Xinwentongzhi> xinwentongzhis = page.getRecords();
        xinwentongzhiVo.setList(xinwentongzhis);
        xinwentongzhiVo.setPages(page.getPages());
        xinwentongzhiVo.setTotal(page.getTotal());
        xinwentongzhiVo.setCurrent(page.getCurrent());
        xinwentongzhiVo.setCurrentNum(page.getSize());
        return xinwentongzhiVo;
    }

    @Override
    public void deleteList(List<Xinwentongzhi> list) {
        List<Integer> ids =  list.stream().map(Xinwentongzhi::getId).collect(Collectors.toList());
        xinwentongzhiDao.deleteBatchIds(ids);
    }
	
	
}
