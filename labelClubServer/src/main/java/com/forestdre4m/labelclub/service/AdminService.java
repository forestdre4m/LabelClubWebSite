package com.forestdre4m.labelclub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.forestdre4m.labelclub.entity.Admin;
import com.forestdre4m.labelclub.vo.AdminVo;

import java.util.List;

public interface AdminService extends IService<Admin> {
    Admin add(Admin admin);
    void delete(Long id);
    void update(Admin admin);
    Admin findById(Integer id);
    AdminVo findPage(AdminVo adminVo);
	Admin login(Admin admin);
    void deleteList(List<Admin> list);
}
