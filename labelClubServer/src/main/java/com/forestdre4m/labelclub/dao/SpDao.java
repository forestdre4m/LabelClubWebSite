package com.forestdre4m.labelclub.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forestdre4m.labelclub.entity.Sp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpDao extends BaseMapper<Sp> {

@Select("select * from sp")
List<Map<String, Object>> daochuexcel();

//tonxgji1
}
