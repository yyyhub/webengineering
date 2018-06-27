package cn.yyy.mapper;

import cn.yyy.pojo.Submit;
import cn.yyy.pojo.SubmitExample;
import cn.yyy.pojo.SubmitKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubmitMapper {
    int countByExample(SubmitExample example);

    int deleteByExample(SubmitExample example);

    int deleteByPrimaryKey(SubmitKey key);

    int insert(Submit record);

    int insertSelective(Submit record);

    List<Submit> selectByExample(SubmitExample example);

    Submit selectByPrimaryKey(SubmitKey key);

    int updateByExampleSelective(@Param("record") Submit record, @Param("example") SubmitExample example);

    int updateByExample(@Param("record") Submit record, @Param("example") SubmitExample example);

    int updateByPrimaryKeySelective(Submit record);

    int updateByPrimaryKey(Submit record);
}