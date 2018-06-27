package cn.yyy.mapper;

import cn.yyy.pojo.Join;
import cn.yyy.pojo.JoinExample;
import cn.yyy.pojo.JoinKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoinMapper {
    int countByExample(JoinExample example);

    int deleteByExample(JoinExample example);

    int deleteByPrimaryKey(JoinKey key);

    int insert(Join record);

    int insertSelective(Join record);

    List<Join> selectByExample(JoinExample example);

    Join selectByPrimaryKey(JoinKey key);

    int updateByExampleSelective(@Param("record") Join record, @Param("example") JoinExample example);

    int updateByExample(@Param("record") Join record, @Param("example") JoinExample example);

    int updateByPrimaryKeySelective(Join record);

    int updateByPrimaryKey(Join record);
}