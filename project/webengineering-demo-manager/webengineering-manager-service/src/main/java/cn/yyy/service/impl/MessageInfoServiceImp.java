package cn.yyy.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.pojo.Message;
import cn.yyy.pojo.MessageInfo;
import cn.yyy.service.MessageInfoService;
import cn.yyy.service.UserService;
import common.utils.FileUtil;

@Service
public class MessageInfoServiceImp implements MessageInfoService{
	@Autowired
	private UserService userService;

	@Override
	public MessageInfo getMessageInfoByMessage(Message message) {
		MessageInfo messageInfo = new MessageInfo();
		if (message != null) {
			String urlString = message.getMessagecontent();
			String fullMsg = FileUtil.getDocumentByURL(urlString);
			messageInfo.setFullMsg(fullMsg);
			String shortMsg = fullMsg.substring(0, 70);
			messageInfo.setMessagecontent(message.getMessagecontent());
			messageInfo.setMessageid(message.getMessageid());
			messageInfo.setReceiveuid(message.getReceiveuid());
			
			messageInfo.setReceiveusername(userService.getUserInfoByUid(message.getReceiveuid()).getUsername());
			messageInfo.setSendtime(message.getSendtime());
			messageInfo.setSenduid(message.getSenduid());
			messageInfo.setSendusername(userService.getUserInfoByUid(message.getSenduid()).getUsername());
			messageInfo.setShortMsg(shortMsg);
			messageInfo.setState(message.getState());
			messageInfo.setSubject(message.getSubject());
			messageInfo.setTitle(message.getTitle());
		}
		return messageInfo;
	}
	
}
