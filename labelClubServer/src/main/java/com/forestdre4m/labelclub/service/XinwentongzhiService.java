package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Xinwentongzhi;
import com.forestdre4m.labelclub.vo.XinwentongzhiVo;

import java.util.List;

public interface XinwentongzhiService extends IService<Xinwentongzhi> {
    Xinwentongzhi add(Xinwentongzhi xinwentongzhi);
    void delete(Long id);
    void update(Xinwentongzhi xinwentongzhi);
    Xinwentongzhi findById(Integer id);
    XinwentongzhiVo findPage(XinwentongzhiVo xinwentongzhiVo);
	
    void deleteList(List<Xinwentongzhi> list);
	
}
