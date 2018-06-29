package cn.yyy.pojo;

import java.util.Date;

public class Message {
    private Integer messageid;

    private Integer senduid;

    private Integer receiveuid;

    private String messagecontent;

    private String state;

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