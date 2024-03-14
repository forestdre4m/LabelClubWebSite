package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.FileInfo;

public interface FileInfoService extends IService<FileInfo> {
    FileInfo add(FileInfo fileInfo);
    void delete(Long id);
    void update(FileInfo fileInfo);
    FileInfo findById(Long id);
}
