package cn.yyy.service;

import cn.yyy.pojo.Message;
import cn.yyy.pojo.PageBean;

public interface MessageService {
	public PageBean<Message> getMessageByReceiveId(Integer receiveid,int pageIndex,int pageSize);
	
	public PageBean<Message> getMessageBySendId(Integer sendid,int pageIndex,int pageSize);
	
	public void addMessage(String messagecontent,Integer senduid,Integer receiveuid,String title,String subject);
	
	
}
