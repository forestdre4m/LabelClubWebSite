package com.forestdre4m.labelclub.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.common.ResultCode;
import com.forestdre4m.labelclub.entity.Admin;
import com.forestdre4m.labelclub.exception.CustomException;
import com.forestdre4m.labelclub.service.AdminService;
import com.forestdre4m.labelclub.utils.MapWrapperUtils;
import com.forestdre4m.labelclub.utils.jwt.JwtUtil;
import com.forestdre4m.labelclub.vo.AdminVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping
    public Result<Admin> add(@RequestBody AdminVo admin) {
        adminService.add(admin);
           return Result.success(admin);
    }

    @PostMapping("/deleteList")
    public Result<Admin> deleteList(@RequestBody AdminVo admin) {
        adminService.deleteList(admin.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        adminService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody AdminVo admin) {
        adminService.update(admin);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Admin> detail(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        return Result.success(admin);
    }

    @GetMapping
    public Result<List<Admin>> all() {
        return Result.success(adminService.list());
    }

    @PostMapping("/page")
    public Result<AdminVo> page(@RequestBody AdminVo adminVo) {
        return Result.success(adminService.findPage(adminVo));
    }
	    @PostMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest request) {
        if (StrUtil.isBlank(admin.getUsername()) || StrUtil.isBlank(admin.getPassword())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Admin login = adminService.login(admin);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法登录系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID, admin.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Admin info, HttpServletRequest request) {
        Admin admin = adminService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getPassword());
        if (!oldPassword.equals(admin.getPassword())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setMima(SecureUtil.md5(info.getNewPassword()));
        Admin admin1 = new Admin();
        BeanUtils.copyProperties(info, admin1);
        adminService.update(admin1);
        return Result.success();
    }
}
