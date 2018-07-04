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
    
  //��ѯ��ʵλ��Ϊi������Ϊm������,i�±�Ϊ�㿪ʼ
    List<Message> selectBysenduidLimit(@Param("senduid")int senduid, @Param("i")int i, @Param("m")int m);
    
    //ͬ��
    List<Message> selectByreceiveuidLimit(@Param("receiveuid")int receiveuid, @Param("i")int i, @Param("m")int m);
    
    //ѡ�����senduid��message����
    int selectBysenduidcount(@Param("senduid")int senduid);
    
  //ѡ�����receiveuid��message����
    int selectByreceiveuidcount(@Param("receiveuid")int receiveuid);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer messageid);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}