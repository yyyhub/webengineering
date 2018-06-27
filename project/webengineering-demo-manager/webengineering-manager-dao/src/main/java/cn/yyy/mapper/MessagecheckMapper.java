package cn.yyy.mapper;

import cn.yyy.pojo.Messagecheck;
import cn.yyy.pojo.MessagecheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessagecheckMapper {
    int countByExample(MessagecheckExample example);

    int deleteByExample(MessagecheckExample example);

    int deleteByPrimaryKey(Integer messageid);

    int insert(Messagecheck record);

    int insertSelective(Messagecheck record);

    List<Messagecheck> selectByExample(MessagecheckExample example);

    Messagecheck selectByPrimaryKey(Integer messageid);

    int updateByExampleSelective(@Param("record") Messagecheck record, @Param("example") MessagecheckExample example);

    int updateByExample(@Param("record") Messagecheck record, @Param("example") MessagecheckExample example);

    int updateByPrimaryKeySelective(Messagecheck record);

    int updateByPrimaryKey(Messagecheck record);
}