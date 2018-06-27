package cn.yyy.mapper;

import cn.yyy.pojo.Create;
import cn.yyy.pojo.CreateExample;
import cn.yyy.pojo.CreateKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreateMapper {
    int countByExample(CreateExample example);

    int deleteByExample(CreateExample example);

    int deleteByPrimaryKey(CreateKey key);

    int insert(Create record);

    int insertSelective(Create record);

    List<Create> selectByExample(CreateExample example);

    Create selectByPrimaryKey(CreateKey key);

    int updateByExampleSelective(@Param("record") Create record, @Param("example") CreateExample example);

    int updateByExample(@Param("record") Create record, @Param("example") CreateExample example);

    int updateByPrimaryKeySelective(Create record);

    int updateByPrimaryKey(Create record);
}