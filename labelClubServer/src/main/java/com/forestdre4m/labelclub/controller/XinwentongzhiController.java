package com.forestdre4m.labelclub.controller;

import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.entity.Xinwentongzhi;
import com.forestdre4m.labelclub.service.XinwentongzhiService;
import com.forestdre4m.labelclub.vo.XinwentongzhiVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/xinwentongzhi")
public class XinwentongzhiController {

    @Resource
    private XinwentongzhiService xinwentongzhiService;

    @PostMapping
    public Result<Xinwentongzhi> add(@RequestBody XinwentongzhiVo xinwentongzhi) {
        xinwentongzhiService.add(xinwentongzhi);
           return Result.success(xinwentongzhi);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Xinwentongzhi> deleteList(@RequestBody XinwentongzhiVo xinwentongzhi) {
        xinwentongzhiService.deleteList(xinwentongzhi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        xinwentongzhiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody XinwentongzhiVo xinwentongzhi) {
        xinwentongzhiService.update(xinwentongzhi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Xinwentongzhi> detail(@PathVariable Integer id) {
        Xinwentongzhi xinwentongzhi = xinwentongzhiService.findById(id);
        return Result.success(xinwentongzhi);
    }

    @GetMapping
    public Result<List<Xinwentongzhi>> all() {
        return Result.success(xinwentongzhiService.list());
    }

    @PostMapping("/page")
    public Result<XinwentongzhiVo> page(@RequestBody XinwentongzhiVo xinwentongzhiVo) {
        return Result.success(xinwentongzhiService.findPage(xinwentongzhiVo));
    }
	//youupdt2login
}
