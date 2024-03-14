package com.forestdre4m.labelclub.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forestdre4m.labelclub.entity.Lfm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LfmDao extends BaseMapper<Lfm> {


    void insertBatch(List<Lfm> lfmList);
}
