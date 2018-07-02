package cn.yyy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.MessageMapper;
import cn.yyy.pojo.Message;
import cn.yyy.pojo.PageBean;
import cn.yyy.service.MessageService;

@Service
public class MessageServiceImp implements MessageService{
	@Autowired
	private MessageMapper messageMapper;

	public PageBean<Message> getMessageByReceiveId(Integer receiveid,int pageIndex,int pageSize){
		if (pageIndex < 0) {
			throw new RuntimeException("页数不能为负");
		}
		List<Message> messages = messageMapper.selectByreceiveuidLimit(receiveid, pageIndex, pageSize);
		PageBean<Message> pageBean = new PageBean<>();
		int totalRecords = messageMapper.selectByreceiveuidcount(receiveid);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecords(totalRecords);
		pageBean.setPageDatas(messages);
		return pageBean;
	}
	
	public PageBean<Message> getMessageBySendId(Integer sendid,int pageIndex,int pageSize){
		if (pageIndex < 0) {
			throw new RuntimeException("页数不能为负");
		}
		List<Message> messages = messageMapper.selectBysenduidLimit(sendid, pageIndex, pageSize);
		PageBean<Message> pageBean = new PageBean<>();
		int totalRecords = messageMapper.selectBysenduidcount(sendid);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecords(totalRecords);
		pageBean.setPageDatas(messages);
		return pageBean;
	}
	
	public void addMessage(String messagecontent,Integer senduid,Integer receiveuid) {
		Message message = new Message();
		message.setMessageid(null);
		message.setMessagecontent(messagecontent);
		Date sendtime = new Date();
		message.setSendtime(sendtime);
		message.setSenduid(senduid);
		message.setReceiveuid(receiveuid);
		message.setState("未读");
		messageMapper.insert(message);
	}
}
