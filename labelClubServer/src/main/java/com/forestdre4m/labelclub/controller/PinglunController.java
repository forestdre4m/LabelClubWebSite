package com.forestdre4m.labelclub.controller;

import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.entity.Pinglun;
import com.forestdre4m.labelclub.service.PinglunService;
import com.forestdre4m.labelclub.vo.PinglunVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/pinglun")
public class PinglunController {

    @Resource
    private PinglunService pinglunService;

    @PostMapping
    public Result<Pinglun> add(@RequestBody PinglunVo pinglun) {
        pinglunService.add(pinglun);
           return Result.success(pinglun);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Pinglun> deleteList(@RequestBody PinglunVo pinglun) {
        pinglunService.deleteList(pinglun.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        pinglunService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody PinglunVo pinglun) {
        pinglunService.update(pinglun);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Pinglun> detail(@PathVariable Integer id) {
        Pinglun pinglun = pinglunService.findById(id);
        return Result.success(pinglun);
    }

    @GetMapping
    public Result<List<Pinglun>> all() {
        return Result.success(pinglunService.list());
    }

    @PostMapping("/page")
    public Result<PinglunVo> page(@RequestBody PinglunVo pinglunVo) {
        return Result.success(pinglunService.findPage(pinglunVo));
    }
	//youupdt2login
}
