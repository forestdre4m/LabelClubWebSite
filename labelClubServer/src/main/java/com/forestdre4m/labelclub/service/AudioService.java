package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Audio;
import com.forestdre4m.labelclub.vo.AudioVo;

import java.util.List;
import java.util.Map;

public interface AudioService extends IService<Audio> {
    Audio add(Audio audio);
    void delete(Long id);
    void update(Audio audio);
    Audio findById(Integer id);
    AudioVo findPage(AudioVo audioVo);
	
    void deleteList(List<Audio> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
