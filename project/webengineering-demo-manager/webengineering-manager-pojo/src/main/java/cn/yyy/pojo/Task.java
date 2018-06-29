package cn.yyy.pojo;

import java.util.Date;

public class Task {
	//教师布置的作业编号
    private Integer taskid;

    //作业名称
    private String taskname;

    //教师编号
    private Integer teacherid;

    //课程编号
    private Integer courseid;

    //作业内容
    private String taskcontent;

    //截至日期
    private Date deadline;
    
    public Task(Integer taskid, String taskname, Integer teacherid, Integer courseid, String taskcontent, Date deadline){
    	this.setTaskid(taskid);
    	this.setTaskname(taskname);
    	this.setTeacherid(teacherid);
    	this.setCourseid(courseid);
    	this.setDeadline(deadline);
    	this.setTaskcontent(taskcontent);
    	
    }
    
    public Task() {
    	
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent == null ? null : taskcontent.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}