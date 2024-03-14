package com.forestdre4m.labelclub.controller;

import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.entity.Liuyanban;
import com.forestdre4m.labelclub.service.LiuyanbanService;
import com.forestdre4m.labelclub.vo.LiuyanbanVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/liuyanban")
public class LiuyanbanController {

    @Resource
    private LiuyanbanService liuyanbanService;

    @PostMapping
    public Result<Liuyanban> add(@RequestBody LiuyanbanVo liuyanban) {
        liuyanbanService.add(liuyanban);
           return Result.success(liuyanban);
    }

    @PostMapping("/deleteList")
    public Result<Liuyanban> deleteList(@RequestBody LiuyanbanVo liuyanban) {
        liuyanbanService.deleteList(liuyanban.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        liuyanbanService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody LiuyanbanVo liuyanban) {
        liuyanbanService.update(liuyanban);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Liuyanban> detail(@PathVariable Integer id) {
        Liuyanban liuyanban = liuyanbanService.findById(id);
        return Result.success(liuyanban);
    }

    @GetMapping
    public Result<List<Liuyanban>> all() {
        return Result.success(liuyanbanService.list());
    }

    @PostMapping("/page")
    public Result<LiuyanbanVo> page(@RequestBody LiuyanbanVo liuyanbanVo) {
        return Result.success(liuyanbanService.findPage(liuyanbanVo));
    }
	//youupdt2login
}
