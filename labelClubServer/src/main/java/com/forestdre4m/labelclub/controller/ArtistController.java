package com.forestdre4m.labelclub.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.common.ResultCode;
import com.forestdre4m.labelclub.entity.Artist;
import com.forestdre4m.labelclub.exception.CustomException;
import com.forestdre4m.labelclub.service.ArtistService;
import com.forestdre4m.labelclub.utils.MapWrapperUtils;
import com.forestdre4m.labelclub.utils.jwt.JwtUtil;
import com.forestdre4m.labelclub.vo.ArtistVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController {

    @Resource
    private ArtistService artistService;

    @PostMapping
    public Result<Artist> add(@RequestBody ArtistVo artist) {
		//yoxuxiaxnci
        artistService.add(artist);
        return Result.success(artist);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("username","用户名");
        row.put("uid","uid");
        row.put("email","邮箱");
        row.put("sex","性别");
        row.put("age","年龄");
        row.put("text","签名");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> exportexcellist = artistService.daochuexcel();
        for (Map<String, Object> map : exportexcellist) {
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
    public Result<Artist> deleteList(@RequestBody ArtistVo artist) {
        artistService.deleteList(artist.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        artistService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ArtistVo artist) {
        artistService.update(artist);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Artist> detail(@PathVariable Integer id) {
        Artist artist = artistService.findById(id);
        return Result.success(artist);
    }

    @GetMapping
    public Result<List<Artist>> all() {
        return Result.success(artistService.list());
    }

    @PostMapping("/page")
    public Result<ArtistVo> page(@RequestBody ArtistVo artistVo) {
        return Result.success(artistService.findPage(artistVo));
    }
	    @PostMapping("/login")
    public Result login(@RequestBody Artist artist, HttpServletRequest request) {
        if (StrUtil.isBlank(artist.getUsername()) || StrUtil.isBlank(artist.getPassword())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
            Artist login = artistService.login(artist);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法登录系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID,artist.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Artist info, HttpServletRequest request) {
        Artist artist = artistService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getPassword());
        if (!oldPassword.equals(artist.getPassword())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setPassword(SecureUtil.md5(info.getNewPassword()));
        Artist artist1 = new Artist();
        BeanUtils.copyProperties(info, artist1);
        artistService.update(artist1);
        return Result.success();
    }
	@PostMapping("/register")
    public Result<Artist> register(@RequestBody ArtistVo artistVo) {
        artistService.add(artistVo);
        return Result.success(artistVo);
    }
}
