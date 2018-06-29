package cn.yyy.pojo;

import java.util.Date;

public class TeacherInfo {
	//用户编号
	private Integer userid;

	//用户名
    private String username;

    //密码（MD5）
    private String password;

    //真实姓名
    private String name;

    //身份证号
    private String idno;

    //手机号
    private String phone;

    //邮箱
    private String mail;

    //头像url
    private String headicon;
    
    //教师编号
    private Integer teacherid;
    
    //职工号
    private Integer staffid;

    //学校名称
    private String schoolName;
    
    //学院名称
    private String collegeName;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getHeadicon() {
		return headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
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

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

    
}
