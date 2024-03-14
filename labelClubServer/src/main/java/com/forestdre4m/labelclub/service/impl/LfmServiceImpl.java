package com.forestdre4m.labelclub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.LfmDao;
import com.forestdre4m.labelclub.entity.Lfm;
import com.forestdre4m.labelclub.service.LfmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("lfmService")
public class LfmServiceImpl extends ServiceImpl<LfmDao, Lfm> implements LfmService {

    @Resource
    private LfmDao lfmDao;



}
