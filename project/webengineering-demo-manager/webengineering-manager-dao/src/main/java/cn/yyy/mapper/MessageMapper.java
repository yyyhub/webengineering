package cn.yyy.mapper;

import cn.yyy.pojo.Message;
import cn.yyy.pojo.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer messageid);

    int insert(Message record);

    int insertSelective(Message record);

    //查询其实位置为i，数量为m条数据,i下标为零开始
    List<Message> selectBysenduidLimit(@Param("senduid")int senduid, @Param("i")int i, @Param("m")int m);
    
    //同上
    List<Message> selectByreceiveuidLimit(@Param("receiveuid")int receiveuid, @Param("i")int i, @Param("m")int m);
    
    //选择给定senduid的message数量
    int selectBysenduidcount(@Param("senduid")int senduid);
    
    //选择给定receiveuid的message数量
    int selectByreceiveuidcount(@Param("receiveuid")int receiveuid);
    
    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer messageid);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}