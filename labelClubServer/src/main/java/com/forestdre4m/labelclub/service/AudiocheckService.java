package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Audiocheck;
import com.forestdre4m.labelclub.vo.AudiocheckVo;

import java.util.List;
import java.util.Map;

public interface AudiocheckService extends IService<Audiocheck> {
    Audiocheck add(Audiocheck audiocheck);
    void delete(Long id);
    void update(Audiocheck audiocheck);
    Audiocheck findById(Integer id);
    AudiocheckVo findPage(AudiocheckVo audiocheckVo);
	
    void deleteList(List<Audiocheck> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
