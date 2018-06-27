package cn.yyy.mapper;

import cn.yyy.pojo.DiscussExample;
import cn.yyy.pojo.DiscussKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscussMapper {
    int countByExample(DiscussExample example);

    int deleteByExample(DiscussExample example);

    int deleteByPrimaryKey(DiscussKey key);

    int insert(DiscussKey record);

    int insertSelective(DiscussKey record);

    List<DiscussKey> selectByExample(DiscussExample example);

    int updateByExampleSelective(@Param("record") DiscussKey record, @Param("example") DiscussExample example);

    int updateByExample(@Param("record") DiscussKey record, @Param("example") DiscussExample example);
}