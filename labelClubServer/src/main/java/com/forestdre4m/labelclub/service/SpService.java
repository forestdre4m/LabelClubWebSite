package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Sp;
import com.forestdre4m.labelclub.vo.SpVo;

import java.util.List;
import java.util.Map;

public interface SpService extends IService<Sp> {
    Sp add(Sp sp);
    void delete(Long id);
    void update(Sp sp);
    Sp findById(Integer id);
    SpVo findPage(SpVo spVo);
	
    void deleteList(List<Sp> list);
	
	
	List<Map<String, Object>> daochuexcel();
}
