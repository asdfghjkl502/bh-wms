package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.mapper.LevelMapper;
import io.ukoko.bhwms.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelMapper levelMapper;

    @Override
    public void addLevel(Level level) {
        levelMapper.addLevel(level);
    }

    @Override
    public void updateLevel(Level level) {
        levelMapper.updateLevel(level);
    }

    @Override
    public void deleteLevelByLevelId(Integer levelId) {
        levelMapper.deleteLevel(levelId);
    }

    @Override
    public void batchDeleteLevelByLevelId(List<Integer> levelIds) {
        levelMapper.batchDeleteLevel(levelIds);
    }

    @Override
    public Page getLevelPage(int pageNo, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Level> levelList = levelMapper.getLevelList();
        PageInfo<Level> info = new PageInfo<>(levelList);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setData(info.getList());
        return page;
    }
}
