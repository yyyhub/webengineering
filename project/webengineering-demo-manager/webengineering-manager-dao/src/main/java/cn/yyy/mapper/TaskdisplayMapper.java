package cn.yyy.mapper;

import cn.yyy.pojo.Taskdisplay;
import cn.yyy.pojo.TaskdisplayExample;
import cn.yyy.pojo.TaskdisplayKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskdisplayMapper {
    int countByExample(TaskdisplayExample example);

    int deleteByExample(TaskdisplayExample example);

    int deleteByPrimaryKey(TaskdisplayKey key);

    int insert(Taskdisplay record);

    int insertSelective(Taskdisplay record);

    List<Taskdisplay> selectByExample(TaskdisplayExample example);

    Taskdisplay selectByPrimaryKey(TaskdisplayKey key);

    int updateByExampleSelective(@Param("record") Taskdisplay record, @Param("example") TaskdisplayExample example);

    int updateByExample(@Param("record") Taskdisplay record, @Param("example") TaskdisplayExample example);

    int updateByPrimaryKeySelective(Taskdisplay record);

    int updateByPrimaryKey(Taskdisplay record);
}