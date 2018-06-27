package cn.yyy.mapper;

import cn.yyy.pojo.Problem;
import cn.yyy.pojo.ProblemExample;
import cn.yyy.pojo.ProblemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemMapper {
    int countByExample(ProblemExample example);

    int deleteByExample(ProblemExample example);

    int deleteByPrimaryKey(ProblemKey key);

    int insert(Problem record);

    int insertSelective(Problem record);

    List<Problem> selectByExampleWithBLOBs(ProblemExample example);

    List<Problem> selectByExample(ProblemExample example);

    Problem selectByPrimaryKey(ProblemKey key);

    int updateByExampleSelective(@Param("record") Problem record, @Param("example") ProblemExample example);

    int updateByExampleWithBLOBs(@Param("record") Problem record, @Param("example") ProblemExample example);

    int updateByExample(@Param("record") Problem record, @Param("example") ProblemExample example);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKeyWithBLOBs(Problem record);

    int updateByPrimaryKey(Problem record);
}