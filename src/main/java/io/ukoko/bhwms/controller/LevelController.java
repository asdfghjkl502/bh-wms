package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "级别模块")
@CrossOrigin
@RestController
public class LevelController {
    @Autowired
    private LevelService levelService;

    /**
     * 级别分页查询
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping(value = "/getLevelPage")
    public Object getLevelPage(int offset,int limit){
        Page page = levelService.getLevelPage(offset, limit);
        return new Result(page);
    }

    /**
     * 添加级别
     * @param level
     * @return
     */
    @PostMapping(value = "/addLevel")
    public Object addLevel(Level level){
        levelService.addLevel(level);
        return new Result();
    }
}
