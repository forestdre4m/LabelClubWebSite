package com.forestdre4m.labelclub.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.common.ResultCode;
import com.forestdre4m.labelclub.dao.LabelDao;
import com.forestdre4m.labelclub.dao.LfmDao;
import com.forestdre4m.labelclub.entity.Artist;
import com.forestdre4m.labelclub.entity.Label;
import com.forestdre4m.labelclub.entity.Lfm;
import com.forestdre4m.labelclub.exception.CustomException;
import com.forestdre4m.labelclub.service.ArtistService;
import com.forestdre4m.labelclub.vo.ArtistVo;
import com.forestdre4m.labelclub.dao.ArtistDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("artistService")
public class ArtistServiceImpl extends ServiceImpl<ArtistDao, Artist> implements ArtistService {

    @Resource
    private ArtistDao artistDao;
    @Resource
    private LfmDao lfmDao;
    @Resource
    private LabelDao labelDao;

    @Transactional(rollbackFor = Exception.class)
    public Artist add(Artist artist) {
		if(artist.getPassword()==null) {artist.setPassword(SecureUtil.md5("001"));}else {artist.setPassword(SecureUtil.md5(artist.getPassword())); }
	    LambdaQueryWrapper<Artist> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Artist::getUsername,artist.getUsername());
        Artist findArtist = artistDao.selectOne(wrapper);
        if (findArtist != null) {
            throw new CustomException("1001", "" + artist.getUsername() + "\"已存在");
        }
        artist.setAddtime(new Date());
        artistDao.insert(artist);
        //新增成功后向推荐表中添加数据
        List<Label> labelList = labelDao.selectList(new LambdaQueryWrapper<>());
        List<Lfm> lfmList = new ArrayList<>();
        for (Label label : labelList) {
            Lfm lfm = new Lfm();
            lfm.setUid(artist.getId());
            // 默认为0
            lfm.setRate(0);
            lfm.setLid(label.getId());
            lfmList.add(lfm);
        }
        // 批量插入lfmList中的所有记录
        lfmDao.insertBatch(lfmList);

        return artist;
    }
	
	
	
    public void delete(Long id) {
        artistDao.deleteById(id);
    }
	

    public void update(Artist artist) {
         LambdaQueryWrapper<Artist> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Artist::getUsername,artist.getUsername());
        Artist findArtist = artistDao.selectOne(wrapper);
		if (findArtist != null && artist.getId() != findArtist.getId()) {
            throw new CustomException("1001", "" + artist.getUsername() + "\"已存在");
        }
        artistDao.updateById(artist);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return artistDao.daochuexcel();
    }

    @Override
    public Artist findById(Integer id) {
        return artistDao.selectById(id);
    }

    public ArtistVo findPage(ArtistVo artistVo) {
        LambdaQueryWrapper<Artist> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(artistVo.getUsername()), Artist::getUsername,artistVo.getUsername());
        wrapper.like(ObjectUtils.isNotEmpty(artistVo.getPassword()), Artist::getPassword,artistVo.getPassword());
        wrapper.like(ObjectUtils.isNotEmpty(artistVo.getUid()), Artist::getUid,artistVo.getUid());
        wrapper.like(ObjectUtils.isNotEmpty(artistVo.getEmail()), Artist::getEmail,artistVo.getEmail());
        wrapper.eq(ObjectUtils.isNotEmpty(artistVo.getSex()), Artist::getSex,artistVo.getSex());
        wrapper.like(ObjectUtils.isNotEmpty(artistVo.getAge()), Artist::getAge,artistVo.getAge());
        wrapper.like(ObjectUtils.isNotEmpty(artistVo.getText()), Artist::getText,artistVo.getText());
        wrapper.like(ObjectUtils.isNotEmpty(artistVo.getIcon()), Artist::getIcon,artistVo.getIcon());
        
        Page<Artist> page = new Page<>(artistVo.getCurrent(),artistVo.getCurrentNum());
        artistDao.selectPage(page,wrapper);
        List<Artist> artists = page.getRecords();
        artistVo.setList(artists);
        artistVo.setPages(page.getPages());
        artistVo.setTotal(page.getTotal());
        artistVo.setCurrent(page.getCurrent());
        artistVo.setCurrentNum(page.getSize());
        return artistVo;
    }

    @Override
    public void deleteList(List<Artist> list) {
        List<Integer> ids =  list.stream().map(Artist::getId).collect(Collectors.toList());
        artistDao.deleteBatchIds(ids);
    }

	@Override
    public Artist login(Artist artist) {
        LambdaQueryWrapper<Artist> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(artist.getUsername()), Artist::getUsername,artist.getUsername());
        Artist artistInfo = artistDao.selectOne(wrapper);
        if (artistInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(artist.getPassword()).equalsIgnoreCase(artistInfo.getPassword())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return artistInfo;
    }

    @Override
    public Artist loginA(Artist artist, HttpSession session) {
        LambdaQueryWrapper<Artist> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(artist.getUsername()), Artist::getUsername,artist.getUsername());
        Artist artistInfo = artistDao.selectOne(wrapper);
        if (artistInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(artist.getPassword()).equalsIgnoreCase(artistInfo.getPassword())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        session.setAttribute("artist",artistInfo);
        return artistInfo;
    }
	 @Override
    public void findartistusername(Artist artist) {
        LambdaQueryWrapper<Artist> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Artist::getUsername,artist.getUsername());
         Artist findArtist = artistDao.selectOne(wrapper);
        if (findArtist != null) {
            throw new CustomException("1001", "" + artist.getUsername() + "\"已存在");
        }
    }
	
	//youxxianxci
}
