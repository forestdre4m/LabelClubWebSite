package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Liuyanban;
import com.forestdre4m.labelclub.vo.LiuyanbanVo;

import java.util.List;

public interface LiuyanbanService extends IService<Liuyanban> {
    Liuyanban add(Liuyanban liuyanban);
    void delete(Long id);
    void update(Liuyanban liuyanban);
    Liuyanban findById(Integer id);
    LiuyanbanVo findPage(LiuyanbanVo liuyanbanVo);
	
    void deleteList(List<Liuyanban> list);

    List<Liuyanban> getLiuyan();
}
