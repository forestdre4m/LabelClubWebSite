package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Pinglun;
import com.forestdre4m.labelclub.vo.PinglunVo;

import java.util.List;

public interface PinglunService extends IService<Pinglun> {
    Pinglun add(Pinglun pinglun);
    void delete(Long id);
    void update(Pinglun pinglun);
    Pinglun findById(Integer id);
    PinglunVo findPage(PinglunVo pinglunVo);
	
    void deleteList(List<Pinglun> list);
	
	
}
