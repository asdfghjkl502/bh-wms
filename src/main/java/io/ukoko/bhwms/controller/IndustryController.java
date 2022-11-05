package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Industry;
import io.ukoko.bhwms.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 添加行业
     * @param industry
     * @return
     */
    @PostMapping(value = "/addIndustry")
    public Object addIndustry(Industry industry){
        industryService.addIndustry(industry);
        return new Result();
    }
}
