package cn.yyy.pojo;

public class College {
    private Integer collegeid;

    private String collegename;
    
    public College() {
    	
    }
    
    public College(Integer collegeid, String collegename) {
    	this.setCollegeid(collegeid);
    	this.setCollegename(collegename);
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename == null ? null : collegename.trim();
    }
}