package com.forestdre4m.labelclub.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.common.ResultCode;
import com.forestdre4m.labelclub.entity.Label;
import com.forestdre4m.labelclub.exception.CustomException;
import com.forestdre4m.labelclub.service.LabelService;
import com.forestdre4m.labelclub.utils.MapWrapperUtils;
import com.forestdre4m.labelclub.utils.jwt.JwtUtil;
import com.forestdre4m.labelclub.vo.LabelVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/label")
public class LabelController {

    @Resource
    private LabelService labelService;

    @PostMapping
    public Result<Label> add(@RequestBody LabelVo label) {
		//yoxuxiaxnci
        labelService.add(label);
        return Result.success(label);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("username","用户名");
        row.put("lid","lid");
        row.put("labelname","厂牌名称");
        row.put("email","邮箱");
        row.put("place","地点");
        row.put("doe","成立日期");
        row.put("genre","流派标签");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = labelService.daochuexcel();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=chaoba.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Label> deleteList(@RequestBody LabelVo label) {
        labelService.deleteList(label.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        labelService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody LabelVo label) {
        labelService.update(label);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Label> detail(@PathVariable Integer id) {
        Label label = labelService.findById(id);
        return Result.success(label);
    }

    @GetMapping
    public Result<List<Label>> all() {
        return Result.success(labelService.list());
    }

    @PostMapping("/page")
    public Result<LabelVo> page(@RequestBody LabelVo labelVo) {
        return Result.success(labelService.findPage(labelVo));
    }
    @PostMapping("/login")
    public Result login(@RequestBody Label label, HttpServletRequest request) {
        if (StrUtil.isBlank(label.getUsername()) || StrUtil.isBlank(label.getPassword())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Label login = labelService.login(label);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法登录系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID, label.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Label info, HttpServletRequest request) {
        Label label = labelService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getPassword());
        if (!oldPassword.equals(label.getPassword())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setPassword(SecureUtil.md5(info.getNewPassword()));
        Label label1 = new Label();
        BeanUtils.copyProperties(info, label1);
        labelService.update(label1);
        return Result.success();
    }
	@PostMapping("/register")
    public Result<Label> register(@RequestBody LabelVo label) {
        labelService.add(label);
        return Result.success(label);
    }
}
