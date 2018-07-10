package cn.yyy.mapper;

import cn.yyy.pojo.SelectExample;
import cn.yyy.pojo.SelectKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectMapper {
    int countByExample(SelectExample example);

    int deleteByExample(SelectExample example);

    int deleteByPrimaryKey(SelectKey key);

    int insert(SelectKey record);

    int insertSelective(SelectKey record);

    List<SelectKey> selectByExample(SelectExample example);
    
    //按照studentid查找出select的序列，解决了select关键词的冲突
    List<SelectKey> selectByStudentid(@Param("studentid") int studentid);
    
    //按照classid查找出select的序列，解决了select关键词的冲突
    List<SelectKey> selectByCalssid(@Param("classid") int classid);

    int updateByExampleSelective(@Param("record") SelectKey record, @Param("example") SelectExample example);

    int updateByExample(@Param("record") SelectKey record, @Param("example") SelectExample example);
}