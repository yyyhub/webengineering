package cn.yyy.pojo;

public class Course {
	//课程编号
    private Integer courseid;

    //课程名称
    private String coursename;

    //老师编号
    private Integer teacherid;

    //学院编号
    private Integer collegeid;
    
    public Course() {
    	
    }
    
    public Course(Integer courseid, String coursename, Integer teacherid, Integer collegeid) {
    	this.setCollegeid(collegeid);
    	this.setCourseid(courseid);
    	this.setCoursename(coursename);
    	this.setTeacherid(teacherid);
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }
}