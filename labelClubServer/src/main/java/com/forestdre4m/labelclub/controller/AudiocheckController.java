package com.forestdre4m.labelclub.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.entity.Audiocheck;
import com.forestdre4m.labelclub.service.AudiocheckService;
import com.forestdre4m.labelclub.vo.AudiocheckVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/audiocheck")
public class AudiocheckController {

    @Resource
    private AudiocheckService audiocheckService;

    @PostMapping
    public Result<Audiocheck> add(@RequestBody AudiocheckVo audiocheck) {
		//yoxuxiaxnci
        audiocheckService.add(audiocheck);
        return Result.success(audiocheck);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("author","投稿人");
        row.put("labelname","厂牌名称");
        row.put("audioname","作品名");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = audiocheckService.daochuexcel();
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
    public Result<Audiocheck> deleteList(@RequestBody AudiocheckVo audiocheck) {
        audiocheckService.deleteList(audiocheck.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        audiocheckService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody AudiocheckVo audiocheck) {
        audiocheckService.update(audiocheck);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Audiocheck> detail(@PathVariable Integer id) {
        Audiocheck audiocheck = audiocheckService.findById(id);
        return Result.success(audiocheck);
    }

    @GetMapping
    public Result<List<Audiocheck>> all() {
        return Result.success(audiocheckService.list());
    }

    @PostMapping("/page")
    public Result<AudiocheckVo> page(@RequestBody AudiocheckVo audiocheckVo) {
        return Result.success(audiocheckService.findPage(audiocheckVo));
    }
	//youupdt2login
}
