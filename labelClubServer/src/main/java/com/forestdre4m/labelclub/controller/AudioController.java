package com.forestdre4m.labelclub.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.entity.Audio;
import com.forestdre4m.labelclub.service.AudioService;
import com.forestdre4m.labelclub.vo.AudioVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/audio")
public class AudioController {

    @Resource
    private AudioService audioService;

    @PostMapping
    public Result<Audio> add(@RequestBody AudioVo audio) {
		//yoxuxiaxnci
        audioService.add(audio);
        return Result.success(audio);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("aid","aid");
        row.put("labelname","厂牌名称");
        row.put("audioname","作品名");
        row.put("author","作者");
        row.put("genre","流派");
        row.put("remark","稿件备注");
        row.put("udt","上传时间");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = audioService.daochuexcel();
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
    public Result<Audio> deleteList(@RequestBody AudioVo audio) {
        audioService.deleteList(audio.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        audioService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody AudioVo audio) {
        audioService.update(audio);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Audio> detail(@PathVariable Integer id) {
        Audio audio = audioService.findById(id);
        return Result.success(audio);
    }

    @GetMapping
    public Result<List<Audio>> all() {
        return Result.success(audioService.list());
    }

    @PostMapping("/page")
    public Result<AudioVo> page(@RequestBody AudioVo audioVo) {
        return Result.success(audioService.findPage(audioVo));
    }
	//youupdt2login
}
