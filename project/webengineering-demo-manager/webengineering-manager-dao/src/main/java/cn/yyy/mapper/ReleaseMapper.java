package cn.yyy.mapper;

import cn.yyy.pojo.Release;
import cn.yyy.pojo.ReleaseExample;
import cn.yyy.pojo.ReleaseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReleaseMapper {
    int countByExample(ReleaseExample example);

    int deleteByExample(ReleaseExample example);

    int deleteByPrimaryKey(ReleaseKey key);

    int insert(Release record);

    int insertSelective(Release record);

    List<Release> selectByExample(ReleaseExample example);

    Release selectByPrimaryKey(ReleaseKey key);

    int updateByExampleSelective(@Param("record") Release record, @Param("example") ReleaseExample example);

    int updateByExample(@Param("record") Release record, @Param("example") ReleaseExample example);

    int updateByPrimaryKeySelective(Release record);

    int updateByPrimaryKey(Release record);
}