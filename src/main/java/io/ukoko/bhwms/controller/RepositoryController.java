package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Repository;
import io.ukoko.bhwms.enums.RepoStatus;
import io.ukoko.bhwms.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "仓库模块")
@CrossOrigin
@RestController
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * 添加仓库
     * @param repository
     * @return
     */
    @PostMapping(value = "/addRepository")
    public Object addRepository(@RequestBody Repository repository){
        repositoryService.addRepository(repository);
        return new Result();
    }

    /**
     * 更新仓库
     * @param repository
     * @return
     */
    @PostMapping(value = "/updateRepository")
    public Object updateRepository(@RequestBody Repository repository){
        repositoryService.updateRepository(repository);
        return new Result();
    }

    /**
     * 获取仓库列表
     * @param pageNo
     * @param pageSize
     * @param repoAddress
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping(value = "/getRepositoryPage")
    public Object getRepositoryPage(Integer pageNo, Integer pageSize, String repoAddress, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,String repoName){
        Page page = repositoryService.getRepositoryPage(pageNo, pageSize, repoAddress, startTime, endTime,repoName);
        return new Result(page);
    }

    /**
     * 获取部门列表
     * @param repoName
     * @return
     */
    @GetMapping(value = "/getRepositoryList")
    public Object getRepositoryList(String repoName){
        List<Repository> repositoryList = repositoryService.getRepositoryList(repoName);
        return new Result(repositoryList);
    }

    /**
     * 删除仓库
     * @param repoId
     * @return
     */
    @PostMapping(value = "/deleteRepository")
    public Object deleteRepository(Integer repoId){
        repositoryService.deleteRepository(repoId);
        return new Result();
    }

    /**
     * 批量删除仓库
     * @param repoIds
     * @return
     */
    @PostMapping(value = "/batchDeleteRepository")
    public Object batchDeleteRepository(@RequestBody List<Integer> repoIds){
        repositoryService.batchDeleteRepository(repoIds);
        return new Result();
    }


    /**
     * 获取所有列表
     */
    @GetMapping(value = "/getRepositoryAll")
    public Object getRepositoryAll(){
        List<Repository> repositoryAll = repositoryService.getRepositoryAll();
        return new Result(repositoryAll);
    }

    /**
     * 获取仓库状态列表
     * @return
     */
    @GetMapping(value = "/getRepositoryStatusList")
    public Object getRepositoryStatusList(){
        List<Map<String,Object>> rss = new ArrayList<>();
        RepoStatus[] values = RepoStatus.values();
        for (RepoStatus value : values) {
            Map<String,Object> map = new HashMap<>();
            map.put("repoStatusId",value.getC());
            map.put("repoStatusName",value.getM());
            rss.add(map);
        }
        return new Result(rss);
    }
}
