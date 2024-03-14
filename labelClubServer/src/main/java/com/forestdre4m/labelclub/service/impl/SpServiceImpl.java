package com.forestdre4m.labelclub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.SpDao;
import com.forestdre4m.labelclub.entity.Sp;
import com.forestdre4m.labelclub.service.SpService;
import com.forestdre4m.labelclub.vo.SpVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("spService")
public class SpServiceImpl extends ServiceImpl<SpDao, Sp> implements SpService {

    @Resource
    private SpDao spDao;

    public Sp add(Sp sp) {
		
	   //youquchong1
        sp.setAddtime(new Date());
        spDao.insert(sp);
        return sp;
    }
	
	
	
    public void delete(Long id) {
        spDao.deleteById(id);
    }
	

    public void update(Sp sp) {
        //youquchong2
        spDao.updateById(sp);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return spDao.daochuexcel();
    }

    @Override
    public Sp findById(Integer id) {
        return spDao.selectById(id);
    }

    public SpVo findPage(SpVo spVo) {
        LambdaQueryWrapper<Sp> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(spVo.getName()), Sp::getName,spVo.getName());
        wrapper.like(ObjectUtils.isNotEmpty(spVo.getPic()), Sp::getPic,spVo.getPic());
        
        Page<Sp> page = new Page<>(spVo.getCurrent(),spVo.getCurrentNum());
        spDao.selectPage(page,wrapper);
        List<Sp> sps = page.getRecords();
        spVo.setList(sps);
        spVo.setPages(page.getPages());
        spVo.setTotal(page.getTotal());
        spVo.setCurrent(page.getCurrent());
        spVo.setCurrentNum(page.getSize());
        return spVo;
    }

    @Override
    public void deleteList(List<Sp> list) {
        List<Integer> ids =  list.stream().map(Sp::getId).collect(Collectors.toList());
        spDao.deleteBatchIds(ids);
    }
	
	
	
	
}
