package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.entity.Source;
import io.ukoko.bhwms.service.LevelService;
import io.ukoko.bhwms.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "来源模块")
@CrossOrigin
@RestController
public class SourceController {
    @Autowired
    private SourceService sourceService;


    /**
     * 更新
     * @param source
     * @return
     */
    @PostMapping(value = "/updateSource")
    public Object updateSource(@RequestBody Source source){
        sourceService.updateSource(source);
        return new Result();
    }

    /**
     * 删除
     * @param sourceId
     * @return
     */
    @GetMapping(value = "/deleteSource")
    public Object deleteSource(Integer sourceId){
        sourceService.deleteSourceBySourceId(sourceId);
        return new Result();
    }

    /**
     * 批量删除
     * @param sourceIds
     * @return
     */
    @PostMapping(value = "/batchDeleteSource")
    public Object batchDeleteSource(@RequestBody List<Integer> sourceIds){
        sourceService.batchDeleteSourceBySourceId(sourceIds);
        return new Result();
    }


    /**
     * 来源分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/getSourcePage")
    public Object getSourcePage(int pageNo,int pageSize){
        Page page = sourceService.getSourcePage(pageNo,pageSize);
        return new Result(page);
    }

    /**
     * 添加来源
     * @param source
     * @return
     */
    @PostMapping(value = "/addSource")
    public Object addSource(@RequestBody Source source){
        sourceService.addSource(source);
        return new Result();
    }
}
