package cn.yyy.mapper;

import cn.yyy.pojo.Speak;
import cn.yyy.pojo.SpeakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeakMapper {
    int countByExample(SpeakExample example);

    int deleteByExample(SpeakExample example);

    int deleteByPrimaryKey(Integer discussid);

    int insert(Speak record);

    int insertSelective(Speak record);

    List<Speak> selectByExample(SpeakExample example);

    Speak selectByPrimaryKey(Integer discussid);

    int updateByExampleSelective(@Param("record") Speak record, @Param("example") SpeakExample example);

    int updateByExample(@Param("record") Speak record, @Param("example") SpeakExample example);

    int updateByPrimaryKeySelective(Speak record);

    int updateByPrimaryKey(Speak record);
}