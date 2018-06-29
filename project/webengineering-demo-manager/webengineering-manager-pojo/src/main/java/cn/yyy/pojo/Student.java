package cn.yyy.pojo;

public class Student {
	//学生编号
    private Integer studentid;

    //用户编号
    private Integer userid;

    //学校编号
    private Integer schoolid;

    //学院编号
    private Integer collegeid;

    //学号
    private Integer sid;
    
    public Student(Integer studentid, Integer userid, Integer schoolid, Integer collegeid, Integer sid) {
    	this.setStudentid(studentid);
    	this.setUserid(userid);
    	this.setSchoolid(schoolid);
    	this.setCollegeid(collegeid);
    	this.setSid(sid);
    	
    }
    
    public Student() {
    	
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}