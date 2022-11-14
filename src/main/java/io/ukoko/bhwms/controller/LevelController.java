package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "级别模块")
@CrossOrigin
@RestController
public class LevelController {
    @Autowired
    private LevelService levelService;


    /**
     * 删除单个
     * @param levelId
     * @return
     */
    @GetMapping(value = "/deleteLevelByLevelId")
    public Object deleteLevelByLevelId(Integer levelId){
        levelService.deleteLevelByLevelId(levelId);
        return new Result();
    }

    /**
     * 更新级别
     * @param level
     * @return
     */
    @PostMapping(value = "/updateLevel")
    public Object updateLevel(@RequestBody Level level){
        System.out.println("======"+level);
        levelService.updateLevel(level);
        return new Result();
    }


    /**
     * 批量删除
     * @param levelIds
     * @return
     */
    @PostMapping(value = "/batchDeleteLevel")
    public Object batchDeleteLevel(@RequestBody List<Integer> levelIds){
        levelService.batchDeleteLevelByLevelId(levelIds);
        return new Result();
    }


    /**
     * 级别分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/getLevelPage")
    public Object getLevelPage(int pageNo,int pageSize){
        Page page = levelService.getLevelPage(pageNo, pageSize);
        return new Result(page);
    }

    /**
     * 获取级别列表
     * @return
     */
    @GetMapping(value = "/getLevelList")
    public Object getLevelList(){
        return new Result(levelService.getLevelList());
    }

    /**
     * 添加级别
     * @param level
     * @return
     */
    @PostMapping(value = "/addLevel")
    public Object addLevel(@RequestBody Level level){
        levelService.addLevel(level);
        return new Result();
    }
}
