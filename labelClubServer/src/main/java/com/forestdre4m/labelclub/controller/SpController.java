package com.forestdre4m.labelclub.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.entity.Sp;
import com.forestdre4m.labelclub.service.SpService;
import com.forestdre4m.labelclub.vo.SpVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/sp")
public class SpController {

    @Resource
    private SpService spService;

    @PostMapping
    public Result<Sp> add(@RequestBody SpVo sp) {
        spService.add(sp);
           return Result.success(sp);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("name","名称");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = spService.daochuexcel();
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
    public Result<Sp> deleteList(@RequestBody SpVo sp) {
        spService.deleteList(sp.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        spService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody SpVo sp) {
        spService.update(sp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Sp> detail(@PathVariable Integer id) {
        Sp sp = spService.findById(id);
        return Result.success(sp);
    }

    @GetMapping
    public Result<List<Sp>> all() {
        return Result.success(spService.list());
    }

    @PostMapping("/page")
    public Result<SpVo> page(@RequestBody SpVo spVo) {
        return Result.success(spService.findPage(spVo));
    }
	//youupdt2login
}
