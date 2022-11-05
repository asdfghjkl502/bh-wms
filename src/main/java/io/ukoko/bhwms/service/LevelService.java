package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Level;

import java.util.List;

/**
 * 级别管理模块的业务逻辑层
 */
public interface LevelService {

    /**
     * 添加级别
     * @param level
     */
    void addLevel(Level level);

    /**
     * 更新级别
     * @param level
     */
    void updateLevel(Level level);

    /**
     * 根据ID删除
     * @param levelId
     */
    void deleteLevelByLevelId(Integer levelId);

    /**
     * 批量删除
     * @param levelIds
     */
    void batchDeleteLevelByLevelId(List<Integer> levelIds);

    /**
     * 获取级别分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page getLevelPage(int pageNo,int pageSize);
}
