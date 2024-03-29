package com.forestdre4m.labelclub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.dao.FileInfoDao;
import com.forestdre4m.labelclub.entity.FileInfo;
import com.forestdre4m.labelclub.service.FileInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("FileInfoService")
public class FileInfoServiceImpl extends ServiceImpl<FileInfoDao, FileInfo> implements FileInfoService {

    @Resource
    private FileInfoDao FileInfoDao;

    public FileInfo add(FileInfo FileInfo) {
        FileInfoDao.insert(FileInfo);
        return FileInfo;
    }

    public void delete(Long id) {
        FileInfoDao.deleteById(id);
    }

    public void update(FileInfo FileInfo) {
        FileInfoDao.updateById(FileInfo);
    }

    public FileInfo findById(Long id) {
        return FileInfoDao.selectById(id);
    }
}
