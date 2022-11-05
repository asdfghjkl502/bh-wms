package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Level;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *操作数据库级别表(level)的接口类
 */
@Mapper
public interface LevelMapper {

    /**
     * 添加级别
     * @param level
     */
    void addLevel(Level level);

    /**
     * 获取级别列表
     * @return
     */
    List<Level> getLevelList();

    /**
     * 通过ID查询级别信息
     */
    Level getLevel(Integer levelId);

    /**
     * 批量删除
     */
    void batchDeleteLevel(List<Integer> levelIds);

    /**
     * 通过ID删除
     */
    void deleteLevel(Integer levelId);

}
