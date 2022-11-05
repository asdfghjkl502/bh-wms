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
     * 获取级别分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page getLevelPage(int pageNo,int pageSize);
}
