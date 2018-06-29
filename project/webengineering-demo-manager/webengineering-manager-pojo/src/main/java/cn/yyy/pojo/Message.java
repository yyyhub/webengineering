package cn.yyy.pojo;

import java.util.Date;

public class Message {
	//信息编号
    private Integer messageid;

    //发送方编号
    private Integer senduid;

    //接收方编号
    private Integer receiveuid;

    //消息内容
    private String messagecontent;

    //消息状态（已读/未读）
    private String state;

    //发送时间
    private Date sendtime;
    
    public Message(Integer messageid, Integer senduid, Integer receiveuid, String messagecontent, String state, Date sendtime) {
    	this.setMessageid(messageid);
    	this.setMessagecontent(messagecontent);
    	this.setSenduid(senduid);
    	this.setReceiveuid(receiveuid);
    	this.setState(state);
    	this.setSendtime(sendtime);
    }
    
    public Message() {
    	
    }

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

    public Integer getReceiveuid() {
        return receiveuid;
    }

    public void setReceiveuid(Integer receiveuid) {
        this.receiveuid = receiveuid;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent == null ? null : messagecontent.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}