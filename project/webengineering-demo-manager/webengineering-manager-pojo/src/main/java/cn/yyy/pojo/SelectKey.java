package cn.yyy.pojo;

public class SelectKey {
    private Integer studentid;

    private Integer classid;
    
    public SelectKey() {
    	
    }
    
    public SelectKey(Integer studentid, Integer classid) {
    	this.setClassid(classid);
    	this.setStudentid(studentid);
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}