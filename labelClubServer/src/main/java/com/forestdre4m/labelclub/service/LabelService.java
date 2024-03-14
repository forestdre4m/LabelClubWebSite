package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Label;
import com.forestdre4m.labelclub.vo.LabelVo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface LabelService extends IService<Label> {
    Label add(Label label);
    void delete(Long id);
    void update(Label label);
    Label findById(Integer id);
    LabelVo findPage(LabelVo labelVo);
	Label login(Label label);
    void deleteList(List<Label> list);
	
	
	List<Map<String, Object>> daochuexcel();

    LabelVo findRecommendPage(LabelVo labelVo, HttpSession session);
    //youxxianxci
}
