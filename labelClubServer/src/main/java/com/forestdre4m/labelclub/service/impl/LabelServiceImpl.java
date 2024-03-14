package com.forestdre4m.labelclub.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.common.ResultCode;
import com.forestdre4m.labelclub.dao.ArtistDao;
import com.forestdre4m.labelclub.dao.LfmDao;
import com.forestdre4m.labelclub.entity.Artist;
import com.forestdre4m.labelclub.entity.Label;
import com.forestdre4m.labelclub.entity.Lfm;
import com.forestdre4m.labelclub.exception.CustomException;
import com.forestdre4m.labelclub.service.LabelService;
import com.forestdre4m.labelclub.vo.LabelVo;
import com.forestdre4m.labelclub.dao.LabelDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("labelService")
public class LabelServiceImpl extends ServiceImpl<LabelDao, Label> implements LabelService {

    @Resource
    private LabelDao labelDao;
    @Resource
    private ArtistDao artistDao;
    @Resource
    private LfmDao lfmDao;

    @Transactional(rollbackFor = Exception.class)
    public Label add(Label label) {
		if(label.getPassword()==null) {
            label.setPassword(SecureUtil.md5("001"));}else {
            label.setPassword(SecureUtil.md5(label.getPassword())); }
	    LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Label::getUsername, label.getUsername());
        Label findLabel = labelDao.selectOne(wrapper);
        if (findLabel != null) {
            throw new CustomException("1001", "" + label.getUsername() + "\"已存在");
        }
        label.setAddtime(new Date());
        labelDao.insert(label);
        //新增成功后向推荐表中添加数据
        List<Artist> artistList = artistDao.selectList(new LambdaQueryWrapper<>());
        List<Lfm> lfmList = new ArrayList<>();
        for (Artist artist : artistList) {
            Lfm lfm = new Lfm();
            lfm.setUid(artist.getId());
            // 默认为0
            lfm.setRate(0);
            lfm.setLid(label.getId());
            lfmList.add(lfm);
        }
        // 批量插入lfmList中的所有记录
        lfmDao.insertBatch(lfmList);

        return label;
    }
	
	
	
    public void delete(Long id) {
        labelDao.deleteById(id);
    }
	

    public void update(Label label) {
         LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Label::getUsername, label.getUsername());
        Label findLabel = labelDao.selectOne(wrapper);
		if (findLabel != null && label.getId() != findLabel.getId()) {
            throw new CustomException("1001", "" + label.getUsername() + "\"已存在");
        }
        labelDao.updateById(label);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return labelDao.daochuexcel();
    }

    @Override
    public LabelVo findRecommendPage(LabelVo labelVo,HttpSession session) {
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery();
        Page<Label> page = new Page<>(labelVo.getCurrent(), labelVo.getCurrentNum());
        labelDao.selectPage(page,wrapper);
        Artist artist = (Artist) session.getAttribute("artist");
        List<Label> labelList = new ArrayList<>();
        if (artist != null && artist.getId() != null) {
            List<Lfm> lfmList = lfmDao.selectList(new LambdaQueryWrapper<Lfm>()
                    .eq(Lfm::getUid, artist.getId())
                    .gt(Lfm::getRate, 5));
            // 获取lfmList中的lid列表
            List<Integer> lidList = lfmList.stream().map(Lfm::getLid).collect(Collectors.toList());
            if (!lidList.isEmpty()) {
                // 查询符合lid在lidList中的记录
                labelList = labelDao.selectList(new LambdaQueryWrapper<Label>()
                        .in(Label::getId, lidList));
            }
        }
        labelVo.setList(labelList);
        labelVo.setPages(page.getPages());
        labelVo.setTotal(page.getTotal());
        labelVo.setCurrent(page.getCurrent());
        labelVo.setCurrentNum(page.getSize());
        return labelVo;
    }

    @Override
    public Label findById(Integer id) {
        return labelDao.selectById(id);
    }

    public LabelVo findPage(LabelVo labelVo) {
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(labelVo.getUsername()), Label::getUsername, labelVo.getUsername());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getPassword()), Label::getPassword, labelVo.getPassword());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getLid()), Label::getLid, labelVo.getLid());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getLabelname()), Label::getLabelname, labelVo.getLabelname());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getEmail()), Label::getEmail, labelVo.getEmail());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getPlace()), Label::getPlace, labelVo.getPlace());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getDoe()), Label::getDoe, labelVo.getDoe());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getGenre()), Label::getGenre, labelVo.getGenre());
        wrapper.like(ObjectUtils.isNotEmpty(labelVo.getLabelpic()), Label::getLabelpic, labelVo.getLabelpic());
        
        Page<Label> page = new Page<>(labelVo.getCurrent(), labelVo.getCurrentNum());
        labelDao.selectPage(page,wrapper);
        List<Label> labels = page.getRecords();
        labelVo.setList(labels);
        labelVo.setPages(page.getPages());
        labelVo.setTotal(page.getTotal());
        labelVo.setCurrent(page.getCurrent());
        labelVo.setCurrentNum(page.getSize());
        return labelVo;
    }

    @Override
    public void deleteList(List<Label> list) {
        List<Integer> ids =  list.stream().map(Label::getId).collect(Collectors.toList());
        labelDao.deleteBatchIds(ids);
    }
	
	@Override
    public Label login(Label label) {
        LambdaQueryWrapper<Label> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(label.getUsername()), Label::getUsername, label.getUsername());
        Label labelInfo = labelDao.selectOne(wrapper);
        if (labelInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(label.getPassword()).equalsIgnoreCase(labelInfo.getPassword())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return labelInfo;
    }
	
	
	
	//youxxianxci
}
