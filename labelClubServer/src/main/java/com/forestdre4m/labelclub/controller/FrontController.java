package com.forestdre4m.labelclub.controller;
import com.forestdre4m.labelclub.entity.*;
import com.forestdre4m.labelclub.common.Result;
import com.forestdre4m.labelclub.service.*;
import com.forestdre4m.labelclub.service.impl.CollectServiceImpl;
import com.forestdre4m.labelclub.vo.ArtistVo;
import com.forestdre4m.labelclub.vo.LabelVo;
import com.forestdre4m.labelclub.vo.AudioVo;
import com.forestdre4m.labelclub.vo.AudiocheckVo;

import com.forestdre4m.labelclub.vo.PinglunVo;
import com.mysql.cj.xdevapi.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/front")
public class FrontController {
    @Autowired
private ArtistService artistService;
@Autowired
private LabelService labelService;
@Autowired
private AudioService audioService;
@Autowired
private AudiocheckService audiocheckService;

    @Autowired
    private PinglunService pinglunService;
	@Autowired
    private SpService spService;
    @Autowired
    private XinwentongzhiService  xinwentongzhiService;
    @Autowired
    private LiuyanbanService liuyanbanService;
    @Resource
    private CollectServiceImpl collectService;

	@PostMapping("/registerartist")
public Result registerartist(@RequestBody Artist artist) {
artistService.add(artist);
return Result.success();
}
@PostMapping("/findartistusername")
public Result findartistusername(@RequestBody Artist artist) {
artistService.findartistusername(artist);
return Result.success();
}
@PostMapping("/loginartist")
public Result loginartist(@RequestBody Artist artist,HttpSession session) {
return Result.success(artistService.loginA(artist,session));
}
@GetMapping("/getlabeldetail/{id}")
public Result getlabeldetail(@PathVariable Integer id) {
	return Result.success(labelService.findById(id));
}
@PostMapping("/label")
public Result<LabelVo> label(@RequestBody LabelVo labelVo) {
return Result.success(labelService.findPage(labelVo));
}
@PostMapping("/loginlabel")
public Result loginlabel(@RequestBody Label label) {
return Result.success(labelService.login(label));
}
@PostMapping("/postaudio")
public Result<Audio> postaudio(@RequestBody Audio audio) {
return Result.success(audioService.add(audio));
}

	
	@PostMapping("/postpinglun")
    public Result<Pinglun> postpinglun(@RequestBody Pinglun pinglun) {
        return Result.success(pinglunService.add(pinglun));
    }
    @PostMapping("/pinglun")
    public Result<PinglunVo> pinglun(@RequestBody PinglunVo pinglunVo) {
        return Result.success(pinglunService.findPage(pinglunVo));
    }
	
	@GetMapping("/sp")
    public Result sp() {
        return Result.success(spService.list());
    }
   
    @GetMapping("/xinwentongzhi")
    public Result xinwentongzhi() {
        return Result.success(xinwentongzhiService.list());
    }
    @GetMapping("/getxinwentongzhi/{id}")
    public Result getxinwentongzhi(@PathVariable Integer id) {
        return Result.success(xinwentongzhiService.findById(id));
    }
    @PostMapping("/addLiuyan")
    public Result addComment(@RequestBody Liuyanban liuyanban) {
        liuyanbanService.add(liuyanban);
        return Result.success();
    }
    @GetMapping("/getLiuyan")
    public Result<List<Liuyanban>> getCommentTiezi() {
        return Result.success(liuyanbanService.getLiuyan());
    }
    @PostMapping("/addCollect")
    public Result addCollect(@RequestBody Collect collect) {
        Collect collect1 = collectService.add(collect);
        if(collect1  == null){
            return Result.success("请勿重复收藏");
        }
        return Result.success();
    }
    @DeleteMapping("/deleteCollect/{id}")
    public Result deleteCollect(@PathVariable Integer id) {
        collectService.delete(id);
        return Result.success();
    }
	@PostMapping("/getUserCollect")
    public Result getUserCollect(@RequestBody Collect collect) {
        return Result.success(collectService.findFrontPages(collect.getUserId()));
    }
    @DeleteMapping("/deleteCollect/{id}/{userId}")
    public Result deleteCollect(@PathVariable Integer id,@PathVariable Integer userId) {
        collectService.deleteByUserId(id,userId);
        return Result.success();
    }
	
	@PutMapping("/artist")
public Result updateArtist(@RequestBody ArtistVo artist) {
artistService.update(artist);
return Result.success();
}
@PutMapping("/label")
public Result updateLabel(@RequestBody LabelVo label) {
labelService.update(label);
return Result.success();
}
@PutMapping("/audio")
public Result updateAudio(@RequestBody AudioVo audio) {
audioService.update(audio);
return Result.success();
}
@PutMapping("/audiocheck")
public Result updateAudiocheck(@RequestBody AudiocheckVo audiocheck) {
audiocheckService.update(audiocheck);
return Result.success();
}

    @PostMapping("/recommend")
    public Result<LabelVo> recommend(@RequestBody LabelVo labelVo, HttpSession session) {

        return Result.success(labelService.findRecommendPage(labelVo, session));
    }


}
