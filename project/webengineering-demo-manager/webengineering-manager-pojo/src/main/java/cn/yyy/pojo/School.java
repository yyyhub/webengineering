package cn.yyy.pojo;

public class School {
    private String schoolname;

    private String schoolplace;

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getSchoolplace() {
        return schoolplace;
    }

    public void setSchoolplace(String schoolplace) {
        this.schoolplace = schoolplace == null ? null : schoolplace.trim();
    }
}