package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Artist;
import com.forestdre4m.labelclub.vo.ArtistVo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface ArtistService extends IService<Artist> {
    Artist add(Artist artist);
    void delete(Long id);
    void update(Artist artist);
    Artist findById(Integer id);
    ArtistVo findPage(ArtistVo artistVo);
    Artist login(Artist artist);
    Artist loginA(Artist artist, HttpSession session);
    void deleteList(List<Artist> list);
	
	void findartistusername(Artist artist);
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
