package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;

import com.forestdre4m.labelclub.entity.Collect;

public interface CollectService extends IService<Collect> {
    void deleteByUserId(Integer id, Integer userId);
}
