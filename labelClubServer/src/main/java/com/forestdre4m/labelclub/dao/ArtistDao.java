package com.forestdre4m.labelclub.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forestdre4m.labelclub.entity.Artist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArtistDao extends BaseMapper<Artist> {

@Select("select * from artist")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
