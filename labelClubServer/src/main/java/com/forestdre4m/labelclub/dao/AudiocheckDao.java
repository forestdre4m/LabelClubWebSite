package com.forestdre4m.labelclub.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forestdre4m.labelclub.entity.Audiocheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AudiocheckDao extends BaseMapper<Audiocheck> {

@Select("select * from audiocheck")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
