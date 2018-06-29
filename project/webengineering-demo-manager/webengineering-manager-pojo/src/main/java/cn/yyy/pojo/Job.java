package cn.yyy.pojo;

import java.util.Date;

public class Job {
    private Integer jobid;

    private Integer studentid;

    private String state;

    private Integer grade;

    private Integer taskid;

    private String content;

    private String jobname;

    private Date submittime;
    
    public Job(Integer jobid, Integer studentid, String state, Integer grade, Integer taskid, String content,String jobname, Date submittime) {
    	this.setJobid(jobid);
    	this.setContent(content);
    	this.setGrade(grade);
    	this.setJobname(jobname);
    	this.setState(state);
    	this.setStudentid(studentid);
    	this.setSubmittime(submittime);
    	this.setTaskid(taskid);
    }
    
    public Job() {
    	
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }
}