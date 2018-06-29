package cn.yyy.pojo;

public class School {
    private Integer schoolid;

    private String schoolname;
    
    public School() {
    	
    }
    
    public School(Integer schoolid, String schoolname) {
    	this.setSchoolid(schoolid);
    	this.setSchoolname(schoolname);
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }
}