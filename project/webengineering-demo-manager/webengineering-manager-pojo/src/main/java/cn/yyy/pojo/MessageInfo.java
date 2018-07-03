package cn.yyy.pojo;

import java.util.Date;

public class MessageInfo {
	private Integer messageid;

    private Integer senduid;
    
    private String sendusername;

    private Integer receiveuid;
    
    private String receiveusername;

    private String messagecontent;

    private String state;

    private Date sendtime;

    private String title;

    private String subject;
    
    private String shortMsg;
    
    private String fullMsg;

	public Integer getMessageid() {
		return messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public Integer getSenduid() {
		return senduid;
	}

	public void setSenduid(Integer senduid) {
		this.senduid = senduid;
	}

	public String getSendusername() {
		return sendusername;
	}

	public void setSendusername(String sendusername) {
		this.sendusername = sendusername;
	}

	public Integer getReceiveuid() {
		return receiveuid;
	}

	public void setReceiveuid(Integer receiveuid) {
		this.receiveuid = receiveuid;
	}

	public String getReceiveusername() {
		return receiveusername;
	}

	public void setReceiveusername(String receiveusername) {
		this.receiveusername = receiveusername;
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getShortMsg() {
		return shortMsg;
	}

	public void setShortMsg(String shortMsg) {
		this.shortMsg = shortMsg;
	}

	public String getFullMsg() {
		return fullMsg;
	}

	public void setFullMsg(String fullMsg) {
		this.fullMsg = fullMsg;
	}


	
}
