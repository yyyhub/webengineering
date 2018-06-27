package cn.yyy.pojo;

public class Teacher {
    private Integer staffid;

    private Integer userid;

    private String teachercall;

    private Integer collegeid;

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTeachercall() {
        return teachercall;
    }

    public void setTeachercall(String teachercall) {
        this.teachercall = teachercall == null ? null : teachercall.trim();
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }
}