package com.forestdre4m.labelclub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.ArtistDao;
import com.forestdre4m.labelclub.dao.AudiocheckDao;
import com.forestdre4m.labelclub.dao.LabelDao;
import com.forestdre4m.labelclub.dao.LfmDao;
import com.forestdre4m.labelclub.entity.Artist;
import com.forestdre4m.labelclub.entity.Audiocheck;
import com.forestdre4m.labelclub.entity.Label;
import com.forestdre4m.labelclub.entity.Lfm;
import com.forestdre4m.labelclub.service.AudiocheckService;
import com.forestdre4m.labelclub.vo.AudiocheckVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("audiocheckService")
public class AudiocheckServiceImpl extends ServiceImpl<AudiocheckDao, Audiocheck> implements AudiocheckService {

    @Resource
    private AudiocheckDao audiocheckDao;
    @Resource
    private LfmDao lfmDao;
    @Resource
    private LabelDao labelDao;
    @Resource
    private ArtistDao artistDao;

    public Audiocheck add(Audiocheck audiocheck) {
		
	   //youquchong1
        audiocheck.setAddtime(new Date());
        audiocheckDao.insert(audiocheck);
        return audiocheck;
    }
	
	
	
    public void delete(Long id) {
        audiocheckDao.deleteById(id);
    }



    @Transactional(rollbackFor = Exception.class)
    public void update(Audiocheck audiocheck) {
        //youquchong2
        audiocheckDao.updateById(audiocheck);
        //审核通过将对应的评分+2
        Integer uid = artistDao.selectOne(new LambdaQueryWrapper<Artist>()
                .eq(Artist::getUsername, audiocheck.getAuthor())
                .last("limit 1")).getId();
        Integer lid = labelDao.selectOne(new LambdaQueryWrapper<Label>()
                .eq(Label::getLabelname, audiocheck.getLabelname())
                .last("limit 1")).getId();
        Lfm lfm = lfmDao.selectOne(new LambdaQueryWrapper<Lfm>()
                .eq(Lfm::getUid, uid)
                .eq(Lfm::getLid, lid)
                .last("limit 1"));
        if (audiocheck.getIssh()) {
            lfm.setRate(lfm.getRate() + 2);
        }
        lfmDao.updateById(lfm);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return audiocheckDao.daochuexcel();
    }

    @Override
    public Audiocheck findById(Integer id) {
        return audiocheckDao.selectById(id);
    }

    public AudiocheckVo findPage(AudiocheckVo audiocheckVo) {
        LambdaQueryWrapper<Audiocheck> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(audiocheckVo.getAuthor()), Audiocheck::getAuthor,audiocheckVo.getAuthor());
        wrapper.like(ObjectUtils.isNotEmpty(audiocheckVo.getLabelname()), Audiocheck::getLabelname,audiocheckVo.getLabelname());
        wrapper.like(ObjectUtils.isNotEmpty(audiocheckVo.getAudioname()), Audiocheck::getAudioname,audiocheckVo.getAudioname());
        wrapper.eq(ObjectUtils.isNotEmpty(audiocheckVo.getIssh()), Audiocheck::getIssh,audiocheckVo.getIssh());
        
        Page<Audiocheck> page = new Page<>(audiocheckVo.getCurrent(),audiocheckVo.getCurrentNum());
        audiocheckDao.selectPage(page,wrapper);
        List<Audiocheck> audiochecks = page.getRecords();
        audiocheckVo.setList(audiochecks);
        audiocheckVo.setPages(page.getPages());
        audiocheckVo.setTotal(page.getTotal());
        audiocheckVo.setCurrent(page.getCurrent());
        audiocheckVo.setCurrentNum(page.getSize());
        return audiocheckVo;
    }

    @Override
    public void deleteList(List<Audiocheck> list) {
        List<Integer> ids =  list.stream().map(Audiocheck::getId).collect(Collectors.toList());
        audiocheckDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
