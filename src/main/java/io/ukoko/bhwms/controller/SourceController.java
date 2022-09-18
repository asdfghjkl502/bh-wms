package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.entity.Source;
import io.ukoko.bhwms.service.LevelService;
import io.ukoko.bhwms.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "来源模块")
@CrossOrigin
@RestController
public class SourceController {
    @Autowired
    private SourceService sourceService;

    /**
     * 来源分页查询
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping(value = "/getSourcePage")
    public Object getSourcePage(int offset,int limit){
        Page page = sourceService.getSourcePage(offset,limit);
        return new Result(page);
    }

    /**
     * 添加来源
     * @param source
     * @return
     */
    @PostMapping(value = "/addSource")
    public Object addSource(Source source){
        sourceService.addSource(source);
        return new Result();
    }
}
