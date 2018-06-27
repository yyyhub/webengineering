package cn.yyy.mapper;

import cn.yyy.pojo.Arrange;
import cn.yyy.pojo.ArrangeExample;
import cn.yyy.pojo.ArrangeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrangeMapper {
    int countByExample(ArrangeExample example);

    int deleteByExample(ArrangeExample example);

    int deleteByPrimaryKey(ArrangeKey key);

    int insert(Arrange record);

    int insertSelective(Arrange record);

    List<Arrange> selectByExample(ArrangeExample example);

    Arrange selectByPrimaryKey(ArrangeKey key);

    int updateByExampleSelective(@Param("record") Arrange record, @Param("example") ArrangeExample example);

    int updateByExample(@Param("record") Arrange record, @Param("example") ArrangeExample example);

    int updateByPrimaryKeySelective(Arrange record);

    int updateByPrimaryKey(Arrange record);
}