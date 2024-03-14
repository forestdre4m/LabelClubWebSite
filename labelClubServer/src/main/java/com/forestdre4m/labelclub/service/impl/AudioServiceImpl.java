package com.forestdre4m.labelclub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.AudioDao;
import com.forestdre4m.labelclub.entity.Audio;
import com.forestdre4m.labelclub.service.AudioService;
import com.forestdre4m.labelclub.vo.AudioVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("audioService")
public class AudioServiceImpl extends ServiceImpl<AudioDao, Audio> implements AudioService {

    @Resource
    private AudioDao audioDao;

    public Audio add(Audio audio) {
		
	   //youquchong1
        audio.setAddtime(new Date());
        audioDao.insert(audio);
        return audio;
    }
	
	
	
    public void delete(Long id) {
        audioDao.deleteById(id);
    }
	

    public void update(Audio audio) {
        //youquchong2
        audioDao.updateById(audio);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return audioDao.daochuexcel();
    }

    @Override
    public Audio findById(Integer id) {
        return audioDao.selectById(id);
    }

    public AudioVo findPage(AudioVo audioVo) {
        LambdaQueryWrapper<Audio> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(audioVo.getAid()), Audio::getAid, audioVo.getAid());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getLabelname()), Audio::getLabelname, audioVo.getLabelname());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getAudioname()), Audio::getAudioname, audioVo.getAudioname());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getAuthor()), Audio::getAuthor, audioVo.getAuthor());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getFile()), Audio::getFile, audioVo.getFile());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getGenre()), Audio::getGenre, audioVo.getGenre());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getRemark()), Audio::getRemark, audioVo.getRemark());
        wrapper.like(ObjectUtils.isNotEmpty(audioVo.getUdt()), Audio::getUdt, audioVo.getUdt());
        
        Page<Audio> page = new Page<>(audioVo.getCurrent(), audioVo.getCurrentNum());
        audioDao.selectPage(page,wrapper);
        List<Audio> audio = page.getRecords();
        audioVo.setList(audio);
        audioVo.setPages(page.getPages());
        audioVo.setTotal(page.getTotal());
        audioVo.setCurrent(page.getCurrent());
        audioVo.setCurrentNum(page.getSize());
        return audioVo;
    }

    @Override
    public void deleteList(List<Audio> list) {
        List<Integer> ids =  list.stream().map(Audio::getId).collect(Collectors.toList());
        audioDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
