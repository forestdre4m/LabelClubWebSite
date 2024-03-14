package com.forestdre4m.labelclub.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forestdre4m.labelclub.common.ResultCode;
import com.forestdre4m.labelclub.dao.AdminDao;
import com.forestdre4m.labelclub.entity.Admin;
import com.forestdre4m.labelclub.exception.CustomException;
import com.forestdre4m.labelclub.service.AdminService;
import com.forestdre4m.labelclub.vo.AdminVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

    @Resource
    private AdminDao adminDao;

    public Admin add(Admin admin) {
        admin.setMima(SecureUtil.md5(admin.getPassword()));
	    LambdaQueryWrapper<Admin> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Admin::getUsername, admin.getUsername());
        Admin findAdmin = adminDao.selectOne(wrapper);
        if (findAdmin != null) {
            throw new CustomException("1001", "" + admin.getUsername() + "\"已存在");
        }
        admin.setAddtime(new Date());
        adminDao.insert(admin);
        return admin;
    }

    public void delete(Long id) {
        adminDao.deleteById(id);
    }

    public void update(Admin admin) {
         LambdaQueryWrapper<Admin> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Admin::getUsername, admin.getUsername());
        Admin findAdmin = adminDao.selectOne(wrapper);
		if (findAdmin != null && admin.getId() != findAdmin.getId()) {
            throw new CustomException("1001", "" + admin.getUsername() + "\"已存在");
        }
        adminDao.updateById(admin);
    }

    @Override
    public Admin findById(Integer id) {
        return adminDao.selectById(id);
    }

    public AdminVo findPage(AdminVo adminVo) {
        LambdaQueryWrapper<Admin> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(adminVo.getUsername()), Admin::getUsername,adminVo.getUsername());
        
        Page<Admin> page = new Page<>(adminVo.getCurrent(),adminVo.getCurrentNum());
        adminDao.selectPage(page,wrapper);
        List<Admin> admins = page.getRecords();
        adminVo.setList(admins);
        adminVo.setPages(page.getPages());
        adminVo.setTotal(page.getTotal());
        adminVo.setCurrent(page.getCurrent());
        adminVo.setCurrentNum(page.getSize());
        return adminVo;
    }

    @Override
    public void deleteList(List<Admin> list) {
        List<Integer> ids =  list.stream().map(Admin::getId).collect(Collectors.toList());
        adminDao.deleteBatchIds(ids);
    }
	
	@Override
    public Admin login(Admin admin) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(admin.getUsername()), Admin::getUsername, admin.getUsername());
        Admin adminInfo = adminDao.selectOne(wrapper);
        if (adminInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(admin.getPassword()).equalsIgnoreCase(adminInfo.getPassword())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return adminInfo;
    }
}
