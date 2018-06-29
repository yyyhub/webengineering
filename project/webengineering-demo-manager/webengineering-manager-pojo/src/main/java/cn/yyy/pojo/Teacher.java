package cn.yyy.pojo;

public class Teacher {
    private Integer teacherid;

    private Integer staffid;

    private Integer schoolid;

    private Integer collegeid;

    private Integer userid;
    
    public Teacher(Integer teacherid, Integer staffid, Integer schoolid, Integer collegeid, Integer userid) {
    	this.setTeacherid(teacherid);
    	this.setStaffid(staffid);
    	this.setSchoolid(schoolid);
    	this.setCollegeid(collegeid);
    	this.setUserid(userid);
    }
    
    public Teacher() {
    	
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}