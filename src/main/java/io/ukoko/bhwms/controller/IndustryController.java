package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Industry;
import io.ukoko.bhwms.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "行业模块")
@CrossOrigin
@RestController
public class IndustryController {
    @Autowired
    private IndustryService industryService;

    /**
     * 行业分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/getIndustryPage")
    public Object getIndustryPage(int pageNo,int pageSize){
        Page page = industryService.getIndustryPage(pageNo,pageSize);
        return new Result(page);
    }

    /**
     * 获取行业列表
     * @return
     */
    @GetMapping(value = "/getIndustryList")
    public Object getIndustryList(){
        return new Result(industryService.getIndustryList());
    }

    /**
     * 添加行业
     * @param industry
     * @return
     */
    @PostMapping(value = "/addIndustry")
    public Object addIndustry(@RequestBody Industry industry){
        industryService.addIndustry(industry);
        return new Result();
    }

    /**
     * 更新
     * @param industry
     * @return
     */
    @PostMapping(value = "/updateIndustry")
    public Object updateIndustry(@RequestBody Industry industry){
        industryService.updateIndustry(industry);
        return new Result();
    }

    /**
     * 删除
     * @param industryId
     * @return
     */
    @GetMapping(value = "/deleteIndustry")
    public Object deleteIndustry(Integer industryId){
        industryService.deleteIndustryByIndustryId(industryId);
        return new Result();
    }

    /**
     * 批量删除
     * @param industryIds
     * @return
     */
    @PostMapping(value = "/batchDeleteIndustry")
    public Object batchDeleteIndustry(@RequestBody List<Integer> industryIds){
        industryService.batchDeleteIndustryByIndustryId(industryIds);
        return new Result();
    }
}
